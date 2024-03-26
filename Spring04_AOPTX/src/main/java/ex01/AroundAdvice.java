package ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//Advice: 주변 로직을 갖는 공통 관심 사항을 구현한 객체
public class AroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invo) throws Throwable {
		System.out.println("==== I am AroundAdvice1: "+invo.getMethod()+" 호출 전 ====");
		Object obj = invo.proceed();
		System.out.println("==== I am AroundAdvice1: "+invo.getMethod()+" 호출 후 ====");
		return obj;
	}
	
}
