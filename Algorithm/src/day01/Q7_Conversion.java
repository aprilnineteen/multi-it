package day01;

import java.util.Scanner;

public class Q7_Conversion {
	
	//�Ű����� num�� ���� 2���� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼��带 �����ϼ���
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
		System.out.println("���� ������ �Է�: ");
		int num=sc.nextInt();
		//System.out.println(conv_binary2(num));
		System.out.println("�� ������ �ٲܱ��(2~16): ");
		int radix=sc.nextInt();
		//System.out.println(conv_radix(num,radix));
		System.out.println(num+"�� 16����: "+conv_hexadecimal(num));
	}

}
