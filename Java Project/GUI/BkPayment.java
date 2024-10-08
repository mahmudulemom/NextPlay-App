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


public class BkPayment extends JFrame implements ActionListener {
    JTextField pMNo, pCode, pDate;
    JPasswordField pPass;
    JButton payB;
    String username;

    Font font15Cambria = new Font("Cambria", Font.PLAIN, 18);
    Font font15CambriaB = new Font("Cambria", Font.BOLD, 30);
    Font font15CambriaI = new Font("Cambria", Font.ITALIC, 15);
    Font font15CambriaBI = new Font("Cambria", Font.ITALIC | Font.BOLD, 15);

    public BkPayment(String username) {
        setSize(800, 800);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        this.username = username;

        JLabel paymentlbl = new JLabel("Online Payment ");
        paymentlbl.setBounds(340, 20, 250, 40);
        paymentlbl.setFont(font15CambriaB);
        add(paymentlbl);

        JLabel mNolbl = new JLabel("Mobile Number ");
        mNolbl.setBounds(250, 70, 190, 20);
        mNolbl.setFont(font15Cambria);
        add(mNolbl);

        pMNo = new JTextField();
        pMNo.setBounds(250, 100, 200, 20);
        pMNo.setFont(font15Cambria);
        add(pMNo);

        JLabel pPasslbl = new JLabel("Password ");
        pPasslbl.setBounds(250, 130, 200, 20);
        pPasslbl.setFont(font15Cambria);
        add(pPasslbl);

        pPass = new JPasswordField();
        pPass.setBounds(250, 160, 200, 20);
        pPass.setFont(font15Cambria);
        add(pPass);   

        JLabel pCodelbl = new JLabel("Code");
        pCodelbl.setBounds(250, 190, 200, 20);
        pCodelbl.setFont(font15Cambria);
        add(pCodelbl);

        pCode = new JTextField();
        pCode.setBounds(250, 220, 200, 20);
        pCode.setFont(font15Cambria);
        add(pCode);

        JLabel pDatelbl = new JLabel("Date");
        pDatelbl.setBounds(250, 250, 200, 20);
        pDatelbl.setFont(font15Cambria);
        add(pDatelbl);

        pDate = new JTextField();
        pDate.setBounds(250, 280, 200, 20);
        pDate.setFont(font15Cambria);
        add(pDate);

    
        payB = new JButton("Pay");
        payB.setBounds(250, 320, 200, 30);
        payB.setFont(font15Cambria);
        payB.addActionListener(this);  
        add(payB);

        /*ImageIcon icon = new ImageIcon("Entities/back.png" );  // Load the image
        JLabel imgLabel = new JLabel(icon);  // Place it inside a JLabel
        imgLabel.setBounds(50, 400, 300, 200);  // Set bounds for the image
        add(imgLabel); */

        setVisible(true);
    }

    public void payClick() {
        String mobileNumber = pMNo.getText();
        String password = pPass.getText();
        String code = pCode.getText();
        String date = pDate.getText();
        if (mobileNumber.isEmpty() || password.isEmpty() || code.isEmpty() || date.isEmpty()) {
             
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
