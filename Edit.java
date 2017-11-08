import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class Edit extends JFrame 
{
	
	JPanel panel = new JPanel();
	JTextField name = new JTextField(50);
	JTextField branch = new JTextField(10);
	JTextField phoneno = new JTextField(10);
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JButton submit = new JButton("Submit");
	JButton breset = new JButton("Reset");
	JButton back = new JButton("Back");
	String edname,edbranch,edphone,rollno;
	static StringBuffer stringBufferOfData = new StringBuffer();
	String line1=null;
	Edit(String line)'
	{
	
		line1=line;
		int i=1;	
		String[]  words = line.split(" / ");
		for (String word : words) 
		{
			if(i==1)
			{
				name.setText(word);
				edname=word;
			}
			if(i==3)
			{
				branch.setText(word);
				edbranch=word;
			}
			if(i==4)
			{
				phoneno.setText(word);
				edphone=word;
			}
			if(i==2)
			{
			rollno=word;
			i++;
			}
		}
		label3.setText("!! EDIT RECORD !!");
		label4.setText(" Name :- ");
		label6.setText(" Branch :- ");
		label7.setText(" Phone No. :- ");
		setTitle("Welcome to Student Managment System ");
		setSize(350,300);	
		setLocation(300,280);
		panel.setLayout (null); 
		label3.setBounds(90,30,300,20);
		label4.setBounds(40,70,150,20);
		name.setBounds(120,70,150,20);
		label6.setBounds(40,100,150,20);
		branch.setBounds(120,100,150,20);
		label7.setBounds(40,130,150,20);
		phoneno.setBounds(120,130,150,20);
		submit.setBounds(20,180,80,20);
		breset.setBounds(130,180,80,20);
		back.setBounds(240,180,80,20);
		panel.add(label3);
		panel.add(label4);
		panel.add(name);
		panel.add(label6);
		panel.add(branch);
		panel.add(label6);
		panel.add(label7);
		panel.add(phoneno);
		panel.add(submit);
		panel.add(breset);
		panel.add(back);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		action2();
	}
	public void action2(){ 
		//Submit Button
		submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				String line = null;
				String sname = name.getText();
				String sbranch = branch.getText();
				String sphone = phoneno.getText();
				String FILENAME = "student.txt";
				BufferedWriter bw = null;
				FileWriter fw = null;
				try 
				{
					File file = new File(FILENAME);
					// true = append file
					fw = new FileWriter(file.getAbsoluteFile(), true);
					bw = new BufferedWriter(fw);						
					String line2=sname+" / "+sbranch+" / "+sphone;
					line1.replaceAll(edname,sname);
					System.out.println(edname+"  "+sname);
					System.out.println(line1);
					JOptionPane.showMessageDialog(null,"Record Saved");
				}
				catch (Exception e) {//if an exception occurs
         					   System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        				}
			}
		});
		//Reset Button
		breset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				name.setText("");
				branch.setText("");
				phoneno.setText("");
				name.requestFocus();
			}
		});
		//Back Button
		back.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				EditRec regFace =new EditRec();
					regFace.setVisible(true);
					dispose();
			}
		});
	}
	
}