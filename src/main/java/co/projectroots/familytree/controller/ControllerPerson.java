package co.projectroots.familytree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	private static final Log LOG = LogFactory.getLog(ControllerPerson.class);
	
	@GetMapping(value={"", "form"})
	public ModelAndView selectAllPerson(){
		ModelAndView mav = new ModelAndView(ViewConstants.PERSON);
		List<ModelPerson> listModelPerson = servicePerson.selectAllPerson();
		mav.addObject("listPerson", listModelPerson);
		mav.addObject("modelPerson", new ModelPerson());
		return mav;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute(name="modelPerson") ModelPerson modelPerson,
			BindingResult bindingResult){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/person");
		if(bindingResult.hasErrors()){
			LOG.error("Faltan campos: " + bindingResult.getAllErrors());	
		}else{			
			if(servicePerson.addPerson(modelPerson) != null)
				LOG.info("ID: " + modelPerson.getId() + " - First Name: " + modelPerson.getFirstName());
			else
				LOG.warn("Person not added");
		}
		List<ModelPerson> listModelPerson = servicePerson.selectAllPerson();
		mav.addObject("listPerson", listModelPerson);
		return mav;
	}
	
	@PostMapping("/deleteperson")
	public ModelAndView deletePerson(@ModelAttribute(name="modelPerson") ModelPerson modelPerson){
		ModelAndView mav = new ModelAndView(ViewConstants.PERSON);
		servicePerson.deletePerson(modelPerson);
		return mav;		
	}
	
	@PostMapping("/updateperson")
	public ModelAndView updatePerson(@ModelAttribute(name="modelPerson") ModelPerson modelPerson){
		ModelAndView mav = new ModelAndView(ViewConstants.PERSON);
		servicePerson.updatePerson(modelPerson);
		return mav;
	}
	
}
