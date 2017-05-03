package com.mvc.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import com.mvc.model.Person;

	@Controller

	public class PersonController {
		
		
		@RequestMapping("/")
		public String getPersonForm(Model model)
		{
			model.addAttribute("personObj",new Person());
			return "personform";
		}
		 @RequestMapping("/personDetails")   
	    public String getPersonDetails(@ModelAttribute(value="personObj")  Person person,Model model)
	    {
	    	model.addAttribute("person",person);
	    	return "persondetails";	    	
		}
	}



