package com.example.demo;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import java.util.ArrayList;
import java.util.Date;

public class Project{
	private final String name;
	private final Date creationTime;
	private String description;
	private String creatorName;
	private String email;
	private String website;
	private String youtubeLink;
	private ArrayList<Position> positions;

	public Project(Entity baseEntity){
		this((String) baseEntity.getProperty("projectName"), (Date) baseEntity.getProperty("creationTime"), 
			(String)baseEntity.getProperty("creatorName"), (String)baseEntity.getProperty("website"), 
			(String)baseEntity.getProperty("youtubeLink"), (String)baseEntity.getProperty("email"), 
			(String)baseEntity.getProperty("description"), (ArrayList<Position>)baseEntity.getProperty("positions"));
	}

	public Project(String name, String creatorName, String email, String description, ArrayList<Position> positions){
		this(name, new Date(), creatorName, email, description, positions);
	}

	public Project(String name, Date creationTime, String creatorName, String email, String description, ArrayList<Position> positions){
		this(name, creationTime, creatorName, "---", "---", email, description, positions);
	}

	private Project(String name, Date creationTime, String creatorName, String website, String youtubeLink, String email, String description, ArrayList<Position> positions){
		this.name = name;
		this.creationTime = creationTime;
		this.creatorName = creatorName;
		this.email = email;
		this.youtubeLink = youtubeLink;
		this.website = website;
		this.description = description;
		this.positions = positions;
	}


	public void setWebsite(String website){
		this.website = website;
	}

	public void setYoutubeLink(String youtube){
		youtubeLink = youtube;
	}

	public String getName(){
		return name;
	}

	public Date getCreationTime(){
		return creationTime;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatorName(){
		return creatorName;
	}

	public String getWebsite(){
		return website;
	}

	public String getYoutubeLink(){
		return youtubeLink;
	}

	public ArrayList<Position> getPositions(){
		return positions;
	}

	public ArrayList<Position> getAvailablePositions(){
		ArrayList<Position> available = new ArrayList<>();
		for(Position position : positions){
			if(position.isAvailable()){
				available.add(position);
			}
		}
		return available;
	}

	public Entity getEntity(){
		Entity entity = new Entity("Project");
		entity.setProperty("projectName", name);
		entity.setProperty("creationTime", creationTime);
		entity.setProperty("creatorName", creatorName);
		entity.setProperty("description", description);
		entity.setProperty("positions", positions);
		entity.setProperty("youtubeLink", youtubeLink);
		entity.setProperty("website", website);
		return entity;
	}
}