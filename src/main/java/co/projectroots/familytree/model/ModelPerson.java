package co.projectroots.familytree.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ModelPerson {

	private int id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Date birthDate;
	@NotNull
	private String birthPlace;
	
	public ModelPerson(){}
	
	public ModelPerson(int id, String firstName, String lastName, Date birthDate, String birthPlace) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	
	
}
