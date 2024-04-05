package day01;

import java.util.Scanner;

public class Q7_Conversion {
	
	//매개변수 num의 값을 2진수 문자열로 변환하여 반환하는 메서드를 구성하세요
	public static String conv_binary(int num) {
		String answer="";
		int[] arr=new int[32];
		int cnt=0;
		do {
			int mod=num%2;
			arr[cnt++]=mod;
			num/=2;
		}while(num!=0);		
		for(int i=0;i<cnt;i++) {
			answer+=arr[cnt-1-i];
		}		
		return answer;
	}//---------------------
	
	public static String conv_binary2(int num) {
		StringBuffer buf=new StringBuffer("");
		do {
			int mod=num%2;
			buf.append(mod);
			num/=2;
		}while(num!=0);
		return buf.reverse().toString();
	}//----------------------
	public static String conv_radix(int num, int radix) {
		String str="0123456789ABCDEF";
		String answer="";
		while(num>0) {
			answer = str.charAt(num%radix)+answer;
			num/=radix;
		}
		return answer;
	}//-----------------------------
	
	public static String conv_hexadecimal(int num) {
        String answer = "";
        while(num>0) {
            int remainder=num%16;
            answer = (remainder>=10)?Character.toString((char)(remainder+55)):Integer.toString(remainder)+answer;
            num=num/16;
        }
        return answer;
    }//--------------------------------

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("양의 정수를 입력: ");
		int num=sc.nextInt();
		//System.out.println(conv_binary2(num));
		System.out.println("몇 진수로 바꿀까요(2~16): ");
		int radix=sc.nextInt();
		//System.out.println(conv_radix(num,radix));
		System.out.println(num+"의 16진수: "+conv_hexadecimal(num));
	}

}
