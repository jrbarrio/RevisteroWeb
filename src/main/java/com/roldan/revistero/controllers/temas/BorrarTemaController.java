package com.roldan.revistero.controllers.temas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.TemaDao;

public class BorrarTemaController extends AbstractCommandController
{
	private TemaDao temaDao;
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	public BorrarTemaController() {
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
		
		temaDao.borrarTema(tema);
		
		List<Tema> temas = temaDao.findTemas();
		
		return new ModelAndView("temas", "temas", temas);
	}
}
