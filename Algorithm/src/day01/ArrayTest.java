package day01;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		//배열 카피 : 얕은 복사, 깊은 복사
		int[] a = {10,20,30};
		int tmp[];
		tmp=a; //얕은 복사, 같은 배열 참조

		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(tmp)+tmp);
		
		tmp[1]=200;
		
		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(tmp)+tmp);
		//clone(): 깊은 복사, 실제 저장된 요소를 카피해 새로운 배열 생성
		
		int[] b=a.clone();
		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(b)+b);
		b[1]=20;
		System.out.println(Arrays.toString(a)+a);
		System.out.println(Arrays.toString(b)+b);
	}

}
