package nlp.ex01;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

public class KomoranTest3 {

	public static void main(String [] args) {
		Komoran komo = new Komoran(DEFAULT_MODEL.FULL);
		// 사용자 정의 사전 설정
		komo.setUserDic("C:\\multicampus\\Spring-workspace\\Spring07_NCPAI\\src\\main\\java\\nlp\\ex01\\dic.user");
		komo.setFWDic("C:\\multicampus\\Spring-workspace\\Spring07_NCPAI\\src\\main\\java\\nlp\\ex01\\fwd.user");
		String str = "바람과 함께 사라지다 진짜 재미있어요 비대면으로 보았는데 꿀잼! 개이득... 감기는 걸리면 안 좋아요";
		str += "내 청하는아이오아이출신입니다";
		System.out.println();
		KomoranResult result = komo.analyze(str);
		List<Token> list = result.getTokenList();
		System.out.println("====================");
		int cnt = 0;
		for(Token tk : list) {
			// System.out.println(tk);
			if(tk.getPos().equals("NNP")) {
				System.out.println(tk.getMorph());
				cnt++;
			}
		}
		System.out.println("====================");
		System.out.println("NNP count: "+cnt);
		
		List<String>nList = result.getNouns();
		System.out.println(nList);
	}
}
