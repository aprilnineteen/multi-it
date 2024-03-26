package ex01;

import org.springframework.aop.framework.ProxyFactory;

public class AopTest {

	public static void main(String[] args) {
		//1. 핵심 로직을 갖는 객체 => Target
		Service target = new ServiceImpl();
		System.out.println("target: "+target);
		//2. 공통 관심 사항 객체 => Aspect(추상적 개념) => Advice(실제 구현한 코드)
		AroundAdvice advice = new AroundAdvice();
		//3. Proxy 객체 얻기 => ProxyFactory 통해서
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(advice);
		//4. Proxy 통해서 메서드 호출
		ServiceImpl proxy = (ServiceImpl)pf.getProxy();
		System.out.println("proxy: "+proxy);
		proxy.sayHello("리즈", "사나", "하니");
	}
}
