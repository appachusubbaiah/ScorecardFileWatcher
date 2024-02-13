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
@Table(name = "ASIT_PKT")
public class ASIT_PKT {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="pktid_generator")
	  @SequenceGenerator(name="pktid_generator", sequenceName = "ASIT_PKT_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	  
	@Column(name = "EMPLOYEE_ID")
	  private String employeeId;
	
	@Column(name = "NAME")
	  private String name;
	
	@Column(name = "DEPARTMENT")
	  private String department;
	
	@Column(name = "SCORE_PERCENTAGE")
	  private double scorePercentage;
	  
	@Column(name = "SCORE")
	  private double score;
	
	@Column(name = "RESULT")
	  private String result;
	
	@Column(name = "TEAM_LEAD")
	  private String teamLead;
	
	@Column(name = "LOCATION")
	  private String location;
	
	@Column(name = "DOJ")
	  private Date doj;

	@Column(name = "TENURE")
	  private double tenure;
	
	@Column(name = "TENURE_YEARS")
	  private String tenureYears;
	
	@Column(name = "AGENT_LEVEL")
	  private String agentLevel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getScorePercentage() {
		return scorePercentage;
	}

	public void setScorePercentage(double scorePercentage) {
		this.scorePercentage = scorePercentage;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public String getTenureYears() {
		return tenureYears;
	}

	public void setTenureYears(String tenureYears) {
		this.tenureYears = tenureYears;
	}

	public String getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(String agentLevel) {
		this.agentLevel = agentLevel;
	}
	
	
}
