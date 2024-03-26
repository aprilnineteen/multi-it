package ex01;

import org.springframework.aop.framework.ProxyFactory;

public class AopTest {

	public static void main(String[] args) {
		//1. �ٽ� ������ ���� ��ü => Target
		Service target = new ServiceImpl();
		System.out.println("target: "+target);
		//2. ���� ���� ���� ��ü => Aspect(�߻��� ����) => Advice(���� ������ �ڵ�)
		AroundAdvice advice = new AroundAdvice();
		//3. Proxy ��ü ��� => ProxyFactory ���ؼ�
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(advice);
		//4. Proxy ���ؼ� �޼��� ȣ��
		ServiceImpl proxy = (ServiceImpl)pf.getProxy();
		System.out.println("proxy: "+proxy);
		proxy.sayHello("����", "�糪", "�ϴ�");
	}
}
