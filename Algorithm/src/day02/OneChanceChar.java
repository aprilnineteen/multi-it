package day02;

import java.util.*;

public class OneChanceChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요: ");
		String str = sc.next();
		So2lution sol = new So2lution();
		System.out.println(sol.solution(str));
	}
}

class So2lution {
	public String solution(String s) {
		String answer = "";
		String[] arr = s.split("");
		Arrays.sort(arr);
		int count=0;
		
		for(int i=0; i<arr.length; i++) {
				count = 0;
			for(int j=0; j<arr.length; j++) {
				if(arr[i].equals(arr[j])) {
					count++;
				}
			}
			if(count == 1) {
				answer += arr[i];
			}
		}

		return answer;

	}
}