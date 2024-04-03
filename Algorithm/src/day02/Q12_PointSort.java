package day02;

import java.util.Arrays;
import java.util.Scanner;

public class Q12_PointSort {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// x,y��ǥ�� ���� Point Ŭ������ �����Ͽ� �����ϼ���
		// �켱 x��ǥ �������� �����ϵ�, x���� ������ ��� y ������������ �����ϼ���
		PointSortX();

	}

	public static void PointSortX() {
		System.out.println("��ǥ ���� ");
		int n = sc.nextInt();
		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			System.out.println("x, y ��ǥ�� �Է��ϼ���: ");
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Point(x, y);
		}
		
		System.out.println(Arrays.toString(points));
		final Pointx px = new Pointx();
		Arrays.sort(points, px);
		System.out.println("�迭 x��ǥ �������� ��");
		System.out.println(Arrays.toString(points));

			System.out.println("x�� ������ ��� y��ǥ �������� ����");
			final Pointy py = new Pointy();
			Arrays.sort(points, py);
			System.out.println("�迭 y��ǥ �������� ��");
			System.out.println(Arrays.toString(points));
	}
}
