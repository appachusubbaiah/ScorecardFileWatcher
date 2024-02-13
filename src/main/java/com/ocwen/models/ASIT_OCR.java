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
@Table(name = "ASIT_OCR")
public class ASIT_OCR 
{
	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="ocrid_generator")
	  @SequenceGenerator(name="ocrid_generator", sequenceName = "ASIT_OCR_seq", allocationSize=1)
	  private long id;
	
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getTotalCalls() {
		return totalCalls;
	}

	public void setTotalCalls(double totalCalls) {
		this.totalCalls = totalCalls;
	}

	public double getTotalRepeatCalls() {
		return totalRepeatCalls;
	}

	public void setTotalRepeatCalls(double totalRepeatCalls) {
		this.totalRepeatCalls = totalRepeatCalls;
	}

	public double getTotalCallsPending() {
		return totalCallsPending;
	}

	public void setTotalCallsPending(double totalCallsPending) {
		this.totalCallsPending = totalCallsPending;
	}

	public double getTotalRepeatCallsPending() {
		return totalRepeatCallsPending;
	}

	public void setTotalRepeatCallsPending(double totalRepeatCallsPending) {
		this.totalRepeatCallsPending = totalRepeatCallsPending;
	}

	public double getOcr() {
		return ocr;
	}

	public void setOcr(double ocr) {
		this.ocr = ocr;
	}

	@Column(name = "MONTH")
	private Date Month;
	
	@Column(name = "FUSION_ID")
	private String fusionId;

	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "SPVR_NAME")
	private String spvrName;
	
	@Column(name = "DEPT")
	private String dept;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "TOTAL_CALLS")
	private double totalCalls;
	
	@Column(name = "TOTAL_REPEAT_CALLS")
	private double totalRepeatCalls;
	
	@Column(name = "TOTAL_CALLS_PENDING")
	private double totalCallsPending;
	
	@Column(name = "TOTAL_REPEAT_CALLS_PENDING")
	private double totalRepeatCallsPending;
	
	@Column(name = "OCR")
	private double ocr;
	
}
