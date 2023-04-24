package main;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtx2;

public class MainAspect2 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx2.class);

		beanList(ctx);
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		long fiveFact = cal.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFact);
		System.out.println(cal.getClass().getName());
		
		// Aspect는 인터페이스 타입으로 받아야 한다.
		Calculator cal2 = ctx.getBean("impecalculator", Calculator.class);
		long fiveFact2 = cal2.factorial(5);
		System.out.println("cal2.factorial(5) = " + fiveFact2);
		System.out.println(cal2.getClass().getName());
				
		ctx.close();
	}
	public static void beanList(ApplicationContext ctx) {
		System.out.println("빈객체 목록");
		String[] names = ctx.getBeanDefinitionNames();
		Arrays.stream(names).forEach(name -> System.out.println(name));
	}
}
