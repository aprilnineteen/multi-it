package day05;

/*쉘정렬 알고리즘은 삽입정렬 알고리즘의 느린 속도를 보완하기 위해 만들어진 알고리즘.
 * 데이터의 그룹을 나누어 그룹 안에서 쉘 정렬을 수행하고, 마지막에 삽입정렬을 수행하는 알고리즘이다.
 * 삽입정렬의 장점: 대부분이 정렬되어 있는 상태에 가까울 때 속도가 아주 빠르다
 *         단점: 삽입할 곳이 멀리 떨어지면 이동(대입)하는 횟수가 많다.
 *         ex) 1 2 3 4 5 0 6  식의 배열일 경우 0을 삽입하려면 총 6회에 걸쳐 요소를 이동시켜야 한다.
 *셀정렬의 시간복잡도는 O(n^1.25), 삽입정렬 O(n^2)보다는 빠르다. but안정적이진 않음 멀리 떨어진 요소를 교환함으로         
 * */
import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 1, 4, 2, 33, 7, 6, 3, 5, 25, 26, 13, 34, 20 };
		System.out.println(Arrays.toString(arr));
		// intervalSort(arr);
		intervalSort2(arr);
		System.out.println("셸 정렬 후");
		System.out.println(Arrays.toString(arr));
	}

	/*
	 * interval을 n배수로 증가시키면 나눈 그룹이 서로 섞이지 않고 같은 멤버로 구성될 수 있다. 이를 개선하기 위해서 interval을
	 * [3*n+1 ==> interval]
	 * 
	 */
	private static void intervalSort2(int[] arr) {
		// interval의 초기값을 구하기 위해서 반복문을 돌려 보자
		int inter;
		for (inter = 1; inter < arr.length; inter = inter * 3 + 1)
			;
		// 1, 4, 13
		// System.out.print(inter+",")};
		// System.out.println();
		System.out.println("inter: " + inter);
		// inter 13에서 시작
		for (; inter > 0; inter /= 3) {
			for (int i = inter; i < arr.length; i++) {
				// System.out.println("i: "+i+", inter: "+inter);
				int tmp = arr[i];
				int j = i - inter;
				for (; j >= 0; j -= inter) {
					// System.out.println("i: "+i+" inter: "+inter);
					if (arr[j] > tmp) {
						arr[j + inter] = arr[j]; // 뒤로 밀어냄
					} else {
						break;
					}
				}
				arr[j + inter] = tmp;
			}
			// System.out.println(Arrays.toString(arr));
			// System.out.println("---------------------");
		}
	}

	private static void intervalSort(int[] arr) {
		// interval: 4, 2, 1 순으로 건너뛰기 하면서 삽입 정렬을 수행한다 => 셸정렬
		for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
			for (int i = interval; i < arr.length; i++) {
				int tmp = arr[i];
				int j = i - interval;
				System.out.println("interval:" + interval + ", tmp: " + tmp);
				for (; j >= 0; j -= interval) {
					if (arr[j] > tmp) {
						arr[j + interval] = arr[j];
					} else {
						break;
					}
				}
				arr[j + interval] = tmp;
				System.out.println(Arrays.toString(arr));
				System.out.println("--------------------");
			}
		}

	}

}
