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
@Table(name = "ASIT_REV_HRD")
public class ASIT_REV_HRD {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revhrdid_generator")
	  @SequenceGenerator(name="revhrdid_generator", sequenceName = "ASIT_REV_HRD_seq", allocationSize=1)
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	  
	  @Column(name = "FSUION_ID")
	  private String fusionId;
		
	  @Column(name = "NETWORK_ID")
	  private String networkId;
		
	  @Column(name = "NAME")
	  private String name;
	  
	  @Column(name = "RESOLUTIONS_CREDIT")
	  private double resCredits;
		
	  @Column(name = "QUALITY_AVERAGE")
	  private double qaAverage;
	  
	  @Column(name = "STELLA_STAR_RATING")
	  private double stellaStarRating;
	  
	  public double getStellaStarRating() {
		return stellaStarRating;
	}

	public void setStellaStarRating(double stellaStarRating) {
		this.stellaStarRating = stellaStarRating;
	}

	@Column(name = "SCHEDULE_ADHERENCE")
	  private double scheduleAdherence;
	  
	  @Column(name = "INBOUND_AHT")
	  private double inboundAht;
	  
	  @Column(name = "PROPER_ICW_REGISTRATION_OF_COMPLIANTS")
	  private double propIcwRegOfCmplts;
	  
	  @Column(name = "SKILLPORT_COMPLIANCE_COMPLETION")
	  private double skillportComplianceCmpltion;
	  
	  @Column(name = "UTILIZATON_OF_CMS_TOOL")
	  private double utlztnOfCms;

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

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getResCredits() {
		return resCredits;
	}

	public void setResCredits(double resCredits) {
		this.resCredits = resCredits;
	}

	public double getQaAverage() {
		return qaAverage;
	}

	public void setQaAverage(double qaAverage) {
		this.qaAverage = qaAverage;
	}

	public double getScheduleAdherence() {
		return scheduleAdherence;
	}

	public void setScheduleAdherence(double scheduleAdherence) {
		this.scheduleAdherence = scheduleAdherence;
	}

	public double getInboundAht() {
		return inboundAht;
	}

	public void setInboundAht(double inboundAht) {
		this.inboundAht = inboundAht;
	}

	public double getPropIcwRegOfCmplts() {
		return propIcwRegOfCmplts;
	}

	public void setPropIcwRegOfCmplts(double propIcwRegOfCmplts) {
		this.propIcwRegOfCmplts = propIcwRegOfCmplts;
	}

	public double getSkillportComplianceCmpltion() {
		return skillportComplianceCmpltion;
	}

	public void setSkillportComplianceCmpltion(double skillportComplianceCmpltion) {
		this.skillportComplianceCmpltion = skillportComplianceCmpltion;
	}

	public double getUtlztnOfCms() {
		return utlztnOfCms;
	}

	public void setUtlztnOfCms(double utlztnOfCms) {
		this.utlztnOfCms = utlztnOfCms;
	}
	  
	  
	  
	
}
