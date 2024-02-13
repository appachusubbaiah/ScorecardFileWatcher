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

import com.ocwen.models.ASIT_CMS_DEFECT;
import com.ocwen.models.ASIT_ICW_QAQC;

public class ExcelHelperAsitQa {
	static Logger logger = LogManager.getLogger(ExcelHelperAsitQa.class);
	
	static String[] HEADERs = { "MONTH", "Fusion Id", "Agent", "Team Leader", "Location","MTD Scores" };
	  static String SHEET = "ICW_QAQC";
	  
	  public static List<ASIT_ICW_QAQC> excelToObjects(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);
		      SimpleDateFormat sdf=null;
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_ICW_QAQC> objects = new ArrayList<ASIT_ICW_QAQC>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_ICW_QAQC object = new ASIT_ICW_QAQC();

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
		        		  object.setAgent(null);
		        	  else
		        		  object.setAgent(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTeamLeader(null);
		        	  else
		        		  object.setTeamLeader(formatter.formatCellValue(currentCell));
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
		        		  object.setMtdScores(0);
		        	  else
		        		  object.setMtdScores(currentCell.getNumericCellValue());
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
