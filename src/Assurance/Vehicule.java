package Assurance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Interface.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestion.*;


@SuppressWarnings("serial")
public class Vehicule extends JFrame implements ItemListener, ActionListener{
	private JPanel panel;
	private JLabel home,Jl,Jl1,Jl2,Jl3,Jl4,Jl5,Jl6;
	private JButton jb;
	private JTextField JTF,JTF1,JTF2,JTF3,JTF4;
	private JComboBox<String> JCB,JCB2;
	private Person user;
	
	public Vehicule(String _user) {
		user = new Person(_user);
		if (user.getCategory().equals("Adulte")) 
    		user = new Adult(_user);
		
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("formulaire");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
				 
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(panel, BorderLayout.NORTH);
		this.setVisible(true);
		
		
		home = new JLabel("Marque du véhicule");
		c.weightx = 0.25;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(home,c);
		
		
		JComboBox<String> Marque = new JComboBox<String>();
		c.weightx = 0.25;
		c.gridx = 3;
		c.gridy = 0;
		Marque.addItem("");
		Marque.addItem("Renault");
		Marque.addItem("Peugeot");
		Marque.addItem("Tesla");
		Marque.addItem("Ford");
		Marque.addItem("Autre");
		
		
		panel.add(Marque,c);
		Jl = new JLabel("Année de fabrication du véhicule");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(Jl,c);
			
			
			JTF=new JTextField();	 
		 c.weightx = 0.25;
			c.gridx = 3;
			c.gridy = 1;
		
		 panel.add(JTF,c);
		 
		 Jl1 = new JLabel("Modele du véhicule ");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(Jl1,c);
			
		 JTF1=new JTextField();
		 c.weightx = 0.25;
			c.gridx = 3;
			c.gridy = 2;
		 
		 panel.add(JTF1,c);
		 
		 Jl2 = new JLabel("Type  de Moteur :  ");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 3;
			panel.add(Jl2,c);
			
			JTF2=new JTextField();
			 c.weightx = 0.25;
				c.gridx = 3;
				c.gridy = 3; 
			 panel.add(JTF2,c);
			
		 
		 
		 Jl3 = new JLabel("Année d'ancienneté du Conducteur");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 4;
			panel.add(Jl3,c);
			
			
			JTF3=new JTextField();
		 c.weightx = 0.25;
			c.gridx = 3;
			c.gridy = 4; 
		 panel.add(JTF3,c);
		 
		 Jl4 = new JLabel("Plaque d'immatriculation du véhicule");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 5;
			panel.add(Jl4,c);
			
			
			JTF4=new JTextField();
		 c.weightx = 0.25;
			c.gridx = 3;
			c.gridy = 5; 
		 panel.add(JTF4,c);
		 
		 Jl5 = new JLabel("Utilisation du véhicule :  ");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 6;
			panel.add(Jl5,c);
			
			
			JCB=new JComboBox<String>();
			JCB.addItem(" ");
			JCB.addItem("Professionnel");
			JCB.addItem("Privé");
		 c.weightx = 0.25;
			c.gridx = 3;
			c.gridy = 6; 
		 panel.add(JCB,c);
		 
		 Jl6 = new JLabel("  type d'energie :  ");
		 c.weightx = 0.25;
			c.gridx = 0;
			c.gridy = 7;
			panel.add(Jl6,c);
			
			
			JCB2=new JComboBox<String>();
			JCB2.addItem(" ");
			JCB2.addItem("Essence");
			JCB2.addItem("Diesel");
		 c.weightx = 0.25;
			c.gridx = 3;
			c.gridy = 7; 
		 panel.add(JCB2,c);
		 
		 jb = new JButton("Validez");
		 c.weightx = 0.25;
			c.gridx = 2;
			c.gridy = 8;
		 panel.add(jb,c);
		 
		 
		 
		 jb.addActionListener(event -> annee(JTF.getText(),JTF1.getText(),JTF2.getText(),JTF4.getText(),JCB.getSelectedIndex(),JCB2.getSelectedIndex()));
		
	}

		
		
	 {

}
	 public void annee(String string, String string2, String string3,String string4,int choix,int choix2) {
		 System.out.println("oui");
		 if (choix == 1) {
			 if (choix2 == 1) {
			 String _choix= "Essence";
			 String _choix2 = "Professionnel";
			 System.out.println(string+string2+string3+string4+_choix+_choix2);
		 }else {
			 String _choix = "Essence" ;
			 String _choix2 = "Privé";
			 System.out.println(string+string2+string3+string4+_choix+_choix2);
			 }
			 }
		 if (choix == 2) {
			 if(choix2 == 2) {
				 
			 String _choix = "Diesel";
			 String _choix2 = "Professionnel";
			 System.out.println(string+string2+string3+string4+_choix+_choix2);
			 
			 }else {
				 String _choix = "Diesel";
				 String _choix2 = "Privé";
				 System.out.println(string+string2+string3+string4+_choix+_choix2);
				 
			 }
			 }
		 
		
		
 }
			
	 
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
