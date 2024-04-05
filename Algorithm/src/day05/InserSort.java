package day05;

import java.util.Arrays;

public class InserSort {

	public static void main(String[] args) {
		int[] arr = { 6, 4, 1, 7, 3, 9, 8 };
		System.out.println(Arrays.toString(arr));
		//insertSort(arr);
		inserSort2(arr);
		System.out.println("���� ���� ��");
		System.out.println(Arrays.toString(arr));
	}
private static void inserSort2(int[] a) {
		for(int i=1; i<a.length; i++) {
			int tmp=a[i];
			int j=i-1;
			for(;j>=0 && a[j]>tmp;j--) {
				a[j+1]=a[j];
			}
			a[j+1]=tmp;
		}//for
		
	}/////

	//if else ������ �ȿ� ������ �ڵ带 ���� �� �ִ�.
	static void insertSort(int[] a) {
		for(int i=1; i<a.length; i++) {
			int tmp=a[i];// ÷���� ������ (������ ��ġ�� ã�ư���)
			int j=i-1;
			for(;j>=0;j--) {
				if(a[j] > tmp) {
					a[j+1]=a[j];//�ڷ� �о��
				}else {
					break;
				}
			}//for---
			//System.out.println(j+": "+Arrays.toString(a));
			a[j+1]=tmp; //���� ��ġ ã�Ҵٸ� ����
		}
	}
}
