[S03SpringDI]

1. Spring Dependency Injection(의존 주입)
2. 객체 간의 의존 관계

(MainForAssembler.java)
등록: new abc@ez.co.kr 홍길동 1234 1234
변경: change abc@ez.co.kr 1234 9999
종료: exit

(@Bean)
1. @Bean 애너테이션이 지정되면 메소드이름이 빈객체 이름
2. 빈 객체는 싱글톤 객체
3. 예시
	@Bean
	public 리턴타입 메소드이름(...){
	}
	
4. 빈 객체 취득 방법(캐스팅타입 설정)
	클래스이름 객체 = ctx.getBean("빈객체", 클래스이름.class);
	클래스이름 객체 = (클래스이름)ctx.getBean("빈객체");
	예시) AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	 	 MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		 MemberRegisterService regSvc = (MemberRegisterService)ctx.getBean("memberRegSvc");
		 
(오늘 날짜) 참고;docs.oracle.com/javase/8/docs/api/
소스: Member.java, MemberRegisterService.java

import java.time.LocalDateTime;
LocalDateTime registerDateTime = LocalDateTime.new();

System.out.printf(등록일=%tF", member.getRegisterDateTime());

't', 'T' date/time Prefix for date and time conversion characters. see Date/Time Conversions.
'F' ISO 8601 complete date formatted as "%tY-%tm-%td".

(@Autowired)
1. 자동연결, 자동주입
2. 형식
	@Autowired
	private 클래스이름 빈객체;
3. 예시: 
	- AppConf1.java
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}	
	
	- AppConf1.java에 있는 메소드 memberDao를 자동 연결(주입)
	- AppConf2.java	
	@Autowired
	private MemberDao memberDao;
	
(AppConfImport.java)
1. AppConf2.java를 임포트(import)
2. @Import({AppConf2.class})
	
(MainForSpring2.java)
1. 다중 스프링 빈 설정
2. 예: AppConf1.java, AppConf2.java를 하나로 묶어 빈을 등록
	ctx = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
3. 동일한 빈을 여러 설정 클래스에서 중복하여 등록하면
	마지막으로 지정된 설정 클래스로 덮어(Overrideing) 쓴다.
	
	
	
	
	
	