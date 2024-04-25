package com.multi.melon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class MyController {

    private final HtmlParserService htmlParserService;

    public MyController(HtmlParserService htmlParserService) {
        this.htmlParserService = htmlParserService;
    }

    @GetMapping("/dataList")
    public String dataCrolling(Model model) {
        try {
            List<MyData> dataList = htmlParserService.getDatas();
            model.addAttribute("dataList", dataList);
        } catch (IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
        return "dataList";
    }
}
