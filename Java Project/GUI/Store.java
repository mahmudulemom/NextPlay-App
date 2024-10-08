package GUI;
import javax.swing.border.*;


import Entities.*;
import FileManagement.*;
import GUI.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Store extends JFrame implements ActionListener{
    
    JTextField searchTf ;
    Panel panel;
    JButton gm1Btn,gm2Btn,gm3Btn,backBtn,searchBtn,cart;
    String username;
    

    Font font15Cambria = new Font("Cambria",Font.PLAIN,20);
    Font font15CambriaB = new Font("Cambria",Font.BOLD,60);
    Font font15CambriaI = new Font("Cambria",Font.ITALIC,15);
    Font font15CambriaBI = new Font("Cambria",Font.ITALIC | Font.BOLD,15);

 public Store (String username) {
    setSize( 1280,720);
    setLocation(400,200);
    setTitle("Store");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    
    this.username = username;
      // this.setBounds(0, 0, 1280, 720);
      // this.setTitle("Store");
		// this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLayout(new BorderLayout(0, 0));
      // this.setResizable(false);
		

      // panel = new Panel();
		// panel.setBackground(new Color(102, 153, 153));
		// this.add(panel, BorderLayout.CENTER);
		// panel.setLayout(null);
	
		

    JLabel storelbl = new JLabel("Store");
    storelbl.setBounds(550,20,160,50);
    storelbl.setFont(font15CambriaB);
    add(storelbl);



    	JPanel gm1pnl = new JPanel();
       gm1pnl.setBounds(200, 150, 200, 250);
       add(gm1pnl);
       gm1pnl.setLayout(null);
		
		gm1Btn = new JButton("");
		gm1Btn.setContentAreaFilled(false);
		gm1Btn.setFocusPainted(false);
		gm1Btn.setBounds(0, 0, 200, 250);
		gm1Btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gm1pnl.add(gm1Btn);
		gm1Btn.addActionListener(this);

      JLabel glbl1 = new JLabel();
      ImageIcon originalIcon = new ImageIcon("Image/1.jpg");

      //Scale the image to fit the label size
      Image img = originalIcon.getImage();
      Image scaledImg = img.getScaledInstance(200, 250, Image.SCALE_SMOOTH); // Scale image
      ImageIcon scaledIcon = new ImageIcon(scaledImg);

      glbl1.setIcon(scaledIcon);
      glbl1.setBounds(0, 0, 200, 250); // Make sure the bounds match the image size
      gm1pnl.add(glbl1);



      JPanel gm2pnl = new JPanel();
      gm2pnl.setBounds(500, 150, 200, 250);
      add(gm2pnl);
      gm2pnl.setLayout(null);
		
		gm2Btn = new JButton("");
		gm2Btn.setContentAreaFilled(false);
		gm2Btn.setFocusPainted(false);
		gm2Btn.setBounds(0, 0, 200, 250);
		gm2Btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gm2pnl.add(gm2Btn);
      gm2Btn.addActionListener(this);
		//gm1Btn.addActionListener(this);
      
      JLabel glbl2= new JLabel();
      ImageIcon originalIcon2 = new ImageIcon("Image/2.jpg");

      //Scale the image to fit the label size
      Image img2 = originalIcon2.getImage();
      Image scaledImg2 = img2.getScaledInstance(200, 250, Image.SCALE_SMOOTH); // Scale image
      ImageIcon scaledIcon2 = new ImageIcon(scaledImg2);

      glbl2.setIcon(scaledIcon2);
      glbl2.setBounds(0, 0, 200, 250); // Make sure the bounds match the image size
      gm2pnl.add(glbl2);



      
      JPanel gm3pnl = new JPanel();
      gm3pnl.setBounds(800, 150, 200, 250);
      add(gm3pnl);
      gm3pnl.setLayout(null);
		
		gm3Btn = new JButton("");
		gm3Btn.setContentAreaFilled(false);
		gm3Btn.setFocusPainted(false);
		gm3Btn.setBounds(0, 0, 200, 250);
		gm3Btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gm3pnl.add(gm3Btn);
      gm3Btn.addActionListener(this);
		//gm1Btn.addActionListener(this);
      
      JLabel glbl3= new JLabel();
      ImageIcon originalIcon3 = new ImageIcon("Image/3.jpg");

      //Scale the image to fit the label size
      Image img3 = originalIcon3.getImage();
      Image scaledImg3 = img3.getScaledInstance(200, 250, Image.SCALE_SMOOTH); // Scale image
      ImageIcon scaledIcon3 = new ImageIcon(scaledImg3);

      glbl3.setIcon(scaledIcon3);
      glbl3.setBounds(0, 0, 200, 250); // Make sure the bounds match the image size
      gm3pnl.add(glbl3);

        backBtn = new JButton("Back");
        backBtn.setBounds(30,20,70,20);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(15, 14, 15));
        add(backBtn);
        backBtn.addActionListener(this);




      JLabel searchlbl = new JLabel("Search");
      searchlbl.setBounds(800,50,150,30);
      searchlbl.setFont(new Font("Cambria",Font.PLAIN,30));
      add(searchlbl);  


      searchTf = new JTextField();
      searchTf.setBounds(900,55,150,25);
      add(searchTf);




   searchBtn = new JButton("Click");
   searchBtn.setBounds(1060,55,100,25);
   searchBtn.setFont(new Font("Cambria",Font.PLAIN,25));
   add(searchBtn);
   searchBtn.addActionListener(this);


   cart = new JButton("Cart");
   cart.setBounds(1090,20,70,20);
   cart.setForeground(Color.WHITE);
   cart.setBackground(new Color(15, 14, 15));
    add(cart);
   cart.addActionListener(this);

 


      
      setVisible(true);

    
 }


 public void actionPerformed(ActionEvent e){
          
   if(e.getSource() == gm1Btn){
      dispose();
      Game1 g = new Game1(username);
   }

   if(e.getSource() == gm2Btn){
      dispose();
      Game2 g = new Game2(username);
   }

   if(e.getSource() == gm3Btn){
      dispose();
      Game3 g = new Game3(username);
   }

   if(e.getSource() == backBtn){
      
      dispose();
      HomePage h = new HomePage(username);
   }
   if(e.getSource() == searchBtn){
      
      searchClicked();
   }

   if(e.getSource() == cart){
      dispose();
      Cart c = new Cart(username);
   }


  
}

public void searchClicked(){
   String pcode = searchTf.getText();
   CartDataManager cm = new CartDataManager();
   CartData c = cm.searchGame(Integer.parseInt(pcode));
   if(c == null){
       JOptionPane.showMessageDialog(null,"No Game Found of Product Code : "+pcode);
   }
   else{
      JOptionPane.showMessageDialog(null, "Game Found");
      System.out.println(c.getProductCode());
      if (c.getProductCode() == 101) {
         dispose();
         Game1 g = new Game1(username);
      }
      else if(c.getProductCode() == 202){
         dispose();
         Game2 g = new Game2(username);
      }

      else if(c.getProductCode() == 303){
         dispose();
         Game3 g = new Game3(username);
      }
   }
   
}

      
    
}