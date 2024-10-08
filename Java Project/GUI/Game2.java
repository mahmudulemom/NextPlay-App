package GUI;

import Entities.*;
import FileManagement.*;
import GUI.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Game2 extends JFrame implements ActionListener{

    Font font15Cambria = new Font("Cambria",Font.PLAIN,20);
    Font font15CambriaB = new Font("Cambria",Font.BOLD,50);
    Font font15CambriaI = new Font("Cambria",Font.ITALIC,15);
    Font font15CambriaBI = new Font("Cambria",Font.ITALIC | Font.BOLD,15);

    ImageIcon logo ;

    Panel panel;
	JButton backBtn,homebtn,cart,profile,btnBuy,btnCart;
	
	JSpinner spinner;
	SpinnerNumberModel spinModel;
	
	String username;
	String gameName="Assassin's Creed Valhalla";
	String price ="4500";
    int productCode =202;

    public Game2(String username){
        setSize(1280,720);
        setLocation(300, 150);
        setTitle("NextPlay - Purchase");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 0));

        this.username = username;
        // setLayout(null);

        logo = new ImageIcon("Image/logo.jpg");
        this.setIconImage(logo.getImage());

		panel = new Panel();
		panel.setBackground(new Color(43, 44, 46));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

        JPanel nxtPlayPanel = new JPanel();
		nxtPlayPanel.setBounds(500, 20, 240, 90);
		panel.add(nxtPlayPanel);
		nxtPlayPanel.setLayout(null);
		
        JLabel nxtPlaylbl = new JLabel("NextPlay");
        nxtPlaylbl.setBounds(0, 0, 240, 90); // Adjust label size to fit the text
        nxtPlaylbl.setBackground(new Color(43, 44, 46)); // Custom RGB color
        nxtPlaylbl.setFont(font15CambriaB);
        nxtPlaylbl.setOpaque(true); // Make the background visible
        
        nxtPlaylbl.setForeground(Color.WHITE); // Set text color
       
        nxtPlayPanel.add(nxtPlaylbl);

		JPanel game1panel = new JPanel();
		game1panel.setBounds(100, 100, 283, 410);
		panel.add(game1panel);
		game1panel.setLayout(null);
		
        
        JLabel glbl1 = new JLabel();
        ImageIcon originalIcon = new ImageIcon("Image/2.jpg");
  
        // Scale the image to fit the label size
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(283, 410, Image.SCALE_SMOOTH); // Scale image
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
  
        glbl1.setIcon(scaledIcon);
        glbl1.setBounds(0, 0, 283, 410); // Make sure the bounds match the image size
        game1panel.add(glbl1);



        JLabel gameTitle = new JLabel(gameName);
		gameTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        gameTitle.setForeground(Color.WHITE);
		gameTitle.setBounds(408, 154, 426, 57);
		panel.add(gameTitle);

        JLabel companyName = new JLabel("A Ubisoft Montreal Game");
		companyName.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        companyName.setForeground(Color.WHITE);
		companyName.setBounds(408, 188, 426, 46);
		panel.add(companyName);
		
        JLabel priceLb = new JLabel("Price:  "+price);
		priceLb.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		priceLb.setBounds(408, 240, 200, 36);
        priceLb.setForeground(Color.WHITE);
		panel.add(priceLb);

        JLabel code = new JLabel("Product Code :  " + productCode);
		code.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		code.setBounds(408, 280, 200, 36);
        code.setForeground(Color.WHITE);
		panel.add(code);
	
        JLabel quantityLb = new JLabel("Quantity :");
		quantityLb.setFont(new Font("Tahoma", Font.BOLD, 17));
		quantityLb.setBounds(408, 479, 95, 24);
        quantityLb.setForeground(Color.WHITE);
		panel.add(quantityLb);

        spinModel = new SpinnerNumberModel(0,0,5,1);
		spinner = new JSpinner(spinModel);
		spinner.setBounds(498, 481, 50, 23);
		spinner.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(spinner);


        btnCart = new JButton("Add to Cart");
        btnCart.setBounds(450,550,120,30);
        btnCart.setBackground(new Color(15, 14, 15));
        btnCart.setForeground(Color.WHITE);
        panel.add(btnCart);
        btnCart.addActionListener(this);

        btnBuy = new JButton("Buy Now");
        btnBuy.setBounds(700,550,100,30);
        btnBuy.setForeground(Color.WHITE);
        btnBuy.setBackground(new Color(15, 14, 15));
        panel.add(btnBuy);
        btnBuy.addActionListener(this);

        cart = new JButton("Cart");
        cart.setBounds(1000,20,70,20);
        cart.setForeground(Color.WHITE);
        cart.setBackground(new Color(15, 14, 15));
        panel.add(cart);
        cart.addActionListener(this);


        backBtn = new JButton("Back");
        backBtn.setBounds(30,20,70,20);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(15, 14, 15));
        panel.add(backBtn);
        backBtn.addActionListener(this);

        homebtn = new JButton("Home");
        homebtn.setBounds(120,20,70,20);
        homebtn.setForeground(Color.WHITE);
        homebtn.setBackground(new Color(15, 14, 15));
        panel.add(homebtn);
        homebtn.addActionListener(this);





        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cart) {
            dispose();
            Cart c = new Cart(username);
		
		}
        if(e.getSource() == backBtn ) {
            dispose();
            Store s = new Store(username);
		
		}

        if(e.getSource() == homebtn ) {
            dispose();
            HomePage  h = new HomePage(username);
		
		}

        if(e.getSource() == btnBuy ) {
            dispose();
           Payment p = new Payment(username);
		
		}

        if(e.getSource() == btnCart ) {
           
            int quantity = (int) spinner.getValue();  //  Get the quantity from the spinner
            int unitPrice = Integer.parseInt(price);  // Convert price to integer
            int totalPrice = unitPrice * quantity;    // Calculate total price

            
            CartData cartData = new CartData(username, gameName, String.valueOf(quantity), price, String.valueOf(totalPrice),productCode);

            CartDataManager cartDataManager = new CartDataManager();
            cartDataManager.writeCart(cartData, true);

            JOptionPane.showMessageDialog(null, "Added to Cart\nTotal Price: " + totalPrice + " Taka");
            
		
		}
    }

	
}

