import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

	public static void main(String[] args) 
	{
		Login frameTabel = new Login();
	}
	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JPasswordField pass = new JPasswordField(15);
	String puname ;
	Login()
	{
		label1.setText("Login Autentification");
		label2.setText("User Name :- ");
		label3.setText("Password :- ");
		setTitle("Welcome to Student Managment System ");
		setSize(350,250);
		setLocation(300,280);
		panel.setLayout (null); 
		label1.setBounds(110,30,300,20);
		label2.setBounds(40,70,150,20);
		txuser.setBounds(120,70,150,20);
		label3.setBounds(40,105,150,20);
		pass.setBounds(120,105,150,20);
		blogin.setBounds(130,140,80,20);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(blogin);
		panel.add(txuser);
		panel.add(pass);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}
	public void actionlogin()
	{
		blogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				puname = txuser.getText();
				String ppaswd = pass.getText();
				if(puname.equals("admin") && ppaswd.equals("12345")) 
				{
					Choice regFace =new Choice();
					regFace.setVisible(true);
					dispose();
				} 
				else 
				{
				JOptionPane.showMessageDialog(null,"Wrong Password / Username");
				txuser.setText("");
				pass.setText("");
				txuser.requestFocus();
				}
			}
		});
	}

}