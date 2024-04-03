package day03;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue q = new MyQueue(5);
		q.enque("Tiger"); //rear ++ real:1
		q.enque("Dog");//rear: 2
		q.enque("Cat");//rear: 3
		System.out.println(q.peek());
		System.out.println("q.size(): "+q.size());
		q.enque("Lion");//rear: 4
		q.enque("Rabbit"); //rear: 5
		System.out.println("q.size(): "+q.size());
		System.out.println("q.isFull(): "+q.isFull());
		//q.enque("Eagle"); error
		
		q.printQueue();
		System.out.println("q.deque(): "+q.deque()); //front:1, cnt:4
		System.out.println("q.size(): "+q.size());
		System.out.println("-------------------");
		q.printQueue();
		System.out.println("q.deque(): "+q.deque());
		System.out.println("-------------------");
		q.enque("Elephant");
		System.out.println("-------------------");
		q.printQueue();
		
		int idx=q.indexOf("Rabbit");
		System.out.println("idx: "+idx);
		
		idx=q.indexOf("Elephant");
		System.out.println("idx: "+idx);
		Member m1 = new Member("³ª¿¹ºó", 28, 160);
		q.enque(m1);
		System.out.println("q.peek(): "+q.peek());
		System.out.println("q.size(): "+q.size());
		q.deque();
		q.deque();
		q.deque();
		q.deque();
		System.out.println("q.size(): "+q.size());
		System.out.println("q.peek(): "+q.peek());
	}
}
