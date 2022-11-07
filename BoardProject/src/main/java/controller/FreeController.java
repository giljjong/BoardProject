package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.FreeAddService;
import service.FreeDetailService;
import service.FreeListService;
import service.FreeModifyService;
import service.FreeRemoveService;
import service.FreeService;

@WebServlet("*.do")
public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 / 응답 인코딩
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				// 요청 확인
				String requestURI = request.getRequestURI();
				String contextPath = request.getContextPath();
				String urlMapping = requestURI.substring(contextPath.length());
				
				// BoardService 객체
				FreeService service = null;
				
				// ActionForward 객체
				ActionForward af = null;
				
				switch(urlMapping) {
				case "/list.do" :
					service = new FreeListService();
					break;
				case "/detail.do" :
					service = new FreeDetailService();
					break;
				case "/add.do" :
					service = new FreeAddService();
					break;
				case "/modify.do" :
					service = new FreeModifyService();
					break;
				case "/remove.do" :
					service = new FreeRemoveService();
					break;
				case "/insert.do" :
					af = new ActionForward("/free/insert.jsp", false);
					break;
				}
				
				
				try {
					if(service != null) {
						af = service.execute(request, response);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				if(af != null) {
					if(af.isRedirect()) {
						response.sendRedirect(af.getView());
					} else {
						request.getRequestDispatcher(af.getView()).forward(request, response);
					}
				}
				
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
