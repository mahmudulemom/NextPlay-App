package Entities;


import FileManagement.*;
import GUI.*;
import Entities.*;



import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CartData {

    private String username;
	private String gameName;
	private String quantity;
	private String price;
    private String totalPrice;
    private int productCode;


    public CartData(){}


    public CartData(String username,String gameName,String quantity,String price, String totalPrice,int productCode){
		this.username=username;
		this.gameName=gameName;
		this.quantity=quantity;
		this.price=price;
        this.totalPrice = totalPrice;
        this.productCode = productCode;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getGameName() {
        return gameName;
    }


    public void setGameName(String gameName) {
        this.gameName = gameName;
    }


    public String getQuantity() {
        return quantity;
    }


    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    

    public String getFileWriteFormat(){
        return username + ";" + gameName + ";" + quantity + ";" + price + ";" + totalPrice + ";" + productCode + "\n";
    }

    public Object[] getTableRow(){
        return new Object[] {gameName,productCode,price,quantity,totalPrice};
    }
    
}