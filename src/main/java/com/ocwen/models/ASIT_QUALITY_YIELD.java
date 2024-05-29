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
@Table(name = "ASIT_QUALITY_YIELD")
public class ASIT_QUALITY_YIELD {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="qltyyldid_generator")
	  @SequenceGenerator(name="qltyyldid_generator", sequenceName = "ASIT_QUALITY_YIELD_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	
	@Column(name = "FUSIONID")
	  private String fusionId;
	
	@Column(name = "EMPLOYEE_NAME")
	  private String employeeName;
	
	@Column(name = "NETWORKID")
	  private String ntId;
	
	@Column(name = "LOCATION")
	  private String location;
	
	@Column(name = "DESIGNATION")
	  private String designation;
	
	@Column(name = "SUPERVISOR_NAME")
	  private String supervisorName;
	
	@Column(name = "ASSISTANT_MANAGER")
	  private String asstManager;
	
	@Column(name = "MANAGER")
	  private String manager;
	
	@Column(name = "DIRECTOR")
	  private String director;
	
	@Column(name = "BUSINESS_UNIT")
	  private String businessUnit;
	
	@Column(name = "BUSINESS_PROCESS")
	  private String businessProcess;
	
	@Column(name = "QA_YIELD")
	  private double qaYield;
	
	@Column(name = "QA_AVERAGE")
	  private double qaAverage;
	
	@Column(name = "COUNT_OF_0_SCORE")
	  private double countZero;
	
	@Column(name = "COUNT_OF_LOW_SCORE")
	  private double countLowScore;
	
	@Column(name = "TOTAL_COUNT")
	  private double totalCount;

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

	public String getNtId() {
		return ntId;
	}

	public void setNtId(String ntId) {
		this.ntId = ntId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getAsstManager() {
		return asstManager;
	}

	public void setAsstManager(String asstManager) {
		this.asstManager = asstManager;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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

	public double getQaYield() {
		return qaYield;
	}

	public void setQaYield(double qaYield) {
		this.qaYield = qaYield;
	}

	public double getQaAverage() {
		return qaAverage;
	}

	public void setQaAverage(double qaAverage) {
		this.qaAverage = qaAverage;
	}

	public double getCountZero() {
		return countZero;
	}

	public void setCountZero(double countZero) {
		this.countZero = countZero;
	}

	public double getCountLowScore() {
		return countLowScore;
	}

	public void setCountLowScore(double countLowScore) {
		this.countLowScore = countLowScore;
	}

	public double getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
	
}
