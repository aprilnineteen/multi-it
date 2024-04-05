package day05;

import java.util.Stack;

public class 햄버거만들기 {

	public static int solution(int[] ingredient) {
		int answer = 0;
		if (ingredient.length < 4)
			return 0;
		Stack<Integer> sk = new Stack<>();
		for (int i = 0; i < ingredient.length; i++) {
			sk.push(ingredient[i]);
			System.out.println(sk);
			if (sk.size() >= 4) {
				if ((sk.get(sk.size() - 4) == 1) && (sk.get(sk.size() - 3) == 2) && (sk.get(sk.size() - 2) == 3)
						&& sk.peek() == 1) {
					for (int j = 0; j < 4; j++)
						sk.pop();

					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
		int[] arr2 = { 1, 3, 2, 1, 2, 1, 3, 1, 2 };
		int qty = solution(arr2);
		System.out.println("햄버거 개수: " + qty + "개"); // 1, 2, 3, 1

	}

}
