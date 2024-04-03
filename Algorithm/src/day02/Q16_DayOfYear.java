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
	int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // ����� ���� �ϼ�
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }// ������ ���� �ϼ�
	};

	public static final int LEAP_YEAR = 1;
	public static final int NORM_YEAR = 0;

	public void input_date() {
		int n = 0;
		do {
			int year, month, day, total = 0, isLeap = NORM_YEAR;
			System.out.print("��: ");
			year = sc.nextInt();
			System.out.print("��: ");
			month = sc.nextInt();
			System.out.print("��: ");
			day = sc.nextInt();

			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				isLeap = LEAP_YEAR;
			}

			// �ݺ��� ���鼭 ��, ��, �� �Է¹޾� �ϼ� ����ϴ� �޼���

			for (int i = 0; i < month - 1; i++) {
				total += mdays[isLeap][i];
				System.out.println((i + 1) + "��: " + mdays[isLeap][i] + "��");
			}
			total += day;
			System.out.println("�� �� �� �����Ͻðڽ��ϱ�?");
			System.out.println("�� " + total + "���Դϴ�.");
			n = sc.nextInt();
		} while (n == 1);
		System.out.println("Bye Bye");
	}

	public static void main(String[] args) {
		Q16_DayOfYear app = new Q16_DayOfYear();
		app.input_date();
	}

}
