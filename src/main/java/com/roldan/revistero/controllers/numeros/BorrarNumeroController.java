package com.roldan.revistero.controllers.numeros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.daos.NumeroDao;

public class BorrarNumeroController extends SimpleFormController {
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		Numero numero = new Numero();
		String idNumero = request.getParameter("idNumero");
		if(idNumero != null && !idNumero.equals("")) {
			numero.setIdNumero(Long.valueOf(idNumero));		
			numeroDao.borrarNumero(numero);
		}
		
		return null;
	}
}
