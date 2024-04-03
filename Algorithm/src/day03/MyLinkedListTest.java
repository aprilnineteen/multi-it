package day03;

import java.util.Comparator;

public class MyLinkedListTest {

	public static void main(String[] args) {
//		MyLinkedList<String> list = new MyLinkedList<>();
//		list.addFirst("A");
//		list.addLast("B");
//		list.printCurrentNode();
//		list.addLast("C");
//		list.addLast("D");
//		list.printCurrentNode();
//
//		list.printAllNode();
//		list.addFirst("E");
//		list.printCurrentNode();
//		list.printAllNode();
//
//		list.removeLast();
//		list.printCurrentNode();
//		list.printAllNode();
//
//		list.addFirst("F");
//		list.printAllNode();
//
//		list.printCurrentNode();
//		list.next();// E
//		list.next();// A
//		list.next();// B
//		list.printCurrentNode();
//
//		list.removeCurrentNode();
//		list.printAllNode();
//
//		list.clear();
//		list.printCurrentNode();
//		list.printAllNode();

		MyLinkedList<Emp> list2 = new MyLinkedList<>();
		Emp e1 = new Emp ("���浿", 165, 3000);
		Emp e2 = new Emp ("��浿", 160, 5000);
		Emp e3 = new Emp ("��浿", 175, 2000);
		// Emp��ü 3�� ������ ��, ��ü ��� ����ϼ���
		list2.addFirst(e1);
		list2.addLast(e2);
		list2.addLast(e3);
		list2.printAllNode();
		// Emp 1�� �� ������ �� �� �տ� �߰��ϼ���
		Emp e4 = new Emp ("���浿", 155, 2500);
		list2.addFirst(e4);
		// �߰� ������ �ִ� Emp��ü�� �ϳ� �����ϼ���, ��ü ���
		list2.printCurrentNode();
		list2.next();
		list2.next();
		list2.printCurrentNode();
		//list2.removeCurrentNode();
		list2.printAllNode();
		// �޿��� 3000�� ����� �ִ��� �˻��ؼ� �ִٸ� �ش� ��� ������ ����ϼ���
		Emp findEmp=new Emp("",0,2500);
		Comparator<Emp> comp = new SalaryOrderComparator();
		Emp obj = list2.search(findEmp, comp);
		
		if(obj==null) {
			System.out.println("�˻��� ����� �����ϴ�");
		}else {
			System.out.println(obj);
		}
	
	
	}

}
