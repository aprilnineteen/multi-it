package ex02;

import java.util.ArrayList;
import java.util.List;
//Target
public class BoardServiceImpl implements BoardService {

List<String> dbArr=new ArrayList<>();//DB���� �Ѵٰ� ����	
	
	@Override
	public int insertBoard(String msg) {
		System.out.println("�ٽ� ���� �����ϴ� �޼��� insertBoard()"+msg);
		dbArr.add(msg);
		//int a=10/0; //�׽�Ʈ�� ���� �Ϻη� ���� �߻�(after-throwing, around�׽�Ʈ �� �ּ� Ǯ�� �׽�Ʈ)
		return dbArr.size();
	}

}
