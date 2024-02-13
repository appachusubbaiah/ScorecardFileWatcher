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
import com.ocwen.models.ASIT_REFI_SOLI;

public class ExcelHelperAsitRefiSoli {
static Logger logger = LogManager.getLogger(ExcelHelperAsitRefiSoli.class);
	
	static String[] HEADERs = {"Month", "UCID", "Net Flagged", "Solicited", "Transferred","SOLICITATION_PERCENTAGE", "TRANSFER_PERCENTAGE" };
	  static String SHEET = "REFI_SOLI";
	  
	  public static List<ASIT_REFI_SOLI> excelToObjects(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      SimpleDateFormat sdf=null;
		      List<ASIT_REFI_SOLI> objects = new ArrayList<ASIT_REFI_SOLI>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_REFI_SOLI object = new ASIT_REFI_SOLI();

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
		        		  object.setUcId(null);
		        	  else
		        	  object.setUcId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setNetFlagged(0);
		        	  else
		        		  object.setNetFlagged(currentCell.getNumericCellValue());
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSolicited(0);
		        	  else
		        		  object.setSolicited(currentCell.getNumericCellValue());
		            break;
		          
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTransferred(0);
		        	  else
		        		  object.setTransferred(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setSolicitationPercentage(0);
		        	  else
		        		  object.setSolicitationPercentage(currentCell.getNumericCellValue());
		            break;
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTransferPercentage(0);
		        	  else
		        		  object.setTransferPercentage(currentCell.getNumericCellValue());
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
