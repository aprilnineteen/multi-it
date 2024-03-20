package com.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.common.util.CommonUtil;
import com.shop.domain.CategoryVO;
import com.shop.domain.ProductVO;
import com.shop.service.AdminService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	private CommonUtil util;
	
	@Inject
	private AdminService adminService;

	@GetMapping("/prodForm")
	public String productForm(Model m) {
		
		List<CategoryVO> upCgList=adminService.getUpcategory();
		m.addAttribute("upCgList", upCgList);
		
		return "admin/prodInput";
	}//-------------------------
	
	@GetMapping("/downCgList")
	public String getDownCategory(Model m, int upCg_code) {
		log.info("upCg_code: "+upCg_code);
		
		List<CategoryVO> cgList = adminService.getDowncategory(upCg_code);
		m.addAttribute("cgList", cgList);
		return "admin/downCategory";
	}

	@GetMapping(value="/downCgListJSON", produces = {"application/json; charset=UTF-8"})//produces에 만들어 내는 문서의 컨텐트 타입 지정
	@ResponseBody//뷰 네임을 반환하는 것이 아니라 응답 데이터를 반환한다는 의미로 붙여 준다
	public List<CategoryVO> getDownCategoryJSON(int upCg_code) {
		log.info("upCg_code: "+upCg_code);
		
		List<CategoryVO> cgList = adminService.getDowncategory(upCg_code);

		return cgList;
	}
	
	//0. servlet-context.xml에 multipartResolver빈 등록해야 함
	@PostMapping("/prodInsert")
	public String productInsert(Model m, 
			ProductVO item, 
			@RequestParam("pimage") List<MultipartFile> pimage,
			@RequestParam(value="mode", defaultValue="insert") String mode,
			HttpServletRequest req) {		
		
		log.info("mode: "+mode);
		
		log.info("item: "+item);
		log.info("pimage: "+pimage);
		//1. 업로드할 디렉토리의 절대경로 얻기
		ServletContext app=req.getServletContext();
		String upDir=app.getRealPath("/resources/product_images");
		log.info("upDir: "+upDir);
		
		//2. 파일 업로드 처리=> MultipartFile의 transferTo(File객체)메서드를 이용
		if(pimage!=null) {
			for(int i=0;i<pimage.size();i++) {
				MultipartFile mf=pimage.get(i);
				if(!mf.isEmpty()) {//업로드했다면
					try {
						String fileName=mf.getOriginalFilename();//첨부파일명
						mf.transferTo(new File(upDir,fileName));//업로드 처리
						//3. 업로드한 파일명을 ProductVO의 pimage1,pimage2,pimage3에 setting
						if(i==0) {
							item.setPimage1(fileName);
						}else if(i==1) {
							item.setPimage2(fileName);
						}else if(i==2) {
							item.setPimage3(fileName);
						}
					}catch(IOException e) {
						log.error("파일 업로드 중 에러: "+e);
					}
				}//if
			}//for---
		}//if------
		log.info("item 2: "+item);
		
		int n=0;
		if(mode.equals("insert")) {	
			n=adminService.productInsert(item);//등록 처리
		}else if(mode.equals("edit")) {
			n=adminService.productUpdate(item);//수정 처리
		}
			
		String msg=(n>0)?"성공":"실패";
		String loc=(n>0)? "prodList":"javascript:history.back()";
		return util.addMsgLoc(m, msg, loc);
	}//------------------------------------

	@GetMapping("/prodList")
	public String productList(Model m) {
	
		List<ProductVO> itemList = adminService.productList();
		m.addAttribute("itemList",itemList);
		
		return "admin/prodList";
	}//----------------------
	
	@PostMapping("/prodEditForm")
	public String productEditForm(Model m, @RequestParam(defaultValue="0") int pnum) {
		log.info("pnum: "+pnum);
		if(pnum==0) {
			return "redirect:prodList";
		}
		List<CategoryVO> upCgList=adminService.getUpcategory();
		m.addAttribute("upCgList", upCgList);
		
		
		ProductVO item=adminService.getProduct(pnum);
		
		m.addAttribute("item",item);
		
		return "admin/prodEdit";
	}
	
	
}////////////////////////////////













