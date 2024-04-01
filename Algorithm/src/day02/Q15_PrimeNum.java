package day02;

import java.util.Arrays;

public class Q15_PrimeNum {

	public static void solution() {
		// 1. 반복문 돌면서 2~1000 값 저장
		int[] prime = new int[1001];
		for (int i = 2; i < 1001; i++) {
			prime[i] = i;
		}
		// 2. 2부터 시작해 특정 수의 배수에 해당하는 수 지우기 => 0으로 수정
		int cnt = 0;
		for (int i = 2; i <= 500; i++) {
			for (int j = 2; i * j <= 1000; j++) {
				cnt++;
				prime[i * j] = 0;
			}
		}
		// 3. prime에 남은 0 아닌 추들 출력
		for (int i = 0; i < 1000; i++) {
			if (prime[i] != 0)
				System.out.println(i + ", ");
			;
		}
		System.out.println();
		System.out.println("수행 횟수: " + cnt);
	}

	
	public static void solution2() {
		int [] prime = new int[1001];
		for(int i=2; i<1001;i++) {
			prime[i]=i;
		}
		//System.out.println(Arrays.toString(prime));
		int cnt=0;
		for(int i=2; i*i < prime.length;i++) {
			if(prime[i]!=0) {
				for(int j=i*i; j<prime.length;j+=i) {
					cnt++;
					prime[j]=0;
				}
			}
		}
		System.out.println(Arrays.toString(prime));
		for(int i=2; i<prime.length; i++) {
			if(prime[i]==0) continue;
			System.out.print(prime[i]+", ");
		}
		System.out.println();
		System.out.println("수행 횟수:"+cnt);
	}
	
	public static void main(String[] args) {

		solution2();
	}

}
