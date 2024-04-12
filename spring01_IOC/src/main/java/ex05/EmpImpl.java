package ex05;
import java.util.Date;
public class EmpImpl implements Emp {

	private String name;
	private int sal;
	private Date hiredate;
	
	public EmpImpl(String name, int sal, Date hdate) {
		this.name=name;
		this.sal=sal;
		this.hiredate=hdate;
	}
	
	public EmpImpl(String name, int sal) {
		this(name, sal, null);
	}
	
	public EmpImpl(String name) {
		this(name, 0, null);
	}
	
	@Override
	public void info1() {
		System.out.println("Name: "+name);
		// TODO Auto-generated method stub

	}

	@Override
	public void info2() {
		this.info1();
		System.out.println("Salary: "+sal);
		// TODO Auto-generated method stub

	}

	@Override
	public void info3() {
		this.info2();
		System.out.println("Hiredate: "+hiredate);
		// TODO Auto-generated method stub

	}

	@Override
	public void info4() {
		// TODO Auto-generated method stub

	}

}
