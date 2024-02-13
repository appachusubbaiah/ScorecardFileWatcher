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
@Table(name = "ASIT_QUALITY")
public class ASIT_QUALITY {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="qltyid_generator")
	  @SequenceGenerator(name="qltyid_generator", sequenceName = "ASIT_QUALITY_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "ROSTER_MONTH")
	  private Date rosterMonth;
	
	@Column(name = "TEST_TYPE")
	  private String testType;
	
	@Column(name = "FUSION_ID")
	  private String fusionId;
	
	@Column(name = "EMPLOYEE_NAME")
	  private String employeeName;
	
	@Column(name = "CITRIX__OR_NETWORK_ID")
	  private String citrixNtId;
	
	@Column(name = "DESIGNATION")
	  private String designation;
	
	@Column(name = "SUPERVISOR_NAME")
	  private String supervisorName;
	
	@Column(name = "LOCATION")
	  private String location;
	
	@Column(name = "BUSINESS_UNIT")
	  private String businessUnit;
	
	@Column(name = "BUSINESS_PROCESS")
	  private String businessProcess;
	
	@Column(name = "SCORE")
	  private double score;
	
	@Column(name = "LOAN_NUMBER")
	  private String loanNumber;
	
	@Column(name = "INTERACTION_ID")
	  private String interactionId;
	
	@Column(name = "REVIEW_TYPE")
	  private String reviewType;
	
	@Column(name = "COUNT")
	  private double count;
	
	@Column(name = "THRESHOLD")
	  private String threshold;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getRosterMonth() {
		return rosterMonth;
	}

	public void setRosterMonth(Date rosterMonth) {
		this.rosterMonth = rosterMonth;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getFusionId() {
		return fusionId;
	}

	public void setFusionId(String fusionId) {
		this.fusionId = fusionId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCitrixNtId() {
		return citrixNtId;
	}

	public void setCitrixNtId(String citrixNtId) {
		this.citrixNtId = citrixNtId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getBusinessProcess() {
		return businessProcess;
	}

	public void setBusinessProcess(String businessProcess) {
		this.businessProcess = businessProcess;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(String interactionId) {
		this.interactionId = interactionId;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	
	
}
