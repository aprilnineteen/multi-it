package day03;

public class MyArrayListTest {

	public static void main(String[] args) {
		//MyArrayList �����ؼ� Integer ���� ��ü�� 3�� ������ �� �ݺ��� �̿��� ���
		MyArrayList<Integer> arr = new MyArrayList<>(); // �ʱ� �뷮 5
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
		System.out.println("----- 78 ���� -----");
		if(arr.indexOf(78)!=-1) {
			arr.remove(arr.indexOf(78));
		}
		System.out.println("----- ���� �� -----");
		for(int i=0; i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		MyArrayList<Member> arr2=new MyArrayList<>();
		arr2.add(new Member("�̼���",22,170));
		arr2.add(new Member("�ּ���",25,160));
		
		System.out.println(arr2.get(0));
	}

}
