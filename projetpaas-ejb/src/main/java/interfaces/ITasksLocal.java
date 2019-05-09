package interfaces;

import java.util.List;
import javax.ejb.Local;
import entities.Tasks;

@Local
public interface ITasksLocal {

	List<Tasks> GetAll();
	public void Delete(int tasksId);
	public void Create(Tasks p);
	public void Update(Tasks p,int id);
	public Tasks findById(int id);

}
