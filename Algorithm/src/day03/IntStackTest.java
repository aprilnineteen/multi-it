package day03;

public class IntStackTest {

	public static void main(String[] args) {
		IntStack sk = new IntStack(5);
		System.out.println(sk.size());
		sk.push(10);
		sk.push(20);
		System.out.println(sk.size());
		sk.push(30);
		System.out.println(sk.peek());
		sk.push(40);
		sk.push(50);
		System.out.println(sk.peek());
		System.out.println(sk.full());
		if (!sk.full()) {
			sk.push(60);
		}
		sk.printStack();
		System.out.println(sk.pop()+"값을 스택에서 삭제");
		System.out.println(sk.size()+"개 남았어요");
		System.out.println(sk.peek());
		sk.pop();
		sk.pop();
		System.out.println("sk.peek() "+sk.peek());
		System.out.println(sk.size()+"개 남았어요");
		sk.printStack();
		
		sk.clear();
		System.out.println(sk.size());
		if(!sk.empty()) {
			sk.pop();
		}
		//100~500 저장
		for(int i=1; i<6; i++) {
			sk.push(i*100);
		}
		System.out.println("--------------");
		//출력
		sk.printStack();
		
		//300값 검색
		int idx=sk.search(300);
		if(idx>0) {
			System.out.println(idx+"번째에 있어요");
		}else {
			System.out.println("없습니다");
		}
			//600값 검색
	}

}
