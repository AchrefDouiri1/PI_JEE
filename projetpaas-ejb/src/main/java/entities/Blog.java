package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Blog")
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int blogId ;
	private String titreblog ;
	private String contenu ;
	private String imagePath ;
	private Date dateblog ;
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getTitreblog() {
		return titreblog;
	}
	public void setTitreblog(String titreblog) {
		this.titreblog = titreblog;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Date getDateblog() {
		return dateblog;
	}
	public void setDateblog(Date dateblog) {
		this.dateblog = dateblog;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(int blogId, String titreblog, String contenu, String imagePath) {
		super();
		this.blogId = blogId;
		this.titreblog = titreblog;
		this.contenu = contenu;
		this.imagePath = imagePath;
	}
	public Blog(String titreblog, String contenu, String imagePath) {
		super();
		this.titreblog = titreblog;
		this.contenu = contenu;
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", titreblog=" + titreblog + ", contenu=" + contenu + ", imagePath="
				+ imagePath + ", dateblog=" + dateblog + "]";
	}
	
}
