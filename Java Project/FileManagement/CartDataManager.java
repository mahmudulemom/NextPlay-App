package FileManagement;

import Entities.*;
import FileManagement.*;
import GUI.*;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class CartDataManager {
    
    public void writeCart(CartData c, boolean append){
        File f = new File("DataFiles/cartData.txt");
        try{

            FileWriter writer  = new FileWriter(f,append);
            writer.write(c.getFileWriteFormat());
            writer.flush();
            writer.close();
        }catch(Exception ex){
            
        }
    }

    public CartData[] getAllCartData(){
        File file = new File("DataFiles/cartData.txt");
        CartData[] cartDatas = null;
        try{

            
            Scanner sc2 = new Scanner(file);
            int count=0;
            while(sc2.hasNextLine()){
                sc2.nextLine();
                count++;
            }
            //
            cartDatas = new CartData[count];
            count=0;

            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(";");
                CartData c = new CartData(data[0],data[1],data[2],data[3],data[4], Integer.parseInt(data[5]));                
                //int id  
                cartDatas[count] = c;
                count++;



            }

        }catch(Exception ex){
            System.out.println("Exception Occured");
        }
        return cartDatas;
    }

    public CartData searchGame(int productCode){
        CartData[] cartDatas = getAllCartData();
        for(int i=0;i<cartDatas.length;i++){
            if(cartDatas[i].getProductCode() == productCode){
                return cartDatas[i];
            }
        }
        return null;

    }

    public void removeItem(int productCode){
        CartData[] cartDatas = getAllCartData();
        for(int i=0;i<cartDatas.length;i++){
            if(cartDatas[i].getProductCode() == productCode){
                cartDatas[i] = null;
            }
        }
        for(int i=0;i<cartDatas.length;i++){
            if(cartDatas[i] != null){
                if(i==0)
                writeCart(cartDatas[i],false);
                
                else writeCart(cartDatas[i],true);
            }
        }
    }


}
