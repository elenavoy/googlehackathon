package com.example.demo;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.SortDirection;

import java.util.ArrayList;


public class Data{

	public static Project storeProject(Project project){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(project.getEntity());
		return project;
	}
	
	public static ArrayList<Project> getAllProjects(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Project").addSort("creationTime", SortDirection.DESCENDING);
		PreparedQuery pq = datastore.prepare(q);
		ArrayList<Project> projects = new ArrayList<>();
		for(Entity result : pq.asIterable()){
			Project receivedProject = new Project(result);
			projects.add(receivedProject);
		}
		return projects;
	}

}
