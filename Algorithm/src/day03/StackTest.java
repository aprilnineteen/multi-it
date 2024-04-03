package day03;
import java.util.*;
public class StackTest {

	public static void main(String[] args) {
		Stack<String> sk = new Stack<>();
		sk.add("홍길동");
		sk.push("차승원");
		sk.push("유재석");
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
		
		sk.push("사나");
		sk.push("미나");
		System.out.println(sk);
		int idx = sk.indexOf("사나");
		System.out.println(idx);
		idx = sk.indexOf("르세라핌");
		System.out.println(idx);
		System.out.println(sk.size());
		// 있는 데이터: 0, 없는 데이터: -1
		sk.clear();
		System.out.println(sk.size());
		}

}
