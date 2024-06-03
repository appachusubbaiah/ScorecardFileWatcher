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

import com.ocwen.models.ASIT_REV_ICP;

public class ExcelHelperAsitRevIcp {
static Logger logger = LogManager.getLogger(ExcelHelperAsitRevIcp.class);
	
	static String[] HEADERs = { "MONTH", "FUSIONID", "LIVEVOXID","UCID","NAME","SITE","DESIGNATION","TEAM_LEADER","STATUS","DEPT","TOTAL_WORKED_DAYS","PTO_N_VTO_DAYS","FINAL_WORKED_DAYS","QA","NPSVALUE","FINAL_CREDITS","COUNSELING_IMPACT","FINAL_OCR","OCR_PER","ICW" };
	  static String SHEET = "Sheet1";
	  
	  public static List<ASIT_REV_ICP> excelToObjects(InputStream is)
	  {
		  SimpleDateFormat sdf=null;
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
		      List<ASIT_REV_ICP> objects = new ArrayList<ASIT_REV_ICP>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_REV_ICP object = new ASIT_REV_ICP();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMonth(null);
		        	  else{
		        		  //System.out.println("Setting month..");
		        		  //object.setMonth(currentCell.getDateCellValue());
		        		  sdf = new SimpleDateFormat("MM/dd/yy");
		        		  object.setMonth(sdf.parse(formatter.formatCellValue(currentCell)));
		        		  //System.out.println("Month = " + currentCell.getDateCellValue());
		        		  
		        	  }
		            break;

		          case 1:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFusionId(null);
		        	  else
		        		  object.setFusionId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLivevoxId(null);
		        	  else
		        		  object.setLivevoxId(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setUcId(null);
		        	  else
		        		  object.setUcId(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setName(null);
		        	  else
		        		  object.setName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSite(null);
		        	  else
		        		  object.setSite(formatter.formatCellValue(currentCell));
		            break;
		            
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDesignation(null);
		        	  else
		        		  object.setDesignation(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTeamLeader(null);
		        	  else
		        		  object.setTeamLeader(formatter.formatCellValue(currentCell));
		            break;   
		            
		          case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setStatus(null);
		        	  else
		        		  object.setStatus(formatter.formatCellValue(currentCell));
		            break;   
		            
		          case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDept(null);
		        	  else
		        		  object.setDept(formatter.formatCellValue(currentCell));
		            break;   
		            
		          case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalWorkedDays(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setTotalWorkedDays(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setPtoVtoDays(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setPtoVtoDays(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFinalWorkedDays(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setFinalWorkedDays(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 13:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setQa(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setQa(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 14:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setNpsValue(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setNpsValue(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 15:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFinalCredits(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setFinalCredits(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		          
		          case 16:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCounselingImpact(null);
		        	  else
		        		  object.setCounselingImpact(formatter.formatCellValue(currentCell));
		            break;   
		          
		          case 17:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFinalOcr(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setFinalOcr(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 18:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setOcrPer(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setOcrPer(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		            
		          case 19:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setIcw(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setIcw(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
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
