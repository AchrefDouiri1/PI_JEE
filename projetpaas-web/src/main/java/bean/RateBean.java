package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;

import services.ClientService;
import services.RateService;

@SessionScoped
@ManagedBean(name="ratebean")
public class RateBean {

	private int rateId;
	private int rateVal;
	private int managerId;
	private int memberId;
	private int taskId;
	private List<entities.Rates> Rates;
	
	@EJB
	private RateService E;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<Object> getAll(){
		String lr= E.ConsommationGet();
		JSONArray array= new JSONArray(lr);
		ArrayList<Object> listdata=new ArrayList<Object>();
		
		if(array!= null){
			for(int i=0; i<array.length(); i++){
				
				
				listdata.add(array.get(i));

				
			}
		}
		return listdata;
	}
	
	public List<entities.Rates> getRatess() {
		Rates=E.GetAll();
		return Rates;
	}


}
