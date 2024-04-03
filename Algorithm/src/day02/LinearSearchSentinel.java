package day02;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchSentinel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 크기 입력: ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] arr2 = new int[n+1]; //보초법에 사용할 배열, 보조값을 배열 마지막에 저장하자

		System.out.print("저장할 데이터 정수값 입력: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = arr[i];
		}
		System.out.print(Arrays.toString(arr));
		System.out.println("검색할 값 입력: ");
		int key = sc.nextInt();
		int idx = solution(arr, n, key);
		int idx2=solution2(arr2, n, key);
		System.out.println((idx < 0) ? key + "는 없습니다" : key + "는 배열 인덱스 " + idx + "번에 있어요");
		System.out.println("보초법을 이용한 검색 결과: idx2 "+idx2);
		if(idx2==arr2.length-1) {
			System.out.println(key+"값은 배열 arr2에 없습니다.");
		}
	}
	public static int solution(int[] arr, int n, int key) {
		// 선형 검색
		//for(int i=0; i<arr.length; i++) {if(arr[i]==key)return i;} return -1;
	
		int idx=0;
		while(true) {
			if(idx==n) return -1; //검색 값이 없는 경우
			if(arr[idx]==key) { //검색 값이 있는 경우
				return idx;
			}
			idx++;
		}
	}//
	
	public static int solution2(int[] arr, int n, int key) {
		// 보초법을 활용한 선형 검색 => 판단 횟수 줄이는 법
		arr[n]=key; //보초값을 배열 끝에 저장
		System.out.println("---보초값 저장 후---");
		System.out.println(Arrays.toString(arr));
		System.out.println("---------------");
		int idx=0;
		while(true) {
			if(arr[idx]==key) {
				break;
			}
			idx++;
		}//while
		return idx;
	}//
}
