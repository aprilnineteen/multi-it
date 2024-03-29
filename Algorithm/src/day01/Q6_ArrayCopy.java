package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_ArrayCopy {
	Scanner sc = new Scanner(System.in);

	public int[] input(int i) {
		System.out.println("��ڼ� �Է�: ");
		// �Է¹޾� �迭 �޸� �Ҵ�
		int[] arr = new int[sc.nextInt()];
		// �ݺ��� ���鼭 �Է¹޾� �迭�� ����
		for (i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] :");
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public void copy(int[] a, int[] b) {
		if (a.length < b.length) {
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
		}
		else{
			for (int i = 0; i < b.length; i++) {
				a[i] = b[i];
			}
		}
		System.out.println("ī�� �Ϸ�");
	}

	public void reverse_copy(int[] a, int[] b) {
		if (a.length < b.length) {
			for (int i = 0; i < a.length; i++) {
				b[i]=b[b.length-i-1];
						b[i]= a[i];
			}
		}
		else{
			for (int i = 0; i < b.length; i++) {
				a[i]=a[a.length-i-1];
						a[i]= b[i];
			}
		}
		System.out.println("reverse");
	}

	public static void main(String[] args) {
		// �迭 2�� input()�ؼ� ����, ũ�� ���� �� �迭 ū ������ ī�� �� ����� ���
		Q6_ArrayCopy q6 = new Q6_ArrayCopy();
		int[] a = q6.input(0);
		int[] b = q6.input(1);
//		q6.copy(a, b);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		
		q6.reverse_copy(a, b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

}
