package com.roldan.revistero.controllers.categorias;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.daos.CategoriaDao;

public class BorrarCategoriaController extends SimpleFormController {
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		Categoria categoria = new Categoria();
		String idCategoria = request.getParameter("idCategoria");
		if(idCategoria != null && !idCategoria.equals("")) {
			categoria.setIdCategoria(Long.valueOf(idCategoria));		
			categoriaDao.borrarCategoria(categoria);
		}
		
		return null;
	}
}
