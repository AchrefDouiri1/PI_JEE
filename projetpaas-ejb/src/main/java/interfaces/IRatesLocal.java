package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Rates;

@Local
public interface IRatesLocal {
	List<Rates> GetAll();
	public void Delete(int rateId);
	public void Create(Rates p);
	public void Update(Rates p,int id);
	public Rates findById(int id);
	
}
