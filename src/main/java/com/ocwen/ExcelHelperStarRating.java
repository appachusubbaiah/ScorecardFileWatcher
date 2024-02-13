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

import com.ocwen.models.ASIT_STAR_RATING;

public class ExcelHelperStarRating {
static Logger logger = LogManager.getLogger(ExcelHelperAsitQa.class);
	
	static String[] HEADERs = { "MONTH", "request_id", "request_sent_at", "response_received_at", "star_rating","employee_custom_id"
			,"team_leader","team_leader_employee_custom_id","custom_property_location","custom_property_department","custom_property_loan_number"};
	  static String SHEET = "STAR RATING";
	  
	  public static List<ASIT_STAR_RATING> excelToObjects(InputStream is) {
		    try {
		    	logger.info("About to open work book.. " );
		      Workbook workbook = new XSSFWorkbook(is);
		      logger.info("Opened work book." );
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_STAR_RATING> objects = new ArrayList<ASIT_STAR_RATING>();
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

		        ASIT_STAR_RATING object = new ASIT_STAR_RATING();

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
		        		  object.setRequestId(null);
		        	  else
		        	  object.setRequestId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setRequestSentAt(null);
		        	  else
		        		  object.setRequestSentAt(formatter.formatCellValue(currentCell));
		            break;

		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setResponseReceivedAt(null);
		        	  else
		        		  object.setResponseReceivedAt(formatter.formatCellValue(currentCell));
		            break;
		          
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setStarRating(0);
		        	  else
		        		  object.setStarRating(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setEmployeeCustomId(null);
		        	  else
		        		  object.setEmployeeCustomId(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 6:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTeamLeader(null);
		        	  else
		        		  object.setTeamLeader(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 7:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTeamLeaderEmpCustomId(null);
		        	  else
		        		  object.setTeamLeaderEmpCustomId(formatter.formatCellValue(currentCell));
		            break; 
		            
		         case 8:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCutomPropertyDept(null);
		        	  else
		        		  object.setCutomPropertyDept(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCutomPropertyLocation(null);
		        	  else
		        		  object.setCutomPropertyLocation(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setCutomPropertyLoanNo(0);
		        	  else{
		        		  object.setCutomPropertyLoanNo(Double.parseDouble(formatter.formatCellValue(currentCell)));
		        	  }
		            break;
		            
		          default:
		            break;
		          }
		          
		          System.out.println("Cell Index :"  + cellIdx);
		          cellIdx++;
		        }

		        objects.add(object);
		      }

		      workbook.close();

		      return objects;
		    }
		    catch (IOException e) {
		    	e.printStackTrace();
		    	logger.error("fail to parse Excel file: ", e.getMessage() );
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		    
		    catch (Exception e) {
		    	e.printStackTrace();
		    	logger.error("fail to parse Excel file: ", e.getMessage() );
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
}
