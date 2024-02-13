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
@Table(name = "ASIT_ICW_TAT")
public class ASIT_ICW_TAT {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="icwid_generator")
	  @SequenceGenerator(name="icwid_generator", sequenceName = "ASIT_ICW_TAT_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date Month;
	
	@Column(name = "FUSIONID")
	private String fusionId;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SUPERVISOR")
	private String supervisor;
	
	@Column(name = "LOCATION")
	private String location;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getMtdTat() {
		return mtdTat;
	}

	public void setMtdTat(double mtdTat) {
		this.mtdTat = mtdTat;
	}

	@Column(name = "MTD_TAT")
	private double mtdTat;
}
