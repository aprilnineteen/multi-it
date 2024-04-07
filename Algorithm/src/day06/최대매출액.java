package study;

import java.util.Scanner;

public class 최대매출액 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("며칠의 매출기록을 입력하실래요?");
		 int n=sc.nextInt();
		 System.out.println("연속 며칠의 매출을 구할까요?");
		 int k=sc.nextInt();
		 System.out.printf("%d일간의 매출기록을 입력하세요%n", n);
		 int[] a=new int[n];
		 //매출 기록 입력받기
		 
		 int max = solution(n, k, a);
		 System.out.println("최대 매출액: "+max);
	}

	private static int solution(int n, int k, int[] a) {
		
		return 0;
	}

}
