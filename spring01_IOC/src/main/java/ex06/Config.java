package ex06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //���� ConfigŬ������ ȯ�漳������ ����ϰڴ� �ǹ�
public class Config {
	//�������� �⺻������ ��(��ü)�� ���ϰ�ü(Singleton)�� �����ؼ� �����Ѵ�. 
	//�Ź� �ٸ� ��ü�� �����ϰ� �ʹٸ� @Scope ��=>prototype���� �����ϸ� �ȴ�
	@Bean(name="e1") //<bean id="e1" class="ex06.Emp"> �� ����
	//@Scope(value = "singleton")//�Ź� ���� ��ü�� �����. ����Ʈ���� singleton
	@Scope(value="prototype")//�Ź� �ٸ� ��ü ������. ����Ʈ���� singleton
	public Emp empInfo() {
		return new Emp("Ward","Sales",2800);
	}
	
	//@Bean�� name �Ӽ��� ���� ������ �޼��� �̸��� ���� �̸��� �ȴ�
	@Bean  
	public Emp empInfo2() {//<bean id="empInfo2" class="ex06.Emp"> �� ����
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
