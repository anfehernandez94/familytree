package co.projectroots.familytree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.projectroots.familytree.component.ConverterPerson;
import co.projectroots.familytree.model.ModelPerson;
import co.projectroots.familytree.repository.RepositoryJPAPerson;
import co.projectroots.familytree.service.ServicePerson;

@Service("serviceImplPerson")
public class ServiceImplPerson implements ServicePerson{

	@Autowired
	@Qualifier("repositoryJPAPerson")
	RepositoryJPAPerson repositoryJPAPerson;
	
	@Autowired
	@Qualifier("converterPerson")
	ConverterPerson converterPerson;
	
	@Override
	public ModelPerson addPerson(ModelPerson modelPerson) {		
		repositoryJPAPerson.save(converterPerson.modelPerson2Person(modelPerson));
		return null;
	}

}
