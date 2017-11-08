import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Choice extends JFrame {
	JButton bnew = new JButton(" New Record ");
	JButton bview = new JButton(" View Record ");
	JButton bedit = new JButton(" Edit Record ");
	JButton bdelete = new JButton(" Delete Record ");
	JPanel panel = new JPanel();
	Choice(){
		setTitle("Welcome to Student Managment System ");
		setSize(350,250);
		setLocation(300,280);
		panel.setLayout (null); 
		bnew.setBounds(100,50,120,20);
		bedit.setBounds(100,80,120,20);
		bdelete.setBounds(100,110,120,20);
		bview.setBounds(100,140,120,20);
		panel.add(bview);
		panel.add(bnew);
		panel.add(bnew);
		panel.add(bedit);
		panel.add(bdelete);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		action();
	}

	public void action()
	{
		bnew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				NewRec regFace =new NewRec();
				regFace.setVisible(true);
				dispose();
			}
		});
		//Edit Button
		bedit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				EditRec regFace =new EditRec();
				regFace.setVisible(true);
				dispose();
			}
		});
		//Delete Button
		bdelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				DelRec regFace =new DelRec();
				regFace.setVisible(true);
				dispose();
			}
		});
		//View Button
		bview.addActionListener(new ActionListener() 
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
