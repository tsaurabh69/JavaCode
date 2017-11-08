import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class DelRec extends JFrame {

	JPanel panel = new JPanel();
	JTextField rollno = new JTextField(10);
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JButton back = new JButton("Back");
	JButton bdelete = new JButton("Search");
	
	DelRec(){
		label1.setText("!! SEARCH RECORD !!");
		label2.setText(" Roll No. :- ");
		setTitle("Welcome to Student Managment System ");
		setSize(350,200);
		setLocation(300,280);
		panel.setLayout (null); 
		label1.setBounds(90,20,300,20);
		label2.setBounds(40,60,150,20);
		rollno.setBounds(120,60,150,20);
		bdelete.setBounds(60,100,80,20);
		back.setBounds(160,100,80,20);
		panel.add(back);
		panel.add(label1);
		panel.add(label2);
		panel.add(rollno);
		panel.add(bdelete);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Aaction();
	}

	public void Aaction()
	{
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
		//Delete Button
		bdelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				double count = 0;
				double countBuffer=0;
				double countLine=0;
				String lineNumber = "";
				BufferedReader br;
				String sroll = rollno.getText();
				String line = "";
				try {
					FileReader fileReader = new FileReader("Student.txt");
					br = new BufferedReader(fileReader);
					try {
						while((line = br.readLine()) != null)
						{
							countLine++;
							String[] words = line.split(" ");
							for (String word : words) 
							{
								if (word.equals(sroll)) 
								{
									count++;
									countBuffer++;
									break;
								}
							}
							if(countBuffer > 0)
							{
								break;
							}					
						}
						br.close();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if(countBuffer > 0)
				{
					try{
					BufferedReader bw = null;
					FileWriter fw = null;
					File file = new File("student.txt");
					// true = append file
					String lineToRemove = rollno.getText();
				System.out.print(lineToRemove);
					fw = new FileWriter(file.getAbsoluteFile(), true);
					br = new BufferedReader(new FileReader(file));						
					PrintWriter pw = new PrintWriter(fw);
					while ((line = br.readLine()) != null) {
	        					if (!line.trim().equals(lineToRemove)) {
						          pw.println(line);
						          pw.flush();
						          break;
						}
      					}
					JOptionPane.showMessageDialog(null,"Record Deleted.");
					rollno.setText("");
					rollno.requestFocus();
      					pw.close();
      					br.close();
					}
					catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Roll No. not found in DataBase.");
					rollno.setText("");
					rollno.requestFocus();
				}
			}
		});
	}
}