package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.util.CommonUtil;
import com.user.domain.MemberVO;
import com.user.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemberController {
	
	@Autowired  //byType
	private CommonUtil util;
	
	@Autowired
	private MemberService mService;
	
	//@GetMapping("/idCheck"),   @PostMapping("/idCheck")
		//구성한 메서드 부분 코드 제출 ==> MemberController.java 실습 제출

	
	@GetMapping("/signup")
	public String joinForm() {
		
		return "member/join";
	}
	
	@PostMapping("/signup")
	public String joinEnd(Model m, MemberVO user) {
		log.info("user: "+user);
		//유효성 체크
		if(user.getUserid()==null||user.getName()==null
				||user.getUserid().trim().isBlank()
				||user.getName().trim().isBlank()) {
			return "redirect:signup";
		}
		int n=mService.insertMember(user);
		
		String msg=(n>0)?"회원가입 완료-로그인하세요!":"회원가입 실패-아이디 중복체크 하세요";
		String loc=(n>0)?"index":"javascript:history.back()";
		return util.addMsgLoc(m, msg, loc);
	}

	//get방식 요청이면 id 입력 form 보여 주고
	
	//post 방식 요청이면 id 사용 가능 여부 보여 주자
	
	@GetMapping("/idCheck")
	public String idCheck(){
			return "member/idCheck";
			//view: idCheck.jsp
		}
	
	@PostMapping("/idCheck")
	public String idCheckEnd(Model m, @RequestParam("userid") String userid) {
									  // 파라미터값 id로 전달
		if(userid == null || userid.trim().isBlank()) {
			String msg="아이디를 다시 입력하세요.";
			return util.addMsgBack(m, msg);
		} // 유효성 체크
		
		int isUse = mService.idCheck(userid);
		// 중복 확인
		
		String msg = (isUse != 1) ? "사용 가능한 아이디입니다." : "이미 사용 중인 아이디입니다.";
		String result= (isUse != 1) ? "ok" : "fail";
		// DB에 이미 아이디가 있으면 사용이 불가하다
		
		m.addAttribute("msg", msg);
		m.addAttribute("result", result);
		m.addAttribute("uid", userid);
		
		return "member/idCheckResult";
	}
	
	
}


