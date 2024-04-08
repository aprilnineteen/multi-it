package study;

import java.util.*;
//(A(BC)DE)F(G(H)(IJ)K)LM(N)OP(Q)R(STU)V(W(XY)Z)
public class 괄호안문자제거 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>(); // char형 스택
		
		System.out.println("문자열 입력: ");
		String str = sc.nextLine();
		
		for(char c : str.toCharArray()) {
			if(c == ')') {
				while(stack.pop()!='('); // 만약 c가 )라면 (까지 꺼내기 
			}else stack.push(c);
		}
		
		String result = "";
		
		for(int i = 0; i < stack.size(); i++) {
			result += stack.get(i);
		}
		
		System.out.println(result);
		
	}

}
