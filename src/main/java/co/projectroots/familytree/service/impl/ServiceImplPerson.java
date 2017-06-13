package co.projectroots.familytree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.projectroots.familytree.component.ConverterPerson;
import co.projectroots.familytree.entity.Person;
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
		Person person = repositoryJPAPerson.save(converterPerson.modelPerson2Person(modelPerson));
		return converterPerson.person2ModelPerson(person);
	}

	@Override
	public boolean deletePerson(ModelPerson modelPerson) {
		repositoryJPAPerson.delete(converterPerson.modelPerson2Person(modelPerson));
		return false;
	}

	@Override
	public ModelPerson updatePerson(ModelPerson modelPerson) {
		return this.addPerson(modelPerson);
	}

	@Override
	public List<ModelPerson> selectAllPerson() {
		List<Person> listPerson = repositoryJPAPerson.findAll();
		return converterPerson.listPerson2ListModelPerson(listPerson);
	}

	@Override
	public ModelPerson selectPersonById(int id) {
		Person person = repositoryJPAPerson.findById(id);
		return converterPerson.person2ModelPerson(person);
	}

}
