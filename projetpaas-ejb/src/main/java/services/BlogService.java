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

import entities.Blog;
import entities.Clients;
import interfaces.IBlogRemote;

@Stateful
@LocalBean
public class BlogService implements IBlogRemote {

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
	public List<Blog> GetAll() {
	
		List<Blog>  lasp = new ArrayList<Blog>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:33430/api/BlogWS/Gettach"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
       	 
    		Blog m = new Blog();
       	 
       	 m.setContenu(object.getJsonObject(i).get("contenu").toString()); 
       	 m.setTitreblog(object.getJsonObject(i).get("titreblog").toString()); 
       	 //m.setDateblog(object.getJsonObject(i).get("dateblog").toString());
       	 m.setImagePath(object.getJsonObject(i).get("imagePath").toString());
       	// m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
       	 m.setBlogId(Integer.parseInt(object.getJsonObject(i).get("blogId").toString()));

       	 lasp.add(m);
       	}
       	

   return lasp;    	
       }
	
	@Override
	public void Create(Blog p) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/Create");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
	
		String result=response.readEntity(String.class);
		System.out.println(result);
		
		response.close();
		
	}
	
	    @Override
		public void Update(Blog p , int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/WebApiClient/Update?id="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
	
	@Override
	public void Delete(Blog eve)
	{
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:4640/api/EventWebApi?id="+eve.getBlogId()); 
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().delete();
	}
	
	@Override
	public Blog findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
