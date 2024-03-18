package com.shop.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.util.CommonUtil;
import com.shop.domain.CartVO;
import com.shop.service.ShopService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user")
public class CartController {
	
	@Inject
	private ShopService shopService;
	
	@Inject
	private CommonUtil util;
	
	@PostMapping("/cartAdd") //��ǰ��ȣ�� ������ �Ķ���ͷ� ����
	public String addCart(Model m,CartVO cvo) {
		log.info("cvo: "+cvo);
		//���ǿ��� �α����� ����� ���̵� ��������
		String userid="hong";//���� ����
		cvo.setUserid(userid);
		//��ٱ��Ͽ� �߰�
		int n=shopService.addCart(cvo);//insert or update
		
		//Ư�� ȸ���� ��ٱ��� ��� ��������
		//List<CartVO> cartArr=shopService.selectCartView(userid);
		//log.info("cartArr: "+cartArr);
		
		//m.addAttribute("cartArr", cartArr);
		
		//return "shop/cartList";//forward���
		
		/* => forward ������� �̵��ϸ� ������ ���ΰ�ħ �� �� ��� ��ǰ ������
		 * �����ϴ� ������ �߻��Ѵ� => ��ٱ��� �Ѿ� ����
		 * => �߰�, ���� ������ forward ��� redirect ������� �̵��ؾ� �Ѵ�.
		 */
		
		return "redirect:cartList";
		
		
	}//--------------------------------
	@GetMapping("/cartList")
	public String cartList(Model m) {
		String userid="hong";// ���߿� ����
		//Ư�� ȸ���� ��ٱ��� ��� ��������
				List<CartVO> cartArr=shopService.selectCartView(userid);
				//log.info("cartArr: "+cartArr);
				
				//Ư�� ȸ���� ��ٱ��� �Ѿ�, ������Ʈ ��������
				CartVO cvo = shopService.getCartTotal(userid);
				
				m.addAttribute("cartSum", cvo);
				m.addAttribute("cartArr", cartArr);
				return "shop/cartList";
	}//--------------------------------
	
	@PostMapping("/cartDel")
	public String cartDelete(@RequestParam(defaultValue="0") int cnum) {
		if(cnum==0) {
			return "redirect:cartList";
		}
		int n = shopService.delCart(cnum);
		
		return "redirect:cartList";
	}//-----------------------------------
	
	@GetMapping("/cartDelAll")
	public String cartDeleteAll(HttpSession session) {
		String userid="hong";// ���ǿ��� �α����� ��� ���̵� ������
		CartVO cartVo = new CartVO();
		cartVo.setUserid(userid);
		int n=shopService.delCartAll(cartVo);
		
		return "redirect:cartList";
	}//------------------------------------
	
	/*�������� ���� ó�� ���
	 * [1] @ExceptionHandler�� �̿��ϴ� ���
	 * [2] @ControllerAdvice�� �̿��ϴ� ���
	 * [3] @ResponseStatus �� �̿��ؼ� HTTP�����ڵ� ó���ϴ� ���
	 * */
	
	@PostMapping("/cartEdit")
	public String cartEdit(CartVO vo) {
		log.info("vo: "+vo);
		if(vo.getCnum()==0) {
			return "redirect:cartList";
		}
		int n = shopService.editCart(vo);
		return "redirect:cartList";
	}
	/*
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandler(Exception ex, Model m) {
		String msg=ex.getMessage();//���� �޽���
		
		return util.addMsgBack(m, msg);
	}
*/
}