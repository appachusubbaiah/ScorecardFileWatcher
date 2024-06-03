package com.ocwen.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.ocwen.ExcelHelper;
import com.ocwen.ExcelHelperAppntmtTbl;
import com.ocwen.ExcelHelperAsitAht;
import com.ocwen.ExcelHelperAsitNps;
import com.ocwen.ExcelHelperAsitOcr;
import com.ocwen.ExcelHelperAsitPkt;
import com.ocwen.ExcelHelperAsitQa;
import com.ocwen.ExcelHelperAsitQaYield;
import com.ocwen.ExcelHelperAsitQuality;
import com.ocwen.ExcelHelperAsitRefiSoli;
import com.ocwen.ExcelHelperAsitResCredits;
import com.ocwen.ExcelHelperAsitRevCmsDefect;
import com.ocwen.ExcelHelperAsitRevCs;
import com.ocwen.ExcelHelperAsitRevHrd;
import com.ocwen.ExcelHelperAsitRevIcp;
import com.ocwen.ExcelHelperAsitRevTelephony;
import com.ocwen.ExcelHelperAsitRmic;
import com.ocwen.ExcelHelperAsitRoster;
import com.ocwen.ExcelHelperAsitSkillPort;
import com.ocwen.ExcelHelperAsitTLImpact;
import com.ocwen.ExcelHelperAsitTLQC;
import com.ocwen.ExcelHelperAsitTelephony;
import com.ocwen.ExcelHelperAsitTlHuddle;
import com.ocwen.ExcelHelperRevVerbalOcc;
import com.ocwen.ExcelHelperStarRating;
import com.ocwen.ExcelHelperTat;
import com.ocwen.models.ASIT_AHT;
import com.ocwen.models.ASIT_APPOINTMENTS_TABLE;
import com.ocwen.models.ASIT_CMS_DEFECT;
import com.ocwen.models.ASIT_ICW_QAQC;
import com.ocwen.models.ASIT_ICW_TAT;
import com.ocwen.models.ASIT_NPS;
import com.ocwen.models.ASIT_OCR;
import com.ocwen.models.ASIT_PKT;
import com.ocwen.models.ASIT_QUALITY;
import com.ocwen.models.ASIT_QUALITY_YIELD;
import com.ocwen.models.ASIT_REFI_SOLI;
import com.ocwen.models.ASIT_RES_CREDITS;
import com.ocwen.models.ASIT_REV_CMS_DEFECT;
import com.ocwen.models.ASIT_REV_CS;
import com.ocwen.models.ASIT_REV_HRD;
import com.ocwen.models.ASIT_REV_ICP;
import com.ocwen.models.ASIT_REV_TELEPHONY;
import com.ocwen.models.ASIT_REV_VERBAL_OCL;
import com.ocwen.models.ASIT_RMIC;
import com.ocwen.models.ASIT_ROSTER_TABLE;
import com.ocwen.models.ASIT_SKILLPORT;
import com.ocwen.models.ASIT_STAR_RATING;
import com.ocwen.models.ASIT_TELEPHONY;
import com.ocwen.models.ASIT_TL_HUDDLE;
import com.ocwen.models.ASIT_TL_IMPACT;
import com.ocwen.models.ASIT_TL_QC;
import com.ocwen.repositories.ASIT_AHT_Repository;
import com.ocwen.repositories.ASIT_APPOINTMENTS_TABLE_Repository;
import com.ocwen.repositories.ASIT_CMS_DEFECT_Repository;
import com.ocwen.repositories.ASIT_ICW_QAQC_Repository;
import com.ocwen.repositories.ASIT_ICW_TAT_Repository;
import com.ocwen.repositories.ASIT_NPS_Repository;
import com.ocwen.repositories.ASIT_OCR_Repository;
import com.ocwen.repositories.ASIT_PKT_Repository;
import com.ocwen.repositories.ASIT_QUALITY_REPOSITORY;
import com.ocwen.repositories.ASIT_QUALITY_YIELD_Repository;
import com.ocwen.repositories.ASIT_REFI_SOLI_Repository;
import com.ocwen.repositories.ASIT_RES_CREDITS_Repository;
import com.ocwen.repositories.ASIT_REV_CMS_DEFECT_Repository;
import com.ocwen.repositories.ASIT_REV_CS_Repository;
import com.ocwen.repositories.ASIT_REV_HRD_Repository;
import com.ocwen.repositories.ASIT_REV_ICP_Repository;
import com.ocwen.repositories.ASIT_REV_TELEPHONY_Repository;
import com.ocwen.repositories.ASIT_REV_VERBAL_OCL_Repository;
import com.ocwen.repositories.ASIT_RMIC_Repository;
import com.ocwen.repositories.ASIT_ROSTER_TABLE_Repository;
import com.ocwen.repositories.ASIT_SKILLPORT_Repository;
import com.ocwen.repositories.ASIT_STAR_RATING_Repository;
import com.ocwen.repositories.ASIT_TELEPHONY_Repository;
import com.ocwen.repositories.ASIT_TL_HUDDLE_Repository;
import com.ocwen.repositories.ASIT_TL_IMPACT_Repository;
import com.ocwen.repositories.ASIT_TL_QC_Repository;

