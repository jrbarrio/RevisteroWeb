package com.roldan.revistero.modelo.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.roldan.revistero.modelo.Revista;

public class RevistaDao
{
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template)
	{
		this.template = template;
	}
	
	public Revista verRevista(Revista revista)
	{
		Revista result = (Revista) template.get(Revista.class, revista.getIdRevista());
		return result;
	}
	
	public void guardarRevista(Revista revista)
	{
		template.saveOrUpdate(revista);
	}
	
	public void borrarRevista(Revista revista)
	{
		template.delete(revista);
	}

	@SuppressWarnings("unchecked")
	public List<Revista> findRevistas()
	{
		List<Revista> results = template.find("FROM Revista ORDER BY nombre", null);
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<Revista> buscarRevistas(Revista revista)
	{		
		Session session = template.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Revista.class);

		if(revista.getNombre()!=null && !revista.getNombre().trim().equals(""))
		{
			Criterion nombreRestriction = Restrictions.like("nombre", "%" + revista.getNombre() + "%");
			crit.add(nombreRestriction);
		}		
		if(revista.getDescripcion()!=null && !revista.getDescripcion().trim().equals(""))
		{
			Criterion descripcionRestriction = Restrictions.like("descripcion", "%" + revista.getDescripcion() + "%");
			crit.add(descripcionRestriction);
		}
		
		crit.addOrder(Order.asc("nombre"));

		List<Revista> revistas = crit.list();

		session.close();
		
		return revistas;
	}
}