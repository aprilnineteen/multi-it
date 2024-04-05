package day05;

/*������ �˰����� �������� �˰����� ���� �ӵ��� �����ϱ� ���� ������� �˰���.
 * �������� �׷��� ������ �׷� �ȿ��� �� ������ �����ϰ�, �������� ���������� �����ϴ� �˰����̴�.
 * ���������� ����: ��κ��� ���ĵǾ� �ִ� ���¿� ����� �� �ӵ��� ���� ������
 *         ����: ������ ���� �ָ� �������� �̵�(����)�ϴ� Ƚ���� ����.
 *         ex) 1 2 3 4 5 0 6  ���� �迭�� ��� 0�� �����Ϸ��� �� 6ȸ�� ���� ��Ҹ� �̵����Ѿ� �Ѵ�.
 *�������� �ð����⵵�� O(n^1.25), �������� O(n^2)���ٴ� ������. but���������� ���� �ָ� ������ ��Ҹ� ��ȯ������         
 * */
import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 1, 4, 2, 33, 7, 6, 3, 5, 25, 26, 13, 34, 20 };
		System.out.println(Arrays.toString(arr));
		// intervalSort(arr);
		intervalSort2(arr);
		System.out.println("�� ���� ��");
		System.out.println(Arrays.toString(arr));
	}

	/*
	 * interval�� n����� ������Ű�� ���� �׷��� ���� ������ �ʰ� ���� ����� ������ �� �ִ�. �̸� �����ϱ� ���ؼ� interval��
	 * [3*n+1 ==> interval]
	 * 
	 */
	private static void intervalSort2(int[] arr) {
		// interval�� �ʱⰪ�� ���ϱ� ���ؼ� �ݺ����� ���� ����
		int inter;
		for (inter = 1; inter < arr.length; inter = inter * 3 + 1)
			;
		// 1, 4, 13
		// System.out.print(inter+",")};
		// System.out.println();
		System.out.println("inter: " + inter);
		// inter 13���� ����
		for (; inter > 0; inter /= 3) {
			for (int i = inter; i < arr.length; i++) {
				// System.out.println("i: "+i+", inter: "+inter);
				int tmp = arr[i];
				int j = i - inter;
				for (; j >= 0; j -= inter) {
					// System.out.println("i: "+i+" inter: "+inter);
					if (arr[j] > tmp) {
						arr[j + inter] = arr[j]; // �ڷ� �о
					} else {
						break;
					}
				}
				arr[j + inter] = tmp;
			}
			// System.out.println(Arrays.toString(arr));
			// System.out.println("---------------------");
		}
	}

	private static void intervalSort(int[] arr) {
		// interval: 4, 2, 1 ������ �ǳʶٱ� �ϸ鼭 ���� ������ �����Ѵ� => ������
		for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
			for (int i = interval; i < arr.length; i++) {
				int tmp = arr[i];
				int j = i - interval;
				System.out.println("interval:" + interval + ", tmp: " + tmp);
				for (; j >= 0; j -= interval) {
					if (arr[j] > tmp) {
						arr[j + interval] = arr[j];
					} else {
						break;
					}
				}
				arr[j + interval] = tmp;
				System.out.println(Arrays.toString(arr));
				System.out.println("--------------------");
			}
		}

	}

}
