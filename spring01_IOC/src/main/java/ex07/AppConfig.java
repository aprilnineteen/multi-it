package ex07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	// Emp빈을 반환하는 메서드를 구현하세요 id는 emp1으로 주세요
	@Bean(name="emp1")
	@Scope("prototype")
	public Emp getEmp() {
		return new Emp("김사원", "영업부", 7000);
	}
	
	@Bean(name="emp2")
	public Emp getEmp2() {
		Emp e=this.getEmp();
		e.setName("최사원");
		e.setDept("인사부");
		e.setSal(5000);
		return e;
	}
	
	@Bean
	public Member member() {
		return new Member();
	}
	
	@Bean
	public ServiceImpl service() {
		return new ServiceImpl();
	}
}
