package day03;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<String> sk1=new MyStack<>();
		sk1.push("HTML");
		sk1.push("JavaScript");
		sk1.push("Java");
		sk1.push("SQL");
		
		String topData=sk1.peek();
		System.out.println(topData);
		String item=sk1.pop();
		System.out.println(item+"�� �����Ǿ����");
		System.out.println(sk1.peek());
		sk1.pop();
		sk1.pop();
		System.out.println("sk1�� ���� top: "+sk1.peek());
		if(!sk1.isEmpty()) {
			sk1.pop();
		}
		//System.out.println(sk1.peek());
		//���� �߻�
		System.out.println("-------------------------");
	
		
		//[1] Double������ ������ MyStack�����ؼ� �Ǽ��� 3�� �����ϼ���
		MyStack<Double> sk2 = new MyStack<>();
		sk2.push(23.3);
		sk2.push(new Double(5.71));//deprecated
		sk2.push(Double.valueOf("9.4"));
		//[2] �ݺ��� �̿��ؼ� [1]�� ���ÿ� ����� ������ ����ϼ���
		/*for(int i=0; i<3; i++) {
			System.out.println(sk2.pop());
		}*/
		
		while(!sk2.isEmpty()) {
			System.out.println(sk2.pop());
		}
		//[3] Member��ü 3�� �����ؼ� ���ÿ� ������ ��,
		Member m1 = new Member("��ö��", 25, 165);
		Member m2 = new Member("ȫ�浿", 24, 153);
		Member m3 = new Member("������", 21, 179);
		
		MyStack<Member> sk3 = new MyStack<>();
		sk3.push(m1);
		sk3.push(m2);
		sk3.push(m3);
		//    �ݺ��� �̿��ؼ� ȸ�������� �Ѳ����� ����ϼ���
		for(int i=1; !sk3.isEmpty();i++) {
			Member user = sk3.pop();
			System.out.println(i+": "+user);
		}
	
	}

}
