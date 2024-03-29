package day01;
//https://school.programmers.co.kr/learn/courses/30/lessons/120829?language=java
import java.util.*;
public class 각도기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("angle을 입력하세요");
		int angle=sc.nextInt();
		Solution1 st = new Solution1();
		int res = st.solution(angle);
		System.out.println(res);
	}

}//////////////////////

class Solution1 {
    public int solution(int angle) {
        int answer = 0;
        
        if(angle> 0 && angle < 90) {
        	answer=1; //예각
        }else if(angle == 90) {
        	answer=2; //직각
        }else if(angle > 90 && angle <180) {
        	answer=3; //둔각
        }else if(angle == 180) {
        	answer=4; //평각
        }
        
        return answer;
    }
}