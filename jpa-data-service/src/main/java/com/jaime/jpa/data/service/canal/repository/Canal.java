package com.jaime.jpa.data.service.canal.repository;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@javax.persistence.Entity
public class Canal {

	@Id
	private Integer id;
	private String logicalname;
	private Integer maximo;
	private String medio;
	@ManyToMany(mappedBy = "canals")
	private List<Entity> entities;
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
	 * @return the maximo
	 */
	public Integer getMaximo() {
		return maximo;
	}
	/**
	 * @param maximo the maximo to set
	 */
	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}
	/**
	 * @return the medio
	 */
	public String getMedio() {
		return medio;
	}
	/**
	 * @param medio the medio to set
	 */
	public void setMedio(String medio) {
		this.medio = medio;
	}
	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		return entities;
	}
	/**
	 * @param entities the entities to set
	 */
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
}
