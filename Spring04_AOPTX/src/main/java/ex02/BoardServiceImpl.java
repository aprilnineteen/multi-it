package ex02;

import java.util.ArrayList;
import java.util.List;
//Target
public class BoardServiceImpl implements BoardService {

List<String> dbArr=new ArrayList<>();//DB역할 한다고 생각	
	
	@Override
	public int insertBoard(String msg) {
		System.out.println("핵심 로직 수행하는 메서드 insertBoard()"+msg);
		dbArr.add(msg);
		//int a=10/0; //테스트를 위해 일부러 에러 발생(after-throwing, around테스트 시 주석 풀고 테스트)
		return dbArr.size();
	}

}
