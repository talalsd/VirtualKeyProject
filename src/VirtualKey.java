import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VirtualKey {


 void addFile(String fileName) throws IOException {
	Path path = Paths.get("/Users/talal/eclipse-workspaceEE/VirtualKeyProject/src/Directory/"+fileName);
    String s = "";
    Files.createDirectories(path.getParent());

    try {
        Files.createFile(path);
        
    } catch (FileAlreadyExistsException e) {
    	s = e.getMessage();
        System.out.println("A file with the name '"+fileName+"' already exists, try a different name");
    }
    if(s.isEmpty()) {
    		System.out.println("The file '"+fileName+"' has been added successfully");
    	}
    
    
	
}

 void displayFiles() {
     try {
	 List<String> results = new ArrayList<String>();


	 File[] files1 = new File("/Users/talal/eclipse-workspaceEE/VirtualKeyProject/src/Directory").listFiles();
	 
	 for (File file : files1) {
	     if (file.isFile()) {
	         results.add(file.getName());
	     }
	 }
	 if(results.size() > 0) {
	 String [] fileNames = new String [results.size()];
	 for(int i = 0; i < results.size(); i++) {
		 fileNames[i] = results.get(i);
	 }
	 sort(fileNames);
	 
	 for(int i = 0; i < fileNames.length; i++) {
		 System.out.println(fileNames[i]);
	 }
	 } else System.out.println("The directory is currently empty");
     }catch (Exception e) {
    	 System.out.println("The directory doesn't exist");
    	 }
	 
	 
}

void deleteFiles(String fileName) {
	if(searchFile(fileName) == true) {
	try  
	{         
	File f= new File("/Users/talal/eclipse-workspaceEE/VirtualKeyProject/src/Directory/" + fileName);            
	if(f.delete())                        
	{  
	System.out.println("The file '"+fileName+"' has been deleted successfully");     
	}  
	else  
	{  
	System.out.println("The deletion has failed");  
	}  
	}  
	catch(Exception e)  
	{  
	e.printStackTrace();  
	}  
}
	else System.out.println("The file '"+fileName+"' was not found");
}

  String[] sort(String [] fileNames) {
	
	for(int i = 0; i<fileNames.length-1; i++)   
	{  
	for (int j = i+1; j<fileNames.length; j++)   
	{  
	if(fileNames[i].toUpperCase().compareTo(fileNames[j].toUpperCase())>0)   
	{  
	String temp = fileNames[i];  
	fileNames[i] = fileNames[j];  
	fileNames[j] = temp;  
	}  
	}  
	}  
	 return fileNames;
	}
  
  boolean searchFile(String fileName) {
	  boolean flag = false;
	  List<String> results = new ArrayList<String>();


		 File[] files1 = new File("/Users/talal/eclipse-workspaceEE/VirtualKeyProject/src/Directory").listFiles();
		 
		 for (File file : files1) {
		     if (file.isFile()) {
		         results.add(file.getName());
		     }
		 }
		 String [] fileNames = new String [results.size()];
		 for(int i = 0; i < results.size(); i++) {
			 fileNames[i] = results.get(i);
		 }
		 
		 for(int i = 0; i < fileNames.length; i++) {
			 if(fileNames[i].equals(fileName)) {
				 flag = true;
				 break;
			 }
		 }
		 
		 return flag;

  }
}

