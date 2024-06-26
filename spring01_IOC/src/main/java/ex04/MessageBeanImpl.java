package ex04;
import java.util.*;
public class MessageBeanImpl implements MessageBean {

	//property: 멤버 변수
	private String greeting; //default값: null <= 프로퍼티값을 설정 파일(app.Context.xml)에 넣어 줄 예정(setter injection)
	private String name;
	
	private Date today;
	private Random ran;
	@Override
	public void sayHello() {
		System.out.println(greeting+" "+name+" ^^");
		if(today!=null) {
		System.out.println("오늘 날짜는: "+today.toString());
		System.out.println("----------------------");
		}
	}

	@Override
	public void sayHi(String... names) {
		System.out.println(greeting);
		if(names!=null) {
			for(String name:names) {
				System.out.print(name+", ");
			}
		}
	
	System.out.println("\n********************");
	if(ran!=null) {
	System.out.println("오늘의 행운의 숫자는: "+ran.nextInt(100));
	}
	}
	//setter, getter--

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("setGreeting(): "+greeting);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Random getRan() {
		return ran;
	}

	public void setRan(Random ran) {
		this.ran = ran;
	}
	
}//
