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
		Emp e1 = new Emp ("예길동", 165, 3000);
		Emp e2 = new Emp ("빈길동", 160, 5000);
		Emp e3 = new Emp ("김길동", 175, 2000);
		// Emp객체 3개 저장한 후, 전체 노드 출력하세요
		list2.addFirst(e1);
		list2.addLast(e2);
		list2.addLast(e3);
		list2.printAllNode();
		// Emp 1개 더 생성한 후 맨 앞에 추가하세요
		Emp e4 = new Emp ("나길동", 155, 2500);
		list2.addFirst(e4);
		// 중간 지점에 있는 Emp객체를 하나 삭제하세요, 전체 출력
		list2.printCurrentNode();
		list2.next();
		list2.next();
		list2.printCurrentNode();
		//list2.removeCurrentNode();
		list2.printAllNode();
		// 급여가 3000인 사원이 있는지 검색해서 있다면 해당 사원 정보를 출력하세요
		Emp findEmp=new Emp("",0,2500);
		Comparator<Emp> comp = new SalaryOrderComparator();
		Emp obj = list2.search(findEmp, comp);
		
		if(obj==null) {
			System.out.println("검색한 사원은 없습니다");
		}else {
			System.out.println(obj);
		}
	
	
	}

}
