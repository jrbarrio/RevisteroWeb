package com.roldan.revistero.controllers.categorias;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.daos.CategoriaDao;

public class CategoriasController extends AbstractController
{
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request,
			HttpServletResponse response)
	{		
		List<Categoria> categorias = categoriaDao.findCategorias();
		
		return new ModelAndView("categorias", "categorias", categorias);
	}
}
