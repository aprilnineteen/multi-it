package day03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> q = new LinkedList<>();
		q.add("Hello"); // �߰�
		q.add("Bye"); // �߰�
		System.out.println(q);
		System.out.println("q.peek(): " + q.peek());// �� �� ��� ��ȯ
		System.out.println("q.element(): " + q.element());// �� �� ��� ��ȯ

		q.remove();// �� �� ��Һ��� ����
		System.out.println("q.peek(): " + q.peek());
		q.poll();// ����
		System.out.println("q.peek(): " + q.peek());

		System.out.println("q.isEmpty(): " + q.isEmpty());

		q.offer("Hi");
		q.offer("�ȳ�");
		q.offer("�ݰ�����");

		System.out.println(((LinkedList<String>) q).get(0));
		System.out.println("-------------------------------");
		// for���� �̿��ؼ� �Ѳ����� q�� ����� �� ���
		for (String str : q) {
			System.out.println(str);
		}
		System.out.println("-------------------------------");
		// iterator() �޼��� �̿��ؼ� �Ѳ����� q�� ����� �� ���
		Iterator<String> it = q.iterator();
		while (it.hasNext()) {
			String str = it.next(); // �� ĭ �������� �̵�
			System.out.println(str);
		}
	}

}
