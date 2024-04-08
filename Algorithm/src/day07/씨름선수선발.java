package study;

import java.util.*;

//178 66
//165 78
//182 67
//171 70
//180 59
public class 씨름선수선발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("씨름 선수 후보 인원 수: ");
		int n = sc.nextInt();

		System.out.println("키 몸무게 순으로 입력: ");
		ArrayList<Body> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			arr.add(new Body(h, w));
		}
		Collections.sort(arr);
		// 내림차순 정렬

		for (Body b : arr) {
			System.out.println(b.h + " " + b.w);
		}

		int count = solution(arr);
		System.out.println(count + "명 선발 가능");
		System.out.println("--- 선발된 씨름 선수 ---");
		for (int i = n - count; i < n; i++) {
			Body selectedBody = arr.get(i);
			System.out.println(selectedBody.h + " " + selectedBody.w);
		}
	}

	public static int solution(ArrayList<Body> arr) {
		int cnt = 0;
		int max = 0;

		for (Body ob : arr) {
			// 이전에 선택된 선수들의 몸무게보다 큰 경우에만 선발
			if (ob.w > max) {
				max = ob.w;
				cnt++; // 선발 가능 인원 파악
			}
		}
		return cnt;
	}

}

class Body implements Comparable<Body> {
	public int h, w;

	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Body o) {
		if (this.h == o.h) {
			return Integer.compare(o.w, this.w); // 키가 같을 경우 몸무게가 더 큰 순서로 정렬
		}
		return Integer.compare(o.h, this.h); // 키가 더 큰 순서로 정렬
	}
}
