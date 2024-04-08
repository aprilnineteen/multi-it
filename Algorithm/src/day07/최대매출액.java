package study;

import java.util.Scanner;

public class 최대매출액 {
// 슬라이딩 윈도우 사용
// 18 22 15 25 19 26 12 17 27 21
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("며칠의 매출 기록을 입력하실래요?");
		int n = sc.nextInt();
		System.out.println("연속 며칠의 매출을 구할까요?");
		int k = sc.nextInt();
		System.out.printf("%d일 간의 매출 기록을 입력하세요%n", n);
		int[] a = new int[n];
		// 매출 기록 입력받기
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int max = solution(n, k, a);
		System.out.println("최대 매출액: " + max);
	}

	private static int solution(int n, int k, int[] a) {
		int max = 0;
		int sum = 0;

		// 연속 k일의 합 계산
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}

		max = sum;

		for (int i = k; i < n; i++) {
			sum += a[i] - a[i - k];
			max = Math.max(max, sum);
		}

		return max;
	}

}
