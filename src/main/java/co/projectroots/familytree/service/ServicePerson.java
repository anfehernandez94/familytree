package co.projectroots.familytree.service;

import java.util.List;

import co.projectroots.familytree.model.ModelPerson;

public interface ServicePerson {

	ModelPerson addPerson(ModelPerson modelPerson);
	boolean deletePerson(ModelPerson modelPerson);
	ModelPerson updatePerson(ModelPerson modelPerson);
	ModelPerson selectPersonById(int id);
	List<ModelPerson> selectPersonByFirstName(String firstName);
	List<ModelPerson> selectAllPerson();
	
}
