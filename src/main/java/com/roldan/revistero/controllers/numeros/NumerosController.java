package com.roldan.revistero.controllers.numeros;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.daos.NumeroDao;

public class NumerosController extends AbstractController
{
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		List<Numero> numeros = numeroDao.findNumeros();
		
		return new ModelAndView("numeros", "numeros", numeros);
	}
}
