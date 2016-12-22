package com.mindtree.evtmanagement.dao.impl;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mindtree.evtmanagement.dao.EventManagementDao;
import com.mindtree.evtmanagement.dao.entity.Employee;
import com.mindtree.evtmanagement.dao.entity.Event;
import com.mindtree.evtmanagement.dao.vo.EvtRegResponse;
import com.mindtree.evtmanagement.utils.Utils;

public class EventMangementDaoImpl implements EventManagementDao{
	
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public EvtRegResponse registerEmployeeToEvent(String mid, long id) {
		
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String responseMessage = null;
		
		Employee employee = session.load(Employee.class, mid);
		Event event = session.get(Event.class, id);
		if(null == event ){
			responseMessage = Utils.concat("The event id [",id+"] is not found in the system. Please provide a valid event id");
			EvtRegResponse evtRegResponse = new EvtRegResponse();
			evtRegResponse.setMessage(responseMessage);
			return evtRegResponse;
		}
		if(!isEventAlreadyRegistered(employee,id)){
			employee.getEvents().add(event);
			responseMessage = "Employee is successfully associated with the event";
		}else{
			responseMessage = Utils.concat("Employee [",employee.getName(),"] is already registered to event [",event.getEventTitle(),"]");
		}
		
		transaction.commit();
		session.close();
		
		EvtRegResponse evtRegResponse = new EvtRegResponse();
		evtRegResponse.setMessage(responseMessage);
		
		return evtRegResponse;
	}

	/**
	 * Check whether event is already registered for the employee
	 * @param employee
	 * @param id
	 * @return
	 */
	private boolean isEventAlreadyRegistered(Employee employee, long id) {
		ListIterator<Event> events = employee.getEvents().listIterator();
		while (events.hasNext()) {
			Event event = (Event) events.next();
			if(event.getId() == id){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Employee> allEmployees = criteria.list();
		session.close();
		return allEmployees;
	}

}
