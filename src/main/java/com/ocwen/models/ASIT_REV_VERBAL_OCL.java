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
@Table(name = "ASIT_REV_VERBAL_OCL")
public class ASIT_REV_VERBAL_OCL {

	@Id
	  @Column(name = "ID")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="revverocc_generator")
	  @SequenceGenerator(name="revverocc_generator", sequenceName = "ASIT_REV_VERBAL_OCL_SEQ", allocationSize=1)
	  private long id;
	
	@Column(name = "MONTH")
	  private Date month;
	
	@Column(name = "FUSION_ID")
	  private String fusionId;
	
	@Column(name = "AGENT")
	  private String agent;
	
	@Column(name = "TEAM_LEAD")
	  private String tl;
	
	@Column(name = "IB_VERBAL_OC_OBT")
	  private double ibVerbalOcc;
	
	@Column(name = "IB_TOT_OPP")
	  private double ibTotOpp;
	
	@Column(name = "OB_VERBAL_OC_OBT")
	  private double obVerbalOcc;
	
	@Column(name = "VERBAL_OCC_COMP")
	  private double verbOccComp;
	
	@Column(name = "OB_TOT_OPP")
	  private double obTotOpp;

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

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getTl() {
		return tl;
	}

	public void setTl(String tl) {
		this.tl = tl;
	}

	public double getIbVerbalOcc() {
		return ibVerbalOcc;
	}

	public void setIbVerbalOcc(double ibVerbalOcc) {
		this.ibVerbalOcc = ibVerbalOcc;
	}

	public double getIbTotOpp() {
		return ibTotOpp;
	}

	public void setIbTotOpp(double ibTotOpp) {
		this.ibTotOpp = ibTotOpp;
	}

	public double getObVerbalOcc() {
		return obVerbalOcc;
	}

	public void setObVerbalOcc(double obVerbalOcc) {
		this.obVerbalOcc = obVerbalOcc;
	}

	public double getVerbOccComp() {
		return verbOccComp;
	}

	public void setVerbOccComp(double verbOccComp) {
		this.verbOccComp = verbOccComp;
	}

	public double getObTotOpp() {
		return obTotOpp;
	}

	public void setObTotOpp(double obTotOpp) {
		this.obTotOpp = obTotOpp;
	}
	
	
}
