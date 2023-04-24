package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;
import spring.dao.MemberDao;

@Configuration
/*@ComponentScan(basePackages = {"spring", "spring2" }, 
	excludeFilters = { 
			@Filter(type = FilterType.ANNOTATION, classes = {NoProduct.class, ManualBean.class} ) // spring.dao.MemberDao , spring2.MemberRegisterService가 ComponentScan 대상 제외	
})
/*/
@ComponentScan(basePackages = {"spring", "spring2" },
	excludeFilters = { 
			@Filter(type = FilterType.ANNOTATION, classes = ManualBean.class),  // spring.dao.MemberDao 
			@Filter(type = FilterType.REGEX, pattern = "spring2\\..*")})		// spring2.MemberRegisterService

public class AppCtxWithExclude {
	/*
	 * MemberDao @Component로 빈이 선언되어 있어서 중복 선언이다.
	 * 에러는 나오지 않지만 
	 */
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
