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
@Table(name = "ASIT_REV_CMS_DEFECT")
public class ASIT_REV_CMS_DEFECT {

	@Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revcmsdefid_generator")
	  @SequenceGenerator(name="revcmsdefid_generator", sequenceName = "ASIT_REV_CMS_DEFECT_SEQ", allocationSize=1)
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	
	  @Column(name = "FUSIONID")
	  private String fusionId;
	
	  @Column(name = "NAME")
	  private String name;
	
	  @Column(name = "TEAM_LEADER")
	  private String teamLeader;
	
	  @Column(name = "DEPT")
	  private String dept;
	  
	  @Column(name = "TOTAL_NO_OF_MONITORS")
	  private double totalMonitors;
	  
	  @Column(name = "DEFECTS")
	  private double defects;
	  
	  @Column(name = "ACHIEVED")
	  private double achieved;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getTotalMonitors() {
		return totalMonitors;
	}

	public void setTotalMonitors(double totalMonitors) {
		this.totalMonitors = totalMonitors;
	}

	public double getDefects() {
		return defects;
	}

	public void setDefects(double defects) {
		this.defects = defects;
	}

	public double getAchieved() {
		return achieved;
	}

	public void setAchieved(double achieved) {
		this.achieved = achieved;
	}
}
