package com.roldan.revistero.controllers.revistas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.daos.RevistaDao;

public class BorrarRevistaController extends AbstractCommandController
{
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	public BorrarRevistaController() {
		setCommandClass(Revista.class);
		setCommandName("revista");
	}

	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			BindException exception)
	{		
		Revista revista = (Revista) command;
		
		revistaDao.borrarRevista(revista);
		
		List<Revista> revistas = revistaDao.findRevistas();
		
		return new ModelAndView("revistas", "revistas", revistas);
	}
}
