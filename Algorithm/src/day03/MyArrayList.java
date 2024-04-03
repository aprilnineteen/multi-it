package day03;

public class MyArrayList<E> {

	private Object[] data;
	private int capacity;
	private int index;

	public MyArrayList() {
		this(5); // 초기 용량 5로 설정
	}

	public MyArrayList(int capa) {
		this.capacity = capa;
		data = new Object[this.capacity];
		index = 0;
	}

	public int size() {
		return index;
	}

	/** 데이터 저장 */
	public E add(E obj) {
		// 데이터가 꽉 찼다면 저장 공간을 두 배로 증가시키자
		if (index >= capacity - 1) {
			doubling();
		}
		data[index++] = obj;

		return obj;
	}

	private void doubling() {
		// 두 배 용량의 새로운 배열 생성해서 기존 데이터 옮기기
		this.capacity = this.capacity * 2;

		Object[] newData = new Object[this.capacity];

		// 기존 데이터 옮기기
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		// 멤버 변수 data에 새로 만들 배열의 주소값을 할당
		this.data = newData;
		System.out.printf("index: %d, capacity: %d, size: %d%n", index, capacity, size());
	}
	
	/** 데이터 꺼내기 */
	public E get(int i) {
		if(i<0) {
			throw new RuntimeException("Negative Index Value");
		}else if(i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Object val=data[i];
		return (E)val;
	}
	
	/**데이터 검색*/
	public int indexOf(E obj) {
		for(int i=0; i<size(); i++) {
			if(data[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	/**데이터 삭제*/
	public void remove(int i) {
		if(i<0) {
			throw new RuntimeException("Negative Index Value");
		}else if(i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(i<size()) {
			for(int k=i; k<size();k++) {
				data[k]=data[k+1];
			}
			index--;
		}
	}
}
