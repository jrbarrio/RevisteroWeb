package com.roldan.revistero.controllers.temas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.TemaDao;

public class BorrarTemaController extends SimpleFormController {
	private TemaDao temaDao;
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		Tema tema = new Tema();
		String idTema = request.getParameter("idTema");
		if(idTema != null && !idTema.equals("")) {
			tema.setIdTema(Long.valueOf(idTema));		
			temaDao.borrarTema(tema);
		}
		
		return null;
	}
}
