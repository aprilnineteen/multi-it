package day05;

import java.util.Stack;

public class �ùٸ���ȣ {

	public static boolean solution(String str) {
		boolean answer = false;
		char ch[] = str.toCharArray();
		Stack<Character> sk = new Stack<>();
		for (char c : ch) {
			if (c == '(') {
				// ���ÿ� Ǫ��
				sk.push(c);
			} else {// ')'�� ���
				if (sk.isEmpty())
					return answer; // ��� ������ false ��ȯ
				// ���ÿ��� ��
				sk.pop();
			}
		}
		//������ ��� ������ ¦�� �´� ���, ��� ���� �ʴٸ� ���� �ʴ� ���
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
		System.out.println("�ùٸ� ��ȣ?: " + b);

	}

}
