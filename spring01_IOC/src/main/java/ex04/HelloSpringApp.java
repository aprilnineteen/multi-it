package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		String resource = "src/main/java/ex04/appContext.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(resource);
		
		// mb1�� ã�Ƽ� sayHello() ȣ���� ����
		MessageBean mb1 = ctx.getBean("mb3", MessageBean.class);
		mb1.sayHello();
		mb1.sayHi("������", "��������", "Ʈ���̽�");
		// mb2�� ã�Ƽ� sayHello() ȣ���� ����

	}

}
