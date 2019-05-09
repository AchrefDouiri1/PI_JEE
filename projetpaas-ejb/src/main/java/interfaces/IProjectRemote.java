package interfaces;

import java.util.List;

import entities.Project;

public interface IProjectRemote {
	
	List<Project> GetAll();
	public void Delete(Project blogId);
	public void Create(Project p);
	public void Update(Project p,int id);
	public Project findById(int id);

}
