package com.roldan.revistero.controllers.articulos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.Tema;
import com.roldan.revistero.modelo.daos.ArticuloDao;
import com.roldan.revistero.modelo.daos.NumeroDao;
import com.roldan.revistero.modelo.daos.RevistaDao;
import com.roldan.revistero.modelo.daos.TemaDao;

public class BuscarArticulosController extends SimpleFormController {
	
	private ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}
	private TemaDao temaDao;
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	public BuscarArticulosController() {
		setCommandClass(Articulo.class);
		setCommandName("articulo");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{		
		Articulo articulo = new Articulo();
		
		Tema tema = new Tema();
		String idTema = (String) request.getParameter("tema.idTema");
		if(idTema != null && !idTema.equals(""))
		{
			tema.setIdTema(Long.valueOf(idTema));
			tema = temaDao.verTema(tema);
		}
		articulo.setTema(tema);
		
		Numero numero = new Numero();
		String idNumero = (String) request.getParameter("numero.idNumero");
		if(idNumero != null && !idNumero.equals(""))
		{
			numero.setIdNumero(Long.valueOf(idNumero));
			numero = numeroDao.verNumero(numero);
		}
		articulo.setNumero(numero);
		
		Revista revista = new Revista();
		String idRevista = (String) request.getParameter("numero.revista.idRevista");
		if(idRevista != null && !idRevista.equals(""))
		{
			revista.setIdRevista(Long.valueOf(idRevista));
			revista = revistaDao.verRevista(revista);
		}
		articulo.getNumero().setRevista(revista);
		
		return articulo;
	}
	
	protected Map<String, List> referenceData(HttpServletRequest request)
	{
		Map<String, List> referenceData = new HashMap<String, List>();
		
		List<Tema> temas = temaDao.findTemas();
		referenceData.put("temas", temas);
		
		Numero numero = new Numero();
		try {
			Articulo articulo = (Articulo) formBackingObject(request);
			numero.setRevista(articulo.getNumero().getRevista());
		} catch (Exception e) {}

		// Si ni hay una revista seleccionada no se muestran numeros 
		List<Numero> numeros = new ArrayList<Numero>();
		if(!(numero.getRevista().getIdRevista() == null))
		{
			numeros = numeroDao.buscarNumeros(numero);
		}		
		referenceData.put("numeros", numeros);
		
		List<Revista> revistas = revistaDao.findRevistas();
		referenceData.put("revistas", revistas);
		
		return referenceData;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception) {
		
		Articulo articulo = (Articulo) command;
		List<Articulo> articulos = articuloDao.buscarArticulos(articulo);
		
		return new ModelAndView(getSuccessView(), "articulos", articulos);
	}
}