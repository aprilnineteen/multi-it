package day01;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		//�迭 ī�� : ���� ����, ���� ����
		int[] a = {10,20,30};
		int tmp[];
		tmp=a; //���� ����, ���� �迭 ����

		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(tmp)+tmp);
		
		tmp[1]=200;
		
		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(tmp)+tmp);
		//clone(): ���� ����, ���� ����� ��Ҹ� ī���� ���ο� �迭 ����
		
		int[] b=a.clone();
		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(b)+b);
		b[1]=20;
		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(b)+b);
	}

}
