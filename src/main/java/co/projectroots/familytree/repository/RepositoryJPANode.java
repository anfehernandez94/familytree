package co.projectroots.familytree.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.projectroots.familytree.entity.Node;

@Repository
public interface RepositoryJPANode extends JpaRepository<Node, Serializable>{

}
