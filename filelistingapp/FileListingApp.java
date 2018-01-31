
package filelistingapp;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


public class FileListingApp {
    
     static int size=0;
     static List l= new ArrayList();
            
    
     static void  Lister(File input) throws IOException{
         
   
         
       if(input.isDirectory()){ //if its a directory then generate all the files and folders list into an array 
           
            File lists[]=input.listFiles();// say the array is lists
           
            for(int i=0;i<lists.length;i++){
                
                if(lists[i].isFile()){
                  
                    l.add("File name : "+lists[i].getName()+" Path :"+lists[i].getAbsoluteFile());
                    //System.out.println("File name: "+lists[i].getName()+" and Path :"+lists[i].getPath());
                    size++;
                     
                   
                }
                else{
                    File temp=new File(lists[i].getPath());
                    Lister(temp);
                }
                   
                    
            }
            
        }
       else
           System.out.println("File name: "+input.getName()+" and Path :"+input.getPath());
           
       for(int i=0;i<size;i++)
    System.out.println(l.get(i));
       
         
    }
    

    
    public static void main(String[] args) throws IOException {
      
        File input = new File("C:\\Users\\Aditya\\Desktop\\TEST");
        File output = new File("C:\\Users\\Aditya\\Documents\\NetBeansProjects\\FileListingApp\\OutputNew.txt");
        
        
        if(input.isFile()){
            System.out.println("File name: "+input.getName()+" and Path :"+input.getPath());
        }
        else{
            Lister(input);
        }
        
        
        
        
    }
    
    //a function to list files
   
    
}
