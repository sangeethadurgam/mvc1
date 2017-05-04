package com.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.PersonDao;
import com.mvc.model.Person;
@Service
public class PersonServiceimpl implements PersonService {
	
		@Autowired
	private PersonDao personDao;
		
		//personServiceImpl.setPersonDao(new PersonDaoImpl());
		public void savePerson(Person person) {
			personDao.savePerson(person);

}
}