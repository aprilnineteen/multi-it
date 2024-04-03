package day03;

public class IntStackTest {

	public static void main(String[] args) {
		IntStack sk = new IntStack(5);
		System.out.println(sk.size());
		sk.push(10);
		sk.push(20);
		System.out.println(sk.size());
		sk.push(30);
		System.out.println(sk.peek());
		sk.push(40);
		sk.push(50);
		System.out.println(sk.peek());
		System.out.println(sk.full());
		if (!sk.full()) {
			sk.push(60);
		}
		sk.printStack();
		System.out.println(sk.pop()+"���� ���ÿ��� ����");
		System.out.println(sk.size()+"�� ���Ҿ��");
		System.out.println(sk.peek());
		sk.pop();
		sk.pop();
		System.out.println("sk.peek() "+sk.peek());
		System.out.println(sk.size()+"�� ���Ҿ��");
		sk.printStack();
		
		sk.clear();
		System.out.println(sk.size());
		if(!sk.empty()) {
			sk.pop();
		}
		//100~500 ����
		for(int i=1; i<6; i++) {
			sk.push(i*100);
		}
		System.out.println("--------------");
		//���
		sk.printStack();
		
		//300�� �˻�
		int idx=sk.search(300);
		if(idx>0) {
			System.out.println(idx+"��°�� �־��");
		}else {
			System.out.println("�����ϴ�");
		}
			//600�� �˻�
	}

}
