package day01;

import java.util.Scanner;
//1.
///*int a=5555, b=12;
//int mx = max1(a,b);
//System.out.println("최대값: "+mx);
//
//int m=235, n=122, k=432;
//mx = max2(m, n, k);
//System.out.printf("최대값: %d\n",mx);
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
		System.out.println("배열 크기: ");
		int size = sc.nextInt();
		//배열 메모리 할당
		int [] arr = new int[size];
		
		System.out.println("배열에 저장할 값 입력");
		//반복문 돌면서 배열에 저장한 값 입력받기
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int mn = min1(arr);
		System.out.println("최소값은 "+mn);
	}

}

