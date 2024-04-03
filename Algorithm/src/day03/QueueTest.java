package day03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> q = new LinkedList<>();
		q.add("Hello"); // 추가
		q.add("Bye"); // 추가
		System.out.println(q);
		System.out.println("q.peek(): " + q.peek());// 맨 앞 요소 반환
		System.out.println("q.element(): " + q.element());// 맨 앞 요소 반환

		q.remove();// 맨 앞 요소부터 삭제
		System.out.println("q.peek(): " + q.peek());
		q.poll();// 삭제
		System.out.println("q.peek(): " + q.peek());

		System.out.println("q.isEmpty(): " + q.isEmpty());

		q.offer("Hi");
		q.offer("안녕");
		q.offer("반가워요");

		System.out.println(((LinkedList<String>) q).get(0));
		System.out.println("-------------------------------");
		// for루프 이용해서 한꺼번에 q에 저장된 값 출력
		for (String str : q) {
			System.out.println(str);
		}
		System.out.println("-------------------------------");
		// iterator() 메서드 이용해서 한꺼번에 q에 저장된 값 출력
		Iterator<String> it = q.iterator();
		while (it.hasNext()) {
			String str = it.next(); // 한 칸 다음으로 이동
			System.out.println(str);
		}
	}

}
