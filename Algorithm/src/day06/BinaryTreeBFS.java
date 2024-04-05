package day06;

import java.util.LinkedList;
import java.util.Queue;

/*
 너비우선탐색(Breath First Search) => 최단 거리를 구할 때 많이 사용되는 알고리즘
레벨 탐색이라고도 한다
DFS(재귀함수 또는 스택) / BFS(큐)
*/
public class BinaryTreeBFS {
	class Node {
		int data; // 데이터

		Node left, right; // 왼쪽 자식 노드, 오른쪽 자식 노드를 참조할 변수

		public Node(int num) {
			data = num;
			left = null;
			right = null;
		}
	}// inner class

	public static void main(String[] args) {
		BinaryTreeBFS app = new BinaryTreeBFS();

		Node root = app.makeTree(); // 이진트리 구성
		app.BFS(root);

	}

	public Node makeTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;

	}

	public void BFS(Node root) {
		// 앞쪽 포인터 front, 뒤쪽 포인터 rear, 데이터 꺼낼 때: front, 데이터 삽입 시: rear
		// 큐에서 peek => front
		Queue<Node> q = new LinkedList<>();
		// 삽입: add(), offer()
		// 꺼내기(삭제): remove(), poll();
		// 검사: peek => front에 있는 노드를 반환

		q.offer(root);
		int level = 0;
		while (!q.isEmpty()) {
			System.out.println("L" + level + ": ");
			int size=q.size();
			for (int i = 0; i < size; i++) {
				// 큐에서 노드를 꺼내 출력
				Node n = q.poll(); // n 출력
				System.out.println(n.data + "->");
				if (n.left != null)	q.offer(n.left);
				if (n.right != null) q.offer(n.right);
			}
			level++;
		}
	}
}
