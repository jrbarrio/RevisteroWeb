package com.roldan.revistero.controllers.articulos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.daos.ArticuloDao;

public class ArticulosController extends AbstractController
{
	private ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		List<Articulo> articulos = articuloDao.findArticulos();
		
		return new ModelAndView("articulos", "articulos", articulos);
	}
}
