package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTestEx02 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex02/aop.xml");
		BoardService bs = ctx.getBean("boardService", BoardService.class);
									 // 설정한 id,        class로 형변환
		bs.insertBoard("첫 번째 글을 등록합니다.");
	
		bs.insertBoard("두 번째 글도 썼어요.");
	}

}
