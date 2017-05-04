package com.mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.model.Person;
import com.mvc.service.PersonService;



@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	
	//personController.setPersonService(new PersonServiceImpl())
	
	
	
	//http://localhost:8080/mvcdemo/personForm
    @RequestMapping("/personForm")
	public String getPersonForm(Model model){
		model.addAttribute("personObj",new Person()); // firstname,lastname,email and phone are null
		return "personform";
	}
    //personObj - to read the value from spring form fields
    //person - to send the value to the persondetails.jsp
   @RequestMapping("/processPersonDetails") // firstname,lastname,email and phone has some values
    public String getPersonDetails(@ModelAttribute(value="personObj")  Person person,Model model){
	   
	   personService.savePerson(person);
	   
    	model.addAttribute("person",person);
    	return "persondetails";
    	
    }
}
