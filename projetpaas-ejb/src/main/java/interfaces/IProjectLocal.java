package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Project;

@Local
public interface IProjectLocal {
	
	List<Project> GetAll();
	public void Delete(int projectId);
	public void Create(Project p);
	public void Update(Project p,int id);
	public Project findById(int id);

}
