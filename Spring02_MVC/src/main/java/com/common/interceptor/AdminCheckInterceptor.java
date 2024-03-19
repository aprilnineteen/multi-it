	package com.common.interceptor;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import org.springframework.web.servlet.HandlerInterceptor;

	import com.user.domain.MemberVO;

		
		public class AdminCheckInterceptor implements HandlerInterceptor{

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				HttpSession ses=request.getSession();
				MemberVO user = (MemberVO)ses.getAttribute("loginUser");
				if(user.getMstate() != 9) {
					request.setAttribute("msg", "관리자만 사용 가능한 페이지입니다.");
					String loc=request.getContextPath()+"/login";
					request.setAttribute("loc", loc);
					
					RequestDispatcher disp=request.getRequestDispatcher("/WEB-INF/views/message.jsp");
					disp.forward(request, response);
					return false;
					//false 반환 시 controller로 이동하지 못함
				}
				return true; //true 반환 시 컨트롤러 실행됨
			}
			
		}//---

