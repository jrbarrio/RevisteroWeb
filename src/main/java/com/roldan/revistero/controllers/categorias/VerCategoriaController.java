package com.roldan.revistero.controllers.categorias;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.CategoriaDao;
import com.roldan.revistero.modelo.daos.TemaDao;

public class VerCategoriaController extends AbstractCommandController
{
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}
	private TemaDao temaDao;
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	public VerCategoriaController() {
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
		
		categoria = categoriaDao.verCategoria(categoria);
		Tema tema = new Tema();
		tema.setCategoria(categoria);
		categoria.setTemas(temaDao.buscarTemas(tema));
		
		return new ModelAndView("verCategoria", "categoria", categoria);
	}
}