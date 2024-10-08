package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BPayment extends JFrame implements ActionListener {
    JTextField bName,bAccountName ,bAccountNo;
    JPasswordField BpCode;
    JButton payB;
    String username;

    Font font15Cambria = new Font("Cambria", Font.PLAIN, 18);
    Font font15CambriaB = new Font("Cambria", Font.BOLD, 30);
    Font font15CambriaI = new Font("Cambria", Font.ITALIC, 15);
    Font font15CambriaBI = new Font("Cambria", Font.ITALIC | Font.BOLD, 15);

    public BPayment(String username) {
        setSize(800, 800);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        this.username = username;

        JLabel bPaymentlbl = new JLabel(" Bank Payment ");
        bPaymentlbl.setBounds(340, 20, 250, 40);
        bPaymentlbl.setFont(font15CambriaB);
        add(bPaymentlbl);

        JLabel bankNamelbl = new JLabel("Bank Name ");
        bankNamelbl.setBounds(250, 70, 190, 20);
        bankNamelbl.setFont(font15Cambria);
        add( bankNamelbl);

        bName = new JTextField();
        bName.setBounds(250, 100, 200, 20);
        bName.setFont(font15Cambria);
        add( bName);

        JLabel bAccountNamelbl = new JLabel(" Bank Account Name  ");
        bAccountNamelbl.setBounds(250, 130, 200, 20);
        bAccountNamelbl.setFont(font15Cambria);
        add(bAccountNamelbl);

        bAccountName= new JTextField();
        bAccountName.setBounds(250, 160, 200, 20);
        bAccountName.setFont(font15Cambria);
        add(bAccountName);   

        JLabel bAccountNolbl = new JLabel("Account Number");
        bAccountNolbl.setBounds(250, 190, 200, 20);
        bAccountNolbl.setFont(font15Cambria);
        add(bAccountNolbl);

        bAccountNo= new JTextField();
        bAccountNo.setBounds(250, 220, 200, 20);
        bAccountNo.setFont(font15Cambria);
        add(bAccountNo);

        JLabel  BpCodelbl = new JLabel("Pin Code ");
        BpCodelbl.setBounds(250, 250, 200, 20);
        BpCodelbl.setFont(font15Cambria);
        add( BpCodelbl);

        BpCode = new JPasswordField();
        BpCode.setBounds(250, 280, 200, 20);
        BpCode.setFont(font15Cambria);
        add( BpCode);

    
        payB = new JButton("Pay");
        payB.setBounds(250, 320, 200, 30);
        payB.setFont(font15Cambria);
        payB.addActionListener(this);  
        add(payB);

        
        setVisible(true);
    }

    public void payClick() {
        String bankName = bName.getText();
        String bankAccountName  = bAccountName.getText();
        String bankAccountNo = bAccountNo.getText();
        String pinCode = BpCode.getText();
        if (bankName.isEmpty() ||  bankAccountName.isEmpty() || bankAccountNo.isEmpty() || pinCode.isEmpty()) {
             
            JOptionPane.showMessageDialog(this, "Please fill up the form!", "Form Incomplete", JOptionPane.WARNING_MESSAGE);
        } else {
             
            JOptionPane.showMessageDialog(this, "Payment Done", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
        

        

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payB) {
            payClick();
        }
    }
    
    
}   