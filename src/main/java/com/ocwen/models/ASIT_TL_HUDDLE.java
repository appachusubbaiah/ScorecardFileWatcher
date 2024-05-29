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
@Table(name = "ASIT_TL_HUDDLE")
public class ASIT_TL_HUDDLE {

	@Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="tlhudid_generator")
	  @SequenceGenerator(name="tlhudid_generator", sequenceName = "ASIT_TL_HUDDLE_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date month;
	
	@Column(name = "FUSIONID")
	  private String fusionId;
	
	@Column(name = "SUPERVISOR")
	  private String supervisor;
	
	@Column(name = "COMPLETED")
	  private String completed;
	
	@Column(name = "SCORE")
	  private double score;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFusionId() {
		return fusionId;
	}

	public void setFusionId(String fusionId) {
		this.fusionId = fusionId;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}
	
	
	
}
