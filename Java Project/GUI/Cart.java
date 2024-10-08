package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*; // This includes Font and other AWT classes
import javax.swing.table.*;

import Entities.CartData;
import FileManagement.CartDataManager;
import Entities.*;

public class Cart extends JFrame implements ActionListener {

    Font font15Cambria = new Font("Cambria", Font.PLAIN, 20);
    Font font15CambriaB = new Font("Cambria", Font.BOLD, 50);

    ImageIcon logo;
    JPanel panel;
    DefaultTableModel tmodel;
    JTable table;
    JButton buyButton, bckButton , rmvButton;
    String username;
    JTextField rmVTf;

    public Cart(String username) {
        setSize(1280, 720);
        setLocation(300, 150);
        setTitle("NextPlay - Cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.username = username;

        logo = new ImageIcon("Image/logo.jpg");
        this.setIconImage(logo.getImage());
        setLayout(null);

       
        JLabel nextPlaylbl = new JLabel("NextPlay");
        nextPlaylbl.setFont(font15CambriaB);
        nextPlaylbl.setBounds(50, 40, 300, 60);
        add(nextPlaylbl);

      
        JLabel rmv = new JLabel("Product Code:");
        rmv.setFont(font15Cambria);
        rmv.setBounds(50, 120, 200, 30);
        add(rmv);

        rmVTf = new JTextField();
        rmVTf.setBounds(50, 160, 200, 30);
        add(rmVTf);

        rmvButton = new JButton("Remove Item From the Cart");
        rmvButton.setBounds(50, 210, 200, 30);
        add(rmvButton);
        rmvButton.addActionListener(this);

   
        tmodel = new DefaultTableModel();
        tmodel.addColumn("Name");
        tmodel.addColumn("Product Code");
        tmodel.addColumn("Single Unit Price");
        tmodel.addColumn("Quantity");
        tmodel.addColumn("Total Price");

        table = new JTable(tmodel);
        JScrollPane tablescrl = new JScrollPane(table);
        tablescrl.setBounds(400, 40, 800, 400);
        add(tablescrl);
        loadData(); // Load data into the table

      
        buyButton = new JButton("Buy Now");
        buyButton.setFont(font15Cambria);
        buyButton.setBounds(850, 460, 150, 50);
        add(buyButton);
        buyButton.addActionListener(this);

        bckButton = new JButton("Back");
        bckButton.setFont(font15Cambria);
        bckButton.setBounds(650, 460, 150, 50);
        add(bckButton);
        bckButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buyButton) {
            dispose();
            Payment p = new Payment(username);
        }

        if (e.getSource() == bckButton) {
            dispose();
            Store s = new Store(username);
        }

        if (e.getSource() == rmvButton) {
            String employeeID = rmVTf.getText();
            removeEmployee(employeeID);
          //itemRemoved();
        }
    }

    public void loadData() {
        // Load data into the table
        CartDataManager cdm = new CartDataManager();
        CartData[] cartDatas = cdm.getAllCartData();
        for (CartData cartData : cartDatas) {
            tmodel.addRow(cartData.getTableRow());
        }
    }

    // public void itemRemoved() {
    //     String pcode = rmVTf.getText();
        
    //     try {
    //         int productCode = Integer.parseInt(pcode);
    //         CartDataManager cm = new CartDataManager();
            
    //         CartData foundItem = cm.searchGame(productCode);
    //         if (foundItem != null) {
    //             cm.removeItem(productCode);  
    //             refreshTable();  
    //             JOptionPane.showMessageDialog(null, "Item removed successfully.");
    //         } else {
    //             JOptionPane.showMessageDialog(null, "Product Code not found.");
    //         }
    //     } catch (NumberFormatException ex) {
    //         JOptionPane.showMessageDialog(null, "Please enter a valid Product Code.");
    //     }
    // }




     private void removeEmployee(String employeeID) {
        try {
            File inputFile = new File("DataFiles/cartData.txt");
            File tempFile = new File("./temp.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 FileWriter writer = new FileWriter(tempFile)) {

                String lineToRemove = "Employee ID: " + employeeID;
                String currentLine;

                while ((currentLine = reader.readLine()) != null) {
                    // If the line does not contain the employee ID, write it to the temp file
                    if (!currentLine.contains(lineToRemove)) {
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                }
            }

            // Delete the original file and rename the temp file to the original file name
            if (!inputFile.delete()) {
                System.out.println("Failed to delete the original file.");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Failed to rename the temp file.");
            }
            JOptionPane.showMessageDialog(this, "Employee with ID " + employeeID + " removed successfully.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




  public void refreshTable(){
    tmodel.getDataVector().removeAllElements();
    CartDataManager cm = new CartDataManager();
    CartData[] cartDatas = cm.getAllCartData(); 
    for(int i=0;i<cartDatas.length;i++){
        tmodel.addRow(cartDatas[i].getTableRow());
    }

}
}
