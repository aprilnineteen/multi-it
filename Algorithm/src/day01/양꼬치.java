package day01;
//https://school.programmers.co.kr/learn/courses/30/lessons/120830
import java.util.*;
public class 양꼬치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("양꼬치 몇 인분을 주문하시나요");
		int n=sc.nextInt();
		System.out.println("음료 몇 개를 주문하시나요");
		int k=sc.nextInt();
		Solution st = new Solution();
		int res = st.solution(n, k);
		System.out.println("총 비용: "+res);
	}

}
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int service = 0;
        if(n/10>0) {
        	service+=(n/10);
        }
        answer = n*(12000)+k*(2000)-service*(2000);
        
        return answer;
    }
}