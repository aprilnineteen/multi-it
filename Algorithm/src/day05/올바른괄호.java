package day05;

import java.util.Stack;

public class 올바른괄호 {

	public static boolean solution(String str) {
		boolean answer = false;
		char ch[] = str.toCharArray();
		Stack<Character> sk = new Stack<>();
		for (char c : ch) {
			if (c == '(') {
				// 스택에 푸시
				sk.push(c);
			} else {// ')'인 경우
				if (sk.isEmpty())
					return answer; // 비어 있으면 false 반환
				// 스택에서 팝
				sk.pop();
			}
		}
		//스택이 비어 있으면 짝이 맞는 경우, 비어 있지 않다면 맞지 않는 경우
		if(!sk.isEmpty()) return answer; //false
		answer=true;
		return answer;
	}

	public static void main(String[] args) {
		String str = "()()";
		String str2 = "(())()";
		String str3 = ")()(";
		String str4 = "(()(";
		boolean b = solution(str3);
		System.out.println("올바른 괄호?: " + b);

	}

}
