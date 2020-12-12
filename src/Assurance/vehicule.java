package Assurance;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BDgestion.BDconnection;


@SuppressWarnings("serial")
public class Vehicule extends JFrame implements ItemListener, ActionListener{
	private JPanel panel;
	private JLabel marque_label,modele_label,moteur_label,age_label,Jl3,Jl4,Jl5,Jl6;
	private JButton jb;
	private JTextField JTF,JTF2,JTF3,JTF4;
	JComboBox<String> marque,modele,moteur;
	private JComboBox<String> JCB,JCB2;
	private String user;
	private BDconnection bdd = new BDconnection();
	
	public Vehicule(String _user) {
		super("Assurer son véhicule");
		this.user = _user;
		
		this.setLayout(new BorderLayout());
				 
		panel = new JPanel(new GridLayout(9,2));
		
		
		marque_label= new JLabel("Marque du véhicule : ");
		panel.add(marque_label);
		
		marque = new JComboBox<String>();
		marque.addItem("");

		ResultSet marques = bdd.getResult("SELECT DISTINCT Brand FROM Vehicle");
		try {
			while (marques.next()) {
				marque.addItem(marques.getString(1));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		panel.add(marque);
		
		modele_label = new JLabel("Modèle du véhicule :");
		panel.add(modele_label);
			
		 modele=new JComboBox<String>();
		 modele.addItem("");
		 ResultSet modeles = bdd.getResult("SELECT DISTINCT Vehicle FROM Vehicle");
			try {
				while (modeles.next()) {
					modele.addItem(modeles.getString(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					modeles.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 
		 moteur_label = new JLabel("Moteur : ");
		 
		 panel.add(moteur_label);
			
		 moteur = new JComboBox<String>();
		 ResultSet moteurs = bdd.getResult("SELECT DISTINCT `Engine`,`Engine code` FROM Vehicle");
			try {
				while (moteurs.next()) {
					moteur.addItem(moteurs.getString(1)+" "+moteurs.getString(2));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					modeles.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		 
	
		age_label = new JLabel("Année de fabrication du véhicule");

			
			
		JTF=new JTextField();	 
		 
		
		 
		 Jl3 = new JLabel("Année d'ancienneté du Conducteur");
			
			
		JTF3=new JTextField();

		 
		 Jl4 = new JLabel("Plaque d'immatriculation du véhicule");
			
			
		JTF4=new JTextField();

		 
		Jl5 = new JLabel("Utilisation du véhicule :  ");

			
		JCB=new JComboBox<String>();
		JCB.addItem(" ");
		JCB.addItem("Professionnel");
		JCB.addItem("Privé");

		 
		Jl6 = new JLabel("  type d'energie :  ");

			
			
		JCB2=new JComboBox<String>();
		JCB2.addItem(" ");
		JCB2.addItem("Essence");
		JCB2.addItem("Diesel");
		 
		jb = new JButton("Validez");
		
		 
		 
		jb.addActionListener(event -> annee(JTF.getText(),modele.getSelectedItem().toString(),JTF2.getText(),JTF4.getText(),JCB.getSelectedIndex(),JCB2.getSelectedIndex()));
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.add(panel, BorderLayout.NORTH);
		this.setVisible(true);
		 
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
	
	
	public static void main(String[] args) {
		new Vehicule("");
	}
}

