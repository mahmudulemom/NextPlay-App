 
package GUI;

import Entities.*;
import FileManagement.*;
import GUI.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame implements ActionListener {

    JButton pwBks, pwBnk;
    String username;

    Font font15Cambria = new Font("Cambria", Font.PLAIN, 15);
    Font font15CambriaB = new Font("Cambria", Font.BOLD, 17);
    Font font15CambriaI = new Font("Cambria", Font.ITALIC, 15);
    Font font15CambriaBI = new Font("Cambria", Font.ITALIC | Font.BOLD, 15);

    public Payment(String username) {
        setSize(400, 400);
        setLocation(200,  200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        this.username = username;

        JLabel paymentlbl = new JLabel("Payment ");
        paymentlbl.setBounds(140, 20, 170, 40);
        paymentlbl.setFont(font15CambriaB);
        add(paymentlbl);

        pwBks = new JButton("Bikash");
        pwBks.setBounds(80, 70, 120, 40);
        pwBks.setFont(font15Cambria);
        add(pwBks);
        pwBks.addActionListener(this);

        pwBnk = new JButton("Card");
        pwBnk.setBounds(210, 70, 120, 40);  
        pwBnk.setFont(font15Cambria);
        add(pwBnk);
        pwBnk.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == pwBks){
            dispose();
            BkPayment b = new BkPayment(username);
        }
        
    

        if(e.getSource() == pwBnk){
            dispose();
            BPayment b = new BPayment(username);
        }
    }
    }
       
 
