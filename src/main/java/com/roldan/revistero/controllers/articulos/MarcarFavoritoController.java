package com.roldan.revistero.controllers.articulos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.daos.ArticuloDao;

public class MarcarFavoritoController extends SimpleFormController {
	
	private ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		System.out.println("Se va a marcar el articulo como favorito...");
		
		
		Articulo articulo = new Articulo();
		String idArticulo = request.getParameter("idArticulo");
		if(idArticulo != null && !idArticulo.equals(""))
		{
			articulo.setIdArticulo(Long.valueOf(idArticulo));
			articulo = articuloDao.verArticulo(articulo);
		
			if (articulo.isFavorito()) {
				articulo.setFavorito(false);
			} else {
				articulo.setFavorito(true);
			}
			
			articuloDao.guardarArticulo(articulo);
		}
		
		return null;
	}
}