package com.mindtree.evtmanagement.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Provider
public class JacksonObjectMapper implements ContextResolver<ObjectMapper> {

	private static final ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
	
	@Override
	public ObjectMapper getContext(Class<?> arg0) {
		return objectMapper;
	}

	
	
}
