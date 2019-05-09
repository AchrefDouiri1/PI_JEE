package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Blog;

@Remote
public interface IBlogRemote {
	
	List<Blog> GetAll();
	public void Delete(Blog blogId);
	public void Create(Blog p);
	public void Update(Blog p,int id);
	public Blog findById(int id);

}
