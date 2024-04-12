package ex07;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
/* @Value :기본자료형, String 유형을 주입할 때 사용
 * @Autowired : byType으로 주입한다. 자료유형이 같은 객체가 있으면 주입한다. 찾는순서: 자료형> @Qualifier("빈이름")
 * @Resource  : byName으로 주입한다. pom.xml에 라이브러리를 등록해야 사용 가능하다.
 * @Inject : ==>pom.xml에 라이브러리를 등록해야 사용 가능하다. byType> @Qualifier
 * 
 * */
public class ServiceImpl implements Service {

	
	//@Autowired // Emp 객체를 주입해 준다 byType으로 주입
	@Inject //byType으로 주입
	@Qualifier("emp2")
	private Emp emp;
	
	@Resource(name="member") //byName으로 주입한다. 비니의 이름이 member인 객체가 있으면 주입한다.
	private Member user;
	
	@Override
	public void info1() {
		System.out.println("Name: "+emp.getName());
		System.out.println("Name: "+emp.getDept());
		System.out.println("Name: "+emp.getSal());
		
	}

	@Override
	public void info2() {
		user.showInfo();
	}
	
	}


