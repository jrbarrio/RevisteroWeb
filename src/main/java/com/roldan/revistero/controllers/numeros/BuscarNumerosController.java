package com.roldan.revistero.controllers.numeros;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roldan.revistero.modelo.Revista;
import com.roldan.revistero.modelo.Numero;
import com.roldan.revistero.modelo.daos.RevistaDao;
import com.roldan.revistero.modelo.daos.NumeroDao;

public class BuscarNumerosController extends SimpleFormController {
	
	private NumeroDao numeroDao;
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}
	private RevistaDao revistaDao;
	public void setRevistaDao(RevistaDao revistaDao) {
		this.revistaDao = revistaDao;
	}

	public BuscarNumerosController() {
		setCommandClass(Numero.class);
		setCommandName("numero");
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		Numero numero = new Numero();
		numero.setRevista(new Revista());

		return numero;
	}
	
	protected Map<String, List<Revista>> referenceData(HttpServletRequest request)
	{
		Map<String, List<Revista>> referenceData = new HashMap<String, List<Revista>>();
		
		List<Revista>revistas = revistaDao.findRevistas();
		referenceData.put("revistas",revistas);
		
		return referenceData;
	}
	
	public ModelAndView onSubmit(
			Object command,
			BindException exception)
	{		
		Numero numero = (Numero) command;
		List<Numero> numeros = numeroDao.buscarNumeros(numero);
		
		return new ModelAndView("numeros", "numeros", numeros);
	}
}

