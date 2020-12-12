package Assurance;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import BDgestion.BDconnection;
import Gestion.Refund;
import Gestion.Sinistre;
import Interface.PageAccueil;




public class DeclarerSinistre {
	
	private int IDAssu = 0;
	private BDconnection bdd = new BDconnection();
	private String user;
	private JFrame fenetre = new JFrame("Déclarer un sinistre");
	
	private JLabel sinistres_label = new JLabel("Sinistre : ",JTextField.CENTER);
	private JComboBox<String> liste_sin = new JComboBox<String>();
	
	private JLabel valeur_label;
	private JTextField valeur_txt = new JTextField();
	
	private JLabel assurances_label = new JLabel("Votre/Vos assurance(s) : ",JTextField.CENTER);
	private JComboBox<String> liste_assu = new JComboBox<String>();
	
	private String bien;
	private boolean simulation = false;
	
	public DeclarerSinistre(String type,String _user,boolean _simulation) {
    	
    	this.user = _user;
		
		JPanel pan = new JPanel(new GridLayout(4,2,5,5));
		
		sinistres_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(sinistres_label);
		
		liste_sin.addItem("");
		
		//Récupération des sinistres dans la bases de données
		ResultSet sinistres = bdd.getResult("SELECT name FROM Sinister WHERE Sector = '"+type+"'");
		try {
			while (sinistres.next()) {
				liste_sin.addItem(sinistres.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pan.add(liste_sin);
		
		ResultSet assurances = null; // Assurances concernés par le type de sinistre
		
		//Récupération de la valeur des dégats/cout d'opération
		switch(type) {
			case "Habitation":
				valeur_label = new JLabel("Valeur des biens endommagés/volés : ",JTextField.CENTER);
				assurances = bdd.getResult("SELECT * from HomeAssurance WHERE idAsker in (SELECT idPerson FROM Person WHERE login = '"+user+"')");
				break;
			case "Santé":
				valeur_label = new JLabel("Coût des soins : ",JTextField.CENTER);
				assurances = bdd.getResult("SELECT * from HealthAssurance WHERE idAsker in (SELECT idPerson FROM Person WHERE login = '"+user+"')");
				break;
			case "Véhicule":
				valeur_label = new JLabel("Coût des réparations : ",JTextField.CENTER);
				assurances = bdd.getResult("SELECT * from VehicleAssurance WHERE idAsker in (SELECT idPerson FROM Person WHERE login = '"+user+"')");
				break;
			default:
				break;
		}
		valeur_txt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\u0008') {
	            	valeur_txt.setEditable(true);
	           } else {
		           	valeur_txt.setEditable(false);
		           }
			}
		});
		
		valeur_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(valeur_label);
		pan.add(valeur_txt);
		
		
		assurances_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(assurances_label);
		
		//Récupération de/des assurance(s) (Habitation,Santé ou Véhicule) dans la bases de données
		
		liste_assu.addItem("");
		try {
			while (assurances.next()) {
					liste_assu.addItem("Assurance "+type+" n."+IDAssu+" du "+DateJJMMYYY(assurances.getDate(2).toString()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pan.add(liste_assu);
		
		
		
		JButton declarer = new JButton("Déclarer le sinistre");
			declarer.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (!(liste_sin.getSelectedItem().toString().equals("") || valeur_txt.getText().equals(""))) {
						
					
						if (liste_assu.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Veuillez choisir une assurance.");
						}else {
							declarer.addActionListener(event -> LancerDeclaration(liste_sin.getSelectedItem().toString(),Float.parseFloat(valeur_txt.getText())));
							
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs.");
					}
				}
			});
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
				new PageAccueil(user);
			}
		});
		
		pan.add(declarer);
		pan.add(retour);
		fenetre.add(pan);
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack();
        fenetre.setSize(580,200);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
	}
	
	
	public void LancerDeclaration(String name, float cost) {
		Sinistre sin = new Sinistre(name);
		
		JFrame fen = new JFrame("Bien à assurer");
		fen.setLayout(new GridLayout(2,1));
		
		JPanel pan = new JPanel(new GridLayout(2,1));
		
		JLabel bien_label = new JLabel("Choisissez le bien à assurer :");
		bien_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(bien_label);
		
		JComboBox<String> liste_bien = new JComboBox<String>();
		liste_bien.addItem("");
		if (sin.getSector().equals("Habitation")) {
			
			ResultSet biens = bdd.getResult("SELECT * FROM Residency WHERE idResident = (SELECT idPerson FROM Person WHERE login = '"+user+"')");
			try {
				while(biens.next()) {
					liste_bien.addItem(biens.getString(3)+" ("+biens.getString(5)+") "+biens.getString(10)+" m² "+biens.getString(17)+" pièces "+biens.getString(8)+" "+biens.getString(7)+"| Utilisation : "+biens.getString(9)+" |n."+biens.getString(1));
				}
			} catch (SQLException e) {
				System.out.println("Erreur de récupération des biens.");
			}
			
		}else if (sin.getSector().equals("Véhicule")){
			ResultSet biens = bdd.getResult("SELECT * FROM Driving WHERE DriverID = (SELECT idPerson FROM Person WHERE login = '"+user+"')");
			try {
				while(biens.next()) {
					liste_bien.addItem(biens.getString(4)+" "+biens.getString(5)+" "+biens.getString(6)+" | Immatriculé:"+biens.getString(2)+" | Véhicule "+biens.getString(7)+" | "+biens.getString(9));
				}
			} catch (SQLException e) {
				System.out.println("Erreur de récupération des biens.");
				e.printStackTrace();
			}
			
		}
		pan.add(liste_bien);
		
		JPanel button = new JPanel(new GridLayout(1,2));
		JButton declarer = new JButton("Calculer le taux");
		
		
		declarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sin.getSector().equals("Véhicule")) {
					bien = liste_bien.getSelectedItem().toString().split(" ")[6].split(":")[1];
				}else if(sin.getSector().equals("Habitation")) {
					bien = liste_bien.getSelectedItem().toString().split(" ")[11].split("\\.")[1];
				}
				
				if (!bien.equals("")) {
					Refund ref = new Refund(sin.getName(),IDAssu,cost,user,sin,bien,simulation);
					if (ref.isInscrit()) {
						JOptionPane.showMessageDialog(null, "Votre sinistre est enregistré. Votre assurance payera "+ref.getRate()+"% de ce que vous devrez payer. Soit "+ref.getNewCost()+'\u20ac');
						fen.dispose();
						fenetre.dispose();
						new PageAccueil(user);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir un bien.");
				}
				
			}
		});
		
		button.add(new JLabel(""));
		button.add(declarer);
		button.add(new JLabel(""));
		
		fen.add(pan);
		fen.add(button);
		fen.setSize(500,170);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
		
	}
	

	public String DateJJMMYYY(String date) {
		String[] tab = date.split("-");
		return tab[2]+"-"+tab[1]+"-"+tab[0];
	}


}


