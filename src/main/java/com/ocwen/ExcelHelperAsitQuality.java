package com.ocwen;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.ocwen.models.ASIT_CMS_DEFECT;
import com.ocwen.models.ASIT_QUALITY;
import com.ocwen.repositories.ASIT_QUALITY_REPOSITORY;

public class ExcelHelperAsitQuality {

	static Logger logger = LogManager.getLogger(ExcelHelperAppntmtTbl.class);
	static String[] HEADERs = { "Roster Month", "Test Type", "Fusion ID", "Employee Name","CITRIX__OR_NETWORK_ID"
			,"Designation","Supervisor Name","Location","Business Unit","Business Process","Score","Loan Number"
			,"Interaction ID","Review Type","Count","Threshold"};
	  static String SHEET = "QUALITY";

	  	  
	  public static List<ASIT_QUALITY> excelToObjects(InputStream is)
	  {
		  System.out.println("In excel to objects...");
		  try {
		    	System.out.println("Opening file " + is.toString());
		    	logger.info("Opening file ",is.toString());
		      Workbook workbook = new XSSFWorkbook(is);
		      System.out.println("Opened WB " + is.toString());
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_QUALITY> objects = new ArrayList<ASIT_QUALITY>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_QUALITY object = new ASIT_QUALITY();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setRosterMonth(null);
		        	  else{
		        		  //System.out.println("Setting month..");
		        		  DateFormat dtFrmt = new SimpleDateFormat("MM/dd/yy");
		        		  object.setRosterMonth(dtFrmt.parse(formatter.formatCellValue(currentCell)));
		        		  //object.setRosterMonth(currentCell.getDateCellValue());
		        		  //System.out.println("Month = " + currentCell.getDateCellValue());
		        		  
		        	  }
		            break;

		          case 1:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTestType(null);
		        	  else
		        		  object.setTestType(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFusionId(null);
		        	  else
		        		  object.setFusionId(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setEmployeeName(null);
		        	  else
		        		  object.setEmployeeName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCitrixNtId(null);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setCitrixNtId(formatter.formatCellValue(currentCell));
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDesignation(null);
		        	  else
		        	  {
		        		  object.setDesignation(formatter.formatCellValue(currentCell));
		        	  }
		        	  
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSupervisorName(null);
		        	  else
		        	  {
		        		  object.setSupervisorName(formatter.formatCellValue(currentCell));
		        	  }
		        	  
		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        	  {
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		        	  }
		            break;
		            
		            
		          case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBusinessUnit(null);
		        	  else
		        	  {
		        		  object.setBusinessUnit(formatter.formatCellValue(currentCell));
		        	  }
		            break;
		            
		          case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBusinessProcess(null);
		        	  else
		        	  {
		        		  object.setBusinessProcess(formatter.formatCellValue(currentCell));
		        	  }
		            break;
		            
		          case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setScore(0);
		        	  else
		        	  {
		        		  object.setScore(currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLoanNumber(null);
		        	  else
		        	  {
		        		  object.setLoanNumber(formatter.formatCellValue(currentCell));
		        	  }
		            break;
		            
		            
		          case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setInteractionId(null);
		        	  else
		        	  {
		        		  object.setInteractionId(formatter.formatCellValue(currentCell));
		        	  }
		            break;
		            
		            
		          case 13:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setReviewType(null);
		        	  else
		        	  {
		        		  object.setReviewType(formatter.formatCellValue(currentCell));
		        	  }
		            break;
		            
		          case 14:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCount(0);
		        	  else
		        	  {
		        		  object.setCount(currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		          default:
		            break;
		          }
		          System.out.println("Cell Index = " + cellIdx);
		          cellIdx++;
		        }
		        objects.add(object);
		      }

		      workbook.close();

		      return objects;
		    } catch (IOException e) {
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    	logger.info("fail to parse Excel file: ",e.getMessage());
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    	logger.info("fail to parse Excel file: ",e.getMessage());
		    	throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
	  
	  

}
