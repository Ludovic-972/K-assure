package Assurance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import Interface.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class habitation extends JFrame implements ActionListener {
	public JPanel panel;
	public JPanel panel2;
	public JButton home;
	public habitation() {
		
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("formulaire");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
				 
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.setVisible(true);
		home = new JButton("home");
		home.addActionListener(this);
		panel.add(home);
		
		JComboBox type = new JComboBox();
		type.addItem(" ");
		type.addItem("principale");
		type.addItem("secondaire");
		panel.add(type);
	
		JComboBox logement = new JComboBox();
		logement.addItem(" ");
		logement.addItem("Appartement");
		logement.addItem("Maison");
		panel.add(logement);
	
		JComboBox type2 = new JComboBox();
		type2.addItem(" ");
		type2.addItem("Locataire");
		type2.addItem("Proprietaire");
		type2.addItem("Colocataire");
		panel.add(type2);
	
	
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == home) {
			this.dispose();
			fenetre test = new fenetre();
			
		
		}
	}
}
