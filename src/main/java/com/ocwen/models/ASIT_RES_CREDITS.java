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
@Table(name = "ASIT_RES_CREDITS")
public class ASIT_RES_CREDITS {

	@Id
	  @Column(name = "id")
	  @GeneratedValue(strategy=GenerationType.AUTO, generator="credid_generator")
	  @SequenceGenerator(name="credid_generator", sequenceName = "ASIT_RES_CREDITS_seq", allocationSize=1)
	  private long id;
	
	@Column(name = "RPT_MONTH")
	private Date rptMonth;
	
	@Column(name = "DEPT")
	private String dept;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "SPVR_NAME")
	private String spvrName;
	
	@Column(name = "UCID")
	private String ucId;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "PYMT_COLCTN_CREDITS")
	private double pymtColctnCredits;
	
	@Column(name = "DWNPMT_RPYMT_CREDITS")
	private double dwnpmtRpymtCredits;
	
	@Column(name = "SBSQNT_RPYMT_CREDITS")
	private double sbsqntRpymtCredits;
	
	@Column(name = "RPYMT_CMPLT_CREDITS")
	private double rpymtCmpltCredits;
	
	@Column(name = "FRST_TRL_PMT_CREDITS")
	private double frstTrlPmtCredits;
	
	@Column(name = "SCND_TRL_PMT_CREDITS")
	private double scndTrlPmtCredits;
	
	@Column(name = "THRD_TRL_PMT_CREDITS")
	private double thrdTrlPmtCredits;
	
	@Column(name = "FRTH_TRL_PMT_CREDITS")
	private double frthTrlPmtCredits;
	
	@Column(name = "MOD_CMPLTN_CREDITS")
	private double modCmpltnCredits;
	
	@Column(name = "SS_CMPLTN_CREDITS")
	private double ssCmpltnCredits;
	
	@Column(name = "DIL_CMPLTN_CREDITS")
	private double dilCmpltnCredits;
	
	@Column(name = "MISSG_DOC_COLLN_CREDITS")
	private double missingDocCollnCredits;
	
	@Column(name = "PYF_CREDITS")
	private double pyfCredits;
	
	@Column(name = "SETTLEMENT_CREDITS")
	private double settlementCredits;
	
	@Column(name = "BK_CORT_APPRVL_CREDIT")
	private double bkCortApprvlCredits;
	
	@Column(name = "BK_DEBT_AUTHZ_CREDIT")
	private double bkDebtAuthzCredits;

	@Column(name = "LMDPGI_CREDITS")
	private double lmdpgiCredits;
	
	@Column(name = "COVID_CREDITS")
	private double covidCredits;
	
	@Column(name = "WEBFORM_CREDITS")
	private double webFormCredits;
	
	@Column(name = "INFORB_CREDITS")
	private double inforbCredits;
	
	@Column(name = "VERBAPP_CREDITS")
	private double verbAppCredits;
	
	@Column(name = "RPC_ON_APPT_CREDITS")
	private double rpcOnAppTCredits;
	
	@Column(name = "FINAL_RESOL_CRDTS")
	private double finalResolCredits;
	
	@Column(name = "HOURS_WORKED")
	private double hoursWorked;
	
	@Column(name = "DAYS_WORKED")
	private double daysWorked;
	
	@Column(name = "CREDITS_PER_HOUR")
	private double creditsPerHour;
	
	@Column(name = "CREDITS_PER_DAY")
	private double creditsPerDay;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getRptMonth() {
		return rptMonth;
	}

	public void setRptMonth(Date rptMonth) {
		this.rptMonth = rptMonth;
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

	public String getSpvrName() {
		return spvrName;
	}

	public void setSpvrName(String spvrName) {
		this.spvrName = spvrName;
	}

	public String getUcId() {
		return ucId;
	}

	public void setUcId(String ucId) {
		this.ucId = ucId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getPymtColctnCredits() {
		return pymtColctnCredits;
	}

	public void setPymtColctnCredits(double pymtColctnCredits) {
		this.pymtColctnCredits = pymtColctnCredits;
	}

	public double getDwnpmtRpymtCredits() {
		return dwnpmtRpymtCredits;
	}

	public void setDwnpmtRpymtCredits(double dwnpmtRpymtCredits) {
		this.dwnpmtRpymtCredits = dwnpmtRpymtCredits;
	}

	public double getSbsqntRpymtCredits() {
		return sbsqntRpymtCredits;
	}

	public void setSbsqntRpymtCredits(double sbsqntRpymtCredits) {
		this.sbsqntRpymtCredits = sbsqntRpymtCredits;
	}

	public double getRpymtCmpltCredits() {
		return rpymtCmpltCredits;
	}

	public void setRpymtCmpltCredits(double rpymtCmpltCredits) {
		this.rpymtCmpltCredits = rpymtCmpltCredits;
	}

	public double getFrstTrlPmtCredits() {
		return frstTrlPmtCredits;
	}

	public void setFrstTrlPmtCredits(double frstTrlPmtCredits) {
		this.frstTrlPmtCredits = frstTrlPmtCredits;
	}

	public double getScndTrlPmtCredits() {
		return scndTrlPmtCredits;
	}

	public void setScndTrlPmtCredits(double scndTrlPmtCredits) {
		this.scndTrlPmtCredits = scndTrlPmtCredits;
	}

	public double getThrdTrlPmtCredits() {
		return thrdTrlPmtCredits;
	}

	public void setThrdTrlPmtCredits(double thrdTrlPmtCredits) {
		this.thrdTrlPmtCredits = thrdTrlPmtCredits;
	}

	public double getFrthTrlPmtCredits() {
		return frthTrlPmtCredits;
	}

	public void setFrthTrlPmtCredits(double frthTrlPmtCredits) {
		this.frthTrlPmtCredits = frthTrlPmtCredits;
	}

	public double getModCmpltnCredits() {
		return modCmpltnCredits;
	}

	public void setModCmpltnCredits(double modCmpltnCredits) {
		this.modCmpltnCredits = modCmpltnCredits;
	}

	public double getSsCmpltnCredits() {
		return ssCmpltnCredits;
	}

	public void setSsCmpltnCredits(double ssCmpltnCredits) {
		this.ssCmpltnCredits = ssCmpltnCredits;
	}

	public double getDilCmpltnCredits() {
		return dilCmpltnCredits;
	}

	public void setDilCmpltnCredits(double dilCmpltnCredits) {
		this.dilCmpltnCredits = dilCmpltnCredits;
	}

	public double getMissingDocCollnCredits() {
		return missingDocCollnCredits;
	}

	public void setMissingDocCollnCredits(double missingDocCollnCredits) {
		this.missingDocCollnCredits = missingDocCollnCredits;
	}

	public double getPyfCredits() {
		return pyfCredits;
	}

	public void setPyfCredits(double pyfCredits) {
		this.pyfCredits = pyfCredits;
	}

	public double getSettlementCredits() {
		return settlementCredits;
	}

	public void setSettlementCredits(double settlementCredits) {
		this.settlementCredits = settlementCredits;
	}

	public double getBkCortApprvlCredits() {
		return bkCortApprvlCredits;
	}

	public void setBkCortApprvlCredits(double bkCortApprvlCredits) {
		this.bkCortApprvlCredits = bkCortApprvlCredits;
	}

	public double getBkDebtAuthzCredits() {
		return bkDebtAuthzCredits;
	}

	public void setBkDebtAuthzCredits(double bkDebtAuthzCredits) {
		this.bkDebtAuthzCredits = bkDebtAuthzCredits;
	}

	public double getLmdpgiCredits() {
		return lmdpgiCredits;
	}

	public void setLmdpgiCredits(double lmdpgiCredits) {
		this.lmdpgiCredits = lmdpgiCredits;
	}

	public double getCovidCredits() {
		return covidCredits;
	}

	public void setCovidCredits(double covidCredits) {
		this.covidCredits = covidCredits;
	}

	public double getWebFormCredits() {
		return webFormCredits;
	}

	public void setWebFormCredits(double webFormCredits) {
		this.webFormCredits = webFormCredits;
	}

	public double getInforbCredits() {
		return inforbCredits;
	}

	public void setInforbCredits(double inforbCredits) {
		this.inforbCredits = inforbCredits;
	}

	public double getVerbAppCredits() {
		return verbAppCredits;
	}

	public void setVerbAppCredits(double verbAppCredits) {
		this.verbAppCredits = verbAppCredits;
	}

	public double getRpcOnAppTCredits() {
		return rpcOnAppTCredits;
	}

	public void setRpcOnAppTCredits(double rpcOnAppTCredits) {
		this.rpcOnAppTCredits = rpcOnAppTCredits;
	}

	public double getFinalResolCredits() {
		return finalResolCredits;
	}

	public void setFinalResolCredits(double finalResolCredits) {
		this.finalResolCredits = finalResolCredits;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(double daysWorked) {
		this.daysWorked = daysWorked;
	}

	public double getCreditsPerHour() {
		return creditsPerHour;
	}

	public void setCreditsPerHour(double creditsPerHour) {
		this.creditsPerHour = creditsPerHour;
	}

	public double getCreditsPerDay() {
		return creditsPerDay;
	}

	public void setCreditsPerDay(double creditsPerDay) {
		this.creditsPerDay = creditsPerDay;
	}
	
	
	
}
