package com.mindtree.evtmanagement.svc;

import java.util.List;

import com.mindtree.evtmanagement.dao.vo.EvtRegResponse;
import com.mindtree.evtmanagement.dto.EmployeeDto;
import com.mindtree.evtmanagement.dto.EmployeeEvntRegDto;

public interface EventManagementSvc {
	
	public EvtRegResponse registerEmployeeToEvent(EmployeeEvntRegDto empEvntReg);
	
	public List<EmployeeDto> getAllEmployees();
	
}
