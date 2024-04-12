package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		String resource = "src/main/java/ex04/appContext.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(resource);
		
		// mb1을 찾아서 sayHello() 호출해 보기
		MessageBean mb1 = ctx.getBean("mb3", MessageBean.class);
		mb1.sayHello();
		mb1.sayHi("뉴진스", "르세라핌", "트와이스");
		// mb2를 찾아서 sayHello() 호출해 보기

	}

}
