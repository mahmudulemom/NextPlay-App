package Entities;

import FileManagement.*;
import GUI.*;
import Entities.*;


public class User {
    
    private String firstName;
    private String lastName;
    private String emailAdd;
    private String userName;
    private String password;
    private String confirmPassword;

    public User(){}
    public User(String firstName, String lastName, String emailAdd, String userName, String password, String confirmPassword ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdd = emailAdd;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailAdd() {
        return emailAdd;
    }
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void show(){
        
        System.out.println("First Name: "+ firstName);
        System.out.println("Last Name: "+ lastName);
        System.out.println("User Name: "+ userName);
        System.out.println("Email Address: "+ emailAdd);
        
    }

    public String getFileWriteFormat(){
        return firstName+";"+lastName+";"+emailAdd+";"+userName+";"+password+";"+confirmPassword+"\n";
    }


}
