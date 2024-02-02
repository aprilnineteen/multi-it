package day02;
/* Reference Type (참조형)
 *  [1] 클래스형
 *  [2] 인터페이스형
 *  [3] 배열
 *  - 참조형은 반드시 new 연산자로 객체를 생성해서 사용해야 한다.
 *    다만 예외는 있다. String의 경우 자주 사용하기 때문에
 *    기본자료형처럼 문자열값(literal)을 직접 할당하도록 하고 있다.
 *    Integer, Float, Double,Character
 * */

import java.util.Date;
public class Reference {
	//main
	public static void main(String[] args) {
		int a=100;
//		Date d="2024-01-23";
		Date d=new Date();
		System.out.println(d);
		//String도 참조형
		String s1=new String("Hello");
		System.out.println(s1);
		System.out.println(s1);
		Integer i=100; //참조형
		int j=100;//기본자료형
		
		int m=20;
		int n=30;
		System.out.println("합=>"+m+n);
		System.out.println("합=>"+(m+n));
		System.out.println(m+n+"<=합");
	}
}
