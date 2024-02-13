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
@Table(name = "ASIT_REFI_SOLI")
public class ASIT_REFI_SOLI {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="refsoliid_generator")
	  @SequenceGenerator(name="refsoliid_generator", sequenceName = "ASIT_REFI_SOLI_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	private Date Month;
	
	@Column(name = "UCID")
	private String ucId;
	
	@Column(name = "NET_FLAGGED")
	private double netFlagged;
	
	@Column(name = "SOLICITED")
	private double solicited;
	
	@Column(name = "TRANSFERRED")
	private double transferred;
	
	@Column(name = "SOLICITATION_PERCENTAGE")
	private double solicitationPercentage;
	
	@Column(name = "TRANSFER_PERCENTAGE")
	private double transferPercentage;

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

	public String getUcId() {
		return ucId;
	}

	public void setUcId(String ucId) {
		this.ucId = ucId;
	}

	public double getNetFlagged() {
		return netFlagged;
	}

	public void setNetFlagged(double netFlagged) {
		this.netFlagged = netFlagged;
	}

	public double getSolicited() {
		return solicited;
	}

	public void setSolicited(double solicited) {
		this.solicited = solicited;
	}

	public double getTransferred() {
		return transferred;
	}

	public void setTransferred(double transferred) {
		this.transferred = transferred;
	}

	public double getSolicitationPercentage() {
		return solicitationPercentage;
	}

	public void setSolicitationPercentage(double solicitationPercentage) {
		this.solicitationPercentage = solicitationPercentage;
	}

	public double getTransferPercentage() {
		return transferPercentage;
	}

	public void setTransferPercentage(double transferPercentage) {
		this.transferPercentage = transferPercentage;
	}
	
}
