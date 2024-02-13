package com.ocwen.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class FileMoveService {

	Logger logger = LogManager.getLogger(FileMoveService.class);
	public void moveFile(File file,String destDir)
	{
		try{
			
			Path result  = Files.move(Paths.get(file.getPath()),Paths.get((destDir)+"\\" + file.getName()),StandardCopyOption.REPLACE_EXISTING);
			if(result != null)
			{
			    logger.info("File " + file + " moved succesfully" );
			}
			else
			{
			    System.out.println("Failed to move the file");
			    logger.info("Failed to move the file" );
			}
		}
			catch (IOException e){
			e.printStackTrace();
			logger.error("Exception while moving file :",  e.getMessage());
			throw new RuntimeException("Exception while moving file: " + e.getMessage());
			}
		}
}
