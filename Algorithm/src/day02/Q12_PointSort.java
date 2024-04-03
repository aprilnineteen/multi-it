package day02;

import java.util.Arrays;
import java.util.Scanner;

public class Q12_PointSort {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// x,y좌표로 갖는 Point 클래스를 구현하여 정렬하세요
		// 우선 x좌표 내림차순 정렬하되, x값이 동일할 경우 y 내림차순으로 정렬하세요
		PointSortX();

	}

	public static void PointSortX() {
		System.out.println("좌표 개수 ");
		int n = sc.nextInt();
		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			System.out.println("x, y 좌표를 입력하세요: ");
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Point(x, y);
		}
		
		System.out.println(Arrays.toString(points));
		final Pointx px = new Pointx();
		Arrays.sort(points, px);
		System.out.println("배열 x좌표 내림차순 후");
		System.out.println(Arrays.toString(points));

			System.out.println("x값 동일한 경우 y좌표 오름차순 정리");
			final Pointy py = new Pointy();
			Arrays.sort(points, py);
			System.out.println("배열 y좌표 오름차순 후");
			System.out.println(Arrays.toString(points));
	}
}
