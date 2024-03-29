package day01;

import java.util.Scanner;

public class Q5_ArrayEquals {
	Scanner sc = new Scanner(System.in);

	public int[] input(int i) {
		System.out.println("요솟수 입력: ");
		//입력받아 배열 메모리 할당
		int[] arr = new int[sc.nextInt()];
		//반복문 돌면서 입력받아 배열에 저장
		for(i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] :");
			arr[i]=sc.nextInt();
		}
		return arr;
	}

	public boolean equalsArray(int[] a, int[] b) {
		//a와 b에 저장된 요소값이 같으면 true, 다르면 false 반환
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
		//배열 2개 input() 통해 반환받아 비교하세요
		Q5_ArrayEquals array = new Q5_ArrayEquals();
		int[] a = array.input(0);
		int[] b = array.input(1);
		
		boolean result = array.equalsArray(a, b);
		
		System.out.println(result ? "같은 배열입니다." : "다른 배열입니다.");
	}

}
