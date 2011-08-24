package com.roldan.revistero.controllers.articulos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.daos.ArticuloDao;

public class BorrarArticuloController extends AbstractCommandController
{
	private ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}

	public BorrarArticuloController() {
		setCommandClass(Articulo.class);
		setCommandName("articulo");
	}

	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			BindException exception)
	{		
		Articulo articulo = (Articulo) command;
		
		articuloDao.borrarArticulo(articulo);
		
		List<Articulo> articulos = articuloDao.findArticulos();
		
		return new ModelAndView("articulos", "articulos", articulos);
	}
}
