package com.roldan.revistero.controllers.articulos;

import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.daos.ArticuloDao;

public class BorrarArticuloControllerTest
{
	private BorrarArticuloController controller;
	private ArticuloDao articuloDao;
	private Articulo articulo;
	
	@Before
	public void prepareTests()
	{
		controller = new BorrarArticuloController();
		
		articuloDao = createMock(ArticuloDao.class);	
		articulo = new Articulo();
		
		articuloDao.borrarArticulo(articulo);
		
		articuloDao.findArticulos();
		List<Articulo> articulos = new ArrayList<Articulo>();
		expectLastCall().andReturn(articulos);
		
		replay(articuloDao);
		
		controller.setArticuloDao(articuloDao);
	}
	
	@Test
	public void testHandle()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		try
		{
			controller.handle(request, response, articulo, null);
		}
		catch (Exception e) {}
		
		verify(articuloDao);
	}

}
