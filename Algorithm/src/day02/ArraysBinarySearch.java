package day02;
import java.util.*;
//Arrays클래스의 이진 검색 메서드 binarySearch() 활용
public class ArraysBinarySearch {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void floatBinarySearch() {
		float[] arr= {1.3f, 3.14f, 20e-2f, 25, -73.8f,'A','a'};
		System.out.println(Arrays.toString(arr));
		System.out.println("---오름차순 정렬 후------------");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("검색할 실수 값을 입력하세요: ");
		float key=sc.nextFloat();
		
		int idx=Arrays.binarySearch(arr, key);
		System.out.println("idx: "+idx);
		if(idx<0) {
			System.out.println(key+"값은 배열에 없어요");
		}else {
			System.out.println(key+"값은 오름차순 배열 "+idx+"번 인덱스에 있어요");
		}
	}//-----------------------------------

	public static void main(String[] args) { 
		//floatBinarySearch();
		//stringBinarySearch();
		//memberBinarySearch();
		empBinarySearch();
	}//-----------------------------------
	
	
	private static void empBinarySearch() {
		//1. Emp객체 4개 생성해서 배열에 저장한 뒤 배열을 출력하세요
		Emp e1=new Emp("Scott",166,3000);
		Emp e2=new Emp("Ward",175,3500);
		Emp e3=new Emp("James",186,2000);
		Emp e4=new Emp("King",163,5000);
		
		Emp[] emps= {e1,e2,e3,e4};
		System.out.println(Arrays.toString(emps));
		System.out.println("----키 오름차순 sort 후----------------");
		final HeightOrderComparator comp1=new HeightOrderComparator();
		Arrays.sort(emps, comp1);
		System.out.println(Arrays.toString(emps));
		
		System.out.println("---급여 내림차순 sort후-----------------");
		final SalaryOrderComparator comp2=new SalaryOrderComparator();
		Arrays.sort(emps, comp2);
		System.out.println(Arrays.toString(emps));
		
		//급여로 검색하여 결과 출력하기
		System.out.println("급여가 얼마인 사원을 검색하시나요?");
		int findSal=sc.nextInt();
		int idx=Arrays.binarySearch(emps, new Emp("",0,findSal), comp2);
		System.out.println("idx: "+idx);
		if(idx>0) {
			System.out.println(emps[idx]);
		}
		//배열 sort==> Arrays.sort(배열)
		//ArrayList sort==> Collections.sort(list)
	}//------------------------------------

	private static void memberBinarySearch() {
		// Member객체 4개 생성해서 배열에 저장하세요
		Member m1=new Member("홍길동",22,178);
		Member m2=new Member("이철수",25,173);
		Member m3=new Member("최동민",20,181);
		Member m4=new Member("김영희",28,170);
		Member m5=new Member("이철수",25,173);
		
		System.out.println("주소값 비교 m2==m5: "+(m2==m5));
		System.out.println("내용 비교 m2.equals(m5): "+(m2.equals(m5)));
		
		Member[] users= {m1,m2,m3,m4,m5};
		System.out.println(Arrays.toString(users));
		System.out.println("---sort후------------------");
		Arrays.sort(users);
		//정렬하려면 해당 객체(Member)는 Comparable을 구현하던지, Comparator를 구현해야 한다
		System.out.println(Arrays.toString(users));
		System.out.println("검색할 회원의 이름 입력: ");
		String findName=sc.next();
		int idx=Arrays.binarySearch(users, new Member(findName,0,0));
		if(idx<0) {
			System.out.println(findName+"님은 없어요");
		}else {
			System.out.println(findName+"님 정보는 "+users[idx]+"입니다");
		}
		System.out.println("idx: "+idx);
	}//-----------------------------------

	/*String클래스가 Comparable인터페이스(compareTo()메서드를 구현하고 있음)를 상속받아 구현하고 있기 때문에 정렬이된다. 
	 * => 정렬이 되면 이진검색 가능하다.
	 * */
	private static void stringBinarySearch() {
		String[] str= {
				"abstract",   "assert",  "native",     "boolean",   "break",      "byte",
	            "case",       "catch",        "char",      "class",      "const",
	            "continue",   "default",      "do",        "double",     "else",
	            "enum",       "extends",      "final",     "finally",    "float",
	            "for",        "goto",         "if",    "void",    "implements", "import",
	            "instanceof", "int",          "interface", "long",       
	            "new",        "package",      "private",   "protected",  "public",
	            "return",     "short",        "static",    "strictfp",   "super",
	            "switch",     "synchronized", "this",      "throw",      "throws",
	            "transient",  "try",    "volatile",   "while"
		};
		Arrays.sort(str);
		System.out.println("---오름차순 정렬 후-----------------");
		System.out.println(Arrays.toString(str));
		//검색어 입력 받아 Arrays binarySearch()이용해서 검색어 위치 출력하세요
		System.out.println("검색어 입력: ");
		String key=sc.next();
		int idx=Arrays.binarySearch(str, key);
		String msg=(idx<0)? key+"는 없습니다":key+"는 배열 "+idx+"번에 있어요";
		System.out.println(msg);
	}//----------------------------------

}//////////////////////////////////