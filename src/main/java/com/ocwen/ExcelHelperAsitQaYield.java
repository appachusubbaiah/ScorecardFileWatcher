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

import com.ocwen.models.ASIT_QUALITY_YIELD;

public class ExcelHelperAsitQaYield {
static Logger logger = LogManager.getLogger(ExcelHelperAsitQaYield.class);
	
	static String[] HEADERs = { "Month", "FusionID", "Employee_Name" ,"NetworkID", "Location","Designation","Supervisor_Name", "Assistant_Manager", "Manager", "Director","Business_Unit","Business_Process","QA_Yield","QA_Average","Count_of_0_Score","Count_of_Low_Score","total_count" };
	static String SHEET = "Sheet1";
	
	public static List<ASIT_QUALITY_YIELD> excelToObjects(InputStream is){
		
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
		      
		      List<ASIT_QUALITY_YIELD> objects = new ArrayList<ASIT_QUALITY_YIELD>();
		      
		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();
		        
		        ASIT_QUALITY_YIELD object = new ASIT_QUALITY_YIELD();
		        
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
		        		  object.setEmployeeName(null);
		        	  else
		        		  object.setEmployeeName(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setNtId(null);
		        	  else
		        		  object.setNtId(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDesignation(null);
		        	  else
		        		  object.setDesignation(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSupervisorName(null);
		        	  else
		        		  object.setSupervisorName(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setAsstManager(null);
		        	  else
		        		  object.setAsstManager(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setManager(null);
		        	  else
		        		  object.setManager(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDirector(null);
		        	  else
		        		  object.setManager(formatter.formatCellValue(currentCell));
		            break;
		            		
		         case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBusinessUnit(null);
		        	  else
		        		  object.setBusinessUnit(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBusinessProcess(null);
		        	  else
		        		  object.setBusinessProcess(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setQaYield(0);
		        	  else
		        	  {
		        		  object.setQaYield(currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		         case 13:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setQaAverage(0);
		        	  else
		        	  {
		        		  object.setQaAverage(currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		         case 14:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCountZero(0);
		        	  else
		        	  {
		        		  object.setCountZero(currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		         case 15:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCountLowScore(0);
		        	  else
		        	  {
		        		  object.setCountLowScore(currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		         case 16:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalCount(0);
		        	  else
		        	  {
		        		  object.setTotalCount(currentCell.getNumericCellValue());
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