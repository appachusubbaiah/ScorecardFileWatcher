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
@Table(name = "ASIT_REV_ICP")
public class ASIT_REV_ICP {
	
	@Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revicp_generator")
	  @SequenceGenerator(name="revicp_generator", sequenceName = "ASIT_REV_ICP_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	
	@Column(name = "FUSIONID")
	  private String fusionId;
	
	@Column(name = "LIVEVOXID")
	  private String livevoxId;
	
	@Column(name = "UCID")
	  private String ucId;
	
	@Column(name = "NAME")
	  private String name;
	
	@Column(name = "SITE")
	  private String site;
	
	@Column(name = "DESIGNATION")
	  private String designation;
	
	@Column(name = "TEAM_LEADER")
	  private String teamLeader;
	
	@Column(name = "STATUS")
	  private String status;
	
	@Column(name = "DEPT")
	  private String dept;
	
	 @Column(name = "TOTAL_WORKED_DAYS")
	  private double totalWorkedDays;
	
	 @Column(name = "PTO_N_VTO_DAYS")
	  private double ptoVtoDays;
	 
	 @Column(name = "FINAL_WORKED_DAYS")
	  private double finalWorkedDays;
	 
	 @Column(name = "QA")
	  private double qa;
	 
	 @Column(name = "NPSVALUE")
	  private double npsValue;
	 
	 @Column(name = "FINAL_CREDITS")
	  private double finalCredits;
	 
	 @Column(name = "COUNSELING_IMPACT")
	  private String counselingImpact;

	 @Column(name = "FINAL_OCR")
	  private double finalOcr;
	 
	 @Column(name = "OCR_PER")
	  private double ocrPer;
	 
	 @Column(name = "ICW")
	  private double icw;

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

	public String getLivevoxId() {
		return livevoxId;
	}

	public void setLivevoxId(String livevoxId) {
		this.livevoxId = livevoxId;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getTotalWorkedDays() {
		return totalWorkedDays;
	}

	public void setTotalWorkedDays(double totalWorkedDays) {
		this.totalWorkedDays = totalWorkedDays;
	}

	public double getPtoVtoDays() {
		return ptoVtoDays;
	}

	public void setPtoVtoDays(double ptoVtoDays) {
		this.ptoVtoDays = ptoVtoDays;
	}

	public double getFinalWorkedDays() {
		return finalWorkedDays;
	}

	public void setFinalWorkedDays(double finalWorkedDays) {
		this.finalWorkedDays = finalWorkedDays;
	}

	public double getQa() {
		return qa;
	}

	public void setQa(double qa) {
		this.qa = qa;
	}

	public double getNpsValue() {
		return npsValue;
	}

	public void setNpsValue(double npsValue) {
		this.npsValue = npsValue;
	}

	public double getFinalCredits() {
		return finalCredits;
	}

	public void setFinalCredits(double finalCredits) {
		this.finalCredits = finalCredits;
	}

	public String getCounselingImpact() {
		return counselingImpact;
	}

	public void setCounselingImpact(String counselingImpact) {
		this.counselingImpact = counselingImpact;
	}

	public double getFinalOcr() {
		return finalOcr;
	}

	public void setFinalOcr(double finalOcr) {
		this.finalOcr = finalOcr;
	}

	public double getOcrPer() {
		return ocrPer;
	}

	public void setOcrPer(double ocrPer) {
		this.ocrPer = ocrPer;
	}

	public double getIcw() {
		return icw;
	}

	public void setIcw(double icw) {
		this.icw = icw;
	}

}
