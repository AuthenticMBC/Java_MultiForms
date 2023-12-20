package multiForms;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class Form1 extends JFrame implements ActionListener {
	
    
    
    JTextField nameField = new JTextField(10);
    JTextField surnameField = new JTextField(10);
    JRadioButton male = new JRadioButton("male");
    JRadioButton female = new JRadioButton("female");
    ButtonGroup genderGroup = new ButtonGroup();
    
    String[] items= {"Congolese", "Nigerian", "Cypriot", "Tanzanian"};
    JComboBox<String> nationalityCombo = new JComboBox<String>(items);
    JTextArea about = new JTextArea(20, 20);
    JCheckBox oop = new JCheckBox("Object Oriented prog.");
    JCheckBox os = new JCheckBox("Operating Systems");
    JCheckBox sp = new JCheckBox("System Programming");
    
    JButton submit = new JButton("Submit");
    JButton exit = new JButton("Exit");
    
    JPanel panelName = new JPanel();
    JPanel panelSurname = new JPanel();
    JPanel panelGender = new JPanel();
    JPanel panelNationality = new JPanel();
    JPanel panelAbout = new JPanel();
    JPanel panelLecture = new JPanel();
    JPanel panelButton = new JPanel();
	
    
    
	
	public Form1()
	{
		setTitle("Form - Enter Info");
        setLayout(new GridLayout(7, 1));
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panelName.setLayout(new FlowLayout());
        panelName.add(new JLabel("Your Name*    : "));
        panelName.add(nameField);
        add(panelName);
        
        
        panelSurname.setLayout(new FlowLayout());
        panelSurname.add(new JLabel("Your Surname* : "));
        panelSurname.add(surnameField);
        add(panelSurname);
        
        genderGroup.add(male);
        genderGroup.add(female);
        
        panelGender.setLayout(new FlowLayout());
        panelGender.add(new JLabel("   Your Gender*     : "));
        
        panelGender.add(male);
        panelGender.add(female);
        add(panelGender);
        

        panelNationality.setLayout(new FlowLayout());
        panelNationality.add(new JLabel("Your Nationality* : "));
        panelNationality.add(nationalityCombo);
        add(panelNationality);
        
        panelAbout.setLayout(new FlowLayout());
        panelAbout.add(about);
       
        add(panelAbout);
   
        
        
        
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
}
