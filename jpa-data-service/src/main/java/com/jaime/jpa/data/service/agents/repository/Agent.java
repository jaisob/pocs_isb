package com.jaime.jpa.data.service.agents.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity()
public class Agent {
	
	@Id
	@GeneratedValue
	private String id;
	private String agent;
	private String place_id;
	
	
	/**
	 * @return the agent
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * @param agent the agent to set
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place_id;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place_id = place;
	}
}
