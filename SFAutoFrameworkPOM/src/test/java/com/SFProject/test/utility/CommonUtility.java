package com.SFProject.test.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class CommonUtility {
public FileInputStream stream=null;
	
	public Properties loadFile(String filename){
		Properties propertyFile = new Properties();
		String  PropertyFilePath=null;
		switch(filename) {
		case "sfData":
			
			PropertyFilePath =constants.APPLICATION_PROPERTIES_PATH;
							break;
		//case "studentRegistrationProperties":
			//PropertyFilePath =constants.GENERATE_REPORT_PATH;
					//	break;
		}
		try {
			stream=new FileInputStream(PropertyFilePath);
			propertyFile.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyFile;
	}
	
	public String getApplicationProperty(String Key,Properties propertyFile) {
		String value = propertyFile.getProperty(Key);
		System.out.println("Property we got from the file is::" + value);
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public HashMap getAllPropertiesAsSet(Properties propertyFile) {
		
		return new HashMap(propertyFile);
	}

}
