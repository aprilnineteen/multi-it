package day01;

import java.util.Scanner;
//1.
///*int a=5555, b=12;
//int mx = max1(a,b);
//System.out.println("�ִ밪: "+mx);
//
//int m=235, n=122, k=432;
//mx = max2(m, n, k);
//System.out.printf("�ִ밪: %d\n",mx);
//
//mx = max3(a, m, n, k);
//System.out.println(mx);*/
public class Q1_Max {
	public static int max1(int x, int y) {
		if(x>y) {
			y=x;
		}return y;
	}

	public static int max2(int x, int y, int z) {
		int max = x;
		if (max < y) max = y;
		if (max < z) max = z;
		return max;
	}
	public static int max3(int x, int y, int z, int q) {
		return max1(max1(x,y), max1(z,q));
	}
	
	
	public static int min1(int[] arr) {
		int min = arr[0];
	    for(int i = 1; i < arr.length; i++) {
	        if (arr[i] < min) min = arr[i];
	    }
	    return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�迭 ũ��: ");
		int size = sc.nextInt();
		//�迭 �޸� �Ҵ�
		int [] arr = new int[size];
		
		System.out.println("�迭�� ������ �� �Է�");
		//�ݺ��� ���鼭 �迭�� ������ �� �Է¹ޱ�
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int mn = min1(arr);
		System.out.println("�ּҰ��� "+mn);
	}

}

