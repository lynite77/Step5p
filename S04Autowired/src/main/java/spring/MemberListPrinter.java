package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.dao.Member;
import spring.dao.MemberDao;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter() {
	}
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("[MemberListPrinter]setMemberDao");
		this.memberDao = memberDao;
	}
	
	@Autowired
	public void setMemberPrinter(MemberSummaryPrinter printer) {
		System.out.println("[MemberListPrinter]setMemberPrinter");
		this.printer = printer;
	}
	/*
	@Autowired
	public void setMemberPrinter(MemberPrinter printer) {
		System.out.println("[MemberListPrinter]setMemberPrinter");
		this.printer = printer;
	}*/
}
