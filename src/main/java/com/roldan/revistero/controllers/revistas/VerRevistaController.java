package com.roldan.revistero.controllers.revistas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.daos.NumeroDao;
import com.roldan.revistero.modelo.daos.RevistaDao;

public class VerRevistaController extends AbstractCommandController
{
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}

	public VerRevistaController() {
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
		
		revista = revistaDao.verRevista(revista);
		
		Numero numero = new Numero();
		numero.setRevista(revista);
		List<Numero> numeros = numeroDao.buscarNumeros(numero);
		revista.setNumeros(numeros);
		
		return new ModelAndView("verRevista", "revista", revista);
	}
}