package com.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.model.Person;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao 
{	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PersonDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public void savePerson(Person person)
	{
		Session session=sessionFactory.openSession();
	
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(person);
		tx.commit();
	}
}