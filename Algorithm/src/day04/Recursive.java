package day04;

public class Recursive {

	public static void recursive(int n) {
		if(n<=0) { // 기본 단계 (종료 조건)
			return;
		}
		recursive(n-1); // 재귀 단계
		System.out.println("recursive() n: "+n);
		
	}
	
	public static void main(String[] args) {
		recursive(4);
	}

}
