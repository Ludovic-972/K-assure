package Interface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Gestion.Person;

public class Compte extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person utilisateur;
	private JPanel panel;
	private JLabel Jl,Jl2,Jl3,Jl4,Jl5,Jl6,Jl7,Jl8,Jl9,Jl10,Jl11,Jl12,Jl13,Jl14,Jl15,Jl16;
	private JButton jb;
	
	public Compte(String user) {
		utilisateur = new Person(user);

    	
    		panel = new JPanel();
    		panel.setLayout(new GridBagLayout());
    		GridBagConstraints c = new GridBagConstraints();
    		
    		
    		Jl  = new JLabel("Login : ");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=0;
    	    panel.add(Jl ,c);
    		Jl2 = new JLabel(utilisateur.getLogin());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=0;
    	    panel.add(Jl2,c);
    		Jl3 = new JLabel("Nom :");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=1;
    	    panel.add(Jl3,c);
    		Jl4 = new JLabel(utilisateur.getName());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=1;
    	    panel.add(Jl4,c);
    		Jl5 = new JLabel("Prenom :");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=2;
    	    panel.add(Jl5,c);
    		Jl6 = new JLabel(utilisateur.getSurname());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=2;
    	    panel.add(Jl6,c);
    		Jl7 = new JLabel("eMail :");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=3;
    	    panel.add(Jl7,c);
    		Jl8 = new JLabel(utilisateur.getEmail());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=3;
    	    panel.add(Jl8,c);
    		Jl9 = new JLabel("Cat�gorie : ");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=4;
    	    panel.add(Jl9,c);
    		Jl10 = new JLabel(utilisateur.getCategory());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=4;
    	    panel.add(Jl10,c);
    		Jl11 = new JLabel("Adresse:");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=5;
    	    panel.add(Jl11,c);
    		Jl12= new JLabel(utilisateur.getAddress());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=5;
    	    panel.add(Jl12,c);
    		Jl13 = new JLabel("Date de Naissance:");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=6;
    	    panel.add(Jl13,c);
    		Jl14 = new JLabel(utilisateur.getBirthdate());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=6;
    	    panel.add(Jl14,c);
    		Jl15 = new JLabel("Profession :");
    			c.weightx = 0.5;
    			c.gridx=0;
    			c.gridy=7;
    	    panel.add(Jl15,c);
    		Jl16 = new JLabel(utilisateur.getProfession());
    			c.weightx = 0.5;
    			c.gridx=1;
    			c.gridy=7;
    	    panel.add(Jl16,c);
    	    
    	   jb=new JButton();
    	   c.weightx = 0.5;
			c.gridx=2;
			c.gridy=8;
    	   
    	   jb.addActionListener(event-> modif(utilisateur.getLogin()));
    	   panel.add(jb,c);
    		
	
	
	add(panel,BorderLayout.NORTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle(utilisateur.getName()+" "+utilisateur.getSurname());       
    this.pack();
    this.setSize(500,500);
    this.setLocationRelativeTo(null);
    this.setVisible(true);  
	}

	private void modif(String login) {
		new ModifierUtilisateur(utilisateur.getLogin());	
	}
	
	
}
