package day06;

// Node Ŭ���� �����ؼ� ���� ������ ��
// 3���� ���� �ڽ� ����� ���
public class �������ڽ� {
	static final String islands = " HFSUEZKNAYT";
	Node root;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public Node Island() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.right.left = new Node(9);

		root.right.right.right = new Node(10);
		root.left.right.left.right = new Node(11);

		return root;
	}

	public static void main(String[] args) {
		// 3���� ���� �ڽ� ����� ����� ��
		�������ڽ� app = new �������ڽ�();
		Node root = app.Island();
		System.out.print("�� ���� A�ڽ�: ");
		app.course1(root);
		System.out.println();
		System.out.print("�� ���� B�ڽ�: ");
		 app.course2(root);
		System.out.println();
		System.out.print("�� ���� C�ڽ�: ");
		app.course3(root);

	}

	// ���� ��ȸ
	public void course1(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(islands.charAt(root.data) + "->");
		course1(root.left);
		course1(root.right);
	}

	// ���� ��ȸ
	public void course2(Node root) {
		if (root == null) {
			return;
		}
		course2(root.left);
		System.out.print(islands.charAt(root.data) + "->");
		course2(root.right);
	}
	
	// ���� ��ȸ
	private void course3(Node root) {
		if (root == null) {
			return;
		}
		course3(root.left);
		course3(root.right);
		System.out.print(islands.charAt(root.data) + "->");
	}

}
