package com.roldan.revistero.controllers.categorias;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.CategoriaDao;
import com.roldan.revistero.modelo.daos.TemaDao;

public class EditarCategoriaController extends SimpleFormController {
	
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}
	private TemaDao temaDao;
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	public EditarCategoriaController() {
		setCommandClass(Categoria.class);
		setCommandName("categoria");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		Categoria categoria = new Categoria();
		
		String idCategoria = request.getParameter("idCategoria");
		if(idCategoria != null && !idCategoria.equals(""))
		{
			categoria.setIdCategoria(Long.valueOf(idCategoria));
			categoria = categoriaDao.verCategoria(categoria);
		}
		
		return categoria;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception) {
		
		Categoria categoria = (Categoria) command;
		categoriaDao.guardarCategoria(categoria);
		Tema tema = new Tema();
		tema.setCategoria(categoria);
		categoria.setTemas(temaDao.buscarTemas(tema));
		
		return new ModelAndView(getSuccessView(), "categoria", categoria);
	}
}