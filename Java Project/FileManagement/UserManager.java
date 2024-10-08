package FileManagement;

import Entities.*;
import FileManagement.*;
import GUI.*;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserManager {
    public void writeUser(User u, boolean append){
        File f = new File("DataFiles/data.txt");
        try{

            FileWriter writer  = new FileWriter(f,append);
            writer.write(u.getFileWriteFormat());
            writer.flush();
            writer.close();
        }catch(Exception ex){
            
        }
    }

    public User[] getAllUser(){
        File file = new File("DataFiles/data.txt");
        User[] users = null;
        try{

            
            Scanner sc2 = new Scanner(file);
            int count=0;
            while(sc2.hasNextLine()){
                sc2.nextLine();
                count++;
            }
            //
            users = new User[count];
            count=0;

            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(";");
                User u = new User(data[0],data[1],data[2],data[3],data[4],data[5]);                
                //int id  
                users[count] = u;
                count++;



            }

        }catch(Exception ex){
            System.out.println("Exception Occured");
        }
        return users;
    }
}
