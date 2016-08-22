package com.jaime.jpa.data.service.canal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, Integer> {
	
	Entity findByLogicalname(String logicalname);

}
