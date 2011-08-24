package com.roldan.revistero.modelo.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.roldan.revistero.modelo.Categoria;

public class CategoriaDao
{
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template)
	{
		this.template = template;
	}

	public Categoria verCategoria(Categoria categoria)
	{
		Categoria result = (Categoria) template.get(Categoria.class, categoria.getIdCategoria());
		return result;
	}
	
	public void guardarCategoria(Categoria categoria)
	{
		template.saveOrUpdate(categoria);
	}
	
	public void borrarCategoria(Categoria categoria)
	{
		template.delete(categoria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findCategorias()
	{
		List<Categoria> results = template.find("FROM Categoria ORDER BY nombre", null);
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarCategorias(Categoria categoria)
	{		
		Session session = template.getSessionFactory().openSession();
		
		Criteria crit = session.createCriteria(Categoria.class);

		if(categoria.getNombre()!=null && !categoria.getNombre().trim().equals(""))
		{
			Criterion nombreRestriction = Restrictions.like("nombre", "%" + categoria.getNombre() + "%");
			crit.add(nombreRestriction);
		}		

		if(categoria.getDescripcion()!=null && !categoria.getDescripcion().trim().equals(""))
		{
			Criterion descripcionRestriction = Restrictions.like("descripcion", "%" + categoria.getDescripcion() + "%");
			crit.add(descripcionRestriction);
		}

		crit.addOrder(Order.asc("nombre"));
		
		List<Categoria> categorias = crit.list();
		
		session.close();
		
		return categorias;
	}
}