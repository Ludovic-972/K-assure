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
import Gestion.Adult;
import Gestion.Refund;
import Gestion.Sinistre;
import Interface.PageAccueil;



@SuppressWarnings("serial")
public class DeclarerSinistre extends JFrame{
	
	private int IDAssu = 0;
	private BDconnection bdd = new BDconnection();
	private Adult user;
	
	public DeclarerSinistre(String type,String login) {
		super("D�clarer un sinistre");
		this.setLayout(new GridLayout(2,1,10,20));
    	
    	this.user = new Adult(login);
		
		JPanel pan = new JPanel(new GridLayout(3,3,5,5));
		
		JLabel sinistres_label = new JLabel("Sinistre : ",JTextField.CENTER);
		sinistres_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(sinistres_label);
		
		JComboBox<String> liste_sin = new JComboBox<String>();
		liste_sin.addItem("");
		
		//R�cup�ration des sinistres dans la bases de donn�es
		ResultSet sinistres = bdd.getResult("SELECT name FROM Sinister WHERE Sector = '"+type+"'");
		try {
			while (sinistres.next()) {
				liste_sin.addItem(sinistres.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pan.add(liste_sin);
		
		ResultSet assurances = null; // Assurances concern�s par le type de sinistre
		
		//R�cup�ration de la valeur des d�gats/cout d'op�ration
		JLabel valeur_label = new JLabel();
		switch(type) {
			case "Habitation":
				valeur_label = new JLabel("Valeur des biens endommag�s/vol�s : ",JTextField.CENTER);
				assurances = bdd.getResult("SELECT * from HomeAssurance WHERE idAsker in (SELECT idPerson FROM Person WHERE login = '"+login+"')");
				break;
			case "Sant�":
				valeur_label = new JLabel("Co�t des soins : ",JTextField.CENTER);
				assurances = bdd.getResult("SELECT * from HealthAssurance WHERE idAsker in (SELECT idPerson FROM Person WHERE login = '"+login+"')");
				break;
			case "V�hicule":
				valeur_label = new JLabel("Co�t des r�parations : ",JTextField.CENTER);
				assurances = bdd.getResult("SELECT * from VehicleAssurance WHERE idAsker in (SELECT idPerson FROM Person WHERE login = '"+login+"')");
				break;
			default:
				break;
		}
		JTextField valeur_txt = new JTextField();
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
		
		
		JLabel assurances_label = new JLabel("Votre/Vos assurance(s) : ",JTextField.CENTER);
		assurances_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(assurances_label);
		
		//R�cup�ration de/des assurance(s) (Habitation,Sant� ou V�hicule) dans la bases de donn�es
		JComboBox<String> liste_assu = new JComboBox<String>();
		
		liste_assu.addItem("");
		try {
			while (assurances.next()) {
					liste_assu.addItem("Assurance "+type+" n."+IDAssu+" du "+DateJJMMYYY(assurances.getDate(2).toString()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pan.add(liste_assu);
		
		
		
		JPanel button = new JPanel(new GridLayout(1,3));
		JButton declarer = new JButton("D�clarer le sinistre");
			declarer.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (liste_sin.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "D�solez, vous ne disposez d'aucune assurance. "
							+ "Veuillez soucrire � une assurance avant la d�claration d'un sinistre.");
					}else {
						declarer.addActionListener(event -> LancerDeclaration(liste_sin.getSelectedItem().toString(),Float.parseFloat(valeur_txt.getText())));
					}
					
				}
			});
		button.add(new JLabel(""));
		button.add(declarer);
		button.add(new JLabel(""));
		
		this.add(pan);
		this.add(button);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("D�claration d'un sinnistre");   
        this.pack();
        this.setSize(500,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	
	public void LancerDeclaration(String name, float cost) {
		Sinistre sin = new Sinistre(name);
		String bien = null;
		
		JFrame fen = new JFrame("Bien � assurer");
		fen.setLayout(new GridLayout(2,1));
		
		JPanel pan = new JPanel(new GridLayout(1,2));
		
		JLabel bien_label = new JLabel("Choisissez le bien � assurer :");
		bien_label.setFont(new Font("Arial",Font.TYPE1_FONT, 15));
		pan.add(bien_label);
		
		JComboBox<String> liste_bien = new JComboBox<String>();
		
		if (sin.getSector().equals("Habitation")) {
			
			ResultSet biens = bdd.getResult("SELECT * FROM Residency WHERE idResident = '"+user.getIdPerson()+"'");
			try {
				while(biens.next()) {
					
				}
			} catch (SQLException e) {
				System.out.println("Erreur de r�cup�ration des biens.");
			}
			
		}else if (sin.getSector().equals("V�hicule")){
			ResultSet biens = bdd.getResult("SELECT * FROM Driving WHERE DriverID = '"+user.getIdPerson()+"'");
			try {
				while(biens.next()) {
					
				}
			} catch (SQLException e) {
				System.out.println("Erreur de r�cup�ration des biens.");
			}
			
		}
		pan.add(liste_bien);
		
		JButton declarer = new JButton("Calculer le taux");
		declarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refund ref = new Refund(name,IDAssu,cost,user,sin,bien);
				if (ref.isInscrit()) {
					JOptionPane.showMessageDialog(null, "Votre sinitre est enregistr�. Votre assurance payera "+ref.getRate()+"% de ce que vous devrez payer.");
					fen.dispose();
					new PageAccueil(user.getLogin());
				}
				
			}
		});
		fen.add(pan);
		fen.add(declarer);
		fen.setSize(500,100);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
		
	}
	
	public String DateJJMMYYY(String date) {
		String[] tab = date.split("-");
		return tab[2]+"-"+tab[1]+"-"+tab[0];
	}



	public static void main(String[] args) {
		new DeclarerSinistre("V�hicule","35004835");
	}
}


