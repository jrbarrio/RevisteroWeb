package com.roldan.revistero.controllers.articulos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.daos.ArticuloDao;

public class BuscarArticulosFavoritosController extends SimpleFormController {
	private ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		Articulo articulo = new Articulo();
		articulo.setFavorito(true);
		
		List<Articulo> articulos = articuloDao.buscarArticulosFavoritos(articulo);
		
		return new ModelAndView("articulos", "articulos", articulos);
	}
}