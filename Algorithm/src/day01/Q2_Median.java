package day01;

public class Q2_Median {

	public static void main(String[] args) {
		int x = 324, y = 890, z = 234;
		int res = median(x, y, z);
		System.out.printf("%d, %d, %d ���� �߾Ӱ��� %d\n", x, y, z, res);
	}

	public static int median(int a, int b, int c) {
		int res = (a >= b && a <= c) || (a >= c && a <= b) ? a : (b >= a && b <= c) || (b >= c && b <= a) ? b : c;
		return res; // �߾Ӱ� ��ȯ
	}

}
