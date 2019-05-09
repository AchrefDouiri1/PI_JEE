package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Blog;

@Local
public interface IBlogLocal {
	
	List<Blog> GetAll();
	public void Delete(int blogId);
	public void Create(Blog p);
	public void Update(Blog p,int id);
	public Blog findById(int id);

}
