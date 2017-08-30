package utilities;

import java.io.File;

public class CreateDirectory
{
	
	public static void createFolder(String FolderPath,String FolderName)
	{
		String dir_Screenshots = FolderPath + FolderName;
	
	    File directory = new File(dir_Screenshots);
  
	    //only create folder dir_Screenshots if doesn't exists
	    if (!directory.exists()) 
	    {
	        System.out.println("creating directory: " + directory);
	        boolean result = false;
	
	        try
	        {
	        	directory.mkdir();
	            result = true;
	        } 
	        catch(SecurityException se)
	        {
	            //handle it
	        }        
	        if(result) 
	        {    
	            System.out.println("DIR is created");  
	        }
	        else
	        {
	        	System.out.println("DIR can't be created");
	        }
	    }
	    else
	    {
	    	System.out.println("DIR is already present");
	    }
	}
}
	
