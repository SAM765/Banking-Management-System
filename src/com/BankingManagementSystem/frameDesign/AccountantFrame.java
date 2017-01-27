package com.BankingManagementSystem.frameDesign;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

class Accountantform extends JFrame
{

	private JPanel accountantPage ;
	private Panel DisplayPage;
	private JButton btnAddAccount;
	private JButton btnRemoveAccount;
	private JButton btnUpdateDetails;
	private JButton btnTransaction;
	private JLabel lblViewDetals;
	
	private JComboBox View;
	
	public Accountantform() 
	{
		formOpen();
		
	}
	
	

	private void formOpen() 
	{
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		setTitle("Accountant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 700, 600);
		accountantPage = new JPanel();
		accountantPage .setBackground(new Color(130, 255, 50));
		accountantPage .setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(accountantPage );
		accountantPage .setLayout(null);
		
		btnAddAccount = new JButton("ADD ACCOUNT ");
		btnAddAccount.setForeground(new Color(0, 70, 60));
		btnAddAccount.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnAddAccount.setBounds(180,70,300,60);
		accountantPage.add(btnAddAccount);
		
		btnRemoveAccount = new JButton("REMOVE ACCOUNT ");
		btnRemoveAccount.setForeground(new Color(0, 20, 60));
		btnRemoveAccount.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnRemoveAccount.setBounds(180,160,300,60);
		accountantPage.add(btnRemoveAccount);
		
		btnUpdateDetails = new JButton("UPDATE ACCOUNT ");
		btnUpdateDetails.setForeground(new Color(0, 20, 60));
		btnUpdateDetails.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnUpdateDetails.setBounds(180,250,300,60);
		accountantPage.add(btnUpdateDetails);
	
		btnTransaction = new JButton("TRANSACTION");
		btnTransaction.setForeground(new Color(0, 20, 60));
		btnTransaction.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		btnTransaction.setBounds(180,340,300,60);
		accountantPage.add(btnTransaction);
	
		lblViewDetals = new JLabel("VIEW ACCOUNT:");
		lblViewDetals.setForeground(new Color(0, 20, 60));
		lblViewDetals.setFont(new Font("Tekton Pro Cond", Font.BOLD, 30));
		lblViewDetals.setBounds(50, 430, 200, 60);
		accountantPage.add(lblViewDetals);
		
	/*	
		txtAddAccount = new JTextField();
		txtAddAccount.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAddAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddAccount.setBounds(270, 75, 360, 40);
		accountantPage.add(txtAddAccount);
		txtAddAccount.setColumns(10);
		

		txtRemoveAccount = new JTextField();
		txtRemoveAccount.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtRemoveAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRemoveAccount.setBounds(270, 168, 360, 40);
		accountantPage.add(txtRemoveAccount);
		txtRemoveAccount.setColumns(10);
		
		txtUpdate = new JTextField();
		txtUpdate.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtUpdate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUpdate.setBounds(270, 255, 360, 40);
		accountantPage.add(txtUpdate);
		txtUpdate.setColumns(10);
		
		txtTransaction = new JTextField();
		txtTransaction.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtTransaction.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTransaction.setBounds(270, 345, 360, 40);
		accountantPage.add(txtTransaction);
		txtTransaction.setColumns(10);*/
		
		String str[] = {"Account wise","All Accounts"};
		
		View = new JComboBox(str);
		View.setBounds(220, 435, 360, 40);
		View.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		accountantPage.add(View);
				
	
	}	
}
public  class AccountantFrame
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Accountantform accountant = new Accountantform();
					accountant.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}