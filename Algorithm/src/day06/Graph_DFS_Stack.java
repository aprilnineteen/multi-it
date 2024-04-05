package day06;

//Stack ���
import java.util.Stack;
// 
public class Graph_DFS_Stack {
	// 0~7�� �� ����� �ִ� �� ���� �߰�ȣ�� ����
	static int[][] graph = { {}, { 2, 3, 8 }, { 1, 6, 8 }, { 1, 5 }, { 5, 7 }, { 3, 4, 7 }, { 2 }, { 4, 5 }, { 1, 2 } };
	// �ߺ��Ǵ� ���� �� ���� ������
	static boolean visited[] = new boolean[9]; // ����Ʈ�� false, ũ�� �ϳ� �� ũ��
	// ���ÿ� ���� �� �̹� �湮�� ���ڴ� ���� �ʵ��� �湮 ���θ� üũ�� ����. �湮�ϸ� true ��
	static Stack<Integer> sk = new Stack<>();
	
	public static void main(String[] args) {
		sk.push(1); // ���� ���
		visited[1]=true; // ���ÿ� ������ ��� �湮 ó��
		
		while(!sk.isEmpty()) {
			// ������ ��� ���� �ʴٸ� ���ÿ��� ��带 �ϳ� ������ (LIFO)
			int i = sk.pop();
			System.out.print(i+"->");
			// ���� ���� ������ ��带 ã�´�. �湮���� ���� ����� ���ÿ� Ǫ��
			// graph[1][0], graph[1][1], graph[1][2]
			for(int node:graph[i]) {
				if(!visited[node]) {
					sk.push(node);
					visited[node]=true; // �湮 ó��
				}
			}
		}
	}

}