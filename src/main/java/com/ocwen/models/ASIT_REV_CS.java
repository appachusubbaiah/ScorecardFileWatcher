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
@Table(name = "ASIT_REV_CS")
public class ASIT_REV_CS {
	
	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revcsid_generator")
	  @SequenceGenerator(name="revcsid_generator", sequenceName = "ASIT_REV_CS_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date month;
	
	@Column(name = "FSUION_ID")
	private String fusionId;
	
	@Column(name = "NETWORK_ID")
	private String networkId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "OCR_PERCENTAGE")
	private double ocrPrtcentage;
	
	@Column(name = "QUALITY_AVERAGE")
	private double qualityAverage;

	@Column(name = "STELLA_STAR_RATING")
	private double stellaStarRating;
	
	@Column(name = "SCHEDULE_ADHERENCE")
	private double scheduleAdherence;
	
	@Column(name = "INBOUND_AHT")
	private double inboundAht;
	
	@Column(name = "PROPER_ICW_REGISTRATION_OF_COMPLIANTS")
	private double properIcwRegOfCmplnts;
	
	@Column(name = "SKILLPORT_COMPLIANCE_COMPLETION")
	private double skillPortComplianceCompletion;
	
	@Column(name = "UTILIZATON_OF_CMS_TOOL")
	private double utilizationOfCms;

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

	public double getOcrPrtcentage() {
		return ocrPrtcentage;
	}

	public void setOcrPrtcentage(double ocrPrtcentage) {
		this.ocrPrtcentage = ocrPrtcentage;
	}

	public double getQualityAverage() {
		return qualityAverage;
	}

	public void setQualityAverage(double qualityAverage) {
		this.qualityAverage = qualityAverage;
	}

	public double getStellaStarRating() {
		return stellaStarRating;
	}

	public void setStellaStarRating(double stellaStarRating) {
		this.stellaStarRating = stellaStarRating;
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

	public double getProperIcwRegOfCmplnts() {
		return properIcwRegOfCmplnts;
	}

	public void setProperIcwRegOfCmplnts(double properIcwRegOfCmplnts) {
		this.properIcwRegOfCmplnts = properIcwRegOfCmplnts;
	}

	public double getSkillPortComplianceCompletion() {
		return skillPortComplianceCompletion;
	}

	public void setSkillPortComplianceCompletion(double skillPortComplianceCompletion) {
		this.skillPortComplianceCompletion = skillPortComplianceCompletion;
	}

	public double getUtilizationOfCms() {
		return utilizationOfCms;
	}

	public void setUtilizationOfCms(double utilizationOfCms) {
		this.utilizationOfCms = utilizationOfCms;
	}
	
}
