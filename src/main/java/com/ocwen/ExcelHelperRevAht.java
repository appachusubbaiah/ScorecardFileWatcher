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

import com.ocwen.models.ASIT_REV_AHT;


public class ExcelHelperRevAht {
	
	static Logger logger = LogManager.getLogger(ExcelHelperRevAht.class);

	static String[] HEADERs = {"month", "LOGON_ID", "CALLS_HANDLED", "TALK_TIME","HOLD_TIME",
			"ACW_TIME" ,"HANDLE_TIME" ,"DIRECTION","EMP_NAME","SPVR_NAME","MNGR_NAME","LOCATION","Dept"};
	
	  static String SHEET = "Sheet1";
	  
	  public static List<ASIT_REV_AHT> excelToObjects(InputStream is)
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
		      List<ASIT_REV_AHT> objects = new ArrayList<ASIT_REV_AHT>();
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

		        ASIT_REV_AHT object = new ASIT_REV_AHT();
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
		        		  object.setLogonId(null);
		        	  else
		        		  object.setLogonId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCallsHandled(0);
		        	  else
		        		  object.setCallsHandled(currentCell.getNumericCellValue());
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTalkTime(0);
		        	  else
		        		  object.setTalkTime(currentCell.getNumericCellValue());
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setHoldTime(0);
		        	  else
		        		  object.setHoldTime(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setAcwTime(0);
		        	  else
		        		  object.setAcwTime(currentCell.getNumericCellValue());
		            break;

		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setHandleTime(0);
		        	  else
		        		  object.setHandleTime(currentCell.getNumericCellValue());
		            break;
		            
		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDirection(null);
		        	  else
		        		  object.setDirection(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setEmpName(null);
		        	  else
		        		  object.setEmpName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSpvrName(null);
		        	  else
		        		  object.setSpvrName(formatter.formatCellValue(currentCell));
		            break;
		          
		          case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMngrName(null);
		        	  else
		        		  object.setMngrName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDept(null);
		        	  else
		        		  object.setDept(formatter.formatCellValue(currentCell));
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
