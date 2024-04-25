package com.multi.melon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class HtmlParserService {
	private static String DATA_FILE_PATH = "C:/Users/User/Downloads/result.html";

	@PostConstruct
	public List<MyData> getDatas() throws IOException {
		List<MyData> dataList = new ArrayList<>();
		File input = new File(DATA_FILE_PATH);
		Document document = Jsoup.parse(input, "UTF-8");

		// 원하는 데이터를 추출하기 위한 CSS 선택자 설정
		Elements items = document.select("table tbody tr");

		for (Element item : items) {
			String display1 = item.select("td:eq(0)").text();
			String display2 = item.select("td:eq(1)").text();
			int x = Integer.parseInt(item.select("td:eq(2)").text());
			int y = Integer.parseInt(item.select("td:eq(3)").text());
			String createdAt = item.select("td:eq(4)").text();
			String updatedAt = item.select("td:eq(5)").text();

			// MyData 객체 생성 및 리스트에 추가
			MyData data = MyData.builder().display1(display1).display2(display2).x(x).y(y).createdAt(createdAt)
					.updatedAt(updatedAt).build();

			dataList.add(data);
		}

		return dataList;
	}
}
