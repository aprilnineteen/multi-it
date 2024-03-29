package day01;
//https://school.programmers.co.kr/learn/courses/30/lessons/120814

import java.util.Scanner;

public class 피자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("피자가게에 온 손님의 수는?: ");
		int n=sc.nextInt();
		Pizza st = new Pizza();
		int res = st.pizza(n);
		System.out.println("주문한 피자의 수는?" +res);

	}

}
class Pizza {
    public int pizza(int n) {
        int answer = 0;
        
        if (n % 7 == 0) {
            answer = n / 7;
        } else {
            answer = n / 7 + 1;
        }
        
        return answer;
    }
}