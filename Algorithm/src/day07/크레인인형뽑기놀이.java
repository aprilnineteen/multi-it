package study;

import java.util.*;

public class 크레인인형뽑기놀이 {

	public static void main(String[] args) {

	}

}

class Solution23 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0; // 사라진 인형의 개수
		Stack<Integer> stack = new Stack<>();
		for (int mvs : moves) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][mvs - 1] != 0) { // 0이 아닐 때까지
					if (!stack.empty() && board[i][mvs - 1] == stack.peek()) {
						stack.pop();
						// 만약 스택이 비어 있거나 스택 맨 위의 값이 고른 인형과 같다면
						answer += 2;
					} else {
						stack.push(board[i][mvs - 1]);
					}
					board[i][mvs - 1] = 0; // move로 인해 board에서는 제거됨
					break;
				}
			}
		}
		return answer;
	}
}

// 네오: 1, 무지: 2, 오리: 3, 어피치: 4, 프로독: 5 위에서부터 배열
// 게임 화면 격자 상태가 보드, 인형 크레인 위치가 무브즈
// 움직인 게 마지막 moves
