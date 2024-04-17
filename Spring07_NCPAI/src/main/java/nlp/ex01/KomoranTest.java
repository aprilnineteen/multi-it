package nlp.ex01;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

public class KomoranTest {

	public static void main(String[] args) {
		Komoran komo = new Komoran(DEFAULT_MODEL.LIGHT);
		String str = "★★★ 꽁꽁 얼어붙은 한강 위로 고양이가 돌아다닙니다 @@@^^";
		// 전처리: 한글, 영어, 숫자가 아닌 문자 제거
		System.out.println("str: " + str);
		str = str.replaceAll("[^가-힣A-Za_z0-9\\s]", "");
		// 한글, 영어, 숫자, 띄어쓰기 아니면 공백 취급
		System.out.println("--- 전처리 후 ------------");
		System.out.println("str: " + str);

		KomoranResult result = komo.analyze(str);
		System.out.println(result);
		String text = result.getPlainText();
		System.out.println("===plain text============");
		System.out.println(text);
		System.out.println("===token list============");
		List<Token> tkList = result.getTokenList(); // 형태소가 문자열의 어느 위치에 생성됐는지, 품사 등의 정보를 Token에 담아 반환
		// System.out.println(tkList);
		for(Token tk:tkList){
			System.out.printf("%s\t%s\t(%2d, %2d)\n", tk.getMorph(), tk.getPos(), tk.getBeginIndex(), tk.getEndIndex());
		}
		System.out.println("===noun list============");
		// 명사만 반환
		List<String> nounList = result.getNouns();
		// System.out.println(nounList);
		for(String noun : nounList) {
			System.out.print(noun+" "); // NNG(일반명사), NNP(고유명사), NNB(의존명사), VV(동사)
		}
		System.out.println();
		System.out.println("===morph tag list============");
		List<String> mList = result.getMorphesByTags("NNG", "NNP", "NNB", "VV"); // 반환 타입 arraylist
		mList.forEach(System.out::println); // java 8 함수형 프로그래밍
	}
}
