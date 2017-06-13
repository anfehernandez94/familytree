package co.projectroots.familytree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping()
	public ModelAndView selectAllPerson(){
		ModelAndView mav = new ModelAndView();
		List<ModelPerson> listModelPerson = new ArrayList<>();
		mav.addObject("listPerson", listModelPerson);
		return mav;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute(name="personModel") ModelPerson modelPerson){
		ModelAndView mav = new ModelAndView();
		if(servicePerson.addPerson(modelPerson) != null){
			mav.setViewName(ViewConstants.PERSON);
		}
		return mav;
	}
	
	@PostMapping("/deletePerson")
	public ModelAndView deletePerson(@ModelAttribute(name="personModel") ModelPerson modelPerson){
		ModelAndView mav = new ModelAndView(ViewConstants.PERSON);
		servicePerson.deletePerson(modelPerson);
		return mav;		
	}
	
	@PostMapping("/updatePerson")
	public ModelAndView updatePerson(@ModelAttribute(name="personModel") ModelPerson modelPerson){
		ModelAndView mav = new ModelAndView(ViewConstants.PERSON);
		servicePerson.updatePerson(modelPerson);
		return mav;
	}
	
}
