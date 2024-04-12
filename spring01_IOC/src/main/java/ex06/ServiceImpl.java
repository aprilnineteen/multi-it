package ex06;

public class ServiceImpl implements Service {
	
	//property
	private Emp emp;//ÀÇÁ¸¼º

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	@Override
	public void info() {
		System.out.printf("Name: %s\nDept: %s\nSalary: %d\n",
				emp.getName(),emp.getDept(),emp.getSal());

	}

}
