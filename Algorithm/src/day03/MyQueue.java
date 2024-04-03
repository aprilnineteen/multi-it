package day03;

public class MyQueue {

	private Object[] que; // 배열 => 큐
	private int capacity; // 큐의 크기, 용량
	private int front; // 맨 앞 요소 포인터(커서). deque(삭제)할 때 front부터 나와야 함. front++
	private int rear; // 맨 뒤 요소 포인터. enque할 때 뒤(rear)부터 들어가야 함 rear++
	private int cnt; // 현재 데이터 수

	public MyQueue(int capa) {
		this.capacity = capa;
		que = new Object[this.capacity]; // 배열 메모리 할당
		front = 0;
		rear = 0;
		cnt = 0;
	}

	/** 데이터를 삽입하는 메서드 => 인큐, 맨 뒤(rear)에서 들어간다 */
	public Object enque(Object val) {
		if (cnt >= this.capacity)
			throw new RuntimeException("OverflowException");
		que[rear++] = val;
		cnt++;
		if (rear >= this.capacity) {
			rear = 0;
		}
		return val;
	}

	/** 데이터를 꺼내는 메서드 => 디큐, 맨 앞(front)부터 나온다 (FIFO구조) */
	public Object deque() {
		if (cnt <= 0)
			throw new RuntimeException("EmptyException");
		Object val = que[front++];
		cnt--;
		if (front >= capacity) {
			front = 0;
		}
		return val;
	}

	/** front 데이터를 반환하는 메서드 */
	public Object peek() {
		if (cnt <= 0)
			throw new RuntimeException("EmptyException");

		return que[front];
	}

	/** 현재 큐에 저장된 데이터수 반환 */
	public int size() {
		return cnt;
	}

	public boolean isFull() {
		return cnt >= this.capacity;
	}

	public boolean isEmpty() {
		return cnt <= 0;
	}

	/** 큐에 저장된 데이터를 출력하는 메서드 FIFO => front 활용 */
	public void printQueue() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(que[(i+front)%capacity]);
			//System.out.println(que[(i + front)]);
		}
	}

	/** 큐에서 검색하는 메서드 */
	public int indexOf(Object val) {
		for (int i = 0; i < cnt; i++) {
			int index = (i + front) % capacity;
			if (que[index].equals(val)) {
				return index;
			}
		}
		return -1;
	}
}
