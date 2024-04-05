package day06;

public class Graph_DFS_recursive {
	// 0~7의 수 연결돼 있는 것 각각 중괄호에 넣음
	static int[][] graph = { {}, { 2, 3, 8 }, { 1, 6, 8 }, { 1, 5 }, { 5, 7 }, { 3, 4, 7 }, { 2 }, { 4, 5 }, { 1, 2 } };
	// 중복되는 값을 한 번만 나오게
	static boolean visited[] = new boolean[9]; // 디폴트값 false, 크기 하나 더 크게
	// 스택에 넣을 때 이미 방문한 숫자는 넣지 않도록 방문 여부를 체크할 예정. 방문하면 true 값

	public static void main(String[] args) {
		dfs(1);

	}

		static void dfs(int index) {
		visited[index] = true; // 방문처리
		// 방문 노드 출력
		System.out.print(index + "->");
		for (int node : graph[index]) {
			// 방문 여부 체크
			if (!visited[node])
				// 인접 노드 방문한 적 없다면 dfs()호출
				// if() = 재귀함수 종료 조건
				dfs(node); // 재귀호출
		}
	}

}
