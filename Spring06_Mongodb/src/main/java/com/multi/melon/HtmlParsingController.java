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
            // HTML ���� ���
            String filePath = "C:/Users/User/Downloads/sample.html";
            // Jsoup�� ����Ͽ� HTML ���� �Ľ�
            Document doc = Jsoup.parse(new File(filePath), "UTF-8");
            // JSON �����͸� ������ script �±� ���� ��������
            String scriptContent = doc.select("script").html();
            // JSON ������ ����
            String jsonData = scriptContent.substring(scriptContent.indexOf("["));
            // �𵨿� JSON ������ �߰�
            model.addAttribute("jsonData", jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // JSP ���Ϸ� �̵�
        return "htmlData";
    }
}
