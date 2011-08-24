package com.roldan.revistero.controllers.revistas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.daos.RevistaDao;

public class RevistasController extends AbstractController
{
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		List<Revista> revistas = revistaDao.findRevistas();
		
		return new ModelAndView("revistas", "revistas", revistas);
	}
}
