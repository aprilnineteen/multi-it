package day05;

import java.util.*;

public class PalindromeRecur {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		String str = sc.next();
		str = str.toLowerCase();
		char[] ch = str.toCharArray();

		boolean b = isPallindrome(ch);
		System.out.println("isPallindrome: "+b);
	}

	static boolean isPallindrome(char[] ch) {
		if (ch.length <= 1)
			return true;
		else if (ch[0] != ch[ch.length - 1]) {
			return false;
		} else {
			return isPallindrome(Arrays.copyOfRange(ch, 1, ch.length-1));
			// Arrays.copyOfRange(배열, start, end);
			// start < = arr < end 사이의 사본을 만들어서 반환
		}
	}

}
