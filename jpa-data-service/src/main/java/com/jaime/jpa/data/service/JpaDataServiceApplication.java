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
import com.jaime.jpa.data.service.filter.repository.Action;
import com.jaime.jpa.data.service.filter.repository.Filter;
import com.jaime.jpa.data.service.filter.repository.FilterRepository;

@SpringBootApplication
public class JpaDataServiceApplication implements CommandLineRunner {
	
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private EntityRepository entityRepository;
	@Autowired
	private CanalRepository canalRepository;
	@Autowired
	private FilterRepository filterRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDataServiceApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String...strings) throws Exception{
		
		testAgents();
		testEntityCanal();
		testFilter();
	}
	
	private void testAgents(){
		System.out.println("=============================================================");
		System.out.println("Agentes, consulta simple");
		List<Agent> agents = agentRepository.findAll();
		System.out.println("FindAll: número de objetos en tabla Agents: " + agents.size());
		System.out.println("findByAgent: place asociado al user14" + agentRepository.findByAgent("user14").getPlace());
		System.out.println("=============================================================");
	}
	
	private void testEntityCanal(){
		System.out.println("=============================================================");
		System.out.println("Entity_Canal, consulta many to many");
		List<Entity> entities = entityRepository.findAll();
		System.out.println("FindAll: número de entidades: " + entities.size());
		List<Canal> canals = canalRepository.findAll();
		System.out.println("FindAll: número de canales: " + canals.size());
		Entity entity = entityRepository.findByLogicalname("Santander");
		System.out.println("findByLogicalName Santander: " + entity.getEntityName());
		List<Canal> entityToCanal = entity.getCanals();
		System.out.println("La entidad Santander tiene relacionados " + entityToCanal.size() + " canales");
		Canal canal = canalRepository.findByLogicalname("CALL");
		System.out.println("findByLogicalName CALL: " + canal.getLogicalname());
		List<Entity> canalToEntity = canal.getEntities();
		System.out.println("El canal Call tiene relacionadas " + canalToEntity.size() + " entidades");
		System.out.println("=============================================================");
	}
	
	private void testFilter(){
		System.out.println("=============================================================");
		System.out.println("Filter_Action");
		List<Filter> filters = filterRepository.findByHandlerType("INTERACTION_VOICE");
		System.out.println("findByHandlerType: número de filtros con handler_type INTERACTION_EVENT: " + filters.size());
		filters = filterRepository.findByHandlerTypeAndStatusAndReasonAndFilterType("INTERACTION_VOICE", "IDLE", "RELEASED", "PHONECALL");
		System.out.println("findByHandlerTypeAndStatusAndReasonAndFilterType: número de filtros con handler_type INTERACTION_EVENT, status IDLE, reason RELEASED, type PHONECALL: " + filters.size());
		List<Object[]> f = filterRepository.searchFilters("INTERACTION_VOICE", "def_action_1");
		System.out.println("Búsqueda de filtros y acciones con el filtro con handlerType INTERACTION_EVENT y la acción con definición def_action_1" );
		for(Object[] objs : f){
			for(Object obj : objs){
				if(obj instanceof Filter){
					System.out.println("Filtro: " + obj.toString());
				}
				if(obj instanceof Action){
					System.out.println("Acción: " + obj.toString());
				}
			}
		}
		Filter filt = filterRepository.findByLogicalname("Filter1");
		System.out.println("La entidad Filter1 tiene relacionadas las siguientes acciones: ");
		List<Action> act = filt.getActions();
		for(Action a : act){
			System.out.println(a.toString());
		}
		System.out.println("=============================================================");
	}
}
