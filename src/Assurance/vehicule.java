package Assurance;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


import BDgestion.BDconnection;
import Gestion.Person;
import Interface.Inscription;
import Interface.PageAccueil;



public class Vehicule implements ActionListener{
	
	private JFrame fenetre = new JFrame("Assurer son véhicule");
	private JPanel panel;
	private JLabel marque_label,modele_label,moteur_label,age_label,permis_label,plaque_label,usage_label,energie_label,garage_label,obtention_label;
	private JTextField age_txt,plaque_txt,garage_txt;
	private JFormattedTextField permis_txt,obtention_txt;
	private JComboBox<String> marque,modele,moteur,usage,energie;
	private JButton enregistrer;
	
	private Person user;
	private BDconnection bdd = new BDconnection();
	
	public Vehicule(String _user) {
		this.user = new Person(_user);
		
				 
		panel = new JPanel();
		panel.setLayout(new GridLayout(11, 2, 5, 5));
		
		
		marque_label = new JLabel("Marque du véhicule : ");
		marque_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(marque_label);
		marque = new JComboBox<String>();
		marque.addItem("");

		ResultSet marques = bdd.getResult("SELECT DISTINCT Brand FROM Vehicle ORDER BY Brand");
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
				modele.removeAllItems();
				modele.addItem("");
				ResultSet modeles = bdd.getResult("SELECT DISTINCT Vehicle FROM Vehicle WHERE Brand ='"+e.getItem()+"' ORDER BY Vehicle");
				try {
					while (modeles.next()) {
						modele.addItem(modeles.getString(1));
					}						
				} catch (SQLException sqle) {					
					sqle.printStackTrace();
				}
				
			}
		});
		
		panel.add(modele);
		 
		moteur_label = new JLabel("Moteur : ");
		moteur_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(moteur_label);
			
		moteur = new JComboBox<String>();
		moteur.addItem("");
		panel.add(moteur);
		
		modele.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if ((marque.getSelectedItem() instanceof String) && (modele.getSelectedItem() instanceof String)) {
					String ma = marque.getSelectedItem().toString();
					String mo = modele.getSelectedItem().toString();

					ResultSet moteurs = bdd.getResult("SELECT DISTINCT `Engine`,`Engine code` FROM "
							+ "Vehicle WHERE Vehicle = '"+mo+"' AND Brand ='"+ma+"' ORDER BY Engine");
					try {
						while (moteurs.next()) {
							moteur.addItem(moteurs.getString(1)+" "+moteurs.getString(2));
						}
							
					} catch (SQLException sqle) {
						sqle.printStackTrace();
					}
				}
				
			}
		});
		 
	
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
		
		obtention_label = new JLabel("Année d'obtention du véhicule");	
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
		
		garage_label = new JLabel("Adresse du garage : ");	
		garage_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		panel.add(garage_label);
		 
		garage_txt = new JTextField();
		panel.add(garage_txt);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
				new PageAccueil(user.getLogin());
				
			}
		});
		
		enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(event -> assurer(marque.getSelectedItem().toString(),modele.getSelectedItem().toString(),moteur.getSelectedItem().toString(),age_txt.getText(),permis_txt.getText(),obtention_txt.getText(),plaque_txt.getText(),usage.getSelectedItem().toString(),energie.getSelectedItem().toString(),garage_txt.getText()));
		
		panel.add(retour);
		panel.add(enregistrer);

		fenetre.add(panel);
		fenetre.setSize(600,400);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(true);
		fenetre.setVisible(true);
		 
	}

		
	 public void assurer(String _marque,String _modele,String _moteur,String _age,String _permis,String _obtention,String _plaque,String _usage,String _energie,String _garage) {
		 int annee_actuel = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		 if (annee_actuel >= Integer.parseInt(_obtention)) {
			 if (DateValid(_permis)) {
				 double bm = 1;
				 String ddj = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				 int bm_ask = JOptionPane.showConfirmDialog(null, "Avez vous déjà été assurez avant ?", "Question ?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				 if (bm_ask == JOptionPane.YES_OPTION) {
					 while(true) {
						 try {
							 bm = Integer.parseInt(JOptionPane.showInputDialog("Entrez votre bonus/malus",1));
							 assert bm >=0.5 || bm <=3.5;
							 bm = Math.round((bm) * 10) / 10;
							 break;
						 }catch(NumberFormatException e){
							 JOptionPane.showMessageDialog(null, "Veuillez entrez une valeur entre 0.5 et 3.5");;
						 }
					 }
				 }
				int atr = 0;
				int atr_ask = JOptionPane.showConfirmDialog(null, "Voulez-vous l'assurance tout risques ?", "Question ?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (atr_ask == JOptionPane.YES_OPTION) {
						atr = 1;
				} 
				 String req = "INSERT INTO `Driving`(`driverID`, `plateNumber`, `DriverLicenceDate`, `make`,"
				 		+ " `model`, `engine`, `function`, `buyingYear`, `energy`, `AgeOfCar`, `garage`) VALUES"
				 		+ "('"+user.getIdPerson()+"','"+_plaque+"','"+dateFormatSQL(_permis)+"','"+_marque+"','"+_modele+"','"+_moteur+"','"+_usage+"','"+_obtention+"','"
				 		+_energie+"','"+_age+"','"+_garage+"')";
				 String req2 ="INSERT INTO `VehicleAssurance`(`startDate`, `idAsker`, `vehicle`, `bonus_malus`,"
				 		+ " `AllRiskCover`, `price`) VALUES ('"+ddj+"','"+user.getIdPerson()+"','"+_plaque+"','"+bm+"','"+atr+"','0')";
				 bdd.executeQuery(req);
				 bdd.executeQuery(req2);
				 
				 fenetre.dispose();
				 JOptionPane.showMessageDialog(null, "Vous êtes assurez.");
				 new PageAccueil(user.getLogin());
			}else {
				JOptionPane.showMessageDialog(null, "Veuillez entrer une date valide.");
			}
		 }else {
			 JOptionPane.showMessageDialog(null, "Veuillez entrer une année valide.");
		 }
	 }

	public static String dateFormatSQL(String date) {
		String[] tab = date.split("-");
		date = String.join("-", tab[2],tab[1],tab[0]);
		return date;
	}
	
	/**
	 *@see Inscription#bissextile(int)
	  * @since 1.0
	  * */
	public boolean bissextile(int year) {

	    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
	        return true;
	    } else {
	        return false;
	    }
	    }
	 
	
	/**
	 * 
	  *@see Inscription#jours30
	  *@since 1.0
	  * 
	  */
	 public boolean DateValid(String date){
		 try {
			 System.out.println(date.length());
			 if(date == "NULL"){
				 return true;
			 }
			 String[] tab = date.split("-");
			 int jour = Integer.parseInt(tab[0]);
			 int mois = Integer.parseInt(tab[1]);
			 int annee = Integer.parseInt(tab[2]);
			 
			 
			 int annee_actuel = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
			
				 if (mois <= 12 && annee <= annee_actuel) {
					 if (mois == 02) {
						 if (bissextile(annee) && jour <= 29)  
							return true;
						 else if(jour <= 28)
							return true;
					}else if (jours30(mois) && jour <= 30) {
						return true;
					}else if(jour <=31){
						return true;
					}
				}
			 
		} catch (NumberFormatException e) {
			return false;
		}
		 
		 
		 return false;
		 
	        
	    }
	 
	 
	 /**
	  * @see Inscription#jours30(int)
	  *@since 1.0
	  * 
	  */
	 public boolean jours30(int mois) {
		 int[] tab = {4,6,9,11};
		 for (int a : tab) {
			if (a == mois) {
				return true;
			}
		}
		 return false;
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

