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
@Table(name = "ASIT_CMS_DEFECT")
public class ASIT_CMS_DEFECT {

	  @Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="id_generator")
	  @SequenceGenerator(name="id_generator", sequenceName = "ASIT_CMS_DEFECT_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date Month;
		
	@Column(name = "UCID")
	private String UCID;
	
	@Column(name = "OPPORTUNITIES")
	private String Opportunities;
	
	@Column(name = "TOTAL_DEFECTS")
	private String totalDefects;
	
	@Column(name = "CMS_DEFECT_PERCENTAGE")
	private double CMSDefectPercentage;
	
	
	public ASIT_CMS_DEFECT()
	{}
	
	public Date getMonth() {
		return Month;
	}

	public void setMonth(Date month) {
		Month = month;
	}

	public String getUCID() {
		return UCID;
	}

	public void setUCID(String uCID) {
		UCID = uCID;
	}

	public String getOpportunities() {
		return Opportunities;
	}

	public void setOpportunities(String opportunities) {
		Opportunities = opportunities;
	}

	public String getTotalDefects() {
		return totalDefects;
	}

	public void setTotalDefects(String totalDefects) {
		this.totalDefects = totalDefects;
	}

	public double getCMSDefectPercentage() {
		return CMSDefectPercentage;
	}

	public void setCMSDefectPercentage(double cMSDefectPercentage) {
		CMSDefectPercentage = cMSDefectPercentage;
	}
}
