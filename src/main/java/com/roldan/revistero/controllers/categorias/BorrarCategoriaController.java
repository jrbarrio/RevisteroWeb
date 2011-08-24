package com.roldan.revistero.controllers.categorias;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.daos.CategoriaDao;

public class BorrarCategoriaController extends AbstractCommandController
{
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public BorrarCategoriaController() {
		setCommandClass(Categoria.class);
		setCommandName("categoria");
	}

	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			BindException exception)
	{		
		Categoria categoria = (Categoria) command;
		
		categoriaDao.borrarCategoria(categoria);
		
		List<Categoria> categorias = categoriaDao.findCategorias();
		
		return new ModelAndView("categorias", "categorias", categorias);
	}
}
