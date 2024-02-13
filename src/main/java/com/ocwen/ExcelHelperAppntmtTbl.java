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

import com.ocwen.models.ASIT_APPOINTMENTS_TABLE;

public class ExcelHelperAppntmtTbl {

	static Logger logger = LogManager.getLogger(ExcelHelperAppntmtTbl.class);
	static String[] HEADERs = { "MONTH", "EMP ID", "UCID", "NAME", "RPC","DIALLED WITHIN 30 MINS" };
	  static String SHEET = "RMIC";
	  
	  public static List<ASIT_APPOINTMENTS_TABLE> excelToObjects(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);
		      SimpleDateFormat sdf=null;
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_APPOINTMENTS_TABLE> objects = new ArrayList<ASIT_APPOINTMENTS_TABLE>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_APPOINTMENTS_TABLE object = new ASIT_APPOINTMENTS_TABLE();

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
		        		  object.setEmpId(formatter.formatCellValue(null));
		        	  else
		        		  object.setEmpId(formatter.formatCellValue(currentCell));
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
		        		  object.setRpc(0);
		        	  else
		        		  object.setRpc(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDialedWithin30Mins(0);
		        	  else
		        		  object.setDialedWithin30Mins(currentCell.getNumericCellValue());
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
		    	logger.error("fail to parse Excel file: ",e.getMessage());
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }

		    catch (Exception e) {
		    	logger.error("fail to parse Excel file: ",e.getMessage());
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
	  }
}
