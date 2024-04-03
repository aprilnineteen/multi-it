package day02;

/*이진검색
 * - 리스트, 배열을 이용
 * - 정렬되어 있는 자료구조로 해야 함
 * - O(log n)
 * - 100개의 데이터가 있다면 O(log 100) ==>최악의 경우 7번만에 검색을 마칠 수 있음
 * */
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열 크기 입력");
		int n = sc.nextInt();

		int[] arr = new int[n];
		System.out.println("저장할 정수값: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("검색할 정수값: ");
		int key = sc.nextInt();
		int idx = binarySearch(arr, n, key);
		System.out.println("idx: " + idx + "번 인덱스에 있습니다");
	}

	public static int binarySearch(int[] arr, int n, int key) {
		Arrays.sort(arr);// 오름차순 정렬
		System.out.println("--- 오름차순 정렬 후 ---------");
		System.out.println(Arrays.toString(arr));
		System.out.println("-------------------------");
		int left = 0;
		int right = n - 1;
		int center = 0; // 중앙 위치 인덱스 연산
		int cnt = 0;

		// 반복문 돌면서 배열의 중앙 위치에 놓인 값과 key값 비교
		while (left <= right) {
			cnt++;
			center = (left + right) / 2;
			if (key == arr[center]) {
				System.out.println(cnt + "번 만에 찾았습니다.");
				return center;
			} else if (key > arr[center]) {
				left = center+1;
			} else {
				right = center-1;
			}
		}
		return -1;
	}
}
