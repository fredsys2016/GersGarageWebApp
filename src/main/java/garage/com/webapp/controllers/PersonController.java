package garage.com.webapp.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;




import garage.com.webapp.services.PersonService;
import garage.com.webapp.entities.*;

import garage.com.webapp.services.RoleService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private RoleService roleServ;
	
	
	@RequestMapping("login")
	public String showloginForm(Model model)
	{
		Person person=new Person();
		model.addAttribute("person",person);
		return "login";
	}
	
	@RequestMapping("register_P")
	public String showNewPersonForm(Model model)
	{
		Person person=new Person();
		model.addAttribute("person",person);
		return "./WebP/newPerson";
	}
	
	/**
	 * This function save information about Customer that has user role id=3 
	 * 
	 * @param person
	 * @return
	 */
	/*
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("person") Person person)
	{

		
		person.setRoles(rolesRep.findOneByID(3));
		person.setActive(1);
		personService.savePerson(person);

		ModelAndView model=new ModelAndView("Home");
		Person user=personService.finBy_Email(person.getEmail());
		model.addObject("user", user);
		return model;
	}
	
	*/
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("person") Person person)
	{
		person.setRoles(roleServ.findOneByID(3));
		person.setActive(1);
		personService.savePerson(person);

		return "./WebP/homeClient";
	}
	
	
	@RequestMapping("/editUser")
	public String showNewPersonFor(Model model)
	{
		Person person=new Person();
		model.addAttribute("person",person);
		return "./WebP/editPerson";
	}
	

	/**
	 * 
	 * ADMIN
	 * USER
	 * CLIENT
	 */


	/**
	 * Web Admin
	 */


	@RequestMapping("/newStaff")
	public String openFormStaff(Model model)
	{
		Person person=new Person();
		model.addAttribute("person", person);
		List<Roles> lsRole=roleServ.finALL();
		model.addAttribute("lsRole", lsRole);
		return "./WebAdmin/staff";
	}
	
	@RequestMapping(value="/saveStaff", method=RequestMethod.POST)
	public String saveStaff(@ModelAttribute("person") Person person)
	{
		person.setActive(1);
		personService.savePerson(person);
		return "./WebP/homeClient";
	}

}
