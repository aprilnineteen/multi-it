package day01;

import java.util.Scanner;

public class Q5_ArrayEquals {
	Scanner sc = new Scanner(System.in);

	public int[] input(int i) {
		System.out.println("��ڼ� �Է�: ");
		//�Է¹޾� �迭 �޸� �Ҵ�
		int[] arr = new int[sc.nextInt()];
		//�ݺ��� ���鼭 �Է¹޾� �迭�� ����
		for(i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] :");
			arr[i]=sc.nextInt();
		}
		return arr;
	}

	public boolean equalsArray(int[] a, int[] b) {
		//a�� b�� ����� ��Ұ��� ������ true, �ٸ��� false ��ȯ
		if(a.length != b.length) return false;
		for(int i=0; i<a.length; i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
	public boolean equalsArray2(int[] a, int[] b) {
		boolean result;
		result = equalsArray(a, b) ? true : false;
			return result;
	}
		
	public static void main(String[] args) {
		//�迭 2�� input() ���� ��ȯ�޾� ���ϼ���
		Q5_ArrayEquals array = new Q5_ArrayEquals();
		int[] a = array.input(0);
		int[] b = array.input(1);
		
		boolean result = array.equalsArray(a, b);
		
		System.out.println(result ? "���� �迭�Դϴ�." : "�ٸ� �迭�Դϴ�.");
	}

}
