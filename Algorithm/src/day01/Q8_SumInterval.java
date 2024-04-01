package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q8_SumInterval {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("배열 크기 입력: ");
		int n = sc.nextInt();

		System.out.println("구간의 합 몇 번: ");
		int m = sc.nextInt();

		int[] arr = solution(n, m);
		System.out.println(Arrays.toString(arr));

	}

	public static int[] solution(int n, int m) {
		int answer[] = {};
		int[] a = new int[n];
		System.out.println("배열에 저장할 정수 입력: ");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			
		}
		System.out.println("구간의 시작값, 끝값");
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int sum = 0;
			for (int x = start; x <= end; x++) {
				sum += a[x - 1]; // 구간의 합
			}
			answer[i] = sum;
		}
		return answer;
	}

	public static int[] solution2(int n, int m) {
		int answer[] = new int[m];
		int[] a = new int[n];
		System.out.println("배열에 저장할 정수 입력: ");
		int[] sumArr = new int[n+1];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sumArr[i+1]=sumArr[i]+a[i];
		}
		System.out.println("구간의 시작값, 끝값");
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int result = sumArr[end]-sumArr[start-1];
			answer[i]=result;
		}	
			return answer;
	}
}
