package com.roldan.revistero.controllers.numeros;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.daos.NumeroDao;

public class BorrarNumeroController extends AbstractCommandController
{
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}

	public BorrarNumeroController() {
		setCommandClass(Numero.class);
		setCommandName("numero");
	}

	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			BindException exception)
	{		
		Numero numero = (Numero) command;
		
		numeroDao.borrarNumero(numero);
		
		List<Numero> numeros = numeroDao.findNumeros();
		
		return new ModelAndView("numeros", "numeros", numeros);
	}
}
