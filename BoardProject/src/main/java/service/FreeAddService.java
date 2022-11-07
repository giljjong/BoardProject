package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeAddService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = getClientIp(request);
		
		Free free = Free.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build();
		
		int result = FreeDAO.getInstance().insertFree(free);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='/BoardProject/list.do'");
			out.println("</script>");
		}
		
		out.close();
		
		
		return null;
	}

	public static String getClientIp(HttpServletRequest request) {

		String[] header_IPs = { 
					"HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED" 
					, "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED"
					, "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP" 
				 } ;
		
		for (String header : header_IPs) {
			String ip = request.getHeader(header);
			
			if (ip != null && !"unknown".equalsIgnoreCase(ip) && ip.length() != 0) {
				return ip;
			}
		}
		
		return request.getRemoteAddr() ;
		
	}

}
