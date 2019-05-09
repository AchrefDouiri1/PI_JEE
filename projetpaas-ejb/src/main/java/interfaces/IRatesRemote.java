package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Rates;



@Remote
public interface IRatesRemote {

	List<Rates> GetAll();
	public void Delete(Rates rateId);
	public void Create(Rates p);
	public void Update(Rates p,int id);
	public Rates findById(int id);
}	
