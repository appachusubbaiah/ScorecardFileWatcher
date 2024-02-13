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
@Table(name = "ASIT_RMIC")
public class ASIT_RMIC {

	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="rmicid_generator")
	  @SequenceGenerator(name="rmicid_generator", sequenceName = "ASIT_RMIC_seq", allocationSize=1)
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	  
	  @Column(name = "EMP_ID")
	  private String empId;
	  
	  @Column(name = "UCID")
	  private String ucId;
	  
	  @Column(name = "NAME")
	  private String name;
	  
	  @Column(name = "SUPV")
	  private String supv;
	  
	  @Column(name = "SITE")
	  private String site;
	  	  
	  @Column(name = "RMIC_COMPLETION_STATUS")
	  private double rmicCompletionStatus;

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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getUcId() {
		return ucId;
	}

	public void setUcId(String ucId) {
		this.ucId = ucId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupv() {
		return supv;
	}

	public void setSupv(String supv) {
		this.supv = supv;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public double getRmicCompletionStatus() {
		return rmicCompletionStatus;
	}

	public void setRmicCompletionStatus(double rmicCompletionStatus) {
		this.rmicCompletionStatus = rmicCompletionStatus;
	}
	
}
