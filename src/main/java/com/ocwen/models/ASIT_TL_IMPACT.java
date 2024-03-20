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
@Table(name = "ASIT_TL_IMPACT")
public class ASIT_TL_IMPACT {

	@Id
	@Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="tlimpactid_generator")
	  @SequenceGenerator(name="tlimpactid_generator", sequenceName = "ASIT_TL_IMPACT_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	  
	@Column(name = "FUSIONID")
	  private String fusionId;
	
	@Column(name = "UCID")
	  private String ucId;
	
	@Column(name = "NAME")
	  private String name;
	  
	@Column(name = "ASST_MNGR_NAME")
	  private String asstMngrName;
	
	@Column(name = "MNGR_NAME")
	  private String mngrName;
	
	@Column(name = "LOCATION")
	private String location;

	@Column(name = "DEPT")
		private String dept;
	
	@Column(name = "OPPORTUNITIES")
	private double opportunities;
	
	@Column(name = "DEFECT")
	private double defect;
	
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

	
	public String getAsstMngrName() {
		return asstMngrName;
	}

	public void setAsstMngrName(String asstMngrName) {
		this.asstMngrName = asstMngrName;
	}

	public String getMngrName() {
		return mngrName;
	}

	public void setMngrName(String mngrName) {
		this.mngrName = mngrName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(double opportunities) {
		this.opportunities = opportunities;
	}

	public double getDefect() {
		return defect;
	}

	public void setDefect(double defect) {
		this.defect = defect;
	}
	
}
