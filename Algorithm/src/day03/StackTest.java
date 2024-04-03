package day03;
import java.util.*;
public class StackTest {

	public static void main(String[] args) {
		Stack<String> sk = new Stack<>();
		sk.add("ȫ�浿");
		sk.push("���¿�");
		sk.push("���缮");
		System.out.println(sk.peek());
		System.out.println(sk.get(0));
		System.out.println(sk.get(1));
		sk.pop();
		System.out.println(sk.peek());
		System.out.println(sk.size());
		System.out.println("------------------");
		while(!sk.isEmpty()) {
			String item=sk.pop();
			System.out.println(item);
		}
		System.out.println(sk.size());
		
		sk.push("�糪");
		sk.push("�̳�");
		System.out.println(sk);
		int idx = sk.indexOf("�糪");
		System.out.println(idx);
		idx = sk.indexOf("��������");
		System.out.println(idx);
		System.out.println(sk.size());
		// �ִ� ������: 0, ���� ������: -1
		sk.clear();
		System.out.println(sk.size());
		}

}
