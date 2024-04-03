package day02;

import java.util.Scanner;

/*  평년 2월 28일
 *  윤년 2월 29일
 * ----------------------------------
 *  윤년의 판단 기준
 *  - 년도를 4로 나누어 떨어지면서 100으로는 나누어 떨어지면 안된다
 *  - 다만 400으로 나누어 떨어지면 윤년
 * 
 * */
public class Q16_DayOfYear {

	Scanner sc = new Scanner(System.in);
	int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년의 월별 일수
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }// 윤년의 월별 일수
	};

	public static final int LEAP_YEAR = 1;
	public static final int NORM_YEAR = 0;

	public void input_date() {
		int n = 0;
		do {
			int year, month, day, total = 0, isLeap = NORM_YEAR;
			System.out.print("년: ");
			year = sc.nextInt();
			System.out.print("월: ");
			month = sc.nextInt();
			System.out.print("일: ");
			day = sc.nextInt();

			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				isLeap = LEAP_YEAR;
			}

			// 반복문 돌면서 년, 월, 일 입력받아 일수 출력하는 메서드

			for (int i = 0; i < month - 1; i++) {
				total += mdays[isLeap][i];
				System.out.println((i + 1) + "월: " + mdays[isLeap][i] + "일");
			}
			total += day;
			System.out.println("한 번 더 수행하시겠습니까?");
			System.out.println("총 " + total + "일입니다.");
			n = sc.nextInt();
		} while (n == 1);
		System.out.println("Bye Bye");
	}

	public static void main(String[] args) {
		Q16_DayOfYear app = new Q16_DayOfYear();
		app.input_date();
	}

}
