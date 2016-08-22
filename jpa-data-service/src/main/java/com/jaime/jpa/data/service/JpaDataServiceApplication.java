package com.jaime.jpa.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jaime.jpa.data.service.agents.repository.Agent;
import com.jaime.jpa.data.service.agents.repository.AgentRepository;
import com.jaime.jpa.data.service.canal.repository.Canal;
import com.jaime.jpa.data.service.canal.repository.CanalRepository;
import com.jaime.jpa.data.service.canal.repository.Entity;
import com.jaime.jpa.data.service.canal.repository.EntityRepository;

@SpringBootApplication
public class JpaDataServiceApplication implements CommandLineRunner {
	
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private EntityRepository entityRepository;
	@Autowired
	private CanalRepository canalRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDataServiceApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String...strings) throws Exception{
		
		testAgents();
		testEntityCanal();
	}
	
	private void testAgents(){
		System.out.println("Agentes, consulta simple");
		List<Agent> agents = agentRepository.findAll();
		System.out.println("FindAll: número de objetos: " + agents.size());
		System.out.println("findByAgent: " + agentRepository.findByAgent("user14").getPlace());
	}
	
	private void testEntityCanal(){
		System.out.println("Entity_Canal, consulta many to many");
		List<Entity> entities = entityRepository.findAll();
		System.out.println("FindAll: número de entidades: " + entities.size());
		List<Canal> canals = canalRepository.findAll();
		System.out.println("FindAll: número de canales: " + canals.size());
		Entity entity = entityRepository.findByLogicalname("Santander");
		System.out.println("findByLogicalName Santander: " + entity.getEntityName());
		List<Canal> entityToCanal = entity.getCanals();
		System.out.println("La entidad Santander tiene relacionados " + entityToCanal.size() + " canales");
		Canal canal = canalRepository.findByLogicalname("Call");
		System.out.println("findByLogicalName Call: " + canal.getLogicalname());
		List<Entity> canalToEntity = canal.getEntities();
		System.out.println("El canal Call tiene relacionadas " + canalToEntity.size() + " entidades");
	}
}
