package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rates")
public class Rates {
	
	@Id
	@GeneratedValue()
	private int rateId;
	private int rateVal;
	private int managerId;
	private int memberId;
	private int taskId;
	
	public Rates() {
		super();
	}

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public int getRateVal() {
		return rateVal;
	}

	public void setRateVal(int rateVal) {
		this.rateVal = rateVal;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
}
