package com.roldan.revistero.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class InicioController extends AbstractController
{
	protected ModelAndView handleRequestInternal(
			HttpServletRequest arg0,
			HttpServletResponse arg1)
	{		
		return new ModelAndView("inicio");
	}
}
