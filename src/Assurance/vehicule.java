package Assurance;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import BDgestion.BDconnection;
import Interface.PageAccueil;



public class Vehicule implements ActionListener{
	
	private JFrame fenetre = new JFrame("Assurer son véhicule");
	private JPanel panel;
	private JLabel marque_label,modele_label,moteur_label,age_label,permis_label,plaque_label,usage_label,energie_label,garage_label,obtention_label;
	private JTextField age_txt,plaque_txt,garage_txt;
	private JFormattedTextField permis_txt,obtention_txt;
	private JComboBox<String> marque,modele,moteur,usage,energie;
	private JButton enregistrer;
	
	private String user;
	private BDconnection bdd = new BDconnection();
	
	public Vehicule(String _user) {
		this.user = _user;
		
				 
		panel = new JPanel();
		panel.setLayout(new GridLayout(11, 2, 5, 5));
		
		
		marque_label = new JLabel("Marque du véhicule : ");
		marque_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
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
		modele_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(modele_label);	
		modele = new JComboBox<String>();
		modele.addItem("");
		
		marque.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						modele = new JComboBox<String>();
						modele.addItem("");
						ResultSet modeles = bdd.getResult("SELECT DISTINCT Vehicle FROM Vehicle WHERE Brand ='"+e.getItem()+"'");
						try {
							while (modeles.next()) {
								moteur.addItem(modeles.getString(1));
							}
								
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
					}
				});
				
			}
		});
		
		panel.add(modele);
		 
		moteur_label = new JLabel("Moteur : ");
		moteur_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(moteur_label);
			
		moteur = new JComboBox<String>();
		ResultSet moteurs = bdd.getResult("SELECT DISTINCT `Engine`,`Engine code` FROM Vehicle");
		try {
			while (moteurs.next()) {
				moteur.addItem(moteurs.getString(1)+" "+moteurs.getString(2));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		panel.add(moteur);
		 
	
		age_label = new JLabel("Age du véhicule");	
		age_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(age_label);		
		
		age_txt = new JTextField();	 
		panel.add(age_txt);
		
		 
		permis_label = new JLabel("Date d'obtention du permis de conduire");	
		permis_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(permis_label);
		
		try {
	         MaskFormatter formatter = new MaskFormatter("##-##-####");
	         formatter.setPlaceholderCharacter('#');
	         permis_txt = new JFormattedTextField(formatter);
	     }catch(Exception e) {
	         e.printStackTrace();
	     }
		panel.add(permis_txt);
		
		obtention_label = new JLabel("Date d'obtention du véhicule");	
		obtention_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(obtention_label);
		
		try {
	         MaskFormatter formatter = new MaskFormatter("####");
	         formatter.setPlaceholderCharacter('#');
	         obtention_txt = new JFormattedTextField(formatter);
	     }catch(Exception e) {
	         e.printStackTrace();
	     }
		panel.add(obtention_txt);


		 
		plaque_label = new JLabel("Plaque d'immatriculation du véhicule");	
		plaque_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(plaque_label);
		
		plaque_txt = new JTextField();
		panel.add(plaque_txt);

		 
		usage_label = new JLabel("Usage du véhicule :  ");	
		usage_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(usage_label);
		
		usage = new JComboBox<String>();
		usage.addItem(" ");
		usage.addItem("Professionnel");
		usage.addItem("Privé");
		panel.add(usage);
		 
		energie_label = new JLabel("Energie : ");
		energie_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(energie_label);
		
		energie = new JComboBox<String>();
		energie.addItem(" ");
		energie.addItem("Essence");
		energie.addItem("Diesel");
		panel.add(energie);
		
		garage_label = new JLabel("Usage du véhicule :  ");	
		garage_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(garage_label);
		 
		garage_txt = new JTextField();
		panel.add(garage_txt);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
				new PageAccueil(user);
				
			}
		});
		
		enregistrer = new JButton("Enregistrer");
		//enregistrer.addActionListener(event -> assurer());
		
		panel.add(retour);
		panel.add(enregistrer);

		fenetre.add(panel);
		fenetre.setSize(600,400);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(true);
		fenetre.setVisible(true);
		 
	}

		
		
	 {

}
	 public void assurer(String marque,String modele,String moteur,String age) {
		 
	 }
			

	
	
	public static void main(String[] args) {
		new Vehicule("");
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

