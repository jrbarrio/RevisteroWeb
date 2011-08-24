package com.roldan.revistero.controllers.categorias;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.daos.CategoriaDao;

public class BuscarCategoriasController extends SimpleFormController {
	
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public BuscarCategoriasController() {
		setCommandClass(Categoria.class);
		setCommandName("categoria");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		Categoria categoria = new Categoria();

		return categoria;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception)
	{		
		Categoria categoria = (Categoria) command;
		List<Categoria> categorias = categoriaDao.buscarCategorias(categoria);
		
		return new ModelAndView("categorias", "categorias", categorias);
	}
}
