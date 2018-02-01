
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
                  
                    l.add(lists[i].getName()+" "+lists[i].getAbsoluteFile());
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
      
     
        
        Scanner scan=new Scanner(System.in);
        String user_input=scan.next();
        
        
        FileReader fr=new FileReader(user_input);
                BufferedReader br=new BufferedReader(fr); 
                String line = br.readLine();
                    
                br.close();    
                fr.close();    
            
        
        File input = new File(line);
        File output = new File("C:\\Users\\Aditya\\Documents\\NetBeansProjects\\FileListingApp\\Output1.txt");
        
        if(input.isFile()){
            System.out.println("File name: "+input.getName()+" and Path :"+input.getPath());
        }
        else{
            Lister(input);
        }
        
        
        
        
    }
    
    //a function to list files
   
    
}
