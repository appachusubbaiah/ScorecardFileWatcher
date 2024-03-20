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
@Table(name = "ASIT_ROSTER_TABLE")
public class ASIT_ROSTER_TABLE {
	
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="rosterid_generator")
	  @SequenceGenerator(name="rosterid_generator", sequenceName = "ASIT_ROSTER_TABLE_seq", allocationSize=1)
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	  
	  @Column(name = "FUSIONID")
	  private String fusionId;
	  
	  @Column(name = "UCID")
	  private String ucId;
	  
	  @Column(name = "NAME")
	  private String name;
	  
	  @Column(name = "DESIGNATION")
	  private String designation;
	  
	  @Column(name = "TEAM_LEADER")
	  private String teamLeader;
	  
	  @Column(name = "LOCATION")
	  private String location;
	  
	  @Column(name = "DEPT")
	  private String dept;
	  
	  @Column(name = "QA_COMMENTS")
	  private String qaComments;
	  
	  @Column(name = "BIS_COMMENTS")
	  private String bisComments;
	  
	  @Column(name = "NTID")
	  private String ntid;
	  
	  @Column(name = "OCWEN_EMAIL")
	  private String emailId;
	  
	  @Column(name = "BU_SUB_PROCESS")
	  private String buSubProcess;

	  @Column(name = "ASST_MNGR_NAME")
	  private String asstMngrName;

	  @Column(name = "MNGR_NAME")
	  private String mngrName;
	  
	  @Column(name = "FINAL_STATUS")
	  private String finalStatus;
	  
	  @Column(name = "LIVEVOX_ID")
	  private String livevoxId;
	  
	  @Column(name = "TL_FUSIONID")
	  private String tlFusionId;
	  
	  
	  public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

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

	public String getNtid() {
		return ntid;
	}

	public void setNtid(String ntid) {
		this.ntid = ntid;
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

	public String getQaComments() {
		return qaComments;
	}

	public void setQaComments(String qaComments) {
		this.qaComments = qaComments;
	}

	public String getBisComments() {
		return bisComments;
	}

	public void setBisComments(String bisComments) {
		this.bisComments = bisComments;
	}

	public String getBuSubProcess() {
		return buSubProcess;
	}

	public void setBuSubProcess(String buSubProcess) {
		this.buSubProcess = buSubProcess;
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

	
	public String getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}

	public String getLivevoxId() {
		return livevoxId;
	}

	public void setLivevoxId(String livevoxId) {
		this.livevoxId = livevoxId;
	}

	public String getTlFusionId() {
		return tlFusionId;
	}

	public void setTlFusionId(String tlFusionId) {
		this.tlFusionId = tlFusionId;
	}

	
}
