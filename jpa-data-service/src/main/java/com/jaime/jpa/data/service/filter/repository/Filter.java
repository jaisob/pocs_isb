package com.jaime.jpa.data.service.filter.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


@Entity
public class Filter {

	@Id
	private Integer id;
	private String logicalname;
	private String definition;
	private String handlerType;
	private String status;
	private String reason;
	private String filterType;
	@ManyToMany
	@JoinTable(name = "filter_action", joinColumns = { @JoinColumn(name = "filter_name")},
			inverseJoinColumns = {@JoinColumn(name="action_name")})
	private List<Action> actions;
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
	public void setLogicalname(String logicalName) {
		this.logicalname = logicalName;
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
	 * @return the handler_type
	 */
	public String getHandler_type() {
		return handlerType;
	}
	/**
	 * @param handler_type the handler_type to set
	 */
	public void setHandler_type(String handler_type) {
		this.handlerType = handler_type;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return filterType;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.filterType = type;
	}
	/**
	 * @return the actions
	 */
	public List<Action> getActions() {
		return actions;
	}
	/**
	 * @param actions the actions to set
	 */
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
	
}
