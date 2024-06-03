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
@Table(name = "ASIT_REV_TELEPHONY")
public class ASIT_REV_TELEPHONY {
	
	@Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revtel_generator")
	  @SequenceGenerator(name="revtel_generator", sequenceName = "ASIT_REV_TELEPHONY_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	
	@Column(name = "FUSION_ID")
	  private String fusionId;
	
	@Column(name = "ADHERENCE_PERCENTAGE")
	  private double adhPercentage;
	
	@Column(name = "IB_AHT")
	  private double ibAht;

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

	public double getAdhPercentage() {
		return adhPercentage;
	}

	public void setAdhPercentage(double adhPercentage) {
		this.adhPercentage = adhPercentage;
	}

	public double getIbAht() {
		return ibAht;
	}

	public void setIbAht(double ibAht) {
		this.ibAht = ibAht;
	}
	
	
}
