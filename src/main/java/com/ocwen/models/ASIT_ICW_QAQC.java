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
@Table(name = "ASIT_ICW_QAQC")
public class ASIT_ICW_QAQC {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="qaqcid_generator")
	  @SequenceGenerator(name="qaqcid_generator", sequenceName = "ASIT_ICW_QAQC_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date Month;
	
	@Column(name = "FUSION_ID")
	private String fusionId;
	
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

	public String getFusionId() {
		return fusionId;
	}

	public void setFusionId(String fusionId) {
		this.fusionId = fusionId;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getMtdScores() {
		return mtdScores;
	}

	public void setMtdScores(double mtdScores) {
		this.mtdScores = mtdScores;
	}

	@Column(name = "AGENT")
	private String agent;

	@Column(name = "TEAM_LEADER")
	private String teamLeader;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "MTD_SCORES")
	private double mtdScores;
}
