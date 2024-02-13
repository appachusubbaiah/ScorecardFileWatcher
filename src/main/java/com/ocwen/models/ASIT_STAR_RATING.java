package com.ocwen.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ASIT_STAR_RATING")
public class ASIT_STAR_RATING {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="starid_generator")
	  @SequenceGenerator(name="starid_generator", sequenceName = "ASIT_STAR_RATING_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date Month;
	
	@Column(name = "REQUEST_ID")
	private String requestId;
	
	@Column(name = "REQUEST_SENT_AT")
	private String requestSentAt;
	
	@Column(name = "RESPONSE_RECEIVED_AT")
	private String responseReceivedAt;
	
	@Column(name = "STAR_RATING")
	private double starRating;
	
	@Column(name = "EMPLOYEE_CUSTOM_ID")
	private String employeeCustomId;
	
	@Column(name = "TEAM_LEADER")
	private String teamLeader;
	
	@Column(name = "TEAM_LEADER_EMPLOYEE_CUSTOM_ID")
	private String teamLeaderEmpCustomId;
	
	@Column(name = "CUSTOM_PROPERTY_LOCATION")
	private String cutomPropertyLocation;
	
	@Column(name = "CUSTOM_PROPERTY_DEPARTMENT")
	private String cutomPropertyDept;
	
	@Column(name = "CUSTOM_PROPERTY_LOAN_NUMBER")
	private double cutomPropertyLoanNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getMonth() {
		return Month;
	}

	public void setMonth(Date month) {
		Month = month;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestSentAt() {
		return requestSentAt;
	}

	public void setRequestSentAt(String requestSentAt) {
		this.requestSentAt = requestSentAt;
	}

	public String getResponseReceivedAt() {
		return responseReceivedAt;
	}

	public void setResponseReceivedAt(String responseReceivedAt) {
		this.responseReceivedAt = responseReceivedAt;
	}

	public double getStarRating() {
		return starRating;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}

	public String getEmployeeCustomId() {
		return employeeCustomId;
	}

	public void setEmployeeCustomId(String employeeCustomId) {
		this.employeeCustomId = employeeCustomId;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getTeamLeaderEmpCustomId() {
		return teamLeaderEmpCustomId;
	}

	public void setTeamLeaderEmpCustomId(String teamLeaderEmpCustomId) {
		this.teamLeaderEmpCustomId = teamLeaderEmpCustomId;
	}

	public String getCutomPropertyLocation() {
		return cutomPropertyLocation;
	}

	public void setCutomPropertyLocation(String cutomPropertyLocation) {
		this.cutomPropertyLocation = cutomPropertyLocation;
	}

	public String getCutomPropertyDept() {
		return cutomPropertyDept;
	}

	public void setCutomPropertyDept(String cutomPropertyDept) {
		this.cutomPropertyDept = cutomPropertyDept;
	}

	public double getCutomPropertyLoanNo() {
		return cutomPropertyLoanNo;
	}

	public void setCutomPropertyLoanNo(double d) {
		this.cutomPropertyLoanNo = d;
	}
	
}
