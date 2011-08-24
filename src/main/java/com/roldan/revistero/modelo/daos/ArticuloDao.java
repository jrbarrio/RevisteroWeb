package com.roldan.revistero.modelo.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.roldan.revistero.modelo.Articulo;

public class ArticuloDao
{
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template)
	{
		this.template = template;
	}
	
	public Articulo verArticulo(Articulo articulo)
	{
		Articulo result = (Articulo) template.get(Articulo.class, articulo.getIdArticulo());
		return result;
	}
	
	public void guardarArticulo(Articulo articulo)
	{
		template.saveOrUpdate(articulo);
	}
	
	public void borrarArticulo(Articulo articulo)
	{
		template.delete(articulo);
	}

	@SuppressWarnings("unchecked")
	public List<Articulo> findArticulos()
	{
		List<Articulo> results = template.find("FROM Articulo ORDER BY titulo",	null);
		return results;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Articulo> buscarArticulos(Articulo articulo)
	{		
		Session session = template.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Articulo.class);

		if(articulo.getTitulo()!=null && !articulo.getTitulo().trim().equals(""))
		{
			Criterion nombreRestriction = Restrictions.like("titulo", "%" + articulo.getTitulo() + "%");
			crit.add(nombreRestriction);
		}		

		if(articulo.getDescripcion()!=null && !articulo.getDescripcion().trim().equals(""))
		{
			Criterion descripcionRestriction = Restrictions.like("descripcion", "%" + articulo.getDescripcion() + "%");
			crit.add(descripcionRestriction);
		}
		
		Criteria temaCriteria = crit.createCriteria("tema");
		if(articulo.getTema()!=null && articulo.getTema().getIdTema()!=null)
		{
			Criterion catRestriction = Restrictions.eq("idTema", articulo.getTema().getIdTema());
			temaCriteria.add(catRestriction);
		}
		
		Criteria numeroCriteria = crit.createCriteria("numero");
		if(articulo.getNumero()!=null && articulo.getNumero().getIdNumero()!=null)
		{
			Criterion catRestriction = Restrictions.eq("idNumero", articulo.getNumero().getIdNumero());
			numeroCriteria.add(catRestriction);
		}	
		
		if(articulo.getNumero().getRevista()!=null && articulo.getNumero().getRevista().getIdRevista()!=null)
		{
			Criteria revistaCriteria = numeroCriteria.createCriteria("revista");
			Criterion revistaRestriction = Restrictions.eq("idRevista", articulo.getNumero().getRevista().getIdRevista());
			revistaCriteria.add(revistaRestriction);
		}	

		crit.addOrder(Order.asc("titulo"));

		List<Articulo> articulos = crit.list();

		session.close();
		
		return articulos;
	}
}
