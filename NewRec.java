import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class NewRec extends JFrame {
	
	JPanel panel = new JPanel();
	JTextField name = new JTextField(50);
	JTextField rollno = new JTextField(10);
	JTextField branch = new JTextField(10);
	JTextField phoneno = new JTextField(10);
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JButton submit = new JButton("Submit");
	JButton breset = new JButton("Reset");
	JButton back = new JButton("Back");
	NewRec(){
		label1.setText("!! INSERT NEW RECORD !!");
		label2.setText(" Name :- ");
		label3.setText(" Roll No. :- ");
		label4.setText(" Branch :- ");
		label5.setText(" Phone No. :- ");
		setTitle("Welcome to Student Managment System ");
		setSize(350,300);
		setLocation(300,280);
		panel.setLayout (null); 
		label1.setBounds(90,30,300,20);
		label2.setBounds(40,70,150,20);
		name.setBounds(120,70,150,20);
		label3.setBounds(40,100,150,20);
		rollno.setBounds(120,100,150,20);
		label4.setBounds(40,130,150,20);
		branch.setBounds(120,130,150,20);
		label5.setBounds(40,160,150,20);
		phoneno.setBounds(120,160,150,20);
		submit.setBounds(20,190,80,20);
		breset.setBounds(130,190,80,20);
		back.setBounds(240,190,80,20);
		panel.add(label1);
		panel.add(label2);
		panel.add(name);
		panel.add(label3);
		panel.add(rollno);
		panel.add(label4);
		panel.add(branch);
		panel.add(label5);
		panel.add(phoneno);
		panel.add(submit);
		panel.add(breset);
		panel.add(back);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		action();
	}
	public void action()
	{
		submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{    
				String line = null;
				String sname = name.getText();
				String sroll = rollno.getText();
				String sbranch = branch.getText();
				String sphone = phoneno.getText();
				String FILENAME = "student.txt";
				BufferedWriter bw = null;
				FileWriter fw = null;
				try 
				{
					File file = new File(FILENAME);
					// if file doesnt exists, then create it
					if (!file.exists())
						file.createNewFile();
					// true = append file
					fw = new FileWriter(file.getAbsoluteFile(), true);
					bw = new BufferedWriter(fw);						
					String i=" / ";
					bw.write(sname);
					bw.write(i);
					bw.write(sroll);
					bw.write(i);
					bw.write(sbranch);
					bw.write(i);
					bw.write(sphone);
					bw.newLine();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				finally 
				{
					try 
					{
						if (bw != null)
							bw.close();
						if (fw != null)
							fw.close();
					} 
					catch (IOException ex) 
					{
						ex.printStackTrace();
					}
				}
				
			JOptionPane.showMessageDialog(null,"Record Saved");
			name.setText("");
			rollno.setText("");
			branch.setText("");
			phoneno.setText("");
			name.requestFocus();
		}	
	});
	//Reset Button
	breset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				name.setText("");
				rollno.setText("");
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
				Choice regFace =new Choice();
					regFace.setVisible(true);
					dispose();
			}
	});
	}
}