package com.roldan.revistero.controllers.temas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.TemaDao;

public class VerTemaController extends AbstractCommandController
{
	private TemaDao temaDao;
	public void setTemaDao(TemaDao dao) {
		this.temaDao = dao;
	}

	public VerTemaController() {
		setCommandClass(Tema.class);
		setCommandName("tema");
	}

	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			BindException exception)
	{		
		Tema tema = (Tema) command;
		
		tema = temaDao.verTema(tema);
		
		return new ModelAndView("verTema", "tema", tema);
	}
}