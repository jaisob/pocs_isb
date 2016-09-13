/**
 * 
 */
package com.jaime.jpa.data.service.agents.repository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaime.jpa.data.service.JpaDataServiceApplication;
import com.jaime.jpa.data.service.JpaDataServiceApplicationTests;

/**
 * @author Jaime
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaDataServiceApplication.class)
@Transactional
public class AgentRepositoryTest {
	
	@Autowired
	private AgentRepository agentRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		Agent ag1 = new Agent();
		ag1.setAgent("Agente1");
		ag1.setPlace("Place1");
		Agent ag2 = new Agent();
		ag2.setAgent("Agente1");
		ag2.setPlace("Place1");
		agentRepository.save(ag1);
		agentRepository.save(ag2);
	}

	/**
	 * Test method for {@link com.jaime.jpa.data.service.agents.repository.AgentRepository#findByAgent(java.lang.String)}.
	 */
	@Test
	public void testFindByAgent() {
		System.out.println("****");
		List<Agent> l = agentRepository.findAll();
		System.out.println("*********************" + agentRepository.count());
	}

}
