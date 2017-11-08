import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class View extends JFrame {
	
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	JLabel label9 = new JLabel();
	JButton back = new JButton("Back");
	View(String line){
	
		int i=1;	
		String[]  words = line.split(" / ");
		for (String word : words) 
		{
			if(i==1)
				label3.setText(word);
			if(i==3)
				label7.setText(word);
			if(i==4)
				label9.setText(word);
			if(i==2)
				label5.setText(word);
				i++;
		}
		label1.setText("!! VIEW RECORD !!");
		label2.setText(" Name :- ");
		label4.setText(" Roll No. :- ");
		label6.setText(" Branch :- ");
		label8.setText(" Phone No. :- ");
		setTitle("Welcome to Student Managment System ");
		setSize(350,300);
		setLocation(300,280);
		panel.setLayout (null); 
		label1.setBounds(90,30,300,20);
		label2.setBounds(40,70,150,20);
		label3.setBounds(120,70,150,20);
		label4.setBounds(40,100,150,20);
		label5.setBounds(120,100,150,20);
		label6.setBounds(40,130,150,20);
		label7.setBounds(120,130,150,20);
		label8.setBounds(40,160,150,20);
		label9.setBounds(120,160,150,20);
		back.setBounds(90,200,80,20);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		panel.add(back);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		action();
	}
	void action()
	{
		//back Button
		back.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				ViewRec regFace =new ViewRec();
				regFace.setVisible(true);
				dispose();
			}
		});
	}
}