package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tasks")
public class Tasks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tasksId ;
	private int duration ;
	private int projectId ;
	private int DifficulteId ;
	private int team_memberId ;
	private  String nomtask ;
	public int getTasksId() {
		return tasksId;
	}
	public void setTasksId(int tasksId) {
		this.tasksId = tasksId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getDifficulteId() {
		return DifficulteId;
	}
	public void setDifficulteId(int difficulteId) {
		DifficulteId = difficulteId;
	}
	public int getTeam_memberId() {
		return team_memberId;
	}
	public void setTeam_memberId(int team_memberId) {
		this.team_memberId = team_memberId;
	}
	public String getNomtask() {
		return nomtask;
	}
	public void setNomtask(String nomtask) {
		this.nomtask = nomtask;
	}
	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tasks(int duration, int projectId, int difficulteId, int team_memberId, String nomtask) {
		super();
		this.duration = duration;
		this.projectId = projectId;
		DifficulteId = difficulteId;
		this.team_memberId = team_memberId;
		this.nomtask = nomtask;
	}
	public Tasks(int duration, int projectId, int team_memberId, String nomtask) {
		super();
		this.duration = duration;
		this.projectId = projectId;
		this.team_memberId = team_memberId;
		this.nomtask = nomtask;
	}
	public Tasks(int tasksId, int duration, int projectId, int difficulteId, int team_memberId, String nomtask) {
		super();
		this.tasksId = tasksId;
		this.duration = duration;
		this.projectId = projectId;
		DifficulteId = difficulteId;
		this.team_memberId = team_memberId;
		this.nomtask = nomtask;
	}
	
	

}
