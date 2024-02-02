package day02;

public class Casting {

	public static void main(String[] args) {

		// 형변환
		// [1] 자동형변환
		// [2] 강제형변환 ==> 형변환 연산자를 사용 (자료형)변수
		// byte < short < int < long < float < double
		// char
		
		byte b=10;
		float f=b;//byte 타입 => float로 자동 형변환
		System.out.println(b);
		System.out.println(f);
		
		double d=123.456;
		
		short s=(short)d;//강제형변환(casting) : 데이터 손실이 발생할 수 있다.
		System.out.println(d);
		System.out.println(s);
	
		int x=68;
		char y=(char)x;
		System.out.printf("x=%d\n", x);
		System.out.printf("y=%c\n", y);
		//형변환한 뒤 x, y값 출력
		
		double result=b + y *f;//promotion
		//byte+char+float
		System.out.println(result);
		byte m=1;
		byte n=5;
		/* int형보다 작은 유형의 데이터가 연산에 사용되면 자동으로 int형으로 형변환 일어남
		 * byte, float, char은 어떤 연산자든 int 사용됨
		 */
		int result2=m+n;
		System.out.printf("%d\n", result2);
		
		char c1='A';
		char c2='B';
		int c3=c1+c2;
		String c4=""+c1+c2;
		System.out.println(c3);//131
		System.out.println(c4);//AB
	}

}
