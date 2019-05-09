package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId ;
	private String projectname ;
	private String description ;
	private String plan ;
	private String goals ;
	private int Somme ;
	private String dch ;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public int getSomme() {
		return Somme;
	}
	public void setSomme(int somme) {
		Somme = somme;
	}
	public String getDch() {
		return dch;
	}
	public void setDch(String dch) {
		this.dch = dch;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String projectname, String description, String plan, String goals, String dch) {
		super();
		this.projectname = projectname;
		this.description = description;
		this.plan = plan;
		this.goals = goals;
		this.dch = dch;
	}
	public Project(int projectId, String projectname, String description, String plan, String goals,
			String dch) {
		super();
		this.projectId = projectId;
		this.projectname = projectname;
		this.description = description;
		this.plan = plan;
		this.goals = goals;
		this.dch = dch;
	}
	
	
}
