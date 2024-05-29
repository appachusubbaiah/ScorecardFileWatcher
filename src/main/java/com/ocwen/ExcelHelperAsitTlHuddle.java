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

import com.ocwen.models.ASIT_TL_HUDDLE;

public class ExcelHelperAsitTlHuddle {
static Logger logger = LogManager.getLogger(ExcelHelperAsitTlHuddle.class);
	
	static String[] HEADERs = { "MONTH", "FUSIONID", "Supervisor" ,"Completed"};
	static String SHEET = "Sheet1";
	
	public static List<ASIT_TL_HUDDLE> excelToObjects(InputStream is){
		
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
		      
		      List<ASIT_TL_HUDDLE> objects = new ArrayList<ASIT_TL_HUDDLE>();
		      
		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();
		        
		        ASIT_TL_HUDDLE object = new ASIT_TL_HUDDLE();
		        
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
		        		  object.setSupervisor(null);
		        	  else
		        		  object.setSupervisor(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCompleted(null);
		        	  else
		        	  {
		        		  object.setCompleted(formatter.formatCellValue(currentCell));
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