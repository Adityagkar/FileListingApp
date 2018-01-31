
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
        
      
     
        
       /*Step 1 : 
            Taking the Text File's URL which contains the SOURCE URL where we have to lists all 
            the files (even those in directories, if any)
       */
       
        String user_input=JOptionPane.showInputDialog("Enter the File's URL (which contains the URL for showing the Listing");
        
        
        File fobject=new File(user_input);
       char[] ch=new  char[user_input.length()];
        
                try {
                        FileReader in_stream=new FileReader(fobject);
                        int c;
                        int i=0;
                      
        //Extracting the path contained in given Text File using FileReader
                    while((c=in_stream.read())!=-1){
                        
                         ch[i]=(char)c;
                         //stored each character extracted in an character array
                         i++;
                    }
                }catch (FileNotFoundException ex){
                    
                        System.out.print("File not Found!!");  
                        
                }
        
        //converted the character array to a String
        String path= new String(ch);

        
        File input = new File(path);
        File output = new File("C:\\Users\\Aditya\\Documents\\NetBeansProjects\\FileListingApp\\OutputNew.txt");
        
        System.out.println(path);
        
        if(input.isFile()){
            System.out.println("File name: "+input.getName()+" and Path :"+input.getPath());
        }
        else{
            Lister(input);
        }
        
        
        
        
    }
    
    //a function to list files
   
    
}
