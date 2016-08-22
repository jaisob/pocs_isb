package com.jaime.jpa.data.service.canal.repository;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@javax.persistence.Entity
public class Entity {

	@Id
	private Integer id;
	private String logicalname;
	private String entityName;
	@ManyToMany
	@JoinTable(name = "entity_canal", joinColumns = { @JoinColumn(name = "entity_id")},
			inverseJoinColumns = {@JoinColumn(name="canal_id")})
	private List<Canal> canals;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the logicalName
	 */
	public String getLogicalName() {
		return logicalname;
	}
	/**
	 * @param logicalName the logicalName to set
	 */
	public void setLogicalName(String logicalName) {
		this.logicalname = logicalName;
	}
	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	/**
	 * @return the logicalname
	 */
	public String getLogicalname() {
		return logicalname;
	}
	/**
	 * @param logicalname the logicalname to set
	 */
	public void setLogicalname(String logicalname) {
		this.logicalname = logicalname;
	}
	/**
	 * @return the canals
	 */
	public List<Canal> getCanals() {
		return canals;
	}
	/**
	 * @param canals the canals to set
	 */
	public void setCanals(List<Canal> canals) {
		this.canals = canals;
	}
	
	
}
