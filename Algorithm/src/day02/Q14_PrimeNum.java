package day02;

public class Q14_PrimeNum {

	public static void solution() {
		int[] prime = new int[500];
		int ptr=0;
		prime[ptr++]=2;
		prime[ptr++]=3;
		int cnt=0;
		for(int i=5; i<=1000; i+=2) {
			boolean flag=false;
			for(int j=1; prime[j]<Math.sqrt(i);j++) {
				cnt++;
				if(i % prime[j]==0) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				prime[ptr++]=i; //소수 저장
				cnt++;
			}
			}
		for(int i=0;i<ptr;i++) {
			System.out.print(prime[i]+", ");
		}
		System.out.println();
		System.out.println("수행 횟수: "+cnt);

	}

	public static void main(String[] args) {
		solution();
	}

}
