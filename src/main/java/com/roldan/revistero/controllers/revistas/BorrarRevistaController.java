package com.roldan.revistero.controllers.revistas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.daos.RevistaDao;

public class BorrarRevistaController extends SimpleFormController {
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		Revista revista = new Revista();
		String idRevista = request.getParameter("idRevista");
		if(idRevista != null && !idRevista.equals("")) {
			revista.setIdRevista(Long.valueOf(idRevista));		
			revistaDao.borrarRevista(revista);
		}
		
		return null;
	}
}
