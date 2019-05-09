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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import entities.Clients;
import entities.Rates;
import interfaces.IRatesLocal;
import interfaces.IRatesRemote;

@Stateful
@LocalBean
public class RateService implements IRatesLocal,IRatesRemote {
	
	EntityManager em ;
	
	public String ConsommationGet(){
		
		// New Jax REST Client
		Client client=ClientBuilder.newClient();
		// URL service
		WebTarget target = client.target("http://localhost:33430/api/RateWS/GetRates2");
	
		
		// Get Reponse 
		Response response = target.request().get();
		
		String result = response.readEntity(String.class);
		System.out.println(result);
		response.close();
		return result;		
		
	}


	@Override
	public List<Rates> GetAll() {
		List<Rates>  lasp = new ArrayList<Rates>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:3857/api/WebApiClient"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
       	 
    		Rates m = new Rates();
    		
    		m.setRateId(Integer.parseInt(object.getJsonObject(i).get("rateId").toString()));
       	 	m.setRateVal(Integer.parseInt(object.getJsonObject(i).get("rateVal").toString())); 
       	 	m.setManagerId(Integer.parseInt(object.getJsonObject(i).get("managerId").toString()));
       	 	m.setMemberId(Integer.parseInt(object.getJsonObject(i).get("memeberId").toString()));
       	 	m.setTaskId(Integer.parseInt(object.getJsonObject(i).get("taskId").toString()));

       	 	lasp.add(m);
       	}

    	return lasp;
	
	}

	@Override
	public void Delete(int rateId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Rates rateId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Create(Rates p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Rates p, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rates findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
