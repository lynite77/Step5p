package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
// @Order(1)
public class ExeTimeAspect {

	@Pointcut("execution(public * chap07..*(..))")	// 부가 기능 동작시 패키지 chap07에 있는 모든 항목들과 연동
	private void publicTarget() {
	}

	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[ExeTimeAspext]1");
		long start = System.nanoTime();
		try {
			System.out.println("[ExeTimeAspext]2");
			Object result = joinPoint.proceed();	// 핵심기능 호출
			System.out.println("[ExeTimeAspext]3");
			return result;
		} finally {
			System.out.println("[ExeTimeAspext]4");
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinPoint.getArgs()),
					(finish - start));
		}
	}

}
