
package filelistingapp;

import java.io.*;
import java.util.*;


public class FileListingApp {
    
     static int size=0; // for storing the size of ArrayList
     static List l= new ArrayList();
            
     
    public static void main(String[] args) throws IOException {
      
     
        
        Scanner scan=new Scanner(System.in);
        
        System.out.println("###### File Listing Application @ Acadview Project ######");
        System.out.println("Enter the Path for the Text File which contains the source and destination path :");
        String user_input=scan.next();
        
        
        String input_line="Contains source path";
        String output_line="Contains destination path";
        
        
         try (FileReader fr = new FileReader(user_input); BufferedReader br = new BufferedReader(fr)) {
             input_line = br.readLine();
             output_line = br.readLine();
         }catch(FileNotFoundException e) {
            System.out.println("File not Found !");
     
}
         
         
            
        File input = new File(input_line);
        File output = new File(output_line);
        
       
        Lister(input);
        
         //Code to Transfer ArrayList to CSV will come here. Path for csv will be stored in output_line
         
         
        
      //end of main()  
    }
    
    
    // Recursive function Lister
    /*
    Lister() will take a single argument as a File handler which will be the source path where we have
    to work and list all the files's path (even those in directories and subdirectories)
    */
      static void  Lister(File input) throws IOException{
         
   
       //if input points to a directory then generate all the files and folders list into an array called lists[]   
       if(input.isDirectory()){ 
           
            File lists[]=input.listFiles();
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
            l.add(lists[i].getAbsoluteFile());
       }
           
    //This is for testing whether the file paths are been written in ArrayList or not
            for(int i=0;i<size;i++)
                 System.out.println(l.get(i));
    
  
         
    }
    
   
    
}
