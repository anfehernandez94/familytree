package co.projectroots.familytree.component;

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
	
}
