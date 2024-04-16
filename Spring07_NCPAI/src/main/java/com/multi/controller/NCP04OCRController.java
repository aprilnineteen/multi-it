package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.service.OCRService;

@RestController
public class NCP04OCRController {

	@Autowired
	private OCRService ocrService;

	@GetMapping("/ocrform")
	public ModelAndView ocrForm() {
		return new ModelAndView("clova_ocrForm");
	}

	@PostMapping("/ocrEnd")
	public ModelMap ocrProcess(@RequestParam("imgFile") MultipartFile mfile, HttpSession ses) {
		//1. 이미지 파일 서버에 업로드 처리
		
		ModelMap map = new ModelMap();
		map.put("result", "텍스트");
		return map;
	}
}
