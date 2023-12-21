package multiForms;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Form2 extends JFrame implements ActionListener {
	
	JLabel name = new JLabel("   Name: ");
	JLabel surname = new JLabel("   Surname: ");
	JLabel gender = new JLabel();
	JLabel nationality = new JLabel();
	JLabel profile = new JLabel();
	JLabel lectures = new JLabel();
	
	JButton returnBtn = new JButton("Return Back");
	JPanel panel = new JPanel();
	
	public Form2() {
		setTitle("Form 2");
		setLayout(new GridLayout(7, 1));
		setSize(550, 300);
		setLocationRelativeTo(null);
		
		add(name);
		add(surname);
		add(gender);
		add(nationality);
		add(profile);
		add(lectures);
		
		
		panel.setLayout(new FlowLayout());
		
		
		panel.add(returnBtn);
		returnBtn.addActionListener(this);
		add(panel);
		
		setVisible(true);
	} 
		
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnBtn) 
				dispose();
		
	}

}
