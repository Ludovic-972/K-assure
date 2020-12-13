package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Assurance.carInsurance;
import Assurance.homeInsurance;
import BDgestion.BDconnection;
import Gestion.*;

/**
 * Compte est la page qui permet à l'utilisateur connecter d'avoir acces au information de son compte
 * <p>
 * Elle permet aussià l'utilisateur de modifier les informations enregistrer via un bouton qui renvoie vers la page de Modification
 *  </p>
 * @author Gaëtan Lory, Ludovic Mathurin-Cayol
 * @version 1.0
 * */
public class Compte extends JFrame {
	/**
	 * initialisation d'un user ceci permet de garder en mémoire l'utilisater connecter et de récuperer ses informations
	 * @see Person
	 * @since 2.0
	 */
	private Person user;
	/**
     * Creation du conteneur de la page JFrame
     * @see JFrame
     * @since 1.0
     */
	private JPanel panel;
	 /**
     * Affiche d'element de texte sur la page 
     * @see JPanel
     * @since 1.0 
     */
	private JLabel login_label,login,nom_label,nom,prenom_label,prenom,email_label,email,categorie_label,categorie,adress_label,adress,ddn_label,ddn,profession_label,profession;
	/**
	 * Liste d'assurance habitation
	 * @since 2.0
	 */
	private List<homeInsurance> HoAssu_list;
	/**
	 * Liste d'assurance vehicule
	 * @since 2.0
	 */
	private List<carInsurance> VAssu_list;
	/**
	 * Boutton de résiliationn contrat de modification et de retour
	 * @since 2.0
	 */
	private JButton contrat_button,modif,retour;
	/**
	 * Connection a la BD
	 * @since2.0
	 */
	private BDconnection bdd = new BDconnection();
	
