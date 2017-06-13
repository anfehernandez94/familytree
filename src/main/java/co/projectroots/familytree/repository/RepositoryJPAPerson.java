package co.projectroots.familytree.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.projectroots.familytree.entity.Person;

@Repository("repositoryJPAPerson")
public interface RepositoryJPAPerson extends JpaRepository<Person, Serializable>{

	Person findById(int id);
	
}