@Service
public class ExcelService {
	Logger logger = LogManager.getLogger(ExcelService.class);
	
	@Autowired
	ASIT_CMS_DEFECT_Repository cmsDefectRepository;

	@Autowired
	ASIT_ICW_QAQC_Repository qaqcRepository;
	
	@Autowired
	ASIT_APPOINTMENTS_TABLE_Repository apptRepository;
	
	@Autowired
	ASIT_QUALITY_REPOSITORY qualityRepository;
	
	@Autowired
	ASIT_ICW_TAT_Repository tatRepository;
	
	@Autowired
	ASIT_STAR_RATING_Repository starRepository;
	
	@Autowired
	ASIT_REFI_SOLI_Repository refRepository;
	
	@Autowired
	ASIT_OCR_Repository ocrRepository;
	
	@Autowired
	ASIT_RES_CREDITS_Repository creditsRepository;
	
	@Autowired
	ASIT_REV_CS_Repository revCsRepository;
	
	@Autowired
	ASIT_REV_HRD_Repository revHrdRepository;
	
	@Autowired
	ASIT_RMIC_Repository rmicRepository;

	@Autowired
	ASIT_SKILLPORT_Repository skprtRepository;
	
	@Autowired
	ASIT_ROSTER_TABLE_Repository rosterRepository;
	
	@Autowired
	ASIT_TELEPHONY_Repository telRepository;
	
	@Autowired
	ASIT_PKT_Repository pktRepository;
	
	@Autowired
	ASIT_NPS_Repository npsRepository;
	
	@Autowired
	ASIT_TL_IMPACT_Repository tlImpRepository;
	
	@Autowired
	ASIT_TL_QC_Repository tlQCRepository;
	
	@Autowired
	ASIT_QUALITY_YIELD_Repository qaYieldRepository;
	
	@Autowired
	ASIT_AHT_Repository ahtRepository;
	
	@Autowired
	ASIT_TL_HUDDLE_Repository tlHuddleRepository;
	
	@Autowired
	ASIT_REV_CMS_DEFECT_Repository revCmsdefectRepository;
	
	@Autowired
	ASIT_REV_ICP_Repository revIcpRepository;
	
	@Autowired
	ASIT_REV_TELEPHONY_Repository revTelephonyRepository;
	
	@Autowired
	ASIT_REV_VERBAL_OCL_Repository revVerbalOccRepository;
	
	@Autowired
	private Environment env;
	
