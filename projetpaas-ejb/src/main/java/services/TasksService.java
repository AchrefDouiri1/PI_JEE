package services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Tasks;
import interfaces.ITasksRemote;

@Stateful
@LocalBean
public class TasksService implements ITasksRemote {

	
EntityManager em ;
	
	public String consommationGet() {
		// TODO Auto-generated method stub
		
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:3857/api/WebApiClient");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	}
	@Override
	public List<Tasks> GetAll() {
	
		List<Tasks>  lasp = new ArrayList<Tasks>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:33430/api/TasksWS/gettach"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
       	 
    		Tasks m = new Tasks();
       	 
       	 m.setNomtask(object.getJsonObject(i).get("nomtask").toString()); 
       	// m.setDifficulteId(Integer.parseInt(object.getJsonObject(i).get("difficulteId").toString()));
       	 m.setDuration(Integer.parseInt(object.getJsonObject(i).get("duration").toString()));
       	 m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("projectId").toString()));
       	 m.setTasksId(Integer.parseInt(object.getJsonObject(i).get("tasksId").toString()));
       	 m.setTeam_memberId(Integer.parseInt(object.getJsonObject(i).get("team_memberId").toString()));

       	 lasp.add(m);
       	}
       	

   return lasp;    	
       }
	
	@Override
	public void Create(Tasks p) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/ProjectWS/project");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
	
		String result=response.readEntity(String.class);
		System.out.println(result);
		
		response.close();
		
	}
	
	    @Override
		public void Update(Tasks p , int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/WebApiClient/Update?id="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
	
	@Override
	public void Delete(Tasks eve)
	{
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:4640/api/EventWebApi?id="+eve.getTasksId()); 
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().delete();
	}
	
	@Override
	public Tasks findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
