package com.${groupName}.${artifactId}.application;

import java.util.*;

import javax.ws.rs.core.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.${groupName}.${artifactId}.service.*;

public class MainApplication extends Application {
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	HashSet<Object> singletons = new HashSet<Object>();

	public MainApplication() {
		try {
			ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");

			singletons.add(springContext.getBean("statusService", StatusService.class));

			//classes.add(ExceptionMapper.class);
			//classes.add(PreProcessInterceptor.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

	protected ApplicationContext springContext;

	public Set<Object> getSingletons() {
		return singletons;
	}
}