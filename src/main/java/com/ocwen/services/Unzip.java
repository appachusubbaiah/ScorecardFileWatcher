package com.ocwen.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

@Service
public class Unzip {
	Logger logger = LogManager.getLogger(Unzip.class);
	@Autowired
	private Environment env;
	@Autowired
	private FileMoveService fmService;
	
	@Async
	public  void unzip(String zipFilePath, String destDir) throws IOException {
		if(this.fileIsReady(new File(zipFilePath)))
		{
		File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
		String source = zipFilePath;
	    String destination = destDir;
	    String password = "password";
	    String stateCode=null;
	    String stateDir=null;

	    try {
	         ZipFile zipFile = new ZipFile(source);
	         if (zipFile.isEncrypted()) {
	            zipFile.setPassword(password);
	         }
	         zipFile.extractAll(destination);
	         logger.info("Zip extraction complete to folder " + destDir);
	         
	         File folder = new File(destDir);
     		File[] listOfFiles = folder.listFiles();
     		
     		for (File file : listOfFiles) 
     		{
     			try
     				{
         		    	if (file.isFile())
         		    	{
             		    	stateCode=file.getName().toString().substring(0, 2);
             		    	stateDir=env.getProperty(stateCode);
         		        	System.out.println(file.getAbsolutePath());
         		        	System.out.println(stateCode);
         		        	System.out.println(destDir);
         		            fmService.moveFile(new File(file.getAbsolutePath()), stateDir);
         		    	}
         		    }
         		    catch(RuntimeException e)
         		    {
         		    	logger.info(e.getMessage());
         		    	logger.info("Continuing..");
         		    	continue;
         		    }
     		   }
     		logger.info("Deleting zip file..");
     		new File(zipFilePath).delete();
     		logger.info("Deleting zip file is complete");
	    } catch (ZipException e) {
	        e.printStackTrace();
	        logger.error(e.getMessage());
	    }
	}
				  
   }
	
	public boolean fileIsReady(File file)
	{
		System.out.println("Inside fileIsReady..");
		logger.info("Checking if file is downloaded..");
		boolean val=false;
		long s,s1;
		while (!val)
		{
			try {
			s=file.length();
			System.out.println(file.toPath());
			System.out.println("File size s= " + s);
			logger.info("File size s= " + s);
			
				Thread.sleep(10000);
				System.out.println("Sleeping..");
				logger.info("Thread sleeping..");
			s1=file.length();
			if(s==s1){
				val=true;
				System.out.println("File size s1= " + s1);
				System.out.println("val = " +val);
				logger.info("File size stopped growing");
				logger.info("File size s1= " + s1);
				Thread.sleep(10000);
				break;
			}
			else
				System.out.println("val = " +val);
			} catch (InterruptedException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				 throw new RuntimeException("Exception while waiting for file download: " + e.getMessage());
			};
		}
		
		return val;
	}
}
