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

import com.ocwen.models.ASIT_PKT;

public class ExcelHelperAsitPkt {
	static Logger logger = LogManager.getLogger(ExcelHelperAsitPkt.class);

	static String[] HEADERs = {"MONTH", "EMPLOYEE_ID", "NAME", "DEPARTMENT","SCORE_PERCENTAGE",
			"SCORE" ,"RESULT","TEAM_LEAD","LOCATION","DOJ","TENURE","TENURE_YEARS","LEVEL"};
	
	  static String SHEET = "ASIT_PKT";
	  
	  public static List<ASIT_PKT> excelToObjects(InputStream is)
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
		      List<ASIT_PKT> objects = new ArrayList<ASIT_PKT>();
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

		        ASIT_PKT object = new ASIT_PKT();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMonth(null);
		        	  else{
		        		  //object.setMonth(currentCell.getDateCellValue());
		        		  sdf = new SimpleDateFormat("MM/dd/yy");
	    		  			object.setMonth(sdf.parse(formatter.formatCellValue(currentCell)));
		        	  }
		            break;

		          case 1:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setEmployeeId(null);
		        	  else
		        		  object.setEmployeeId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setName(null);
		        	  else
		        		  object.setName(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDepartment(null);
		        	  else
		        		  object.setDepartment(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setScorePercentage(0);
		        	  else
		        		  object.setScorePercentage(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setScore(0);
		        	  else
		        		  object.setScore(currentCell.getNumericCellValue());
		            break;

		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setResult(null);
		        	  else
		        		  object.setResult(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTeamLead(null);
		        	  else
		        		  object.setTeamLead(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		            break;
		           
		          case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDoj(null);
		        	  else{
		        		  //object.setMonth(currentCell.getDateCellValue());
		        		  sdf = new SimpleDateFormat("MM/dd/yy");
	    		  			object.setDoj(sdf.parse(formatter.formatCellValue(currentCell)));
		        	  }
		            break;
		            
		          case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTenure(0);
		        	  else
		        		  object.setTenure(currentCell.getNumericCellValue());
		            break;
		            
		          case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTenureYears(null);
		        	  else
		        		  object.setTenureYears(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setAgentLevel(null);
		        	  else
		        		  object.setAgentLevel(formatter.formatCellValue(currentCell));
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
