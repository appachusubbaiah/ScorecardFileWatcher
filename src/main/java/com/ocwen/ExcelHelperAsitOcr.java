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

import com.ocwen.models.ASIT_ICW_TAT;
import com.ocwen.models.ASIT_OCR;

public class ExcelHelperAsitOcr {
static Logger logger = LogManager.getLogger(ExcelHelperAsitOcr.class);
	
	static String[] HEADERs = { "MONTH", "FUSION_ID", "EMP_NAME", "SPVR_NAME", "DEPT", "LOCATION","TOTAL_CALLS",
			"TOTAL_REPEAT_CALLS" , "TOTAL_CALLS_PENDING", "TOTAL_REPEAT_CALLS_PENDING", "OCR"};
	  static String SHEET = "OCR";
	  
	  public static List<ASIT_OCR> excelToObjects(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);
		      SimpleDateFormat sdf=null;
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_OCR> objects = new ArrayList<ASIT_OCR>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_OCR object = new ASIT_OCR();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMonth(null);
		        	  else
		        		  //object.setMonth(currentCell.getDateCellValue());
		        		  sdf = new SimpleDateFormat("MM/dd/yy");
	        		  		object.setMonth(sdf.parse(formatter.formatCellValue(currentCell)));
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
		        		  object.setEmpName(null);
		        	  else
		        		  object.setEmpName(formatter.formatCellValue(currentCell));
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
		        		  object.setDept(null);
		        	  else
		        		  object.setDept(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLocation(null);
		        	  else
		        		  object.setLocation(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalCalls(0);
		        	  else
		        		  object.setTotalCalls(currentCell.getNumericCellValue());
		            break;
		            
		          case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalRepeatCalls(0);
		        	  else
		        		  object.setTotalRepeatCalls(currentCell.getNumericCellValue());
		            break;  
		            
		          case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalCallsPending(0);
		        	  else
		        		  object.setTotalCallsPending(currentCell.getNumericCellValue());
		            break;
		            
		          case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalRepeatCallsPending(0);
		        	  else
		        		  object.setTotalRepeatCallsPending(currentCell.getNumericCellValue());
		            break;
		            
		          /*case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTotalRepeatCallsPending(0);
		        	  else
		        		  object.setTotalRepeatCallsPending(currentCell.getNumericCellValue());
		            break;*/
		            
		          case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setOcr(0);
		        	  else
		        		  object.setOcr(currentCell.getNumericCellValue());
		            break;
		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        objects.add(object);
		      }

		      workbook.close();

		      return objects;
		    } catch (IOException e) {
		    	logger.error("fail to parse Excel file: ", e.getMessage() );
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		    catch (Exception e) {
		    	logger.error("fail to parse Excel file: ", e.getMessage() );
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
}
