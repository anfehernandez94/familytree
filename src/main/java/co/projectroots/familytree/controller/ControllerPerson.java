package co.projectroots.familytree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.projectroots.familytree.constant.ViewConstants;
import co.projectroots.familytree.model.ModelPerson;
import co.projectroots.familytree.service.ServicePerson;

@Controller
@RequestMapping("/person")
public class ControllerPerson {

	@Autowired
	@Qualifier("serviceImplPerson")
	private ServicePerson servicePerson;
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute(name="personModel") ModelPerson modelPerson){
		ModelAndView mav = new ModelAndView();
		if(servicePerson.addPerson(modelPerson) != null){
			mav.setViewName(ViewConstants.PERSON);
		}
		return mav;
	}
	
}
