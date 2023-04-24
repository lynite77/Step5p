package main;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxForList;
import config.AppCtxWithExclude;

public class MainForExclude {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtxWithExclude.class);
		System.out.println("[컴포넌트 스캔]");
		System.out.println(" 중복 지정된 컴포넌트 스캔 제외 대상 지정");
		System.out.println(" - spring.dao.MemberDao");
		System.out.println(" - spring2.MemberRegisterService");
	}

}