package Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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


/**
 * Inscription est la classe permettant de s'inscrire au logiciel K-assure.
 * 
 * @author Charpentier Ewan,Rittaud Paul,Mathurin-Cayol
 * @version 3.0
 * */
public class Inscription{
	
	/**
	  * Nom de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String name;
	
	/**
	  * Pr�nom de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String surname;
	
	/**
	  * Cat�gorie de l'utilisateur (Adulte ou Enfant).
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
	  * Num�ro de t�l�phone de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
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
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String familySituation;
	
	/**
	  * Email de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
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
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String numberOfChild;

	
	/**
	  * Revenu net de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String netIncome;
	
	/**
	  * Profession de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private String profession;
	
	/**
	  * Mot de passe de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private String pwd;
	
	/**
	  *	Login du parent 1 de l'utilisateur.
	  * (Cas o� l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private String loginparent1;
	
	/**
	  *	Login du parent 2 de l'utilisateur.
	  * (Cas o� l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private String loginparent2;
	
	/**
	 * Connexion � la base de donn�es.
	 * 
	 * <p>
	 * Pour plus d'informations sur la connexion � la base de donn�es,regarder 
	 * la documentation de la classe BDconnection.
	 * </p>
	 * @see BDconnection
	 * @since 1.0
	 * */
	private static BDconnection bdd = new BDconnection();
	
	/**
	 * Interface principale contenant les �l�ments permettant l'inscription.
	 * 
	 * @since 1.0
	 **/
	private JFrame fenetre1;
	
	/**
	 * Interface demandant la cat�gorie � l'utilisateur afin d'adapter le formulaire.
	 * 
	 * @since 1.0
	 **/
	private JFrame demande;
	
	/**
	  * Case d'entr�e du num�ro de t�l�phone de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField numero;
	
	/**
	  * Case d'entr�e de la date de naissance de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField date;
	
	/**
	  * Case d'entr�e du code postal de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField postal;
	
	/**
	  * Case d'entr�e du nombre d'enfants de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JFormattedTextField nombre;
	
	/**
	  * Case d'entr�e du revenu net annuel de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JTextField annuel;
	
	/**
	  * Case d'entr�e du pr�nom de l'utilisateur.
	  * 
	  * @since 1.0
	  * */
	private JTextField surnam;
	
	/**
	  * Case d'entr�e du nom de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField nam;
	
	/**
	  * Case d'entr�e du sexe de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JComboBox<String> sex;
	
	/**
	  * Case d'entr�e de l'adresse de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField adresss;
	
	/**
	  * Case d'entr�e de la ville de naissance de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField birthciti;
	/**
	  * Case d'entr�e de la situation familiale de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JComboBox<String> familiale;
	
	/**
	  * Case d'entr�e de l'email de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField mail;
	
	/**
	  * Case d'entr�e de la ville de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField city;
	
	/**
	  * Case d'entr�e de la profession de l'utilisateur.
	  * (Cas o� l'utilisateur est un adulte)
	  * 
	  * @since 1.0
	  * */
	private JComboBox<String> professionel;
	
	/**
	  * Case d'entr�e du mot de passe de l'utilisateur
	  * 
	  * @since 1.0
	  * */
	private JTextField secret;
	
