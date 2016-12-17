package vitaCost;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import infra.BaseTest;

public class InputOutputFiles extends BaseTest{
	
       public static String directoryForScreenShots = "tmpScreenShots";	
       public static String fileName= "screenshot.png";
       public static String fullPathDirectoryForScreenShots = "c:\\"+ directoryForScreenShots+ "\\" + fileName;

	
	
	public String readFromFile(String path){ 
		String theString = null ;
	try {
		InputStream is = this.getClass().getResourceAsStream(path) ;
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		theString = writer.toString();
		System.out.println(theString);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return theString;
}
	
	public static void opendir(){
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	if (!scrFile.exists()) {
	    System.out.println("creating directory: " + directoryForScreenShots);
	    boolean result = false;
	    try{
	    	scrFile.mkdir();
	        result = true;
	    } 
	    catch(SecurityException se){
	        //handle it
	    }        
	    if(result) {    
	        System.out.println("DIR created");  
	    }
	}
	}
		public static void  screenshot(){
			opendir();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("c:/tmpScreenShots/screenshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	

		public static void DeleteFile()
		{  
		    	try{
		    		File file = new File(fullPathDirectoryForScreenShots);
		    		if(file.delete()){
		    			LOGGER.config(file.getName() + " is deleted!");
		    		}else{
		    			LOGGER.config("Delete operation is failed.");
		    		}

		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
		}
}
