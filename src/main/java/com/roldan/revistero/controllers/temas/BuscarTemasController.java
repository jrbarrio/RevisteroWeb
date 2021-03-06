package com.roldan.revistero.controllers.temas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Categoria;
import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.CategoriaDao;
import com.roldan.revistero.modelo.daos.TemaDao;

public class BuscarTemasController extends SimpleFormController {
	
	private TemaDao temaDao;
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}
	private CategoriaDao categoriaDao;
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public BuscarTemasController() {
		setCommandClass(Tema.class);
		setCommandName("tema");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		Tema tema = new Tema();
		tema.setCategoria(new Categoria());

		return tema;
	}
	
	protected Map<String, List<Categoria>> referenceData(HttpServletRequest request)
	{
		Map<String, List<Categoria>> referenceData = new HashMap<String, List<Categoria>>();
		
		List<Categoria> categorias = categoriaDao.findCategorias();
		referenceData.put("categorias", categorias);
		
		return referenceData;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception)
	{		
		Tema tema = (Tema) command;
		List<Tema> temas = temaDao.buscarTemas(tema);
		
		return new ModelAndView("temas", "temas", temas);
	}
}

