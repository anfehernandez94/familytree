package co.projectroots.familytree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "link")
public class Link {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="idnode1", nullable=false)
	private int idNode1;
	
	@Column(name="idnode1", nullable=false)
	private int idNode2;

}
