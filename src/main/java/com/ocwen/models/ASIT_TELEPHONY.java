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
@Table(name = "ASIT_TELEPHONY")
public class ASIT_TELEPHONY {
	
	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="telid_generator")
	  @SequenceGenerator(name="telid_generator", sequenceName = "ASIT_TELEPHONY_seq", allocationSize=1)
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	  
	  @Column(name = "FUSION_ID")
	  private String fusionId;
	  
	  @Column(name = "IB_AHT")
	  private double ibAht;
	  
	  @Column(name = "LOGIN_PERCENTAGE")
	  private double loginPercentage;
	  
	  @Column(name = "ADHERENCE_PERCENTAGE")
	  private double adhPercentage;
	  
	  @Column(name = "UNPLAN_PTO_PERCENTAGE")
	  private double upaPercentage;  

	  @Column(name = "PTO_PERCENTAGE")
	  private double ptoPercentage;
	  
	  @Column(name = "TOTAL_SHRINKAGE")
	  private double totalShrinkage;

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

	public double getIbAht() {
		return ibAht;
	}

	public void setIbAht(double ibAht) {
		this.ibAht = ibAht;
	}

	public double getLoginPercentage() {
		return loginPercentage;
	}

	public void setLoginPercentage(double loginPercentage) {
		this.loginPercentage = loginPercentage;
	}

	public double getAdhPercentage() {
		return adhPercentage;
	}

	public void setAdhPercentage(double adhPercentage) {
		this.adhPercentage = adhPercentage;
	}

	public double getUpaPercentage() {
		return upaPercentage;
	}

	public void setUpaPercentage(double upaPercentage) {
		this.upaPercentage = upaPercentage;
	}

	public double getPtoPercentage() {
		return ptoPercentage;
	}

	public void setPtoPercentage(double ptoPercentage) {
		this.ptoPercentage = ptoPercentage;
	}

	public double getTotalShrinkage() {
		return totalShrinkage;
	}

	public void setTotalShrinkage(double totalShrinkage) {
		this.totalShrinkage = totalShrinkage;
	}
	  
}