	/**<p>
	 * Consctructeur de la Page Compte 
	 * </p>
	 * <p>
	 * créer la liste des information de l'utilisateur
	 * </p>
	 * @param _user
	 * 				Login de l'utilisateur
	 * @since 2.0
	 */
	public Compte(String _user) {
		user = new Person(_user);
    		panel = new JPanel();
    		panel.setLayout(new GridLayout(10,2));

    		login_label  = new JLabel("Login : ",JLabel.CENTER);	
    	    panel.add(login_label);
    		login = new JLabel(user.getLogin());
    	    panel.add(login);
    	    
    		nom_label = new JLabel("Nom :",JLabel.CENTER);	
    	    panel.add(nom_label);
    		nom = new JLabel(user.getName());
    	    panel.add(nom);
    	    
    		prenom_label = new JLabel("Prenom :",JLabel.CENTER);
    	    panel.add(prenom_label);
    		prenom = new JLabel(user.getSurname());
    	    panel.add(prenom);
    	    
    		email_label = new JLabel("Email :",JLabel.CENTER);
    	    panel.add(email_label);
    		email = new JLabel(user.getEmail());
    	    panel.add(email);
    	    
    		categorie_label = new JLabel("Catégorie : ",JLabel.CENTER);
    	    panel.add(categorie_label);
    		categorie = new JLabel(user.getCategory());
    	    panel.add(categorie);
    	    
    		adress_label = new JLabel("Adresse:",JLabel.CENTER);
    	    panel.add(adress_label);
    		adress= new JLabel(user.getAddress());
    	    panel.add(adress);
    	    
    		ddn_label = new JLabel("Né le :",JLabel.CENTER);
    	    panel.add(ddn_label);
    		ddn = new JLabel(user.getBirthdate());
    	    panel.add(ddn);
    	    
    		profession_label = new JLabel("Profession :",JLabel.CENTER);	
    	    panel.add(profession_label);
    		profession = new JLabel(user.getProfession());
    	    panel.add(profession);
    	    
    	   
    	   contrat_button = new JButton("Voir mes contrats/biens");
    	   contrat_button.addActionListener(event-> voirContrat());
    	   panel.add(contrat_button);
    	   
    	   modif = new JButton("Modifier mes infos");
    	   modif.addActionListener(event -> modif(_user));
    	   panel.add(modif);
    	   
    	   retour = new JButton("Retour à l'accueil");
    	   retour.addActionListener(event -> retour());
    	   panel.add(retour);    		
	
    	 this.add(panel);
    	 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	 this.setTitle(user.getName()+" "+user.getSurname());     
    	 this.setSize(500,550);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);  
	}
	/**
	 * Renvoie sur la page d'accueil en sauvegardant le login enregistrer
	 * @see PageAccueil
	 * @since 2.0
	 */
	private void retour() {
		this.dispose();
		new PageAccueil(user.getLogin());
	}

	/**
	 * Methode qui permet d'afficher la totaliter des Contrats en cours pour l'utilisateur connecter
	 * @since 2.0
	 */
	public void voirContrat() {

		ResultSet HoAssu = bdd.getResult("SELECT idHoa,Residency.idResidency FROM HomeAssurance,Residency "
				+ "WHERE idAsker = (SELECT idPerson FROM Person WHERE login = '"+user.getLogin()+"')");
	    ResultSet VAssu = bdd.getResult("SELECT Distinct idVa,vehicle FROM VehicleAssurance,Driving "
	    		+ "WHERE idAsker = (SELECT idPerson FROM Person WHERE login = '"+user.getLogin()+"')");	
	    HoAssu_list = new ArrayList<homeInsurance>();
	    VAssu_list = new ArrayList<carInsurance>();
	    try {
			while (HoAssu.next()) {
				HoAssu_list.add(new homeInsurance(HoAssu.getInt(1), user.getLogin(),new Residency(HoAssu.getInt(2), user.getLogin())));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
			while (VAssu.next()) {
				VAssu_list.add(new carInsurance(VAssu.getInt(1), user.getLogin(), new Auto(user.getLogin(), VAssu.getString(2))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    
	    JFrame fenetre_assu = new JFrame("Vos contrats");
	    fenetre_assu.setLayout(new BorderLayout());
	    JPanel pan = new JPanel(new GridLayout(1,2)); //Panel principale avec les types d'assurances
	    
	    JPanel HoAssu_pan = new JPanel(new BorderLayout()); //Panel des assurances habitation
	    HoAssu_pan.add(new JLabel("Vos assurances Habitation",JLabel.CENTER),"North");
	    if (HoAssu_list.size() == 0) {
			HoAssu_pan.add(new JLabel("Pas d'assurance Habitation",JLabel.CENTER),"Center");
		}else {
			JPanel[] pan_tab = new JPanel[HoAssu_list.size()]; // Tableau de panel de x éléments avec x le nombre d'assurances
			JPanel infos_pan = new JPanel(new GridLayout(HoAssu_list.size(),1));
			int i = 0;
			for (homeInsurance assu : HoAssu_list) {
				pan_tab[i] = new JPanel(new GridLayout(3,1,0,0));
				Residency res = assu.getResidency();
				if (assu.isAllRisksCover()) {
					pan_tab[i].add(new JLabel("Assurance tout risques n."+assu.getID(),JLabel.CENTER));
				}else {
					pan_tab[i].add(new JLabel("Assurance n."+assu.getID(),JLabel.CENTER));
				}
				pan_tab[i].add(new JLabel("Qui a débuté le "+assu.getStartDate(),JLabel.CENTER));
				pan_tab[i].add(new JLabel("Assure : "+res.getType()+"("+res.getMSR()+")"+" de "+res.getTotalArea()+" m²,"+res.getNumberOfRooms()+ " pièces."),JLabel.CENTER);
				pan_tab[i].setBorder(BorderFactory.createLineBorder(Color.black));
				infos_pan.add(pan_tab[i]);
				i++;
			}
			HoAssu_pan.add(infos_pan,"Center");
		}
	    pan.add(HoAssu_pan);
	    
	    JPanel VAssu_pan = new JPanel(new BorderLayout()); // Panel des assurances auto
	    VAssu_pan.add(new JLabel("Vos assurances Véhicule",JLabel.CENTER),"North");
	    if (VAssu_list.size() == 0) {
			VAssu_pan.add(new JLabel("Pas d'assurance Véhicule",JLabel.CENTER),"Center");
		}else {
			JPanel[] pan_tab = new JPanel[VAssu_list.size()]; // Tableau de panel de x éléments avec x le nombre d'assurances
			JPanel infos_pan = new JPanel(new GridLayout(VAssu_list.size(),1));
			int i = 0;
			for (carInsurance assu : VAssu_list ) {
				pan_tab[i] = new JPanel(new GridLayout(6,1));
				Auto auto = assu.getCar();
				if (assu.isAllRisksCover()) {
					pan_tab[i].add(new JLabel("Assurance tout risques n."+assu.getID(),JLabel.CENTER));
				}else {
					pan_tab[i].add(new JLabel("Assurance n."+assu.getID(),JLabel.CENTER));
				}
				pan_tab[i].add(new JLabel("Qui a débuté le "+assu.getStartDate(),JLabel.CENTER));
				pan_tab[i].add(new JLabel("Assure : "+auto.getMake()+" "+auto.getModel()+" "+auto.getEngine(),JLabel.CENTER));
				pan_tab[i].add(new JLabel("Immatriculé "+auto.getNumberplate(),JLabel.CENTER));
				pan_tab[i].add(new JLabel("Fonction du véhicule assuré: "+auto.getFunction(),JLabel.CENTER));
				pan_tab[i].add(new JLabel("Alimentation :"+auto.getEnergy(),JLabel.CENTER));
				pan_tab[i].setBorder(BorderFactory.createLineBorder(Color.black));
				infos_pan.add(pan_tab[i]);
				i++;
			}
			VAssu_pan.add(infos_pan,"Center");
		}
	    pan.add(VAssu_pan);
	    
	    JButton supprimer = new JButton("Résilier un contrat");
	    supprimer.addActionListener(event -> resi());
	    
	    
	    fenetre_assu.add(pan,"Center");
	    fenetre_assu.add(supprimer,"South");
	    fenetre_assu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    fenetre_assu.setTitle("Mes contrats et biens");   
	    fenetre_assu.setSize(600,500);
	    fenetre_assu.setLocationRelativeTo(null);
	    fenetre_assu.setVisible(true);  
	    
	    
	}
	
	
	/**
	 * Methode qui permet de resilier le contrat selection dans le menu deroulant
	 * @since 2.0
	 */
	private void resi() {
		String[] options = { "Habitation", "Véhicule" };
    	int x =JOptionPane.showOptionDialog(null, "Quel d'assurance voulez-vouz résiliez ?", "Résilier une assurance",
    			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
    			null, options, options[0]);
    	String req = "";
    	int assu;
    	try {
    		assu = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'id du contrat à résilier"));
		} catch (Exception e) {
			assu = -1;
		}
    	
    	
    	switch (x) {
		case 0:
			req="DELETE FROM `HomeAssurance` WHERE idHoA = '"+assu+"' "
					+ "AND idAsker = (SELECT idPerson FROM Person WHERE login = '"+user.getLogin()+"')" ;
			break;
		case 1:
			req="DELETE FROM `VehicleAssurance` WHERE idVA = '"+assu+"' "
					+ "AND idAsker = (SELECT idPerson FROM Person WHERE login = '"+user.getLogin()+"')" ;
			break;
		default:
			break;
		}
    	if (assu!=1) {
    		bdd.executeQuery(req);
        	JOptionPane.showMessageDialog(null,"Votre contrat est bien résilié.");
        	this.dispose();
        	new Compte(user.getLogin());
		}
		
	}

	
	/**
	 * methode qui renvoie vers la page de modification des informations de l'utilisateur
	 * @param login
	 * @since 2.0
	 */
	private void modif(String login) {
		this.dispose();
		new ModifierUtilisateur(user.getLogin());	
	}
	
}
