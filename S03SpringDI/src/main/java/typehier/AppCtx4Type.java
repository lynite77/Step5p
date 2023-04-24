package typehier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx4Type {

	@Bean
	public ConsolePrinter printer() {
		return new ConsolePrinter();
	}
	
	/*
	 *  예제(MainForType4.java)에서 ConsolePrinter.class으로
	 *  빈객체를 취득하려면 오류가 발생한다.
	 */
	
	@Bean
	public ConsolePrinter printer2() {
		return new ConsolePrinter();
	}
}
