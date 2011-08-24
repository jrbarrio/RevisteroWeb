package com.roldan.revistero.modelo.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.roldan.revistero.modelo.Numero;

public class NumeroDao
{

	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template)
	{
		this.template = template;
	}

	public Numero verNumero(Numero numero)
	{
		Numero result = (Numero) template.get(Numero.class, numero.getIdNumero());
		return result;
	}
	
	public void guardarNumero(Numero numero)
	{
		template.saveOrUpdate(numero);
	}
	
	public void borrarNumero(Numero numero)
	{
		template.delete(numero);
	}
	
	@SuppressWarnings("unchecked")
	public List<Numero> findNumeros()
	{
		List<Numero> results = template.find("FROM Numero ORDER BY numero DESC", null);
		return results;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Numero> buscarNumeros(Numero numero)
	{		
		Session session = template.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Numero.class);

		if(numero.getTitulo()!=null && !numero.getTitulo().trim().equals(""))
		{
			Criterion nombreRestriction = Restrictions.like("titulo", "%" + numero.getTitulo() + "%");
			crit.add(nombreRestriction);
		}		
		if(numero.getDescripcion()!=null && !numero.getDescripcion().trim().equals(""))
		{
			Criterion descripcionRestriction = Restrictions.like("descripcion", "%" + numero.getDescripcion() + "%");
			crit.add(descripcionRestriction);
		}		
		if(numero.getRevista()!=null)
		{
			Criteria catCriteria = crit.createCriteria("revista");
			if(numero.getRevista().getIdRevista()!=null)
			{
				Criterion catRestriction = Restrictions.eq("idRevista", numero.getRevista().getIdRevista());
				catCriteria.add(catRestriction);
			}
		}
		
		crit.addOrder(Order.desc("numero"));

		List<Numero> numeros = crit.list();

		session.close();
		
		return numeros;
	}
}