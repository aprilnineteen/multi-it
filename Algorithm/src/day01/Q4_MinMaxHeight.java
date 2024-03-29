package day01;
import java.util.*;
public class Q4_MinMaxHeight {

	public static void main(String[] args) {
		System.out.println("사람 수: ");
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int num = sc.nextInt();
		int arr[] = new int[num];
		for(int i = 0; i<arr.length; i++) arr[i] = ran.nextInt(90)+100;
		//배열 생성 후 Random 클래스 이용. 배열에 키값 저장 (100~190)
		int min = min_max(arr)[0];
		int max = min_max(arr)[1];
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("가장 큰 키: "+max+" 가장 작은 키: "+min);
		
	}


public static int[] min_max(int[] heights){
	Arrays.sort(heights);
	int[] arr = new int[2];
	arr[0] = heights[0];
	arr[1] = heights[heights.length-1];
	return arr; // 최대, 최소값을 담은 배열 반환
}
}
