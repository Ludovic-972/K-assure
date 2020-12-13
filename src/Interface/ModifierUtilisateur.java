package Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.*;
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


/**
 * ModifierUtilisateur est la classe permettant de modifier les informations de l'utilisateur.
 * 
 * @author Charpentier Ewan,Rittaud Paul,Mathurin-Cayol, Gaëtan Lory
 * @version 3.0
 * */
public class ModifierUtilisateur{
	
	/**
	  * Nom de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String name;
	
	/**
	  * Prénom de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String surname;
	
	/**
	  * Catégorie de l'utilisateur (Adulte ou Enfant).
	  * 
	  * @since 1.0
	  * */
	private String category;
	
	/**
	  * Sexe de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String sexe;
	
	/**
	  * Adresse de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String adress;
	
	/**
	  * Numéro de téléphone de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String phoneNumber;
	
	/**
	  * Date de naissance de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String birthdate;
	
	/**
	  * Ville de naissance de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String birthcity;
	
	/**
	  * Situation familiale de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String familySituation;
	
	/**
	  * Email de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String email;
	
	/**
	  * Ville de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String ville;
	
	/**
	  * Code postal de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String zipCode;
	
	/**
	  * Nombre d'enfants de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String numberOfChild;

	
	
	/**
	  * Profession de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String profession;

	/**
	  *	Login du parent 1 de l'utilisateur.
	  * (Cas où l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private String loginparent1;
	
	/**
	  *	Login du parent 2 de l'utilisateur.
	  * (Cas où l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private String loginparent2;
	
	/**
	 * Connexion à la base de données.
	 * 
	 * <p>
	 * Pour plus d'informations sur la connexion à la base de données,regarder 
	 * la documentation de la classe BDconnection.
	 * </p>
	 * @see BDconnection
	 * @since 1.0
	 * */
	private static BDconnection bdd = new BDconnection();
	
	/**
	 * Interface principale contenant les éléments permettant l'inscription.
	 * 
	 * @since 1.0
	 **/
	private JFrame fenetre1;
	
	/**
	 * Interface demandant la catégorie à l'utilisateur afin d'adapter le formulaire.
	 * 
	 * @since 1.0
	 **/
	private JFrame demande;
	
