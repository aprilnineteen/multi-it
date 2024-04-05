package day05;

import java.util.Arrays;

/* 퀵 정렬 알고리즘을 알아보기 전에 pivot을 하나 정해 2 그룹으로 나누어 데이터를 교환하는 작업을 수행해 보자*/
public class Partition {

	public static void main(String[] args) {
		int []arr= {5,7,1,4,6,2,3,9,8};
		System.out.println(Arrays.toString(arr));
		partition(arr);
		System.out.println("2그룹 분할");
		System.out.println(Arrays.toString(arr));
		
	}

	private static void partition(int[] arr) {
		int pl=0; //증가
		int pr=arr.length-1; //감소
		int pivot=arr[arr.length/2]; //기준 피벗
		while(pl<=pr) {
			while(arr[pl] < pivot) pl++;
			while(arr[pr] > pivot) pr--;
			if(pl<=pr) {
				swap(arr, pl, pr);
				pl++;
				pr--;
			}
			System.out.println("pivot: "+pivot);
		}
	}
	static void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
