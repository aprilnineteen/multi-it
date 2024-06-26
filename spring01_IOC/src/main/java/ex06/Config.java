package ex06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //현재 Config클래스를 환경설정으로 사용하겠단 의미
public class Config {
	//스프링은 기본적으로 빈(객체)을 단일객체(Singleton)로 생성해서 관리한다. 
	//매번 다른 객체를 생성하고 싶다면 @Scope 값=>prototype으로 지정하면 된다
	@Bean(name="e1") //<bean id="e1" class="ex06.Emp"> 와 동일
	//@Scope(value = "singleton")//매번 단일 객체를 사용함. 디폴트값은 singleton
	@Scope(value="prototype")//매번 다른 객체 생성함. 디폴트값은 singleton
	public Emp empInfo() {
		return new Emp("Ward","Sales",2800);
	}
	
	//@Bean에 name 속성을 주지 않으면 메서드 이름이 빈의 이름이 된다
	@Bean  
	public Emp empInfo2() {//<bean id="empInfo2" class="ex06.Emp"> 와 동일
		Emp e=this.empInfo();
		e.setName("Scott");
		e.setDept("Research");
		e.setSal(3000);
		return e;
	}

	@Bean
    public ServiceImpl service() {
    	ServiceImpl svc=new ServiceImpl();
    	svc.setEmp(this.empInfo());
    	return svc;
    }
	
}
