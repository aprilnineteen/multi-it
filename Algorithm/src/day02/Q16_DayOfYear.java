package day02;

import java.util.Scanner;

/*  ��� 2�� 28��
 *  ���� 2�� 29��
 * ----------------------------------
 *  ������ �Ǵ� ����
 *  - �⵵�� 4�� ������ �������鼭 100���δ� ������ �������� �ȵȴ�
 *  - �ٸ� 400���� ������ �������� ����
 * 
 * */
public class Q16_DayOfYear {

	Scanner sc = new Scanner(System.in);
	int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // ����� ���� �ϼ�
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }// ������ ���� �ϼ�
	};

	public void input_date() {
		
	}
	
	public static void main(String[] args) {
		Q16_DayOfYear app = new Q16_DayOfYear();
		app.input_date();
	}

}
