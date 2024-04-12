package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// ������ �����̳ʸ� ���� �ʿ��� ��ü��DL(Dependency Lookup)�� ����
		String resource="src/main/java/ex03/applicationContext.xml";
		
		// ������ �����̳� ����
		ApplicationContext ctx = new FileSystemXmlApplicationContext(resource);//������ �����̳�
		
		//�ʿ��� ��ü�� ã�´�
		MessageBean mb = (MessageBean)ctx.getBean("mbEn"); // Lookup
		mb.sayHello("������");
	}

}
