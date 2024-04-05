package day06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
 * */
import java.util.Scanner;

public class Q2_ArraysSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("격자판수 입력: ");
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		System.out.println(n + "행 " + n + "열에 저장할 값 입력: ");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max = solution2(arr);
		System.out.println("각 행, 열, 대각선 1/2 합의 최대값: " + max);
	}

	private static int solution2(int[][] arr) {
		// ArrayList, sort 사용
		int row_sum, col_sum; // 행의 합, 열의 합
		int d1 = 0, d2 = 0; // 대각선의 합을 담을 변수
		int max = -999;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			row_sum = 0;
			col_sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				col_sum += arr[i][j]; // 각 열의 합
				row_sum += arr[j][i]; // 각 행의 합
				if (i == j) {
					d1 += arr[i][j];
				}
				if (i + j == arr.length - 1) {
					d2 += arr[i][j];
				}
			}
			list.add(col_sum);
			list.add(row_sum);
			System.out.println(col_sum + "/" + row_sum);
		}
		list.add(d1); list.add(d2);
		// Collections.sort(list); //오름차순, sort 할 때 Collections로 사용
		/*Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // 내림차순
			}
		});*/
		//Collections.sort(list,(o1,o2)->o2-o1);
		Collections.sort(list,(o1,o2)->Integer.compare(01, 02));
		// 람다식
		System.out.println(list);
		// max = list.get(list.size()-1); // 오름차순
		max = list.get(0); // 최대값
		return max;
	}

	private static int solution(int[][] arr) {
		int row_sum, col_sum; // 행의 합, 열의 합
		int d1 = 0, d2 = 0; // 대각선의 합을 담을 변수
		int max = -999;
		for (int i = 0; i < arr.length; i++) {
			row_sum = 0;
			col_sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				col_sum += arr[i][j]; // 각 열의 합
				row_sum += arr[j][i]; // 각 행의 합
				if (i == j) {
					d1 += arr[i][j];
				}
				if (i + j == arr.length - 1) {
					d2 += arr[i][j];
				}
			}
			System.out.println(col_sum + "/" + row_sum + "/" + d1 + "/" + d2);
			if (col_sum > max) {
				max = col_sum;
			}
			if (row_sum > max) {
				max = row_sum;
			}
			if (d1 > max) {
				max = d1;
			}
			if (d2 > max) {
				max = d2;
			}
		}
		return max;
	}

}
