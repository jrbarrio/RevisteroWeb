package com.roldan.revistero.modelo.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.roldan.revistero.modelo.Tema;

public class TemaDao
{
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template)
	{
		this.template = template;
	}
	
	public Tema verTema(Tema tema)
	{
		Tema result = (Tema) template.get(Tema.class, tema.getIdTema());
		return result;
	}
	
	public void guardarTema(Tema tema)
	{
		template.saveOrUpdate(tema);
	}
	
	public void borrarTema(Tema tema)
	{
		template.delete(tema);
	}

	@SuppressWarnings("unchecked")
	public List<Tema> findTemas()
	{
		List<Tema> results = template.find("FROM Tema ORDER BY nombre", null);
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tema> buscarTemas(Tema tema)
	{		
		Session session = template.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Tema.class);

		if(tema.getNombre()!=null && !tema.getNombre().trim().equals(""))
		{
			Criterion nombreRestriction = Restrictions.like("nombre", "%" + tema.getNombre() + "%");
			crit.add(nombreRestriction);
		}		

		if(tema.getDescripcion()!=null && !tema.getDescripcion().trim().equals(""))
		{
			Criterion descripcionRestriction = Restrictions.like("descripcion", "%" + tema.getDescripcion() + "%");
			crit.add(descripcionRestriction);
		}
		
		if(tema.getCategoria()!=null)
		{
			Criteria catCriteria = crit.createCriteria("categoria");
			if(tema.getCategoria().getIdCategoria()!=null)
			{
				Criterion catRestriction = Restrictions.eq("idCategoria", tema.getCategoria().getIdCategoria());
				catCriteria.add(catRestriction);
			}
		}
		
		crit.addOrder(Order.asc("nombre"));
		
		List<Tema> temas = crit.list();

		session.close();
		
		return temas;
	}
}