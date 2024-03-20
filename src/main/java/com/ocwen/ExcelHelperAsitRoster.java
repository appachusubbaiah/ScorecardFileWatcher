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

import com.ocwen.models.ASIT_ROSTER_TABLE;
import com.ocwen.models.ASIT_SKILLPORT;

public class ExcelHelperAsitRoster {
	static Logger logger = LogManager.getLogger(ExcelHelperAsitRoster.class);

	static String[] HEADERs = {"MONTH", "FUSION_ID", "UCID", "NAME","DESIGNATION","TEAM LEADER", "LOCATION", "DEPT", "QA_COMMENTS","BIS_COMMENTS","NTID","OCWEN_EMAIL","BU_SUB_PROCESS","ASST_MNGR_NAME","MNGR_NAME","FINAL STATUS","LIVEVOX_ID","TL_FUSIONID"};
	
	  static String SHEET = "Sheet1";
	  
	  public static List<ASIT_ROSTER_TABLE> excelToObjects(InputStream is)
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
		      SimpleDateFormat sdf=null;
		      List<ASIT_ROSTER_TABLE> objects = new ArrayList<ASIT_ROSTER_TABLE>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ASIT_ROSTER_TABLE object = new ASIT_ROSTER_TABLE();

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
		        		  object.setDesignation(null);
		        	  else
		        		  object.setDesignation(formatter.formatCellValue(currentCell));
		            break;
		            
		          case 5:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTeamLeader(null);
		        	  else
		        		  object.setTeamLeader(formatter.formatCellValue(currentCell));
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
		        		  object.setQaComments(null);
		        	  else
		        		  object.setQaComments(formatter.formatCellValue(currentCell));
		            break;  
		            
		         case 9:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBisComments(null);
		        	  else
		        		  object.setBisComments(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 10:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setNtid(null);
		        	  else
		        		  object.setNtid(formatter.formatCellValue(currentCell));
		        	  break;
		         case 11:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setEmailId(null);
		        	  else
		        		  object.setEmailId(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 12:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setBuSubProcess(null);
		        	  else
		        		  object.setBuSubProcess(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 13:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setAsstMngrName(null);
		        	  else
		        		  object.setAsstMngrName(formatter.formatCellValue(currentCell));
		            break;
		          
		         case 14:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setMngrName(null);
		        	  else
		        		  object.setMngrName(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 15:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setFinalStatus(null);
		        	  else
		        		  object.setFinalStatus(formatter.formatCellValue(currentCell));
		            break;
		        
		         case 16:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setLivevoxId(null);
		        	  else
		        		  object.setLivevoxId(formatter.formatCellValue(currentCell));
		            break;
		            
		         case 17:
		        	  if(formatter.formatCellValue(currentCell).length()==0
	        		  || formatter.formatCellValue(currentCell).equals(""))
		        		  object.setTlFusionId(null);
		        	  else
		        		  object.setTlFusionId(formatter.formatCellValue(currentCell));
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
