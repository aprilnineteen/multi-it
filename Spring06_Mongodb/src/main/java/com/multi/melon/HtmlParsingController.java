package com.multi.melon;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlParsingController {

    @GetMapping("/parseHtml")
    public String parseHtml(Model model) {
        try {
            // HTML 파일 경로
            String filePath = "C:/Users/User/Downloads/sample.html";
            // Jsoup을 사용하여 HTML 파일 파싱
            Document doc = Jsoup.parse(new File(filePath), "UTF-8");
            // JSON 데이터를 포함한 script 태그 내용 가져오기
            String scriptContent = doc.select("script").html();
            // JSON 데이터 추출
            String jsonData = scriptContent.substring(scriptContent.indexOf("["));
            // 모델에 JSON 데이터 추가
            model.addAttribute("jsonData", jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // JSP 파일로 이동
        return "htmlData";
    }
}
