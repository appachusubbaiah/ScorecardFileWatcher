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

import com.ocwen.models.ASIT_TL_IMPACT;

public class ExcelHelperAsitTLImpact {

	static Logger logger = LogManager.getLogger(ExcelHelperAsitTLImpact.class);
	
	static String[] HEADERs = { "Month", "FUSIONID", "UCID" ,"NAME", "ASST_MNGR_NAME","MNGR_NAME","LOCATION", "DEPT", "Opportunities", "Defect" };
	static String SHEET = "Sheet1";
	
	public static List<ASIT_TL_IMPACT> excelToObjects(InputStream is){
		
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
		      
		      List<ASIT_TL_IMPACT> objects = new ArrayList<ASIT_TL_IMPACT>();
		      
		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();
		        
		        ASIT_TL_IMPACT object = new ASIT_TL_IMPACT();
		        
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
		        		  object.setUcId(null);
		        	  else
		        		  object.setUcId(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setName(null);
		        	  else
		        		  object.setName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setAsstMngrName(null);
		        	  else
		        		  object.setAsstMngrName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMngrName(null);
		        	  else
		        		  object.setMngrName(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDept(null);
		        	  else
		        		  object.setDept(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setOpportunities(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setOpportunities(currentCell.getNumericCellValue());
		        		  //System.out.println("Defect % = " + currentCell.getNumericCellValue());
		        	  }
		            break;
		            
		         case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDefect(0);
		        	  else
		        	  {
		        		  //System.out.println("Setting defect %");
		        		  object.setDefect(currentCell.getNumericCellValue());
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
