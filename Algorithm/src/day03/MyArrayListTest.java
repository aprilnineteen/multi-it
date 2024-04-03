package day03;

public class MyArrayListTest {

	public static void main(String[] args) {
		//MyArrayList 생성해서 Integer 유형 객체를 3개 저장한 후 반복문 이용해 출력
		MyArrayList<Integer> arr = new MyArrayList<>(); // 초기 용량 5
		arr.add(100);
		arr.add(new Integer(200));
		arr.add(Integer.valueOf("300"));;
		System.out.println("arr.size():"+arr.size());
		
		arr.add(45);
		arr.add(78);
		System.out.println("arr.size():"+arr.size());
		arr.add(400);
		System.out.println("----------------------");
		for(int i=0;i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		int idx=arr.indexOf(78);
		System.out.println(idx);
		
		System.out.println(arr.indexOf(780));
		System.out.println("----- 78 삭제 -----");
		if(arr.indexOf(78)!=-1) {
			arr.remove(arr.indexOf(78));
		}
		System.out.println("----- 삭제 후 -----");
		for(int i=0; i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		MyArrayList<Member> arr2=new MyArrayList<>();
		arr2.add(new Member("이선희",22,170));
		arr2.add(new Member("최수희",25,160));
		
		System.out.println(arr2.get(0));
	}

}
