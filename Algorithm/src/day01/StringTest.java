package day01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String s = "���� ���α׷��� ��������";
		String s2 = "��¥";
		// String: final Ŭ����(��� �� ����), immutability(�Һ���), ���� �Һ�
		System.out.println(s + s2); // ���ڿ� ����
		System.out.println(s.concat(s2));
		System.out.println(s);
		System.out.println(s.charAt(3));
		System.out.println(s.startsWith("����") + "," + s.endsWith("����"));
		// s���� ���α׷��� �ܾ� ������ ���
		System.out.println(s.substring(3, 8));

		int index = s.indexOf("���α׷���");
		if (index == -1) {
			System.out.println("���α׷��Ӷ� �ܾ �����ϴ�.");
			return;
		}
		String str = s.substring(index, index + "���α׷���".length());
		System.out.println(str);
		System.out.println(s);

		// s���� ���ڰ� ��ġ�� ���� �ε��� ��ȣ ã�� ���
		System.out.println(s.indexOf("��"));
		// s���� "��" �ڰ� ��ġ�� ���� �ε��� ��ȣ�� �ڿ��� ã�� ����ϼ���

		System.out.println(s.lastIndexOf("��"));
		// ���ڿ� ���� => StringBuffer(����ȭ������), StringBuilder(����ȭ ���� �� ��)

		// ���� �ʷ� ��پ� ��� replace()
		System.out.println(s.replace("����", "�ʴ�"));

		// s���ڿ��� ������ �������� �ɰ��� �迭�� ����� => split()
		String[] arr = s.split(" ");
		System.out.println(Arrays.toString(arr));

		System.out.println("---------------------");

		str = "[12, 25, 33, 8, 3, 60]";
		System.out.println(str);

		// [1] str�� ����� ������ �հ谪�� ���
		str = str.trim();
		str = str.replace("[", "");
		str = str.replace("]", "");
		arr = (str.split(", "));
		
		int[]intArr = new int[arr.length];
		int all=0;
		for(int i=0; i<arr.length; i++) {
			intArr[i]+=Integer.parseInt(arr[i]);
			all+=intArr[i];
		}
		System.out.println("�հ�: "+all);
		// [2] str�� ����� ������ int[] �迭�� ��Ƽ� �������� ������ ����ϼ���
		Arrays.sort(intArr);
		System.out.println("�������� ����: "+Arrays.toString(intArr));
	
		String s3="happy";
		//s3�� �ִ� ���ڵ��� char �迭�� �����ϼ���
		char[] ch = s3.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		String s4=" '����', '��纼��', '���찳', +=-";
		
		//s4 Ư������ ������ �� ���
		System.out.println(s4.replace("+=-", " "));
		
		String s5=s4.replaceAll("[^��-�R]", "");
		//�ѱ� �ƴϸ� ��� ���ڿ��� ��ü
 		System.out.println(s5);
	}

}
