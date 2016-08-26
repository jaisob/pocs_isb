package com.jaime.jpa.data.service.filter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilterRepository extends JpaRepository<Filter, Integer> {
	
	List<Filter> findByHandlerType(String handlerType);
	
	List<Filter> findByHandlerTypeAndStatusAndReasonAndFilterType(String handlerType, String status, String reason, String filterType);
	
	Filter findByLogicalname(String logicalname);
	
	// SELECT Filters.ID, Filters.LOGICALNAME, Filters.DEFINITION AS Filter_Definition, Actions.DEFINITION AS Action_Definition, Actions.LOGICALNAME
	// "FROM FILTER AS Filters INNER JOIN FILTER_ACTION ON Filters.LOGICALNAME = FILTER_ACTION.FILTER_ID " +
	// "INNER JOIN ACTION AS Actions ON Actions.LOGICALNAME = FILTER_ACTION.ACTION_ID " + 
	// "WHERE Filters.HANDLER_TYPE = ? AND Filters.STATUS = ? AND REASON = ?  AND TYPE = ?";
	@Query("SELECT f,a FROM Filter f JOIN f.actions a WHERE f.handlerType=:handlerType AND a.definition=:def")
	List<Object[]> searchFilters(@Param("handlerType") String handlerType, @Param("def") String definition);
}
