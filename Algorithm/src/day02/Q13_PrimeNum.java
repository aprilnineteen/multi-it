package day02;

public class Q13_PrimeNum {

	public static void solution() {
		int[] prime = new int[500]; // 소수를 저장할 배열
		int ptr = 0;
		prime[ptr++] = 2;// 소수 prime[0]=2, ptr=1;
		int cnt = 0;
		for (int i = 3; i <= 1000; i += 2) {// 판별 대상을 홀수만 하도록
			int j;
			for (j = 1; j < ptr; j++) {
				cnt++;
				if (i % prime[j] == 0) {
					break;
				}
			} // for
			if (ptr == j)
				prime[ptr++] = i; // 소수
		}
		for (int i = 0; i < ptr; i++) {
			System.out.print(prime[i] + ", ");
		}
		System.out.println();
		System.out.println("수행 횟수: "+cnt);
	}

	public static void main(String[] args) {
		solution();
	}

}
