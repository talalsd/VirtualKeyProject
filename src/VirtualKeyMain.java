import java.io.IOException;
import java.util.Scanner;


public class VirtualKeyMain {

	public static void main(String[] args) throws IOException {
		String choice;
		System.out.println("*******************************************************");
		System.out.println("**              Welcome to Virtual Key               **");
		System.out.println("*******************************************************");
		System.out.println("** Developer: Talal Bin Dulaym                       **");
		do {
			System.out.println("*******************************************************");
    		System.out.println("** Press 1 to display the files in the directory     **");
    		System.out.println("** Press 2 to see the options to perform             **");
    		System.out.println("** Press 0 to close the application                  **");
    		System.out.println("*******************************************************");
    		System.out.println();
    		Scanner input = new Scanner(System.in);
        	choice = input.next();
        	VirtualKey f = new VirtualKey();
        	if(choice.equals("1")) {
        		f.displayFiles();
        	}
        	else if(choice.equals("2")) {
        		String option;
        do {
        System.out.println();
        System.out.println("*******************************************************");
    	System.out.println("** Press 1 to add a file                             **");
    	System.out.println("** Press 2 to delete a file                          **");
    	System.out.println("** Press 3 to search for a file                      **");
    	System.out.println("** Press 9 to get back to the main menu              **");
    	System.out.println("*******************************************************");
    	System.out.println();
    	
    	option = input.next();
        if(option.equals("1")) {
    		System.out.println("Enter the name of the file:");
    		String fileName = input.next();
    		f.addFile(fileName);
        }
        else if(option.equals("2")) {
    		System.out.println("Enter the name of the file to be deleted:");
    		String fileName = input.next();
    		f.deleteFiles(fileName);
    	}
        else if(option.equals("3")) {
    		System.out.println("Enter the name of the file you want to search for:");
    		String fileName = input.next();
    		boolean result = f.searchFile(fileName);
    		if(result == true)
    			System.out.println("The file '"+fileName+"' was found");
    		else System.out.println("The file '"+fileName+"' was not found");
    	}else if(!option.equals("9"))
    		System.out.println("Invalid input !");
        
        	}while(!option.equals("9"));
        	}
        	else if(choice.equals("0")) {
        		System.out.println("Thank you for using Virtual Key :)");
        	}
        	else System.out.println("Invalid input !");
	}while(!choice.equals("0"));
}
}