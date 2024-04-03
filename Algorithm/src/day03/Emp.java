package day03;

import java.util.Comparator;

//Comparator인터페이스를 구현한 클래스로 정렬을 해보자
public class Emp {
	
	String name;
	int height;
	int salary;
	
	public Emp() {
		
	}
	public Emp(String n, int h, int s) {
		name=n; height=h; salary=s;
	}
	
	public String toString() {
		return name+": "+height+"cm, 급여: "+salary+"/";
	}

}//////////////////////////////////

class HeightOrderComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		if(o1.height == o2.height) {
			return 0;
		}else if(o1.height>o2.height) {
			return 1; //키 오름차순
		}else {
			return -1;
		}
	}
}//////////////////////////////////////
//급여 내림차순 정렬하도록 구현해보기
class SalaryOrderComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		//return o1.salary -o2.salary;//오름차순
		return o2.salary - o1.salary; //내림차순
	}
	
}////////////////////////////////////////