	@Async
	public Future<String> save(File file) {
	    try {
		switch(file.getName()){
	      case "ASIT_CMS_DEFECT.xlsx":
	    	  System.out.println("cms defect");
	    	  if(this.fileIsReady(file)){
	    	  System.out.println("About to call excelToObjects..");
	    	  logger.info("About to call excelToObjects",file.getName());
	    			  List<ASIT_CMS_DEFECT> cmsDefectObjects = ExcelHelper.excelToObjects(new FileInputStream(file));
	    	  System.out.println("Saving to database....");
	    	  logger.info("Saving to database....");
	    	  cmsDefectRepository.saveAll(cmsDefectObjects); 
	    	  System.out.println("Saving to database complete.");
	    	  logger.info("Saving to database complete.");
	    	  moveFile(file);
	    	  }
	      	break;
	      case "ASIT_ICW_QAQC.xlsx":
	    	  if(this.fileIsReady(file)){
	    		  logger.info("About to call excelToObjects",file.getName());
	    		  List<ASIT_ICW_QAQC> qaqcObjects = ExcelHelperAsitQa.excelToObjects(new FileInputStream(file));
	    	  System.out.println("Saving to database....");
	    	  logger.info("Saving to database....");
	    	  qaqcRepository.saveAll(qaqcObjects);
	    	  System.out.println("Saving complete.");
	    	  logger.info("Saving to database complete.");
	    	  moveFile(file);
	    	  }
		      break;
	      case "ASIT_APPOINTMENTS_TABLE.xlsx":
	    	  if(this.fileIsReady(file)){
	    		  logger.info("About to call excelToObjects",file.getName());
	    	  List<ASIT_APPOINTMENTS_TABLE> apptObjects = ExcelHelperAppntmtTbl.excelToObjects(new FileInputStream(file));
	    	  System.out.println("Saving to database....");
	    	  logger.info("Saving to database....");
	    	  apptRepository.saveAll(apptObjects);
	    	  System.out.println("Saved to database");
	    	  logger.info("Saving to database complete.");
	    	  moveFile(file);
	    	  }
		      break;
	      case "ASIT_QUALITY.xlsx":
	    	  if(this.fileIsReady(file)){
	    		  logger.info("About to call excelToObjects",file.getName());
	    	  List<ASIT_QUALITY> qaObjects = ExcelHelperAsitQuality.excelToObjects(new FileInputStream(file));
	    	  System.out.println("Saving to database....");
	    	  logger.info("Saving to database....");
	    	  qualityRepository.saveAll(qaObjects);
	    	  System.out.println("Saved to database");
	    	  logger.info("Saving to database complete.");
	    	  moveFile(file);
	    	  }
	    	  break;
	       case "ASIT_ICW_TAT.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_ICW_TAT> qaObjects = ExcelHelperTat.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  tatRepository.saveAll(qaObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	       case "ASIT_STAR_RATING.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_STAR_RATING> starObjects = ExcelHelperStarRating.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  starRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	       case "ASIT_OCR.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_OCR> starObjects = ExcelHelperAsitOcr.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  ocrRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	       case "ASIT_REFI_SOLI.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REFI_SOLI> starObjects = ExcelHelperAsitRefiSoli.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  refRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	       case "ASIT_RES_CREDITS.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_RES_CREDITS> starObjects = ExcelHelperAsitResCredits.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  creditsRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;

	       case "ASIT_REV_CS.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REV_CS> starObjects = ExcelHelperAsitRevCs.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  revCsRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;

	       case "ASIT_REV_HRD.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REV_HRD> starObjects = ExcelHelperAsitRevHrd.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  revHrdRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	       case "ASIT_RMIC.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_RMIC> starObjects = ExcelHelperAsitRmic.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  rmicRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	       case "ASIT_SKILLPORT.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_SKILLPORT> starObjects = ExcelHelperAsitSkillPort.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  skprtRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	      case "ASIT_ROSTER_TABLE.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_ROSTER_TABLE> starObjects = ExcelHelperAsitRoster.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  rosterRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	     case "ASIT_TELEPHONY.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_TELEPHONY> starObjects = ExcelHelperAsitTelephony.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  telRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	     	case "ASIT_PKT.xlsx":
	    	   if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_PKT> starObjects = ExcelHelperAsitPkt.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  pktRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
		      break;
		      
	     	case "ASIT_NPS.xlsx":
		    	   if(this.fileIsReady(file)){
			    		  logger.info("About to call excelToObjects",file.getName());
			    	  List<ASIT_NPS> starObjects = ExcelHelperAsitNps.excelToObjects(new FileInputStream(file));
			    	  System.out.println("Saving to database....");
			    	  logger.info("Saving to database....");
			    	  npsRepository.saveAll(starObjects);
			    	  System.out.println("Saved to database");
			    	  logger.info("Saving to database complete.");
			    	  moveFile(file);
		    	  }
			      break;
			      
	     	case "ASIT_TL_IMPACT.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_TL_IMPACT> starObjects = ExcelHelperAsitTLImpact.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  tlImpRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		break;
	     
	     	case "ASIT_TL_QC.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_TL_QC> starObjects = ExcelHelperAsitTLQC.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  tlQCRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		break;
	     		
	     	case "ASIT_QUALITY_YIELD.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_QUALITY_YIELD> starObjects = ExcelHelperAsitQaYield.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  qaYieldRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		break;
	     		
	     	case "ASIT_AHT.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_AHT> starObjects = ExcelHelperAsitAht.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  ahtRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		break;
	     	
	     	case "ASIT_TL_HUDDLE.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_TL_HUDDLE> starObjects = ExcelHelperAsitTlHuddle.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  tlHuddleRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		
	     	case "ASIT_REV_CMS_DEFECT.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REV_CMS_DEFECT> starObjects = ExcelHelperAsitRevCmsDefect.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  revCmsdefectRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		
	     		break;
	     		
	     	case "ASIT_REV_ICP.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REV_ICP> starObjects = ExcelHelperAsitRevIcp.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  revIcpRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		
	     		break;
	     		
	     	case "ASIT_REV_TELEPHONY.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REV_TELEPHONY> starObjects = ExcelHelperAsitRevTelephony.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  revTelephonyRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		
	     	case "ASIT_REV_VERBAL_OCL.xlsx":
	     		if(this.fileIsReady(file)){
		    		  logger.info("About to call excelToObjects",file.getName());
		    	  List<ASIT_REV_VERBAL_OCL> starObjects = ExcelHelperRevVerbalOcc.excelToObjects(new FileInputStream(file));
		    	  System.out.println("Saving to database....");
		    	  logger.info("Saving to database....");
		    	  revVerbalOccRepository.saveAll(starObjects);
		    	  System.out.println("Saved to database");
		    	  logger.info("Saving to database complete.");
		    	  moveFile(file);
	    	  }
	     		break;
	     default:
		    	  System.out.println("Unknown file..Ignoring");
		    	  logger.info("Unknown file..Ignoring");
	      }
			return new AsyncResult<String>("Complete");
	    } catch (IOException e) {
	    	logger.error(e.getMessage());
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	    catch (Exception e) {
	    	logger.error(e.getMessage());
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	
	public boolean fileIsReady(File file)
	{
		System.out.println("Inside fileIsReady..");
		logger.info("Checking if file is downloaded..");
		boolean val=false;
		long s,s1;
		while (!val)
		{
			try {
			s=file.length();
			System.out.println(file.toPath());
			System.out.println("File size s= " + s);
			logger.info("File size s= " + s);
			
				Thread.sleep(10000);
				System.out.println("Sleeping..");
				logger.info("Thread sleeping..");
			s1=file.length();
			if(s==s1){
				val=true;
				System.out.println("File size s1= " + s1);
				System.out.println("val = " +val);
				logger.info("File size stopped growing");
				logger.info("File size s1= " + s1);
				Thread.sleep(10000);
				break;
			}
			else
				System.out.println("val = " +val);
			} catch (InterruptedException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				 throw new RuntimeException("Exception while waiting for file download: " + e.getMessage());
			};
		}
		
		return val;
	}
	
	public void moveFile(File file)
			{
		Calendar today = Calendar.getInstance();
		/*int month=today.get(Calendar.MONTH);
		int year= Integer.parseInt(new SimpleDateFormat("yy").format(today.getTime()));
		int day=today.get(Calendar.DAY_OF_MONTH);*/
		String dirName=new SimpleDateFormat("MM-dd-yy").format(today.getTime());
		//dirName = dirName + "-" + Integer.toString(day) + "-" + Integer.toString(year);
		try{
	    String directoryName = Paths.get(env.getProperty("watchFolder.parent")).toString();
	    directoryName = directoryName + "\\" + dirName;
	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

	    Path result  = Files.move(Paths.get(file.getPath()),Paths.get((directoryName)+"\\" + file.getName()),StandardCopyOption.REPLACE_EXISTING);
	    if(result != null)
        {
            System.out.println("File renamed and moved successfully");
            logger.info("File moved succesfully" );
        }
        else
        {
            System.out.println("Failed to move the file");
            logger.info("Failed to move the file" );
        }
	}
	   catch (IOException e){
	   e.printStackTrace();
	   logger.error("Exception while moving file :",  e.getMessage());
	   throw new RuntimeException("Exception while moving file: " + e.getMessage());
	   }
	}
}
	
	
	