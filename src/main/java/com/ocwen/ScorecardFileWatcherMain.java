package com.ocwen;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.ResourceUtils;

import com.ocwen.services.ExcelService;
import com.ocwen.services.FileMoveService;
import com.ocwen.services.Unzip;



@SpringBootApplication
@EnableAsync
public class ScorecardFileWatcherMain implements CommandLineRunner
{
	
	Logger logger = LogManager.getLogger(ScorecardFileWatcherMain.class);
	
	@Autowired
	private Environment env;
	@Autowired
	private ExcelService excelService;
	@Autowired
	private Unzip uZip;
	//@Autowired
	//private FileMoveService fmService;
	
	public static void main(String[] args) {
		SpringApplication.run(ScorecardFileWatcherMain.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		    Path path = Paths.get(env.getProperty("watchFolder.path"));
		    Path path1 = Paths.get(env.getProperty("watchFolderHaf.path"));
		    String unzipPath = env.getProperty("UnzipFolder.path");
		    String stateCode=null;
		    String destDir=null;
		    
		    Map<WatchKey, Path> keys = new HashMap<>();
			  System.out.println("Hello..");
		      System.setProperty("java.awt.headless", "false");
		      System.out.println(java.awt.GraphicsEnvironment.isHeadless());
		      
		      WatchService watchService
	          = FileSystems.getDefault().newWatchService();

	        //Path path = Paths.get(System.getProperty("user.home"));
		      keys.put(
	        path.register(
	          watchService,
	            StandardWatchEventKinds.ENTRY_CREATE 
	              //,StandardWatchEventKinds.ENTRY_DELETE, 
	               //StandardWatchEventKinds.ENTRY_MODIFY
	            ),path);
	        
		      keys.put(
		      path1.register(
	  	          watchService, 
	  	            StandardWatchEventKinds.ENTRY_CREATE 
	  	              //,StandardWatchEventKinds.ENTRY_DELETE, 
	  	               //StandardWatchEventKinds.ENTRY_MODIFY
	  	            ),path1);
		      
	        logger.info("Watching folder " + path);
	        logger.info("Watching folder " + path1);
	        WatchKey key;
	        while ((key = watchService.take()) != null) {
	            for (WatchEvent<?> event : key.pollEvents()) {
	                System.out.println(
	                  "Event kind:" + event.kind() 
	                    + ". File affected: " + event.context().toString() + ".");
	                logger.info("Event kind:" + event.kind() 
                    + ". File affected: " + event.context().toString() + ".");
	                if(event.kind().toString().equals("ENTRY_CREATE"))
	                {
	                	if(keys.get(key).equals(path1) && event.context().toString().endsWith(".zip"))
	                	{
	                		logger.info("ZIP file " + event.context().toString() + " received at " + keys.get(key));
	                		this.uZip.unzip(keys.get(key)+"\\"+ event.context().toString(), unzipPath);
	                		/*File folder = new File(unzipPath);
	                		File[] listOfFiles = folder.listFiles();
	                		
	                		for (File file : listOfFiles) 
	                		{
	                			try
	                				{
		                		    	if (file.isFile())
		                		    	{
			                		    	stateCode=file.getName().toString().substring(0, 2);
			                		    	destDir=env.getProperty(stateCode);
		                		        	System.out.println(file.getAbsolutePath());
		                		        	System.out.println(stateCode);
		                		        	System.out.println(destDir);
		                		            fmService.moveFile(new File(file.getAbsolutePath()), destDir);
		                		    	}
		                		    }
		                		    catch(RuntimeException e)
		                		    {
		                		    	continue;
		                		    }
	                		   }*/
	                			
	                		}
	                		else{
	                		logger.info("Uploading " + event.context().toString());
	                		excelService.save(ResourceUtils.getFile(path + "\\" + event.context().toString()));
	                		}
	                	}
	                key.reset();
	                }
	              }	        
	            }
	}
	
 
 
    
 