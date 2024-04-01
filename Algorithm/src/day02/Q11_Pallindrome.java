package day02;

import java.util.Scanner;

// ȸ�� ���ڿ�
public class Q11_Pallindrome {

	public static String solution(String str) {
		String answer = "";
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
			System.out.println(reverse);
		}
		answer = reverse.equals(str) ? "ok" : "no";
		return answer;
	}

	public static String solution2(String str) {
		// ������ Ǯ��
		String answer = "Pllindrome OK";
		char[] ch = str.toLowerCase().toCharArray();
		for (int i = 0; i < ch.length / 2; i++) {
			char c1 = ch[i];
			char c2 = ch[ch.length - i - 1]; // �ں���
			if (c1 != c2) {
				answer = "Pllindrome NO";
				break;
			}
		}
		return answer;
	}
	
	public static String solution3(String str) {
		//stringbuffer/builder ����
		str=str.toLowerCase();
		StringBuilder sb = new StringBuilder(str);
		String str2=sb.reverse().toString();
		if(str.equalsIgnoreCase(str2)) {
			return "ok";
		}
		return "no";
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ���");
		String str = sc.next();
		System.out.println(solution(str));
		// Pallindrome ok/no

	}

}
