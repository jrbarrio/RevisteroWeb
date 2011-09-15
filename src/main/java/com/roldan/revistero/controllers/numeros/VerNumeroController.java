package com.roldan.revistero.controllers.numeros;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.daos.ArticuloDao;
import com.roldan.revistero.modelo.daos.NumeroDao;

public class VerNumeroController extends AbstractCommandController
{
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}
	private ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}

	public VerNumeroController() {
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
		
		numero = numeroDao.verNumero(numero);
		Articulo articulo = new Articulo();
		articulo.setNumero(numero);
		List<Articulo> articulos = articuloDao.buscarArticulos(articulo);
		numero.setArticulos(articulos);
		
		return new ModelAndView("verNumero", "numero", numero);
	}
}