package com.jaime.jpa.data.service.filter.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


@Entity
public class Action {

	@Id
	private Integer id;
	private String logicalname;
	private String definition;
	@ManyToMany(mappedBy = "actions")
	private List<Filter> filters;
	
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
	public String getLogicalname() {
		return logicalname;
	}
	public void setLogicalname(String logicalname) {
		this.logicalname = logicalname;
	}
	/**
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}
	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	/**
	 * @return the filters
	 */
	public List<Filter> getFilters() {
		return filters;
	}
	/**
	 * @param filters the filters to set
	 */
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
