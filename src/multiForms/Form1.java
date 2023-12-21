package multiForms;

import java.awt.event.*;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
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
    JButton clear = new JButton("Clear");
    
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
        setLayout(new GridLayout(10, 1));
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

        panelLecture.setLayout(new FlowLayout());
        panelLecture.add(new JLabel("Lectures you're taking right now: "));
        panelLecture.add(oop);
        panelLecture.add(os);
        panelLecture.add(sp);
        add(panelLecture);
        
        panelButton.setLayout(new FlowLayout());
        JLabel btnLabel = new JLabel("*Indicate compulsory fields"); 
        btnLabel.setForeground(Color.RED);
        panelButton.add(btnLabel);
        
        submit.addActionListener(this);
        clear.addActionListener(this);
        
        panelButton.add(submit);
        panelButton.add(clear);
        add(new JLabel());
        add(panelButton);
   
        
        
        setVisible(true);
	}
	
	private boolean isErrorHandled() {
		if(this.nameField.getText().length() == 0) {
			JOptionPane.showMessageDialog(
					null,
					"Please Type your Name",
					"Your Name is missing",
					JOptionPane.ERROR_MESSAGE
					);
			this.nameField.requestFocus();
			return false;
		}
		else if(this.surnameField.getText().length() == 0) {
			JOptionPane.showMessageDialog(
					null,
					"Please Type your Surname",
					"Your Surname is missing",
					JOptionPane.ERROR_MESSAGE
					);
			this.surnameField.requestFocus();
			return false;
		}
		else if(!this.male.isSelected() && !this.female.isSelected()) {
			JOptionPane.showMessageDialog(
					null,
					"Please Select your Gender",
					"Your Gender is missing",
					JOptionPane.ERROR_MESSAGE
					);
			this.surnameField.requestFocus();
			return false;
		}
		
		else if(this.nationalityCombo.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(
					null,
					"Please Select your Nationality",
					"Your Nationality is missing",
					JOptionPane.ERROR_MESSAGE
					);
			this.surnameField.requestFocus();
			return false;
		}
			
		
		return true;
	}
	
	public void sendData() {
		Form2 form2 = new Form2();
		form2.name.setText("   Name : " + nameField.getText() );
		form2.surname.setText("   Surname : " + surnameField.getText() );
		form2.gender.setText("   Gender : " + (male.isSelected() ? "Male" : "Female"));
		form2.nationality.setText("   Nationality: " + items[nationalityCombo.getSelectedIndex()]);
		form2.profile.setText("   Profile: " + about.getText());
		
		String lectureString = "   Lectures: "; 
		if(oop.isSelected())
			lectureString += oop.getText() + " ";
		if(os.isSelected())
			lectureString += os.getText() + " ";
		if(sp.isSelected())
			lectureString += sp.getText() + " ";
		
		form2.lectures.setText(lectureString);
	}
	
	public void clearField() {
		nameField.setText("");
		surnameField.setText("");
		about.setText("");
		oop.setSelected(false);
		os.setSelected(false);
		sp.setSelected(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submit)
		{
			if(!isErrorHandled())
				return;
			if(JOptionPane.showConfirmDialog(null, "Do you want to submit these informations ?") == 0)
			{
				sendData();
				clearField();
			}
			
		}
		
		else if(e.getSource() == clear) 
			if(JOptionPane.showConfirmDialog(null, "Are you sure ?")== 0)
				clearField();
		
	}
	
}
