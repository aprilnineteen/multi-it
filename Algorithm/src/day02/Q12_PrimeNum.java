package day02;

public class Q12_PrimeNum {

	public static void solution() {
		int cnt=0;
		for(int i=2; i<1001; i++) {
			int j;
			for(j=2; j<=i; j++) {
				cnt++;
				if(i%j==0) break;
			}//for---
			if(i==j) {
				System.out.println(i+", ");
			}
			
		}
		
		System.out.println();
		System.out.println("수행 횟수:"+cnt);
	}//----------------------------
	public static void main(String[] args) {
		//소수 구하기
		//소수: 1과 자신으로만 나누어지는 수
		//1 ~ 1000까지의 정수 중 소수를 구해 출력하세요
		solution();
	}

}
