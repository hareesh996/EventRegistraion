package com.mindtree.evtmanagement.svc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.dozer.Mapper;

import com.mindtree.evtmanagement.dao.EventManagementDao;
import com.mindtree.evtmanagement.dao.entity.Employee;
import com.mindtree.evtmanagement.dao.vo.EvtRegResponse;
import com.mindtree.evtmanagement.dto.EmployeeDto;
import com.mindtree.evtmanagement.dto.EmployeeEvntRegDto;
import com.mindtree.evtmanagement.svc.EventManagementSvc;

public class EventManagementSvcImpl implements EventManagementSvc{

	private EventManagementDao eventManagementDao;
	
	private org.springframework.beans.factory.BeanFactory beanFactory;
	
	private Mapper mapper;
	
	
	
	public org.springframework.beans.factory.BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	public EventManagementDao getEventManagementDao() {
		return eventManagementDao;
	}

	public void setEventManagementDao(EventManagementDao eventManagementDao) {
		this.eventManagementDao = eventManagementDao;
	}

	@Override
	public EvtRegResponse registerEmployeeToEvent(EmployeeEvntRegDto empEvntReg) {
		return eventManagementDao.registerEmployeeToEvent(empEvntReg.getMid(), empEvntReg.getEventId());
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
	//	Mapper mapper = beanFactory.getBean(Mapper.class);
		List<Employee> employees =  eventManagementDao.getAllEmployees();
		List<EmployeeDto> empDtos = new ArrayList<EmployeeDto>();
		ListIterator<Employee> empIterator = employees.listIterator();
		while(empIterator.hasNext()){
			EmployeeDto empDto = mapper.map(empIterator.next(),EmployeeDto.class);
			empDtos.add(empDto);
		}
		return empDtos;
	}

}
