package day02;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchSentinel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭 ũ�� �Է�: ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] arr2 = new int[n+1]; //���ʹ��� ����� �迭, �������� �迭 �������� ��������

		System.out.print("������ ������ ������ �Է�: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = arr[i];
		}
		System.out.print(Arrays.toString(arr));
		System.out.println("�˻��� �� �Է�: ");
		int key = sc.nextInt();
		int idx = solution(arr, n, key);
		int idx2=solution2(arr2, n, key);
		System.out.println((idx < 0) ? key + "�� �����ϴ�" : key + "�� �迭 �ε��� " + idx + "���� �־��");
		System.out.println("���ʹ��� �̿��� �˻� ���: idx2 "+idx2);
		if(idx2==arr2.length-1) {
			System.out.println(key+"���� �迭 arr2�� �����ϴ�.");
		}
	}
	public static int solution(int[] arr, int n, int key) {
		// ���� �˻�
		//for(int i=0; i<arr.length; i++) {if(arr[i]==key)return i;} return -1;
	
		int idx=0;
		while(true) {
			if(idx==n) return -1; //�˻� ���� ���� ���
			if(arr[idx]==key) { //�˻� ���� �ִ� ���
				return idx;
			}
			idx++;
		}
	}//
	
	public static int solution2(int[] arr, int n, int key) {
		// ���ʹ��� Ȱ���� ���� �˻� => �Ǵ� Ƚ�� ���̴� ��
		arr[n]=key; //���ʰ��� �迭 ���� ����
		System.out.println("---���ʰ� ���� ��---");
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
