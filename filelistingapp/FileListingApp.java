/*
File Listing Application
The Application displays the lists of all available files, even those which are in directories and subdirectories
on the user's screen.


Developed by : Aditya Ghodgaonkar
For : Acadview 
*/
package filelistingapp;

import java.io.*;
import java.util.*;



public class FileListingApp {
    
     static int size=0; // for storing the size of ArrayList
     static List l= new ArrayList();
            
     
    public static void main(String[] args) throws IOException {
      
     
        
        Scanner scan=new Scanner(System.in);
        
        System.out.println("###### File Listing Application @ Acadview Project ######");
        System.out.println(" ");
        System.out.println("Enter the Path for the Text File which contains the source and destination path :");
        String user_input=scan.next();
        
        
        String input_line="Contains source path";
        String output_line="Contains destination path";
        
        //for getting the source and destination path from given text file (whose path is supplied by user)
            try (FileReader fr = new FileReader(user_input); BufferedReader br = new BufferedReader(fr)) {

                input_line = br.readLine(); //reads the first line which is Target path(for input)
                output_line = br.readLine(); // reads the second line which is Destination path (for output)

            }catch(FileNotFoundException e) {System.out.println("File not Found !"+e);}
             catch(IOException e) {System.out.print("An IO Exception Ocurred ! Sorry"+e);}

            try{

             File input = new File(input_line);
             File output = new File(output_line);

             Lister(input);
             System.out.println(size+" Files were stored at "+output_line);
             }
             catch(NullPointerException e)
             {
                 System.out.print("NullPointerException Caught"+e);
             }
         //Code to Transfer ArrayList to CSV will come here. Path for csv will be stored in output_line
         
         
        
      //end of main()  
    }
    
    
    // Recursive function Lister
    /*
    Lister() will take a single argument as a File handler which will be the source path where we have
    to work and list all the files's path (even those in directories and subdirectories)
    */
      static void  Lister(File input) throws IOException{
         
          File lists[]=input.listFiles();
   
       //if input points to a directory then generate all the files and folders list into an array called lists[]   
       if(input.isDirectory()){ 
           
            
        // say the array is lists
           
                //for each file/folder stored in array lists[]
                for(int i=0;i<lists.length;i++){

                        //check if it's a File or Directory
                        if(lists[i].isFile()){  // Also, a break condition for Recursion.
                            //if it's a file write it's path to an ArrayList
                            l.add(lists[i].getAbsoluteFile());
                            //System.out.println("File name: "+lists[i].getName()+" and Path :"+lists[i].getPath());
                            size++;


                        }
                        else{
                            // if it's not a file then initialise File handler "input" with it's path  
                            //Recall the function Lister() by passing the updated File Handler
                            File temp=new File(lists[i].getPath());
                            Lister(temp); //Recursive call
                        }


                    }
            
        }
       else{
           //if input points to a file add it to list and terminate Lister ()
            l.add(lists[0].getAbsoluteFile());
       }
           
            //This is for testing whether the file paths are been written in ArrayList or not
            for(int i=0;i<size;i++)
                 System.out.println(l.get(i));
    
  
         
    }// end of function Lister()
    
    
   
 // end of class   
}
