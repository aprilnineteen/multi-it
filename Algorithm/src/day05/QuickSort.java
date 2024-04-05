package day05;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int [] arr= {1,8,7,4,5,2,6,3,9};
		System.out.println(Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println("퀵 정렬 후");
		System.out.println(Arrays.toString(arr));
	}

	static void printProcess(int[] arr, int left, int right, int pivot) {
		System.out.printf("arr[%d] ~ arr[%d] : {", left, right);
		for(int i=left; i<right;i++) {
			System.out.printf("%d,", arr[i]);
		}
		System.out.printf("%d}\n",arr[right]);
		System.out.println("pivot: "+pivot);
	}
	
	
	static void quickSort(int[] arr, int left, int right) {
		int pl=left;
		int pr=right;
		int pivot=arr[(pl+pr)/2];
		
		printProcess(arr, left, right, pivot);
		
		do {
			while(arr[pl] < pivot) pl++; //피벗보다 작으면 포인터 증가
			while(arr[pr] > pivot) pr--; //피벗보다 크면 포인터 증가
			if(pl<=pr) {
				swap(arr, pl++, pr--);
			}
		}while(pl<=pr);
		if(left<pr)
		quickSort(arr, left, pr);// 재귀호출
		if(right>pl)
		quickSort(arr, pl, right);//재귀호출
		
	
	
	}

	static void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}