package Interface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BDgestion.BDconnection;
import Gestion.Person;

public class Compte extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person utilisateur;
	private JPanel panel;
	private JLabel Jl,Jl2,Jl3,Jl4,Jl5,Jl6,Jl7,Jl8,Jl9,Jl10,Jl11,Jl12,Jl13,Jl14,Jl15,Jl16,Jl17;
	private JComboBox<String> Jcb;
	private JButton jb,jb2;
	private BDconnection bdd = new BDconnection();
	private String plate;
	
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
    		Jl9 = new JLabel("Catégorie : ");
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
    	    
    	    Jl17=new JLabel("Contrat en Cours : ");
    	    c.weightx = 0.5;
			c.gridx=0;
			c.gridy=8;
			panel.add(Jl17,c);
			
			
			ResultSet biens = bdd.getResult("SELECT * FROM Driving WHERE DriverID = (SELECT idPerson FROM Person WHERE login = '"+user+"')");
			ResultSet Assu2 = bdd.getResult("SELECT * FROM HomeAssurance Where idAsker = (SELECT idPerson FROM Person WHERE login = '"+user+"')");
    	    ResultSet Assu = bdd.getResult("SELECT * FROM VehicleAssurance WHERE idAsker = (SELECT idPerson FROM Person WHERE login = '"+user+"')");	
    	   
    	    try {
				while(biens.next()) {
					
					plate = biens.getString(2);
					System.out.println(plate);
					}
			} catch (SQLException e) {
				System.out.println("Erreur de récupération des biens.");
				e.printStackTrace();
			}
    	    
			Jcb = new JComboBox<String>();
					c.weightx = 0.5;
	    	    	c.gridx=1;
	    	    	c.gridy=8;
	    	    	Jcb.addItem("");
			
			try {
				while(Assu.next()) {			
					Jcb.addItem("Contrat Vehicule "+Assu.getInt(1)+" Pour le véhicule : "+Assu.getString(4)+" Date de début : "+Assu.getString(2));
					
				}
			} catch (SQLException e) {
				Jcb.addItem("Pas De Contrat Véhicule");
			}
			try {
				while(Assu2.next()) {
					Jcb.addItem("Contrat Habitation "+Assu2.getInt(1)+ "Pour la residence "+Assu2.getInt(3)+"Date de début : "+Assu.getString(2)	 );
				}
			} catch (SQLException e) {
				Jcb.addItem("Pas De Contrat Habitation");
			}
			
			
    	    panel.add(Jcb,c);
    	    
    	   jb=new JButton("modifier");
    	    c.weightx = 0.5;
			c.gridx=2;
			c.gridy=9;
    	   
    	   jb.addActionListener(event-> modif(utilisateur.getLogin()));
    	   panel.add(jb,c);
    	   
    	   jb2 = new JButton("resilier contrat selectionner");
    	   c.weightx = 0.5;
			c.gridx=1;
			c.gridy=9;
			jb2.addActionListener(event-> resi(Jcb.getSelectedIndex(),user));
	    	   panel.add(jb2,c);
    		
	
	
	add(panel,BorderLayout.NORTH);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle(utilisateur.getName()+" "+utilisateur.getSurname());       
    this.pack();
    this.setSize(500,500);
    this.setLocationRelativeTo(null);
    this.setVisible(true);  
	}

	private void resi(int selectedItem,String user) {
		String req=null;
		if (selectedItem==1) {
		req="DELETE FROM `VehicleAssurance` WHERE idAsker = (SELECT idPerson FROM Person WHERE login = '"+user+"')" ;
		bdd.executeQuery(req);
		this.dispose();
		new Compte(user);
		}
		
	}

	private void modif(String login) {
		new ModifierUtilisateur(utilisateur.getLogin());	
	}
	
	
}