	/**
	  * Case d'entrée du numéro de téléphone de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField numero;
	
	/**
	  * Case d'entrée de la date de naissance de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField date;
	
	/**
	  * Case d'entrée du code postal de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField postal;
	
	/**
	  * Case d'entrée du nombre d'enfants de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField nombre;
	
	
	/**
	  * Case d'entrée du prénom de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JTextField surnam;
	
	/**
	  * Case d'entrée du nom de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField nam;
	
	/**
	  * Case d'entrée du sexe de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JComboBox<String> sex;
	
	/**
	  * Case d'entrée de l'adresse de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField adresss;
	
	/**
	  * Case d'entrée de la ville de naissance de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField birthciti;
	/**
	  * Case d'entrée de la situation familiale de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JComboBox<String> familiale;
	
	/**
	  * Case d'entrée de l'email de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField mail;
	
	/**
	  * Case d'entrée de la ville de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField city;
	
	/**
	  * Case d'entrée de la profession de l'utilisateur.
	  * (Cas où l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JComboBox<String> professionel;
	

	/**
	  * Case d'entrée du login parent 1 de l'utilisateur
	  * (Cas où l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private JTextField loginp1;
	
	/**
	  * Case d'entrée du login parent 2 de l'utilisateur
	  * (Cas où l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private JTextField loginp2;
	
	private Person user;
	
	
	/**Constructeur 1 ModifierUtilisateur
	  * <p>
	  * Crée un formulaire de Modifiaction pour l'utilisateur ou l'admin.
	  * </p>
	  * @param Login
	  * 		code de l'utilisateur
	  * @since 1.0
	  * */
	public ModifierUtilisateur(String Login) {
		user = new Person(Login);
			
		fenetre1 = new JFrame("Modification "+user.getName());
		fenetre1.setLayout(new FlowLayout());
		fenetre1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre1.setResizable(true);
		JPanel panel1 = new JPanel();
		
		
		if (user.getCategory().equals("Adulte")) {
			panel1.setLayout(new GridLayout(17,2,7,7));
			fenetre1.setSize(700,650);
		}else {
			panel1.setLayout(new GridLayout(15,2,7,7));
			fenetre1.setSize(700,550);
		}
		
		
		
		JLabel surnames = new JLabel("Nom :");
		surnam = new JTextField();
		surnam.setText(user.getSurname());
		panel1.add(surnames);
		panel1.add(surnam);
		
		JLabel names = new JLabel("Prenom :");
		nam = new JTextField();
		nam.setText(user.getName());
		panel1.add(names);
		panel1.add(nam);

		
		JLabel sexes = new JLabel("Sexe :");
		sex = new JComboBox<String>();
		sex.addItem(user.getSexe());
		sex.addItem("Homme");
		sex.addItem("Femme");
		sex.addItem("Non binaire");
		panel1.add(sexes);
		panel1.add(sex);
		
		
		if (user.getCategory().equals("Adulte")) {
			JLabel number = new JLabel("Numéro de téléphone : ");
			try {
		         MaskFormatter formatter = new MaskFormatter("##-##-##-##-##");
		         formatter.setPlaceholderCharacter('#');
		         numero = new JFormattedTextField(formatter);
		         numero.setColumns(20);
		         numero.setText(user.getPhoneNumber());
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
			panel1.add(number);
			panel1.add(numero);
		}
		
		JLabel birthdates = new JLabel("Date de naissance : ");
		try {
	         MaskFormatter formatter = new MaskFormatter("##-##-####");
	         formatter.setPlaceholderCharacter('#');
	         date = new JFormattedTextField(formatter);
	         date.setColumns(20);
	         date.setText(user.getBirthdate());
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		panel1.add(birthdates);
		panel1.add(date);
		
		JLabel birthcities = new JLabel("Ville de naissance :");
		birthciti = new JTextField();
		birthciti.setText(user.getBirthcity());
		panel1.add(birthcities);
		panel1.add(birthciti);
		
		if (user.getCategory().equals("Adulte")) {
			JLabel situation = new JLabel("Situation familiale :");
			familiale = new JComboBox<String>();
			familiale.addItem(user.getFamilySituation());
			familiale.addItem("Marié.e");
			familiale.addItem("Pacsé.e");
			familiale.addItem("Divorcé.e");
			familiale.addItem("Séparé.e");
			familiale.addItem("Célibataire");
			familiale.addItem("Veuf.ve");
			panel1.add(situation);
			panel1.add(familiale);
		}
		
		if (user.getCategory().equals("Adulte")) {
			JLabel i = new JLabel("Adresse email :");
			mail = new JTextField();
			mail.setText(user.getEmail());
			panel1.add(i);
			panel1.add(mail);
		}
		
		JLabel adresse = new JLabel("Adresse :");
		adresss = new JTextField();
		adresss.setText(user.getAddress());
		panel1.add(adresse);
		panel1.add(adresss);
		
		JLabel Ville = new JLabel("Ville :");
		city = new JTextField();
		city.setText(user.getCity());
		panel1.add(Ville);
		panel1.add(city);
		
		JLabel code = new JLabel("Code postal : ");
		try {
	         MaskFormatter formatter = new MaskFormatter("#####");
	         formatter.setPlaceholderCharacter('#');
	         postal = new JFormattedTextField(formatter);
	         postal.setColumns(20);
	         postal.setText(user.getZipCode());
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		panel1.add(code);
		panel1.add(postal);
		
		if (user.getCategory().equals("Adulte")) {
			JLabel enfant = new JLabel("Nombre d'enfants : ");
			try {
		         MaskFormatter formatter = new MaskFormatter("#");
		         formatter.setPlaceholderCharacter('#');
		         nombre = new JFormattedTextField(formatter);
		         nombre.setColumns(20);
		         nombre.setText(String.valueOf(user.getNumberOfChild()));
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
			panel1.add(enfant);
			panel1.add(nombre);
		}
		
		if (user.getCategory().equals("Adulte")) {		
		JLabel professions = new JLabel("Profession :");
		professionel = new JComboBox<String>();
		professionel.addItem(user.getProfession());
		professionel.addItem("Salarié.e");
		professionel.addItem("Salarié.e cadre");
		professionel.addItem("Fonction publique d'état");
		professionel.addItem("Fonction publique territoriale");
		professionel.addItem("Fonction publique hospitalière");
		professionel.addItem("Artisan.e");
		professionel.addItem("Ouvrier.ère");
		professionel.addItem("Commerçant.e");
		professionel.addItem("Profession libérale");
		professionel.addItem("Chef.ffe d'entreprise");
		professionel.addItem("Enseignant.e");
		professionel.addItem("Agriculteur.se");
		professionel.addItem("Exploitant.e agricole");
		professionel.addItem("VRP(voyageur.se,représentant.e,placier.ère)");
		professionel.addItem("Visiteur.se médical");
		professionel.addItem("Etudiant.e");
		professionel.addItem("Etudiant.e boursier.ère");
		professionel.addItem("Retraité.e");
		professionel.addItem("Sans profession");
		professionel.addItem("En recherche d'emploi");
		panel1.add(professions);
		panel1.add(professionel);
		}
		
		if(user.getCategory().equals("Enfant")) {
			JLabel loginp1txt = new JLabel("Login parent 1 :");
			loginp1 = new JTextField();
			panel1.add(loginp1txt);
			panel1.add(loginp1);
			
			JLabel loginp2txt = new JLabel("Login parent 2 :");
			loginp2 = new JTextField();
			panel1.add(loginp2txt);
			panel1.add(loginp2);
		}
		

		JButton inscription = new JButton("Modifiez");
		inscription.addActionListener(event -> inscrit(user.getCategory()));
		panel1.add(inscription);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(event -> retour());
		panel1.add(retour);
		
		
		fenetre1.add(panel1);
		fenetre1.setLocationRelativeTo(null);
		fenetre1.setVisible(true);
		
		}
			
	/**
	 * Modifie les informations de  l'utilisateur dans la base de données,
	  * 
	  * @param cat
	  * 		Catégorie de l'utilisateur.
	  * @since 1.0
	  * */
	public void inscrit(String cat) {
	String 	login= user.getLogin();
		name = surnam.getText();
		 surname = nam.getText();
		 sexe = sex.getSelectedItem().toString();
		 category = cat;
		 adress = adresss.getText();
		 birthdate = date.getText();
		 birthcity = birthciti.getText();
		 ville = city.getText();
		 zipCode = postal.getText();
		 
		 if (category.equals("Adulte")) {
			 phoneNumber = numero.getText();
			 email = mail.getText();
			 familySituation = familiale.getSelectedItem().toString();
			 numberOfChild = nombre.getText();
			 profession = professionel.getSelectedItem().toString();
		}else {
			loginparent1 = loginp1.getText();
			loginparent2 = (loginp2.getText().equals("x")) ? "NULL" : loginp2.getText();
		}
		
		 if (!ChampsVide()) {
			 if (DateValid(birthdate)) {
			
				 if (EmailValidator(email)) {

					String req,req2 = null;
					if (category.equals("Adulte")) {
						req = "UPDATE `Person` SET `name`='"+name+"',`surname`='"+surname+"',`sexe`='"+sexe+"',"
								+"`login`='"+login+"',`category`='"+category+"',`adress`='"+adress+"',`phoneNumber`='"+phoneNumber+"',"
								+"`birthdate`="+dateFormatSQL(birthdate)+",`birthcity`='"+birthcity+"',`family_situation`='"+familySituation+"',`email`='"+email+"',"
								+"`ville`='"+ville+"',`zipCode`='"+zipCode+"',`numberOfChild`='"+numberOfChild+"',`profession`='"+profession+"'WHERE login ='"+user.getLogin()+"';";
						
						
					} else {
						req = "UPDATE `Person` SET `name`='"+name+"',`surname`='"+surname+"',`sexe`='"+sexe+"',"
								+"`login`='"+login+"',`category`='"+category+"',`adress`='"+adress+"',`phoneNumber`='"+phoneNumber+"',"
								+"`birthdate`="+dateFormatSQL(birthdate)+",`birthcity`='"+birthcity+"',`family_situation`='"+familySituation+"',`email`='"+email+"',"
								+"`ville`='"+ville+"',`zipCode`='"+zipCode+"',`numberOfChild`='"+numberOfChild+"',`profession`='"+profession+"'WHERE login	=`"+user.getLogin()+"`;";	
					}
					if ( (category.equals("Enfant") && exist(loginparent1)) ) {
						if (loginparent2.equals("NULL") ^ exist(loginparent2)) { 
							bdd.executeQuery(req);
							bdd.executeQuery(req2);
							fenetre1.dispose();
							JOptionPane.showMessageDialog(null, "Modification effectuer");
						}else {
							JOptionPane.showMessageDialog(null, "Un des deux parents n'existe pas.");
						}
					}else if(category.equals("Adulte")) {
						bdd.executeQuery(req);
						fenetre1.dispose();
						JOptionPane.showMessageDialog(null, "Modification Effectuer");
						
					}
					
						
				} else {
					JOptionPane.showMessageDialog(null, "Email non valide.");
		        }
			}else {
				JOptionPane.showMessageDialog(null, "Date non valide.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
		}
				
	}
	
	/**
	 * Permet de retourner à la page de Comtpe de l'utilisateur.
	  * 
	  * @see Compte
	  * @since 2.0
	  * */
	public void retour() {
		fenetre1.dispose();
		new Compte(user.getLogin());
	}
	
	/**
	 * Vérifie si l'année en paramètre est bissextile
	 * 
	  *@param year
	  *		Année à vérifier. 
	  *@return true si l'année est bissextile,false sinon.
	  * @since 3.0
	  * */
	public static boolean bissextile(int year) {

	    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
	        return true;
	    } else {
	        return false;
	    }
	    }
	 
	
	/**
	 * Vérifie si la date en paramètre est valide et inferieur à la date du jour.
	 * 
	  *@param date
	  *		Date à vérifier. 
	  *@return true si la date est valide,false sinon.
	  *@see ModifierUtilisateur#jours30
	  *@since 3.0
	  * 
	  */
	 public static boolean DateValid(String date){
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
	  * Vérifie si le mois entré en paramètre à 30 jours.
	  * 
	  *@param mois
	  *		Mois à vérifier. 
	  *@return true si le mois a 30 jours,false sinon.
	  *@since 3.0
	  * 
	  */
	 public static boolean jours30(int mois) {
		 int[] tab = {4,6,9,11};
		 for (int a : tab) {
			if (a == mois) {
				return true;
			}
		}
		 return false;
	 }
		
	 /**
		 * Vérifie si l'email en paramètre est valide.
		 * 
		  *@param email
		  *		Email à vérifier. 
		  *@return True si l'email est valide,false sinon.
		  *@since 3.0
		  * 
		  */
	 public static boolean EmailValidator(String email) {
		 if (email == null) {
			return true;
		}
		return email.matches("^[a-zA-Z1-9-\\.]+@[a-zA-Z1-9-]+\\.[a-zA-Z]{2,6}$");

	    }
		
	 /**
	  * Vérifie si les champs du formulaires sont vides.
	  * 
	  * @return True si au moins un champ obligatoire est vide,false sinon.
	  * @since 1.0
	  * */
	public boolean ChampsVide() {
		if (category.equals("Adulte") && (name.equals("") || surname.equals("") || sexe.equals("") || adress.equals("") || phoneNumber.equals("##-##-##-##-##") 
				|| birthdate.equals("##-##-####") || birthcity.equals("")
				|| email.equals("") || ville.equals("") || zipCode.equals("#####") || numberOfChild.equals("#"))){		
			return true;
		}else if(category.equals("Enfant") && (name.equals("") || surname.equals("") || sexe.equals("") || adress.equals("") || 
				birthdate.equals("##-##-####") || ville.equals("") || zipCode.equals("#####") || loginparent1.equals(""))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Vérifie si l'utilisateur existe dans la base de données.
	  * 
	  * @param login
	  * 	Login de l'utilisateur
	  *@return True si l'utilisateur existe,false sinon.
	  * @since 1.0
	  * */
	public static boolean exist(String login) {
		String req = "Select * from Person where login = \""+login+"\"";
		ResultSet rs =bdd.getResult(req);
		return bdd.getRowCount(rs) !=0; 
	}
	
	
	/**
	 * Mets la date en paramètre en format YYYY/MM/JJ
	  * 
	  * @param date
	  * 		Date en format JJ/MM/YYYY
	  * 
	  * @return Date en format YYYY/MM/JJ
	  * 
	  * @since 3.0
	  * */
	public static String dateFormatSQL(String date) {
		String[] tab = date.split("-");
		date = String.join("-", tab[2],tab[1],tab[0]);
		return "'"+date+"'";
	}
	

}

