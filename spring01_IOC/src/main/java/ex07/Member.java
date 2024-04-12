package ex07;

import org.springframework.beans.factory.annotation.Value;

public class Member {
	//Filed Injection
	@Value("hong") // annotation을 이용한 주입
	private String userId;
	@Value("010-2568-5651")
	private String tel;
	
	public void showInfo() {
		System.out.println("UserId: "+userId);
		System.out.println("Tel: "+tel);
	}

}
