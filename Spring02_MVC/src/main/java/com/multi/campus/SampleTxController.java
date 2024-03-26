package com.multi.campus;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.common.util.CommonUtil;
import com.memo.model.MemoVO;
import com.shop.service.SampleTxService;
import com.user.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class SampleTxController {

	@Inject
	private SampleTxService service;

	@Inject
	private CommonUtil util;
	
	@GetMapping("/tx")
		public String transactionTest(Model m) {
		String str="또 잘 될까요 잘  되면 마일리지 500 적립";
		//str+="잘 될까요 잘  되면 축하";
		//str+="잘 될까요 잘  되면 축하";
		//str+="잘 될까요 잘  되면 축하";
		MemberVO user = new MemberVO();
		user.setUserid("conan");
		user.setMileage(500); //적립해 줄 마일리지
		
		MemoVO memo = new MemoVO();
		memo.setMsg(str);
		memo.setName(user.getUserid());
		
		service.addMemo(memo, user);
		
		String msg=user.getUserid()+" 님의 글이 한줄 메모장에 등록 완료";
		String loc="index";
		return util.addMsgLoc(m, msg, loc);
		}
	}

