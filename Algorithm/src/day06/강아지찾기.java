package day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import day06.BinaryTreeBFS.Node;

// 최소 몇 번의 점프로 강아지 위치를 찾을 수 있는가
public class 강아지찾기 {
	static int[] distance = { 1, -1, 5 };
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[10001];
	// BSF => 큐 이용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 철이 현재 위치 입력
		System.out.println("철이의 현재 위치 입력: ");
		int S = sc.nextInt();
		// 2. 멍멍이 위치 입력
		System.out.println("강아지가 있는 위치 입력: ");
		int E = sc.nextInt();

		int level = solution(S, E);
		System.out.println("Level: " + level);
	}

	static int solution(int start, int end) {
		q.add(start);
		visited[start] = true;
		int L = 0;
		while (!q.isEmpty()) {
			int size = q.size(); // 사이즈가 계속 변동되므로
			System.out.println("L: " + L + "------------");
			for (int i = 0; i < size; i++) {
				int val = q.remove(); // 꺼내기
				System.out.println(val + " ");
				if (val == end) {// 찾는다면
					return L;
				}
				for (int j = 0; j < distance.length; j++) {
					int node = val + distance[j];
					if (!visited[node] && node >= 1 && node < 10001) {
						q.add(node);
						visited[node] = true;
					}
				}
				System.out.println();
			}
			L++;
		} // while
		return -1;
	}

}
