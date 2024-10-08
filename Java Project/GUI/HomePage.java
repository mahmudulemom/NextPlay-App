package GUI;

import Entities.*;
import FileManagement.*;
import GUI.*;

import java.awt.Image; // Import Image class for scaling
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame implements ActionListener {

    Font font15Cambria = new Font("Cambria",Font.PLAIN,20);
    Font font15CambriaB = new Font("Cambria",Font.BOLD,25);
    Font font15CambriaI = new Font("Cambria",Font.ITALIC,15);
    Font font15CambriaBI = new Font("Cambria",Font.ITALIC | Font.BOLD,15);

    JMenuBar menubar;
    JMenu nextPlay,store,library,userDash;
    JMenuItem purchased,signOut,exit,changeAcc,goToStore,myProfile,cart;
    ImageIcon logo,bgimg,crtIcon,profileIcon;
    String userName;
  
    public HomePage(String userName){

        setSize(1280,900);
        setLocation(300, 150);
        setTitle("NextPlay");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        this.userName = userName;
        try{
            bgimg = new ImageIcon(getClass().getResource("/Image/logo.jpg"));
            // Scale the image to fit the label size
                Image img = bgimg.getImage();
                Image scaledImg = img.getScaledInstance(1280, 900, Image.SCALE_SMOOTH); // Scale image
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
    
                JLabel bgLabel = new JLabel(scaledIcon);
                bgLabel.setBounds(0,0,1280,900);
                add(bgLabel);
        }
        catch(Exception e){
            System.out.println("BackGround Image Not Found");
        }


      




        logo = new ImageIcon("Image/logo.jpg");
        this.setIconImage(logo.getImage());

        menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        

        nextPlay = new JMenu("NextPlay");
        nextPlay.setFont(font15CambriaB);

        store = new JMenu("Store");
        store.setFont(font15Cambria);

        library = new JMenu("Libray");
        library.setFont(font15Cambria);

        menubar.add(nextPlay);
        menubar.add(store);
        menubar.add(library);

        menubar.add(Box.createHorizontalGlue()); //for aside the user dash at right corner

        userDash = new JMenu(userName);
        userDash.setFont(font15Cambria);
   
        menubar.add(userDash);


        
       
        purchased = new JMenuItem("Purchased");
        signOut = new JMenuItem("Sign Out..");
        exit = new JMenuItem("Exit");
        changeAcc = new JMenuItem("Change Account");
        goToStore = new JMenuItem("Go To Store");

        myProfile = new JMenuItem("My Profile ");
        profileIcon = new ImageIcon("Image/profile.png");
        myProfile.setIcon(profileIcon);

        cart = new JMenuItem("Cart");
        crtIcon = new ImageIcon("Image/cart3.png");
        cart.setIcon(crtIcon);


        nextPlay.add(changeAcc);
        nextPlay.add(signOut);
        nextPlay.add(exit);
        store.add(goToStore);
        userDash.add(myProfile);
        userDash.add(cart);


        exit.addActionListener(this);
        signOut.addActionListener(this);
        changeAcc.addActionListener(this);
        goToStore.addActionListener(this);
        myProfile.addActionListener(this);
        cart.addActionListener(this);


        setVisible(true);
    
    }


    public void actionPerformed(ActionEvent e){
          
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == signOut){
            dispose();
            Login l = new Login();
        }
        else if(e.getSource() == changeAcc){
            changeAccClicked();
        }
        if(e.getSource() == goToStore){
            dispose();
            Store s = new Store(userName);
        }
        if(e.getSource() == cart){
            dispose();
            Cart c = new Cart(userName);
        }
       
       
    }
    



    public void changeAccClicked() {
        UserManager um = new UserManager();
        User[] users = um.getAllUser();
    
        // Create a new frame to display the list of usernames
        JFrame userFrame = new JFrame("Select Account");
        userFrame.setSize(400, 400);
        userFrame.setLayout(null);
    
        // Loop through the users array and display usernames as buttons
        int yPos = 30;
        for (int i = 0; i < users.length; i++) {
            String username = users[i].getUserName();
            JButton userButton = new JButton(username);
            userButton.setBounds(50, yPos, 200, 30);

            userFrame.add(userButton);
            yPos += 40; // Adjust vertical spacing for each button

            userButton.addActionListener(this);
            
        }
    
        userFrame.setVisible(true);  // Display the new frame with clickable usernames
    }


    
}
