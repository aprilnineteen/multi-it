package nlp.ex01;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

// 불용어(stop word): 문장 분석에 큰 기여를 하지 않는 단어들
//				불용어를 제거함으로써 분석의 효율성을 높일 수 있다.
public class KomoranTest4 {

	public static void main(String[] args) {

		Komoran komo = new Komoran(DEFAULT_MODEL.FULL);
		// 사용자 정의 사전 설정
		komo.setUserDic("C:\\multicampus\\Spring-workspace\\Spring07_NCPAI\\src\\main\\java\\nlp\\ex01\\dic.user");
		komo.setFWDic("C:\\multicampus\\Spring-workspace\\Spring07_NCPAI\\src\\main\\java\\nlp\\ex01\\fwd.user");
		String str = "바람과 함께 사라지다 진짜 재미있어요 비대면으로 보았는데 꿀잼! 개이득... 감기는 걸리면 안 좋아요";
		str += "내 청하는아이오아이출신입니다";
		str += "이 드라마의 결과가 이것이라니...완전 실망이야!! 너무 허무하다. 갑자기 모든 것이 꿈이라니";
		KomoranResult result = komo.analyze(str);
		// 명사만 추출
		List<String> nList = result.getNouns();
		System.out.println(nList);

		// stop.txt 파일에 있는 불용어들은 HashSet에 옮기자
		Set<String> stopWords = new HashSet<>();
		/*
		 * try { BufferedReader buffer = new BufferedReader(new InputStreamReader(new
		 * FileInputStream(
		 * "C:\\\\multicampus\\\\Spring-workspace\\\\Spring07_NCPAI\\\\src\\\\main\\\\java\\\\nlp\\\\ex01\\\\stop.txt"
		 * ))); String line = null; // System.out.println(buffer.readLine()); while
		 * ((line = buffer.readLine()) != null) { if (line.trim().length() > 0) {
		 * stopWords.add(line.trim()); } } System.out.println(stopWords); } catch
		 * (Exception e) { System.out.println("error: "+e); }
		 */
		String path = "C:\\multicampus\\Spring-workspace\\Spring07_NCPAI\\src\\main\\java\\nlp\\ex01\\stop.txt";

		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			 stopWords = stream.collect(Collectors.toSet());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("stopWords: " + stopWords);
		// 불용어(금칙어) 제외 처리
		List<String> nList2 = new ArrayList<String>();
		for (String noun : nList) {
			if (stopWords.contains(noun)) {
				continue;
			}
			nList2.add(noun);
		}
		System.out.println("===불용어 제외된 명사 목록============");
		System.out.println(nList2);
	}

}
