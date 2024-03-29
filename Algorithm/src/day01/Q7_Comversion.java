package day01;

import java.util.Scanner;

public class Q7_Comversion {

	// 매개변수 num의 값을 이진수 문자열로 변환하여 반환하는 메서드를 구성하세요
	public static String conv_binary(int num) {
	String answer="";
		
		while(num!=0) {
			int rest=num%2;
				num=num/2;
		System.out.print("몫: "+num);
		System.out.println(" 나머지: "+rest);
			answer=rest+answer;
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("양의 정수를 입력: ");
		int num = sc.nextInt();
		System.out.println(conv_binary(num));
	}

}
