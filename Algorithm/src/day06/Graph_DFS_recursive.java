package day06;

public class Graph_DFS_recursive {
	// 0~7�� �� ����� �ִ� �� ���� �߰�ȣ�� ����
	static int[][] graph = { {}, { 2, 3, 8 }, { 1, 6, 8 }, { 1, 5 }, { 5, 7 }, { 3, 4, 7 }, { 2 }, { 4, 5 }, { 1, 2 } };
	// �ߺ��Ǵ� ���� �� ���� ������
	static boolean visited[] = new boolean[9]; // ����Ʈ�� false, ũ�� �ϳ� �� ũ��
	// ���ÿ� ���� �� �̹� �湮�� ���ڴ� ���� �ʵ��� �湮 ���θ� üũ�� ����. �湮�ϸ� true ��

	public static void main(String[] args) {
		dfs(1);

	}

		static void dfs(int index) {
		visited[index] = true; // �湮ó��
		// �湮 ��� ���
		System.out.print(index + "->");
		for (int node : graph[index]) {
			// �湮 ���� üũ
			if (!visited[node])
				// ���� ��� �湮�� �� ���ٸ� dfs()ȣ��
				// if() = ����Լ� ���� ����
				dfs(node); // ���ȣ��
		}
	}

}
