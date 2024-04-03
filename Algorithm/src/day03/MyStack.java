package day03;

public class MyStack<T> {
	
		private Node<T> top=null;
	class Node<T>{
		private T data; //데이터
		private Node<T> next=null;
		
		public Node(T data) {
			this.data=data;
		}
	}//inner class
	public void push(T item) {
		Node<T> newNode=new Node(item);//새로 들어온 노드
		newNode.next=top;//꼭대기에 있던 이전 노드의 주소값을 새로 들어온 newNode의 next에 할당
		top=newNode;
	}
	
	public T peek() {
		if(top==null) throw new RuntimeException("EmptyException");
		return top.data;
	}
	public T pop() {
		if(top==null) throw new RuntimeException("EmptyException");
	
		T delData=top.data;
		top=top.next;//top.next는 이전 노드의 주소값을 가진다.
		return delData;
	}
	public boolean isEmpty() {
		return top==null;
	}
}
