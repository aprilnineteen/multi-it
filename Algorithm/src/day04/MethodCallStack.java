package day04;

public class MethodCallStack {

	public static void main(String[] args) {
		System.out.println("1) push main() 호출되었음");
		a();
		System.out.println("4) pop main 실행 완료");
	}

	public static void a() {
		System.out.println("2) push a() 호출되었음");
		b();
		System.out.println("3) pop a() 실행 완료");
	}

	public static void b() {
		System.out.println("3) push b() 호출되었음");
		c();
		System.out.println("2) pop b() 실행 완료");
	}
	
	public static void c() {
		System.out.println("4) push c() 호출되었음");
		System.out.println("1) pop c() 실행 완료");
	}
}
