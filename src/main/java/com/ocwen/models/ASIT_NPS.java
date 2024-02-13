package com.ocwen.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ASIT_NPS")
@Component
public class ASIT_NPS {
	
	@Id
	@Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="npsid_generator")
	  @SequenceGenerator(name="npsid_generator", sequenceName = "ASIT_NPS_TABLE_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	  
	@Column(name = "FUSION_ID")
	  private String fusionId;
	
	@Column(name = "PROMOTER")
	  private double promoter;
	
	@Column(name = "PASSIVE")
	  private double passive;
	
	@Column(name = "DETRACTOR")
	  private double detractor;
	
	@Column(name = "GRAND_TOTAL")
	  private double grandTotal;
	
	@Column(name = "NPS_PERCENTAGE")
	  private double npsPercent;
	

	public double getNpsPercent() {
		return npsPercent;
	}

	public void setNpsPercent(double npsPercent) {
		this.npsPercent = npsPercent;
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

	public double getPromoter() {
		return promoter;
	}

	public void setPromoter(double promoter) {
		this.promoter = promoter;
	}

	public double getPassive() {
		return passive;
	}

	public void setPassive(double passive) {
		this.passive = passive;
	}

	public double getDetractor() {
		return detractor;
	}

	public void setDetractor(double detractor) {
		this.detractor = detractor;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	  
}
