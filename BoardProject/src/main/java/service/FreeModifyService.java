package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeModifyService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		long freeNo = Long.parseLong(request.getParameter("freeNo"));
		
		Free free = Free.builder()
				.freeNo(freeNo)
				.title(title)
				.content(content)
				.build();
		
		int result = FreeDAO.getInstance().updateFree(free);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 수정되었습니다.')");
			out.println("location.href='/BoardProject/detail.do?freeNo=" + freeNo + "'");
			out.println("</script>");
		}
		
		out.close();
		return null;
	}

}
