package com.ocwen;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ocwen.models.ASIT_CMS_DEFECT;
import com.ocwen.models.ASIT_RES_CREDITS;

public class ExcelHelperAsitResCredits {
	static Logger logger = LogManager.getLogger(ExcelHelperAsitResCredits.class);

	static String[] HEADERs = { "RPT_MONTH", "DEPT", "LOCATION", "SPVR_NAME","UCID","EMP_NAME","PYMT_COLCTN_CREDITS","DWNPMT_RPYMT_CREDITS",
			"SBSQNT_RPYMT_CREDITS","RPYMT_CMPLT_CREDITS","FRST_TRL_PMT_CREDITS","SCND_TRL_PMT_CREDITS","THRD_TRL_PMT_CREDITS","FRTH_TRL_PMT_CREDITS"
			,"MOD_CMPLTN_CREDITS","SS_CMPLTN_CREDITS","DIL_CMPLTN_CREDITS","MISSG_DOC_COLLN_CREDITS","PYF_CREDITS","SETTLEMENT_CREDITS"
			,"BK_CORT_APPRVL_CREDIT", "BK_DEBT_AUTHZ_CREDIT", "LMDPGI_CREDITS", "COVID_CREDITS", "WEBFORM_CREDITS", "INFORB_CREDITS"
			,"VERBAPP_CREDITS","RPC_ON_APPT_CREDITS","FINAL_RESOL_CRDTS","HOURS_WORKED","DAYS_WORKED", "CREDITS_PER_HOUR", "CREDITS_PER_DAY"};
	  static String SHEET = "TELEPHONY";
	  
	  public static List<ASIT_RES_CREDITS> excelToObjects(InputStream is)
	  {
		  System.out.println("In excel to objects...");
		  logger.info("In excel to objects...");
		  try {
		    	System.out.println("Opening file " + is.toString());
		      Workbook workbook = new XSSFWorkbook(is);
		      System.out.println("Opened WB " + is.toString());
		      logger.info("Opened Work Book " + is.toString());
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_RES_CREDITS> objects = new ArrayList<ASIT_RES_CREDITS>();
		      SimpleDateFormat sdf=null;
		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_RES_CREDITS object = new ASIT_RES_CREDITS();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setRptMonth(null);
		        	  else{
		        		  //object.setRptMonth(currentCell.getDateCellValue());
		        		  sdf = new SimpleDateFormat("MM/dd/yy");
	    		  			object.setRptMonth(sdf.parse(formatter.formatCellValue(currentCell)));
		        	  }
		            break;

		          case 1:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDept(null);
		        	  else
		        		  object.setDept(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSpvrName(null);
		        	  else
		        		  object.setSpvrName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setUcId(null);
		        	  else
		        	    object.setUcId(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setEmpName(null);
		        	  else
		        	    object.setEmpName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setPymtColctnCredits(0);
		        	  else
		        	    object.setPymtColctnCredits(currentCell.getNumericCellValue());
		            break;

		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDwnpmtRpymtCredits(0);
		        	  else
		        	    object.setDwnpmtRpymtCredits(currentCell.getNumericCellValue());
		            break;

		          case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSbsqntRpymtCredits(0);
		        	  else
		        	    object.setSbsqntRpymtCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setRpymtCmpltCredits(0);
		        	  else
		        	    object.setRpymtCmpltCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFrstTrlPmtCredits(0);
		        	  else
		        	    object.setFrstTrlPmtCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setScndTrlPmtCredits(0);
		        	  else
		        	    object.setScndTrlPmtCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setThrdTrlPmtCredits(0);
		        	  else
		        	    object.setThrdTrlPmtCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 13:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFrthTrlPmtCredits(0);
		        	  else
		        	    object.setFrthTrlPmtCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 14:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setModCmpltnCredits(0);
		        	  else
		        	    object.setModCmpltnCredits(currentCell.getNumericCellValue());
		            break;

		          case 15:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSsCmpltnCredits(0);
		        	  else
		        	    object.setSsCmpltnCredits(currentCell.getNumericCellValue());
		            break;

		          case 16:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDilCmpltnCredits(0);
		        	  else
		        	    object.setDilCmpltnCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 17:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMissingDocCollnCredits(0);
		        	  else
		        	    object.setMissingDocCollnCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 18:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setPyfCredits(0);
		        	  else
		        	    object.setPyfCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 19:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSettlementCredits(0);
		        	  else
		        	    object.setSettlementCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 20:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBkCortApprvlCredits(0);
		        	  else
		        	    object.setBkCortApprvlCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 21:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBkDebtAuthzCredits(0);
		        	  else
		        	    object.setBkDebtAuthzCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 22:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLmdpgiCredits(0);
		        	  else
		        	    object.setLmdpgiCredits(currentCell.getNumericCellValue());
		            break;
		            
		            
		          case 23:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCovidCredits(0);
		        	  else
		        	    object.setCovidCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 24:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setWebFormCredits(0);
		        	  else
		        	    object.setWebFormCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 25:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setInforbCredits(0);
		        	  else
		        	    object.setInforbCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 26:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setVerbAppCredits(0);
		        	  else
		        	    object.setVerbAppCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 27:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setRpcOnAppTCredits(0);
		        	  else
		        	    object.setRpcOnAppTCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 28:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFinalResolCredits(0);
		        	  else
		        	    object.setFinalResolCredits(currentCell.getNumericCellValue());
		            break;
		            
		          case 29:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setHoursWorked(0);
		        	  else
		        	    object.setHoursWorked(currentCell.getNumericCellValue());
		            break;
		            
		          case 30:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDaysWorked(0);
		        	  else
		        	    object.setDaysWorked(currentCell.getNumericCellValue());
		            break;
		            
		          case 31:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCreditsPerHour(0);
		        	  else
		        	    object.setCreditsPerHour(currentCell.getNumericCellValue());
		            break;
		            
		          case 32:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCreditsPerDay(0);
		        	  else
		        	    object.setCreditsPerDay(currentCell.getNumericCellValue());
		            break;
		            
		          default:
		            break;
		          }
		          //System.out.println("Cell Index = " + cellIdx);
		          cellIdx++;
		        }

		        objects.add(object);
		      }

		      workbook.close();

		      return objects;
		    } catch (IOException e) {
		    	logger.error("fail to parse Excel file: ",e.getMessage());
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		    catch(Exception e)
		    {
		    	logger.error("fail to parse Excel file: ",e.getMessage());
		    	throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }	  
}

