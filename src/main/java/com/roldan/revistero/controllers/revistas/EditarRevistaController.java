package com.roldan.revistero.controllers.revistas;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.daos.RevistaDao;

public class EditarRevistaController extends SimpleFormController {
	
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	public EditarRevistaController() {
		setCommandClass(Revista.class);
		setCommandName("revista");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		Revista revista = new Revista();
		
		String idRevista = request.getParameter("idRevista");
		
		if(idRevista != null && !idRevista.equals(""))
		{
			revista.setIdRevista(Long.valueOf(idRevista));
			revista = revistaDao.verRevista(revista);
		}
		
		return revista;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception) {
		
		Revista revista = (Revista) command;
		revistaDao.guardarRevista(revista);
		
		return new ModelAndView(getSuccessView());
	}
}