	/**
	  * Case d'entr�e du login parent 1 de l'utilisateur
	  * (Cas o� l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private JTextField loginp1;
	
	/**
	  * Case d'entr�e du login parent 2 de l'utilisateur
	  * (Cas o� l'utilisateur est un enfant)
	  * 
	  * @since 2.0
	  * */
	private JTextField loginp2;
	
	
	/**Constructeur 1 Inscription
	  * <p>
	  * Cr�e un formulaire d'inscription pour l'utilisateur.
	  * </p>
	  * @param _cat
	  * 		Cat�gorie de l'utilisateur
	  * @since 1.0
	  * */
	public Inscription(String _cat) {
		
		category = _cat;
			
		fenetre1 = new JFrame("Inscription "+_cat);
		fenetre1.setLayout(new FlowLayout());
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre1.setResizable(true);
		JPanel panel1 = new JPanel();
		
		
		if (_cat.equals("Adulte")) {
			panel1.setLayout(new GridLayout(17,2,7,7));
			fenetre1.setSize(700,650);
		}else {
			panel1.setLayout(new GridLayout(15,2,7,7));
			fenetre1.setSize(700,550);
		}
		
		
		
		JLabel surnames = new JLabel("Nom :");
		surnam = new JTextField();
		panel1.add(surnames);
		panel1.add(surnam);
		
		JLabel names = new JLabel("Prenom :");
		nam = new JTextField();
		panel1.add(names);
		panel1.add(nam);

		
		JLabel sexes = new JLabel("Sexe :");
		sex = new JComboBox<String>();
		sex.addItem("");
		sex.addItem("Homme");
		sex.addItem("Femme");
		sex.addItem("Non binaire");
		panel1.add(sexes);
		panel1.add(sex);
		
		
		if (_cat.equals("Adulte")) {
			JLabel number = new JLabel("Num�ro de t�l�phone : ");
			try {
		         MaskFormatter formatter = new MaskFormatter("##-##-##-##-##");
		         formatter.setPlaceholderCharacter('#');
		         numero = new JFormattedTextField(formatter);
		         numero.setColumns(20);
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
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		panel1.add(birthdates);
		panel1.add(date);
		
		JLabel birthcities = new JLabel("Ville de naissance :");
		birthciti = new JTextField();
		panel1.add(birthcities);
		panel1.add(birthciti);
		
		if (_cat.equals("Adulte")) {
			JLabel situation = new JLabel("Situation familiale :");
			familiale = new JComboBox<String>();
			familiale.addItem("");
			familiale.addItem("Mari�.e");
			familiale.addItem("Pacs�.e");
			familiale.addItem("Divorc�.e");
			familiale.addItem("S�par�.e");
			familiale.addItem("C�libataire");
			familiale.addItem("Veuf.ve");
			panel1.add(situation);
			panel1.add(familiale);
		}
		
		if (_cat.equals("Adulte")) {
			JLabel i = new JLabel("Adresse email :");
			mail = new JTextField();
			panel1.add(i);
			panel1.add(mail);
		}
		
		JLabel adresse = new JLabel("Adresse :");
		adresss = new JTextField();
		panel1.add(adresse);
		panel1.add(adresss);
		
		JLabel Ville = new JLabel("Ville :");
		city = new JTextField();
		panel1.add(Ville);
		panel1.add(city);
		
		JLabel code = new JLabel("Code postal : ");
		try {
	         MaskFormatter formatter = new MaskFormatter("#####");
	         formatter.setPlaceholderCharacter('#');
	         postal = new JFormattedTextField(formatter);
	         postal.setColumns(20);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		panel1.add(code);
		panel1.add(postal);
		
		if (_cat.equals("Adulte")) {
			JLabel enfant = new JLabel("Nombre d'enfants : ");
			try {
		         MaskFormatter formatter = new MaskFormatter("#");
		         formatter.setPlaceholderCharacter('#');
		         nombre = new JFormattedTextField(formatter);
		         nombre.setColumns(20);
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
			panel1.add(enfant);
			panel1.add(nombre);
		}
		
		if (_cat.equals("Adulte")) {
		JLabel revenue = new JLabel("Revenu annuel : ");
		annuel = new JTextField();
		annuel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\u0008') {
	               annuel.setEditable(true);
	            } else {
	               annuel.setEditable(false);
	            }
	         }
	      });
		panel1.add(revenue);
		panel1.add(annuel);
		
		JLabel professions = new JLabel("Profession :");
		professionel = new JComboBox<String>();
		professionel.addItem("");
		professionel.addItem("Salari�.e");
		professionel.addItem("Salari�.e cadre");
		professionel.addItem("Fonction publique d'�tat");
		professionel.addItem("Fonction publique territoriale");
		professionel.addItem("Fonction publique hospitali�re");
		professionel.addItem("Artisan.e");
		professionel.addItem("Ouvrier.�re");
		professionel.addItem("Commer�ant.e");
		professionel.addItem("Profession lib�rale");
		professionel.addItem("Chef.ffe d'entreprise");
		professionel.addItem("Enseignant.e");
		professionel.addItem("Agriculteur.se");
		professionel.addItem("Exploitant.e agricole");
		professionel.addItem("VRP(voyageur.se,repr�sentant.e,placier.�re)");
		professionel.addItem("Visiteur.se m�dical");
		professionel.addItem("Etudiant.e");
		professionel.addItem("Etudiant.e boursier.�re");
		professionel.addItem("Retrait�.e");
		professionel.addItem("Sans profession");
		professionel.addItem("En recherche d'emploi");
		panel1.add(professions);
		panel1.add(professionel);
		}
		
		if(_cat.equals("Enfant")) {
			JLabel loginp1txt = new JLabel("Login parent 1 :");
			loginp1 = new JTextField();
			panel1.add(loginp1txt);
			panel1.add(loginp1);
			
			JLabel loginp2txt = new JLabel("Login parent 2 :");
			loginp2 = new JTextField();
			panel1.add(loginp2txt);
			panel1.add(loginp2);
		}
		
		
		JLabel mdp = new JLabel("mot de passe : ");
		secret = new JTextField();
		secret.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ki) {
	            if (ki.getKeyChar() >= '0' && ki.getKeyChar() <= '9' || ki.getKeyChar() >= 'a' && ki.getKeyChar() <= 'z' || ki.getKeyChar() >= 'A' && ki.getKeyChar() <= 'Z' || ki.getKeyChar() == '\u0008') {
	               secret.setEditable(true);
	            } else {
	               secret.setEditable(false);
	            }
	         }
	      });
		panel1.add(mdp);
		panel1.add(secret);
		
	
		JButton inscription = new JButton("Inscription");
		inscription.addActionListener(event -> inscrit(_cat));
		panel1.add(inscription);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(event -> retour());
		panel1.add(retour);
		
		
		fenetre1.add(panel1);
		fenetre1.setLocationRelativeTo(null);
		fenetre1.setVisible(true);
		
		}
	
	/**Constructeur 2 Inscription
	 * <p>
	  * Demande � l'utilisateur sa cat�gorie.
	  *</p>
	  * 
	  * @see Inscription#setCategory
	  * @since 2.0
	  * */
	public Inscription() {
		demande = new JFrame("Vous �tes ?");
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3, 1,5,5));
		JLabel txt = new JLabel("De quel cat�gorie �tes vous ?",JLabel.CENTER);
		JButton b1 = new JButton("Enfant");
		JButton b2 = new JButton("Adulte");
		b1.setPreferredSize(new Dimension(200,50));
		b1.setPreferredSize(new Dimension(200,50));
		b1.addActionListener(event -> setCategory(b1.getText()));
		b2.addActionListener(event -> setCategory(b2.getText()));
		pan.add(txt);
		pan.add(b1);
		pan.add(b2);
		demande.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		demande.setPreferredSize(new Dimension(400,200));
	    demande.setContentPane(pan);
	    demande.pack();
	    demande.setLocationRelativeTo(null);
	    demande.setVisible(true);
	}
	

	/**
	 * R�cup�re la cat�gorie entr�e par l'utilisateur puis cr�e un formulaire adapt�.
	  * 
	  *@param cat
	  * 		Cat�gorie de l'utilisateur.
	  * @since 2.0
	  * */
	public void setCategory(String cat) {
		demande.dispose();
		new Inscription(cat);
		
	}
	
	
	/**
	 * Inscrit l'utilisateur dans la base de donn�es,
	 * donne un identifiant unique et redirige vers la page de connexion.
	  * 
	  * @param cat
	  * 		Cat�gorie de l'utilisateur.
	  * @since 1.0
	  * */
	public void inscrit(String cat) {
		
		name = surnam.getText();
		 surname = nam.getText();
		 sexe = sex.getSelectedItem().toString();
		 category = cat;
		 adress = adresss.getText();
		 birthdate = date.getText();
		 birthcity = birthciti.getText();
		 ville = city.getText();
		 zipCode = postal.getText();
		 pwd = secret.getText();
		 
		 if (category.equals("Adulte")) {
			 phoneNumber = numero.getText();
			 email = mail.getText();
			 familySituation = familiale.getSelectedItem().toString();
			 numberOfChild = nombre.getText();
			 netIncome = annuel.getText();
			 profession = professionel.getSelectedItem().toString();
		}else {
			loginparent1 = loginp1.getText();
			loginparent2 = (loginp2.getText().equals("x")) ? "NULL" : loginp2.getText();
		}
		
		 if (!ChampsVide()) {
			 if (DateValid(birthdate)) {
			
				 if (EmailValidator(email)) {

					String login = LoginGenerator();
					String req,req2 = null;
					if (category.equals("Adulte")) {
						req = "INSERT INTO `Person`(`name`, `surname`,`sexe`, `login`, `pwd`, `category`, `adress`,"
								+ " `phoneNumber`, `birthdate`,`birthcity`, `family_situation`, `email`, `ville`, `zipCode`,"
								+ " `numberOfChild`, `driverLicenceDate`, `netIncome`, `profession`) VALUES ('"+name
								+"','"+surname+"','"+sexe+"','"+login+"','"+pwd+"','"+category+"','"+adress+"','"
								+phoneNumber+"',"+dateFormatSQL(birthdate)+",'"+birthcity+"','"+familySituation
								+"','"+email+"','"+ville+"','"+zipCode+"','"+numberOfChild+"','"+netIncome+"','"+profession+"')";			
					} else {
						req = "INSERT INTO `Person`(`name`, `surname`,`sexe`, `login`, `pwd`, `category`, `adress`,"
								+ " `phoneNumber`, `birthdate`,`birthcity`, `family_situation`, `email`, `ville`, `zipCode`,"
								+ " `numberOfChild`, `driverLicenceDate`, `netIncome`, `profession`) VALUES ('"+name
								+"','"+surname+"','"+sexe+"','"+login+"','"+pwd+"','"+category+"','"+adress+"',NULL"
								+","+dateFormatSQL(birthdate)+",'"+birthcity+"',NULL,NULL,'"+ville+"','"+zipCode+"',NULL,NULL,NULL);";
						req2 = "INSERT INTO `Child`(`loginChild`, `loginParent1`, `loginParent2`, `name`, `surname`, `birthDate`)  VALUES "
								+ "('"+login+"','"+loginparent1+"','"+loginparent2+"','"+name+"','"+surname+"',"+dateFormatSQL(birthdate)+")";
					}
					if ( (category.equals("Enfant") && exist(loginparent1)) ) {
						if (loginparent2.equals("NULL") ^ exist(loginparent2)) { 
							bdd.executeQuery(req);
							bdd.executeQuery(req2);
							fenetre1.dispose();
							JOptionPane.showMessageDialog(null, "Votre inscription est termin�e. Votre login est "+login+".");
							new PagedeConnection();
						}else {
							JOptionPane.showMessageDialog(null, "Un des deux parents n'existe pas.");
						}
					}else if(category.equals("Adulte")) {
						bdd.executeQuery(req);
						fenetre1.dispose();
						JOptionPane.showMessageDialog(null, "Votre inscription est termin�e. Votre login est "+login+".");
						new PagedeConnection();
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
	 * Permet de retourner � la page de connexion.
	  * 
	  * @see PagedeConnection
	  * @since 2.0
	  * */
	public void retour() {
		fenetre1.dispose();
		new PagedeConnection();
	}
	
	/**
	 * V�rifie si l'ann�e en param�tre est bissextile
	 * 
	  *@param year
	  *		Ann�e � v�rifier. 
	  *@return true si l'ann�e est bissextile,false sinon.
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
	 * V�rifie si la date en param�tre est valide et inferieur � la date du jour.
	 * 
	  *@param date
	  *		Date � v�rifier. 
	  *@return true si la date est valide,false sinon.
	  *@see Inscription#jours30
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
	  * V�rifie si le mois entr� en param�tre � 30 jours.
	  * 
	  *@param mois
	  *		Mois � v�rifier. 
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
		 * V�rifie si l'email en param�tre est valide.
		 * 
		  *@param email
		  *		Email � v�rifier. 
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
	  * V�rifie si les champs du formulaires sont vides.
	  * 
	  * @return True si au moins un champ obligatoire est vide,false sinon.
	  * @since 1.0
	  * */
	public boolean ChampsVide() {
		if (category.equals("Adulte") && (name.equals("") || surname.equals("") || sexe.equals("") || adress.equals("") || phoneNumber.equals("##-##-##-##-##") 
				|| birthdate.equals("##-##-####") || birthcity.equals("")
				|| email.equals("") || ville.equals("") || zipCode.equals("#####") || numberOfChild.equals("#") 
				|| netIncome.equals("") || pwd.equals(""))) {		
			return true;
		}else if(category.equals("Enfant") && (name.equals("") || surname.equals("") || sexe.equals("") || adress.equals("") || 
				birthdate.equals("##-##-####") || ville.equals("") || zipCode.equals("#####") || loginparent1.equals("") || pwd.equals("")))  {
			return true;
		}
		return false;
	}
	
	

	/**
	 * G�n�re un login al�atoire unique.
	  * 
	  * @return Un Login compos� de 7 chiffre.
	  * 
	  * @see Inscription#exist
	  * @since 1.0
	  * */
	public static String LoginGenerator() {
		while(true) {
			String numbers = "0123456789";
			String login = "";
			for (int i = 0; i < 8; i++) {
				login += numbers.charAt((int)(Math.random()*(numbers.length())));
			}
			
			if(!exist(login))
				return login;
			
		}
	}

	/**
	 * V�rifie si l'utilisateur existe dans la base de donn�es.
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
	 * Mets la date en param�tre en format YYYY/MM/JJ
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
