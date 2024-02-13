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
@Table(name = "ASIT_SKILLPORT")
public class ASIT_SKILLPORT {

	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="skprtid_generator")
	  @SequenceGenerator(name="skprtid_generator", sequenceName = "ASIT_SKILLPORT_seq", allocationSize=1)
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	  
	  @Column(name = "FUSION_ID")
	  private String fusionId;
	  
	  @Column(name = "SKILLPORT_ASSIGNED")
	  private double skillportAssigned;
	  
	  @Column(name = "SKILLPORT_MISSED")
	  private double skillportMissed;
	  
	  @Column(name = "COMPLETION_PERCENTAGE")
	  private double completionPercentage;

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

	public double getSkillportAssigned() {
		return skillportAssigned;
	}

	public void setSkillportAssigned(double skillportAssigned) {
		this.skillportAssigned = skillportAssigned;
	}

	public double getSkillportMissed() {
		return skillportMissed;
	}

	public void setSkillportMissed(double skillportMissed) {
		this.skillportMissed = skillportMissed;
	}

	public double getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(double completionPercentage) {
		this.completionPercentage = completionPercentage;
	}
	  
}
