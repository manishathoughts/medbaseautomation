package dto;

public class TableRow {
	
	private String employee;
	
	private String department;
	
	private String absenceDates;
	
	private String status;
	
	private String rtwqStatus;
	
	private String reason;
	
	private String notes;
	
	private String workLost;

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAbsenceDates() {
		return absenceDates;
	}

	public void setAbsenceDates(String absenceDates) {
		this.absenceDates = absenceDates;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRtwqStatus() {
		return rtwqStatus;
	}

	public void setRtwqStatus(String rtwqStatus) {
		this.rtwqStatus = rtwqStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getWorkLost() {
		return workLost;
	}

	public void setWorkLost(String workLost) {
		this.workLost = workLost;
	}

	@Override
	public String toString() {
		return "TableRow [employee=" + employee + ", department=" + department + ", absenceDates=" + absenceDates
				+ ", status=" + status + ", rtwqStatus=" + rtwqStatus + ", reason=" + reason + ", notes=" + notes
				+ ", workLost=" + workLost + "]";
	}
	
	

}
