package com.mindtree.evtmanagement.dao;

import java.util.List;

import com.mindtree.evtmanagement.dao.entity.Employee;
import com.mindtree.evtmanagement.dao.vo.EvtRegResponse;


public interface EventManagementDao {
	
	public EvtRegResponse registerEmployeeToEvent(String mid, long id);
	
	public List<Employee> getAllEmployees();
	
}
