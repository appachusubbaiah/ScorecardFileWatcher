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

import com.ocwen.models.ASIT_REV_VERBAL_OCL;

public class ExcelHelperRevVerbalOcc {
	static Logger logger = LogManager.getLogger(ExcelHelperRevVerbalOcc.class);

	static String[] HEADERs = {"Month", "FUSION_ID", "AGENT", "TEAM_LEAD","IB_VERBAL_OC_OBT",
			"IB_TOT_OPP" ,"OB_VERBAL_OC_OBT" ,"OB_TOT_OPP"};
	
	  static String SHEET = "Sheet1";
	  
	  public static List<ASIT_REV_VERBAL_OCL> excelToObjects(InputStream is)
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
		      List<ASIT_REV_VERBAL_OCL> objects = new ArrayList<ASIT_REV_VERBAL_OCL>();
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

		        ASIT_REV_VERBAL_OCL object = new ASIT_REV_VERBAL_OCL();

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
		        		  object.setFusionId(null);
		        	  else
		        		  object.setFusionId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setAgent(null);
		        	  else
		        		  object.setAgent(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTl(null);
		        	  else
		        		  object.setTl(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setIbVerbalOcc(0);
		        	  else
		        		  object.setIbVerbalOcc(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setIbTotOpp(0);
		        	  else
		        		  object.setIbTotOpp(currentCell.getNumericCellValue());
		            break;

		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setObVerbalOcc(0);
		        	  else
		        		  object.setObVerbalOcc(currentCell.getNumericCellValue());
		            break;
		            
		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setObTotOpp(0);
		        	  else
		        		  object.setObTotOpp(currentCell.getNumericCellValue());
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
