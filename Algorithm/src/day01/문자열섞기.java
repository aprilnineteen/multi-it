package day01;

public class ���ڿ����� {

	public static void main(String[] args) {
	}

}

class Solution24 {
	public String solution(String str1, String str2) {
		String answer = "";
		for (int i = 0; i < str1.length(); i++) {
			// str1 str2 ���� ������
//			answer += String.valueOf(str1.charAt(i));
			answer += String.valueOf(str2.charAt(i));

		}
		return answer;

	}
}