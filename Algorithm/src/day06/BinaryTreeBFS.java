package day06;

import java.util.LinkedList;
import java.util.Queue;

/*
 �ʺ�켱Ž��(Breath First Search) => �ִ� �Ÿ��� ���� �� ���� ���Ǵ� �˰���
���� Ž���̶�� �Ѵ�
DFS(����Լ� �Ǵ� ����) / BFS(ť)
*/
public class BinaryTreeBFS {
	class Node {
		int data; // ������

		Node left, right; // ���� �ڽ� ���, ������ �ڽ� ��带 ������ ����

		public Node(int num) {
			data = num;
			left = null;
			right = null;
		}
	}// inner class

	public static void main(String[] args) {
		BinaryTreeBFS app = new BinaryTreeBFS();

		Node root = app.makeTree(); // ����Ʈ�� ����
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
		// ���� ������ front, ���� ������ rear, ������ ���� ��: front, ������ ���� ��: rear
		// ť���� peek => front
		Queue<Node> q = new LinkedList<>();
		// ����: add(), offer()
		// ������(����): remove(), poll();
		// �˻�: peek => front�� �ִ� ��带 ��ȯ

		q.offer(root);
		int level = 0;
		while (!q.isEmpty()) {
			System.out.println("L" + level + ": ");
			int size=q.size();
			for (int i = 0; i < size; i++) {
				// ť���� ��带 ���� ���
				Node n = q.poll(); // n ���
				System.out.println(n.data + "->");
				if (n.left != null)	q.offer(n.left);
				if (n.right != null) q.offer(n.right);
			}
			level++;
		}
	}
}
