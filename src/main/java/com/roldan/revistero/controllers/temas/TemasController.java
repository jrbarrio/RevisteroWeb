package com.roldan.revistero.controllers.temas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.TemaDao;

public class TemasController extends AbstractController
{
	private TemaDao temaDao;
	public void setTemaDao(TemaDao dao) {
		this.temaDao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		List<Tema> temas = temaDao.findTemas();
		
		return new ModelAndView("temas", "temas", temas);
	}
}
