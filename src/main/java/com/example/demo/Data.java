import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


public class Data{

	public void createProject(String name){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity project = new Entity("Project");
		project.setProperty("projectName", name);
		datastore.put(project);
	}
	
	public ArrayList<Project> getAllProjects(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	}

}
