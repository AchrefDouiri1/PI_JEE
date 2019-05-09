package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Tasks;

@Remote
public interface ITasksRemote {
	
	List<Tasks> GetAll();
	public void Delete(Tasks tasksId);
	public void Create(Tasks p);
	public void Update(Tasks p,int id);
	public Tasks findById(int id);

}
