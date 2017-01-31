package com.BankingManagementSystem.frameDesign;

import com.BankingManagementSystem.Pojo.*;
import com.BankingManagementSystem.FileHandling.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.function.ToDoubleFunction;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.xml.ws.RespectBindingFeature;

import com.BankingManagementSystem.Pojo.CustomerDetails;

public class DepositeFrame extends JFrame
{
	
	ArrayList<CustomerDetails> userlist;
	CustomerDetails r;
	JTextField tdel;
	int accNO;
    public DepositeFrame(int index) {
    	
    	accNO = index;
    	try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
    	
    	
        JFrame frame = new JFrame("DEPOSITE");
        
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        frame, "Are you sure?");
                if( result==JOptionPane.OK_OPTION){
                    // NOW we change it to dispose on close..
                    frame.setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(false);
                    frame.dispose();
                    new TransactionFrame(null);
                }
            }
        });
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setLayout(null);
        CustomerDetails customerDetails = new CustomerDetails();
        JLabel labelName = new JLabel("", JLabel.CENTER);
        labelName.setToolTipText("Name of the Customer");
        Font f1=new Font("comic sans ms",Font.BOLD,48);
        labelName.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        labelName.setForeground(new Color(47, 79, 79));
        labelName.setSize(312,37);;
        labelName.setLocation(250,306);
        contentPane.add(labelName);
        
        JLabel labelAccNo = new JLabel("Acc02233", JLabel.CENTER);
        labelAccNo.setToolTipText("Account Number");
        Font f2=new Font("comic sans ms",Font.BOLD,48);
        labelAccNo.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        labelAccNo.setForeground(new Color(47, 79, 79));
        labelAccNo.setSize(312,42);
        labelAccNo.setLocation(250,221);
        contentPane.add(labelAccNo);
        
        JLabel labelAmount = new JLabel("Amount :", JLabel.CENTER);
        Font f3=new Font("comic sans ms",Font.BOLD,48);
        labelAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        labelAmount.setForeground(Color.RED);
        labelAmount.setSize(200,50);
        labelAmount.setLocation(50,378);
        contentPane.add(labelAmount);
        
        
        JTextField tdel = new JTextField();
        tdel.setToolTipText("Enter amount to be Deposited");
        tdel.setForeground(new Color(47, 79, 79));
        tdel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        Font f5=new Font("Comic Sans MS", Font.BOLD, 22);
        tdel.setFont(f5);
        tdel.setSize(312,42);
        tdel.setLocation(250,387);
        contentPane.add(tdel);
        
        JButton bmanager = new JButton("Confirm");
        bmanager.setToolTipText("Confirmation");
        Font f4=new Font("comic sans ms",Font.BOLD,22);
        bmanager.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        bmanager.setForeground(new Color(34, 139, 34));
        bmanager.setSize(200,72);
        bmanager.setLocation(337,479);
        bmanager.setFocusable(false);
        contentPane.add(bmanager);
        
        bmanager.addActionListener((e)->
        {
        	depositmoney();
        });
        
        
        
        /*
        bmanager.addActionListener(new ActionListener() 
        {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(
                        frame, "Are you sure?");
                if( result==JOptionPane.OK_OPTION)
                {
                	
                	  userlist = CustomerDetailsFile.readDataFromFile();
                	  r.setBalance(Double.parseDouble(tdel.getText().trim()));
                	  userlist.add(r);
				      
				      CustomerDetailsFile.writeDatatoFile(userlist);
				      JOptionPane.showInputDialog(this, "Amount Deposited");
				    
				      resetFrame();
				
			    }
                	
		   }
        }
			
        							);
        							*/
        
 

        frame.setContentPane(contentPane);
        
        JLabel lblMoneyWithdrawal = new JLabel("MONEY DEPOSITED", SwingConstants.CENTER);
        lblMoneyWithdrawal.setForeground(new Color(30, 144, 255));
        lblMoneyWithdrawal.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        lblMoneyWithdrawal.setBounds(10, 11, 564, 90);
        contentPane.add(lblMoneyWithdrawal);
        
        JLabel lblAccountNumber = new JLabel("Account No :", SwingConstants.CENTER);
        lblAccountNumber.setForeground(Color.RED);
        lblAccountNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        lblAccountNumber.setBounds(10, 217, 234, 50);
        contentPane.add(lblAccountNumber);
        
        JLabel lblName = new JLabel("Name :", SwingConstants.CENTER);
        lblName.setForeground(Color.RED);
        lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        lblName.setBounds(108, 299, 142, 50);
        contentPane.add(lblName);
        frame.setSize(600,700);
        frame.setLocationByPlatform(false);
        frame.setVisible(true);
        frame.setResizable(false);
    }

public void depositmoney() {
		
	if(accNO >= 0)
    {
   	 ArrayList<CustomerDetails> userlist = CustomerDetailsFile.readDataFromFile();
   	 userlist.get(accNO).setBalance(userlist.get(accNO).getBalance() + Double.parseDouble(tdel.getText().trim()) );		 
   	 CustomerDetailsFile.writeDatatoFile(userlist);
   	 
   	 JOptionPane.showInputDialog(this, "Transfer complete");
    }
    else
    {
       JOptionPane.showInputDialog(this, "Invalid Account number");
    }
		
	}


	/*public void resetFrame()
    {
   	 this.dispose();
   	 new DepositeFrame();
    }
    
    
    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DepositeFrame();
            }
        });
    }*/
}
