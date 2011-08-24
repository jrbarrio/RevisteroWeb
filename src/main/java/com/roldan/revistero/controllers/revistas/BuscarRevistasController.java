package com.roldan.revistero.controllers.revistas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.daos.RevistaDao;

public class BuscarRevistasController extends SimpleFormController {
	
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	public BuscarRevistasController() {
		setCommandClass(Revista.class);
		setCommandName("revista");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		Revista revista = new Revista();

		return revista;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception) {
		
		Revista revista = (Revista) command;
		List<Revista> revistas = revistaDao.buscarRevistas(revista);
		
		return new ModelAndView("revistas", "revistas", revistas);
	}
}
