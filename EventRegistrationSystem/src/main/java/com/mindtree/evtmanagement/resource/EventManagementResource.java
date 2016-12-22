package com.mindtree.evtmanagement.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mindtree.evtmanagement.dao.vo.EvtRegResponse;
import com.mindtree.evtmanagement.dto.EmployeeDto;
import com.mindtree.evtmanagement.dto.EmployeeEvntRegDto;
import com.mindtree.evtmanagement.svc.EventManagementSvc;

@Path("emp-management")
@Controller
public class EventManagementResource {

	@Autowired
	private EventManagementSvc eventMangementSvc;
	
	@Path("register-event")
	@POST
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	public EvtRegResponse registerEmployeeToEvent(EmployeeEvntRegDto empEvntReg){
		return eventMangementSvc.registerEmployeeToEvent(empEvntReg);
	}
	
	@Path("employees")
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	public List<EmployeeDto> allEmployees(){
		return eventMangementSvc.getAllEmployees();
	}
	
}
