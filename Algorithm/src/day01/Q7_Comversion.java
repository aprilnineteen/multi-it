package day01;

import java.util.Scanner;

public class Q7_Comversion {

	// �Ű����� num�� ���� ������ ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼��带 �����ϼ���
	public static String conv_binary(int num) {
	String answer="";
		
		while(num!=0) {
			int rest=num%2;
				num=num/2;
		System.out.print("��: "+num);
		System.out.println(" ������: "+rest);
			answer=rest+answer;
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ������ �Է�: ");
		int num = sc.nextInt();
		System.out.println(conv_binary(num));
	}

}
