package co.projectroots.familytree.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.projectroots.familytree.entity.Person;
import co.projectroots.familytree.model.ModelPerson;

@Component("personConverter")
public class ConverterPerson {

	public ModelPerson person2ModelPerson(Person person){
		ModelPerson modelPerson = new ModelPerson();
		modelPerson.setId(person.getId());
		modelPerson.setFirstName(person.getFirstName());
		modelPerson.setLastName(person.getLastName());
		modelPerson.setBirthDate(person.getBirthDate());
		modelPerson.setBirthPlace(person.getBirthPlace());
		
		return modelPerson ;
	}
	
	public Person modelPerson2Person(ModelPerson modelPerson){
		Person person = new Person();
		person.setId(modelPerson.getId());
		person.setFirstName(modelPerson.getFirstName());
		person.setLastName(modelPerson.getLastName());
		person.setBirthDate(modelPerson.getBirthDate());
		person.setBirthPlace(modelPerson.getBirthPlace());
		
		return person ;
	}
	
	public List<ModelPerson> listPerson2ListModelPerson(List<Person> listPerson){
		List<ModelPerson> listModelPerson = new ArrayList<>();
		for(Person person : listPerson){
			listModelPerson.add(person2ModelPerson(person));
		}
		return listModelPerson;
	}
	
	public List<Person> listModelPerson2ListPerson(List<ModelPerson> listModelPerson){
		List<Person> listPerson = new ArrayList<>();
		for(ModelPerson modelPerson : listModelPerson){
			listPerson.add(modelPerson2Person(modelPerson));
		}
		return listPerson;
	}
	
	
}
