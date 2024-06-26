package day01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String s = "나는 프로그래머 스머프야";
		String s2 = "진짜";
		// String: final 클래스(상속 못 받음), immutability(불변성), 원본 불변
		System.out.println(s + s2); // 문자열 결합
		System.out.println(s.concat(s2));
		System.out.println(s);
		System.out.println(s.charAt(3));
		System.out.println(s.startsWith("나는") + "," + s.endsWith("나는"));
		// s에서 프로그래머 단어 추출해 출력
		System.out.println(s.substring(3, 8));

		int index = s.indexOf("프로그래머");
		if (index == -1) {
			System.out.println("프로그래머란 단어가 없습니다.");
			return;
		}
		String str = s.substring(index, index + "프로그래머".length());
		System.out.println(str);
		System.out.println(s);

		// s에서 프자가 위치한 곳의 인덱스 번호 찾아 출력
		System.out.println(s.indexOf("프"));
		// s에서 "프" 자가 위치한 곳의 인덱스 번호를 뒤에서 찾아 출력하세요

		System.out.println(s.lastIndexOf("프"));
		// 문자열 편집 => StringBuffer(동기화구현됨), StringBuilder(동기화 구현 안 됨)

		// 나를 너로 밥꾸어 출력 replace()
		System.out.println(s.replace("나는", "너는"));

		// s문자열을 공백을 기준으로 쪼개서 배열로 만들기 => split()
		String[] arr = s.split(" ");
		System.out.println(Arrays.toString(arr));

		System.out.println("---------------------");

		str = "[12, 25, 33, 8, 3, 60]";
		System.out.println(str);

		// [1] str에 저장된 값들의 합계값을 출력
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
		System.out.println("합계: "+all);
		// [2] str에 저장된 값들을 int[] 배열에 담아서 오름차순 정렬해 출력하세요
		Arrays.sort(intArr);
		System.out.println("오름차순 정렬: "+Arrays.toString(intArr));
	
		String s3="happy";
		//s3에 있는 문자들을 char 배열에 저장하세요
		char[] ch = s3.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		String s4=" '휴지', '블루볼펜', '지우개', +=-";
		
		//s4 특수문자 제거한 후 출력
		System.out.println(s4.replace("+=-", " "));
		
		String s5=s4.replaceAll("[^가-힣]", "");
		//한글 아니면 모두 빈문자열로 대체
 		System.out.println(s5);
	}

}
