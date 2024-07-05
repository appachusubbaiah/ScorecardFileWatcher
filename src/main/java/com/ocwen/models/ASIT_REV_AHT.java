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
@Table(name = "ASIT_REV_AHT")
public class ASIT_REV_AHT {

	@Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revrevaht_generator")
	  @SequenceGenerator(name="revrevaht_generator", sequenceName = "ASIT_REV_AHT_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	
	@Column(name = "LOGON_ID")
	  private String logonId;
	
	@Column(name = "CALLS_HANDLED")
	  private double callsHandled;
	
	@Column(name = "TALK_TIME")
	  private double talkTime;
	
	@Column(name = "HOLD_TIME")
	  private double holdTime;
	
	@Column(name = "ACW_TIME")
	  private double acwTime;
	
	@Column(name = "HANDLE_TIME")
	  private double handleTime;
	
	@Column(name = "DIRECTION")
	  private String direction;
	
	@Column(name = "EMP_NAME")
	  private String empName;
	
	@Column(name = "SPVR_NAME")
	  private String spvrName;
	
	@Column(name = "MNGR_NAME")
	  private String mngrName;
	
	@Column(name = "LOCATION")
	  private String location;
	
	@Column(name = "DEPT")
	  private String dept;

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

	public String getLogonId() {
		return logonId;
	}

	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}

	public double getCallsHandled() {
		return callsHandled;
	}

	public void setCallsHandled(double callsHandled) {
		this.callsHandled = callsHandled;
	}

	public double getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(double talkTime) {
		this.talkTime = talkTime;
	}

	public double getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(double holdTime) {
		this.holdTime = holdTime;
	}

	public double getAcwTime() {
		return acwTime;
	}

	public void setAcwTime(double acwTime) {
		this.acwTime = acwTime;
	}

	public double getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(double handleTime) {
		this.handleTime = handleTime;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSpvrName() {
		return spvrName;
	}

	public void setSpvrName(String spvrName) {
		this.spvrName = spvrName;
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
	
}
