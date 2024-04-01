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
	int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년의 월별 일수
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }// 윤년의 월별 일수
	};

	public void input_date() {
		
	}
	
	public static void main(String[] args) {
		Q16_DayOfYear app = new Q16_DayOfYear();
		app.input_date();
	}

}
