package day03;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<String> sk1=new MyStack<>();
		sk1.push("HTML");
		sk1.push("JavaScript");
		sk1.push("Java");
		sk1.push("SQL");
		
		String topData=sk1.peek();
		System.out.println(topData);
		String item=sk1.pop();
		System.out.println(item+"이 삭제되었어요");
		System.out.println(sk1.peek());
		sk1.pop();
		sk1.pop();
		System.out.println("sk1의 현재 top: "+sk1.peek());
		if(!sk1.isEmpty()) {
			sk1.pop();
		}
		//System.out.println(sk1.peek());
		//예외 발생
		System.out.println("-------------------------");
	
		
		//[1] Double유형을 저장할 MyStack생성해서 실수값 3개 저장하세요
		MyStack<Double> sk2 = new MyStack<>();
		sk2.push(23.3);
		sk2.push(new Double(5.71));//deprecated
		sk2.push(Double.valueOf("9.4"));
		//[2] 반복문 이용해서 [1]의 스택에 저장된 값들을 출력하세요
		/*for(int i=0; i<3; i++) {
			System.out.println(sk2.pop());
		}*/
		
		while(!sk2.isEmpty()) {
			System.out.println(sk2.pop());
		}
		//[3] Member객체 3개 생성해서 스택에 저장한 뒤,
		Member m1 = new Member("나철수", 25, 165);
		Member m2 = new Member("홍길동", 24, 153);
		Member m3 = new Member("송은지", 21, 179);
		
		MyStack<Member> sk3 = new MyStack<>();
		sk3.push(m1);
		sk3.push(m2);
		sk3.push(m3);
		//    반복문 이용해서 회원정보를 한꺼번에 출력하세요
		for(int i=1; !sk3.isEmpty();i++) {
			Member user = sk3.pop();
			System.out.println(i+": "+user);
		}
	
	}

}
