package com.mindtree.evtmanagement.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mindtree.evtmanagement.resource.EventManagementResource;

@Component
@ApplicationPath("/event-management")
public class EventRegistrationResourceConfig extends ResourceConfig{

	public EventRegistrationResourceConfig() {
		register(EventManagementResource.class);
	}
	
}
