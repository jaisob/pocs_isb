package com.jaime.jpa.data.service.canal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CanalRepository extends JpaRepository<Canal, Integer> {

	Canal findByLogicalname(String logicalname);
}
