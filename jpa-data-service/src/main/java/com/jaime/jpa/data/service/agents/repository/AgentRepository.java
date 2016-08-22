package com.jaime.jpa.data.service.agents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
	
	Agent findByAgent(String agent);

}
