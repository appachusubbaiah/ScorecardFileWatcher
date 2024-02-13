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
@Table(name = "ASIT_APPOINTMENTS_TABLE")
public class ASIT_APPOINTMENTS_TABLE {
	
	@Id
	  @Column(name = "id")
	  /*@GeneratedValue(strategy=GenerationType.AUTO, generator="apptid_generator")
	  @SequenceGenerator(name="apptid_generator", sequenceName = "ASIT_APPOINTMENTS_TABLE_seq", allocationSize=1)*/
	  private long id;
	
	  @Column(name = "MONTH")
	  private Date month;
	  
	  public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	@Column(name = "EMP_ID")
	  private String empId;
	
	  @Column(name = "UCID")
	  private String ucId;
	  
	  @Column(name = "NAME")
	  private String name;
	  
	  @Column(name = "RPC")
	  private double rpc;
	  
	  @Column(name = "DIALLED_WITHIN_30_MINS")
	  private double dialedWithin30Mins;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public double getRpc() {
		return rpc;
	}

	public void setRpc(double rpc) {
		this.rpc = rpc;
	}

	public double getDialedWithin30Mins() {
		return dialedWithin30Mins;
	}

	public void setDialedWithin30Mins(double dialedWithin30Mins) {
		this.dialedWithin30Mins = dialedWithin30Mins;
	}
	  
}
	
