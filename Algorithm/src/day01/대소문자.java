package day01;

import java.util.Scanner;

public class 대소문자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String answer = "";
		int tmp;
		for (int i = 0; i < a.length(); i++) {
			tmp = a.charAt(i);

			if (65 <= tmp && tmp <= 90)
				answer += (char) (tmp + 32);

			if (97 <= tmp && tmp <= 122)
				answer += (char) (tmp - 32);
		}
		System.out.println(answer);
	}
}

class Solution2312 {
	public String solution(String myString) {
		String answer = "";
		String a;
		char[]arr = myString.toCharArray();
//		for (int i = 0; i < arr.length(); i++) {
//			myString.charAt(i) == 'a' ? 'A' : 'a';

		return answer;
	}
}