package day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import day06.BinaryTreeBFS.Node;

// �ּ� �� ���� ������ ������ ��ġ�� ã�� �� �ִ°�
public class ������ã�� {
	static int[] distance = { 1, -1, 5 };
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[10001];
	// BSF => ť �̿�

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. ö�� ���� ��ġ �Է�
		System.out.println("ö���� ���� ��ġ �Է�: ");
		int S = sc.nextInt();
		// 2. �۸��� ��ġ �Է�
		System.out.println("�������� �ִ� ��ġ �Է�: ");
		int E = sc.nextInt();

		int level = solution(S, E);
		System.out.println("Level: " + level);
	}

	static int solution(int start, int end) {
		q.add(start);
		visited[start] = true;
		int L = 0;
		while (!q.isEmpty()) {
			int size = q.size(); // ����� ��� �����ǹǷ�
			System.out.println("L: " + L + "------------");
			for (int i = 0; i < size; i++) {
				int val = q.remove(); // ������
				System.out.println(val + " ");
				if (val == end) {// ã�´ٸ�
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
