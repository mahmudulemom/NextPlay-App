package GUI;

import Entities.*;
import FileManagement.*;
import GUI.*;




import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import FileManagement.UserManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener{

    JTextField fNametf,lNametf,uNametf,emailtf;
    JButton signUpButton,backLogin;
    JPasswordField passwordtf,cPasswordtf;

    Font font15Cambria = new Font("Cambria",Font.PLAIN,20);
    Font font15CambriaB = new Font("Cambria",Font.BOLD,25);
    Font font15CambriaI = new Font("Cambria",Font.ITALIC,15);
    Font font15CambriaBI = new Font("Cambria",Font.ITALIC | Font.BOLD,15);

    public Signup(){

        setSize(800,800);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel signUplbl = new JLabel("SignUp");
        signUplbl.setBounds(380,20,160,40);
        signUplbl.setFont(font15CambriaB);
        add(signUplbl);
        

        JLabel fNamelbl = new JLabel("First Name");
        fNamelbl.setBounds(250,70,100,20);
        fNamelbl.setFont(font15Cambria);
        add(fNamelbl);

        fNametf = new JTextField();
        fNametf.setBounds(250,100,200,20);
        fNametf.setFont(font15Cambria);
        add(fNametf);

        JLabel lNamelbl = new JLabel("Last Name");
        lNamelbl.setBounds(250,130,100,20);
        lNamelbl.setFont(font15Cambria);
        add(lNamelbl);

        lNametf = new JTextField();
        lNametf.setBounds(250,160,200,20);
        lNametf.setFont(font15Cambria);
        add(lNametf);

        
        JLabel uNamelbl = new JLabel("User Name");
        uNamelbl.setBounds(250,190,100,20);
        uNamelbl.setFont(font15Cambria);
        add(uNamelbl);

        uNametf = new JTextField();
        uNametf.setBounds(250,220,200,20);
        uNametf.setFont(font15Cambria);
        add(uNametf); 

        JLabel emaillbl = new JLabel("Email Adress");
        emaillbl.setBounds(250,250,150,20);
        emaillbl.setFont(font15Cambria);
        add(emaillbl);

        emailtf = new JTextField();
        emailtf.setBounds(250,280,200,20);
        emailtf.setFont(font15Cambria);
        add(emailtf);

        JLabel passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(250,310,100,20);
        passwordlbl.setFont(font15Cambria);
        add(passwordlbl);

        passwordtf = new JPasswordField();
        passwordtf.setBounds(250,340,200,20);
        passwordtf.setFont(font15Cambria);
        add(passwordtf);

        JLabel cPasswordlbl = new JLabel("Confirm Password");
        cPasswordlbl.setBounds(250,370,200,20);
        cPasswordlbl.setFont(font15Cambria);
        add(cPasswordlbl);

        cPasswordtf = new JPasswordField();
        cPasswordtf.setBounds(250,400,200,20);
        cPasswordtf.setFont(font15Cambria);
        add(cPasswordtf);


        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(250,430,100,25);
        signUpButton.setFont(font15Cambria);
        add(signUpButton);
        signUpButton.addActionListener(this);

        backLogin = new JButton("Back to Login");
        backLogin.setBounds(400,430,150,25);
        backLogin.setFont(font15Cambria);
        add(backLogin);
        backLogin.addActionListener(this);


        setVisible(true);


    

    }

    public void actionPerformed(ActionEvent e){
          
        if(e.getSource() == signUpButton){
            signupClicked();
        }
        else if(e.getSource() == backLogin){
            backLoginClicked();
        }
    }


    public void signupClicked(){
        String fname = fNametf.getText();
        String lname = lNametf.getText();
        String email = emailtf.getText();
        String uname = uNametf.getText();
        String password = passwordtf.getText();
        String cPassword = cPasswordtf.getText();
        if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || uname.isEmpty() || password.isEmpty() || cPassword.isEmpty() ){
            JOptionPane.showMessageDialog(null,"Please Fill All The Fields");
        
        }
        else{
            if(password.equals(cPassword)){
                UserManager um = new UserManager();
                User u = new User(fname, lname, email, uname, password, cPassword);
                um.writeUser(u, true);
                JOptionPane.showMessageDialog(null,"Signed Up Successfully");
        
                }
                else  JOptionPane.showMessageDialog(null,"Password & Confirm Password didn't match.");
                
        }
       
        
    }

    public void backLoginClicked(){
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
    }
}
