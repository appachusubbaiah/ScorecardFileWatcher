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
import com.ocwen.models.ASIT_NPS;

public class ExcelHelperAsitNps {

	static Logger logger = LogManager.getLogger(ExcelHelperAsitNps.class);
	static String[] HEADERs = { "MONTH", "FUSION_ID", "PROMOTER", "PASSIVE", "DETRACTOR","GRAND_TOTAL","NPS_PERCENTAGE" };
	  static String SHEET = "Sheet1";
	  
	  public static List<ASIT_NPS> excelToObjects(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);
		      SimpleDateFormat sdf=null;
		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();
		      DataFormatter formatter = new DataFormatter();
		      List<ASIT_NPS> objects = new ArrayList<ASIT_NPS>();
		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_NPS object = new ASIT_NPS();

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
		        		  object.setFusionId(formatter.formatCellValue(null));
		        	  else
		        		  object.setFusionId(formatter.formatCellValue(currentCell));
		            break;

		          case 2:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setPromoter(0);
		        	  else
		        		  object.setPromoter(currentCell.getNumericCellValue());
		            break;


		          case 3:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setPassive(0);
		        	  else
		        		  object.setPassive(currentCell.getNumericCellValue());
		            break;

		          
		          case 4:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setDetractor(0);
		        	  else
		        		  object.setDetractor(currentCell.getNumericCellValue());
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setGrandTotal(0);
		        	  else
		        		  object.setGrandTotal(currentCell.getNumericCellValue());
		            break;
		            
		          default:
		            break;
		          }
		          
		          cellIdx++;
		        }
		        double npspercent=(object.getPromoter()-object.getDetractor())/object.getGrandTotal();
		          object.setNpsPercent(npspercent);
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
