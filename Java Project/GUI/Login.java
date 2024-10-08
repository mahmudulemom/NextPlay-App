package GUI;

import Entities.*;
import FileManagement.*;
import GUI.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

    JTextField unametf,passwordtf;
    JButton loginButton,crtNewAcc;
    //JPasswordField passwordtf;

    Font font15Cambria = new Font("Cambria",Font.PLAIN,20);
    Font font15CambriaB = new Font("Cambria",Font.BOLD,25);
    Font font15CambriaI = new Font("Cambria",Font.ITALIC,15);
    Font font15CambriaBI = new Font("Cambria",Font.ITALIC | Font.BOLD,15);


    public Login(){
        setSize(800,400);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        JLabel nextPlaylbl = new JLabel("NextPlay");
        nextPlaylbl.setBounds(380,20,160,40);
        nextPlaylbl.setFont(font15CambriaB);
        add(nextPlaylbl);
        
        JLabel userlbl = new JLabel("User Name");
        userlbl.setBounds(250,70,100,20);
        userlbl.setFont(font15Cambria);
        add(userlbl);

        unametf = new JTextField();
        unametf.setBounds(350,70,200,20);
        unametf.setFont(font15Cambria);
        add(unametf);

        JLabel passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(250,100,100,20);
        passwordlbl.setFont(font15Cambria);
        add(passwordlbl);

        passwordtf = new JTextField();
        passwordtf.setBounds(350,100,200,20);
        passwordtf.setFont(font15Cambria);
        add(passwordtf);

        loginButton = new JButton("Login");
        loginButton.setBounds(385,150,90,25);
        loginButton.setFont(font15Cambria);
        add(loginButton);
        loginButton.addActionListener(this);

        JLabel suggNewAcc = new JLabel("Don't have a NextPlay acoount?");
        suggNewAcc.setBounds(295,200,300,20);
        suggNewAcc.setFont(font15Cambria);
        add(suggNewAcc);

        crtNewAcc = new JButton("Create New Account");
        crtNewAcc.setBounds(320,250,220,25);
        crtNewAcc.setFont(font15Cambria);
        add(crtNewAcc);
        crtNewAcc.addActionListener(this);





        setVisible(true);
    }

    public JTextField getUnametf() {
        return unametf;
    }

    public void actionPerformed(ActionEvent e){
          
        if(e.getSource() == loginButton){
            System.out.println("Login button clicked!"); 
            loginClicked();
        }
        else if(e.getSource() == crtNewAcc){
            nAccClicked();
        }
       
    }
   
        
        
    public void loginClicked() {
        String uname = unametf.getText().trim();        // Trim input to remove extra spaces
        String password = passwordtf.getText().trim();  // Trim password as well
    
        // Fetch all users from the UserManager
        UserManager um = new UserManager();
        User[] users = um.getAllUser();
    
        boolean isValid = false;  // Variable to track if login is successful
    
        // Loop through all users and check for a match
        for (User user : users) {
            // Compare the username and password
            if (user.getUserName().equals(uname) && user.getPassword().equals(password)) {
                isValid = true;
                JOptionPane.showMessageDialog(null, "Logged in Successfully");
                dispose();
                HomePage h = new HomePage(uname);
                break;
                
                  // Exit loop if login is successful
            }
           
        }
    
        // If no match was found, show the error message
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }
    }
    

    public void nAccClicked(){
        dispose();
        Signup s = new Signup();
        s.setVisible(true);

    }
    

        
    
    
}


// dispose(); for close previus frame
// Signup s = new Signup();
// s.setVisible(true);