package ex01;
//Target: �ٽ� ������ ���� ��ü
public class ServiceImpl implements Service {

	//�ٽ� ������ �����ϴ� �޼���
	@Override
	public void sayHello(String... names) {
		if(names!=null) {
			for(String name:names) {
				System.out.println("Hello~ "+name);
			}
		}
		
	}

}
