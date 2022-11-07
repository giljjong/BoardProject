package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		long freeNo = Long.parseLong(opt.orElse("0"));
		
		FreeDAO dao = FreeDAO.getInstance();
		
		request.setAttribute("free", dao.selectFreeByNo(freeNo));
		return new ActionForward("/free/detail.jsp", false);
	}

}
