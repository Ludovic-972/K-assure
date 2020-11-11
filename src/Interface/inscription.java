package Interface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;

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

@SuppressWarnings({ "unchecked", "rawtypes" })
public class inscription{
	
	private JFormattedTextField numero;
	private JFormattedTextField date;
	private JFormattedTextField postal;
	private JFormattedTextField nombre;
	private JFormattedTextField permi;
	private JTextField annuel;
	private String name;
	private String surname;
	private String category;
	private String sexe;
	private String adress;
	private String phoneNumber;
	private String birthdate;
	private String birthcity;
	private String familySituation;
	private String email;
	private String ville;
	private String zipCode;
	private String numberOfChild;
	private String driverLicenceDate;
	private String netIncome;
	private String profession;
	private String pwd;
	private String loginparent1;
	private String loginparent2;
	
	private BDconnection bdd = new BDconnection();
	private JFrame fenetre1;
	private JFrame demande;
	private JTextField surnam;
	private JTextField nam;
	private JComboBox sex;
	private JTextField adresss;
	private JTextField birthciti;
	private JComboBox familiale;
	private JTextField mail;
	private JTextField city;
	private JComboBox professionel;
	private JTextField secret;
	private JTextField loginp1;
	private JTextField loginp2;
	
	
	
	public inscription(String _cat) {
		
		category = _cat;
			
		fenetre1 = new JFrame("Inscription "+_cat);
		fenetre1.setLayout(new FlowLayout());
		fenetre1.setSize(800,800);
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre1.setLocationRelativeTo(null);
		fenetre1.setResizable(true);
		JPanel panel1 = new JPanel();
		if (_cat.equals("Adulte")) {
			panel1.setLayout(new GridLayout(18,2,7,7));
		}else {
			panel1.setLayout(new GridLayout(16,2,7,7));
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
		sex = new JComboBox();
		sex.addItem("");
		sex.addItem("Homme");
		sex.addItem("Femme");
		sex.addItem("Non binaire");
		panel1.add(sexes);
		panel1.add(sex);
		
		
		if (_cat.equals("Adulte")) {
			JLabel number = new JLabel("Numéro de téléphone : ");
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
			familiale = new JComboBox();
			familiale.addItem("");
			familiale.addItem("Marié.e");
			familiale.addItem("Pacsé.e");
			familiale.addItem("Divorcé.e");
			familiale.addItem("Séparé.e");
			familiale.addItem("Célibataire");
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
			JLabel driver = new JLabel("Date d'obtention du permis conduire* : ");
			try {
		         MaskFormatter formatter = new MaskFormatter("##-##-####");
		         formatter.setPlaceholderCharacter('#');
		         permi = new JFormattedTextField(formatter);
		         permi.setColumns(20);
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
			panel1.add(driver);
			panel1.add(permi);
		
		JLabel revenue = new JLabel("Revenu annuel : ");
		annuel = new JTextField();
		annuel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\u0008' || ke.getKeyChar() == ' ') {
	               annuel.setEditable(true);
	            } else {
	               annuel.setEditable(false);
	            }
	         }
	      });
		panel1.add(revenue);
		panel1.add(annuel);
		
		JLabel professions = new JLabel("Profession :");
		professionel = new JComboBox();
		professionel.addItem("");
		professionel.addItem("Services publics");
		professionel.addItem("Professions administratives, commerciales et de gestion");
		professionel.addItem("Commerce et artisanat");
		professionel.addItem("Hôtellerie – Restauration");
		professionel.addItem("Agronomie");
		professionel.addItem("Professions scientifiques");
		professionel.addItem("Politique, Social, Etude de la société");
		professionel.addItem("Transport et logistique");
		professionel.addItem("Sciences médicales et paramédicales");
		professionel.addItem("Arts et culture");
		professionel.addItem("Juridique");
		professionel.addItem("Communication");
		professionel.addItem("Informatique");
		professionel.addItem("Tourisme");
		professionel.addItem("Enseignement");
		professionel.addItem("Bâtiment & Génie civil");
		professionel.addItem("Industrie/Sciences appliquées");
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
		
		JLabel info = new JLabel("*laissez ##-##-#### si vous n'avez pas le permis");
		panel1.add(info);
		
		fenetre1.add(panel1);
		fenetre1.setVisible(true);
		
		}

	public inscription() {
		demande = new JFrame("Vous êtes ?");
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3, 1,5,5));
		JLabel txt = new JLabel("De quel catégorie êtes vous ?");
		JButton b1 = new JButton("Enfant");
		JButton b2 = new JButton("Adulte");
		b1.addActionListener(event -> setCategory(b1.getText()));
		b2.addActionListener(event -> setCategory(b2.getText()));
		pan.add(txt);
		pan.add(b1);
		pan.add(b2);
		demande.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    demande.setContentPane(pan);
	    demande.pack();
	    demande.setVisible(true);
	}
	

	
	private void setCategory(String cat) {
		demande.dispose();
		new inscription(cat);
		
	}

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
			 driverLicenceDate = (permi.getText().equals("##-##-####")) ? "NULL" : permi.getText();
			 netIncome = annuel.getText();
			 profession = professionel.getSelectedItem().toString();
		}else {
			loginparent1 = loginp1.getText();
			loginparent2 = (loginp2.getText().equals("x")) ? "NULL" : loginp2.getText();
		}
		
		
		if (DateValid(birthdate) && DateValid(driverLicenceDate)) {
	
			if (!ChampsVide()) {
				System.out.println(" name = " + name + "\n surname = " + surname +"\n sexe = " + sexe + "\n category = " + category + "\n adress = " 
						+ adress + "\n phoneNumber = " + phoneNumber + "\n birthdate = " + dateFormatSQL(birthdate) +"\n birthcity = " + birthcity +
						"\n familySituation = " + familySituation + "\n email = " + email + "\n ville = " + ville + "\n zipCode = " 
						+ zipCode + "\n numberOfChild = " + numberOfChild + "\n driverLicenceDate = "
								+ driverLicenceDate + "\n netIncome = " + netIncome + "\n profession = " 
						+ profession + " \n password = " + pwd+ "\n p1 = " + loginparent1 + "\n p2 = " + loginparent2);
				String login = LoginGenerator();
				String req,req2 = null;
				if (category.equals("Adulte")) {
					if (driverLicenceDate.equals("NULL")) {
						req = "INSERT INTO `Person`(`name`, `surname`,`sexe`, `login`, `pwd`, `category`, `adress`,"
								+ " `phoneNumber`, `birthdate`,`birthcity`, `family_situation`, `email`, `ville`, `zipCode`,"
								+ " `numberOfChild`, `driverLicenceDate`, `netIncome`, `profession`) VALUES ('"+name
								+"','"+surname+"','"+sexe+"','"+login+"','"+pwd+"','"+category+"','"+adress+"','"
								+phoneNumber+"','"+dateFormatSQL(birthdate)+"','"+birthcity+"','"+familySituation
								+"','"+email+"','"+ville+"','"+zipCode+"','"+numberOfChild+"',NULL,'"+netIncome+"','"+profession+"')";
					} else {
						req = "INSERT INTO `Person`(`name`, `surname`,`sexe`, `login`, `pwd`, `category`, `adress`,"
								+ " `phoneNumber`, `birthdate`,`birthcity`, `family_situation`, `email`, `ville`, `zipCode`,"
								+ " `numberOfChild`, `driverLicenceDate`, `netIncome`, `profession`) VALUES ('"+name
								+"','"+surname+"','"+sexe+"','"+login+"','"+pwd+"','"+category+"','"+adress+"','"
								+phoneNumber+"','"+dateFormatSQL(birthdate)+"','"+birthcity+"','"+familySituation
								+"','"+email+"','"+ville+"','"+zipCode+"','"+numberOfChild+"','"
								+dateFormatSQL(driverLicenceDate)+"','"+netIncome+"','"+profession+"')";
					}
					
				}else {
					req = "INSERT INTO `Person`(`name`, `surname`,`sexe`, `login`, `pwd`, `category`, `adress`,"
							+ " `phoneNumber`, `birthdate`,`birthcity`, `family_situation`, `email`, `ville`, `zipCode`,"
							+ " `numberOfChild`, `driverLicenceDate`, `netIncome`, `profession`) VALUES ('"+name
							+"','"+surname+"','"+sexe+"','"+login+"','"+pwd+"','"+category+"','"+adress+"',NULL"
							+",'"+dateFormatSQL(birthdate)+"','"+birthcity+"',NULL,NULL,'"+ville+"','"+zipCode+"',NULL,NULL,NULL,NULL);";
					req2 = "INSERT INTO `Child`(`loginChild`, `loginParent1`, `loginParent2`, `name`, `surname`, `birthDate`)  VALUES "
							+ "('"+login+"','"+loginparent1+"','"+loginparent2+"','"+name+"','"+surname+"','"+dateFormatSQL(birthdate)+"')";
				}
				
				if ( (category.equals("Enfant") && exist(loginparent1)) ) {
					if (loginparent2.equals("NULL") ^ exist(loginparent2)) { 
						bdd.executeQuery(req);
						bdd.executeQuery(req2);
						fenetre1.dispose();
						JOptionPane.showMessageDialog(null, "Votre inscription est terminée. Votre login est "+login+".");
						new PagedeConnection();
					}else {
						JOptionPane.showMessageDialog(null, "Un des deux parents n'existe pas.");
					}
				}else if(category.equals("Adulte")) {
					bdd.executeQuery(req);
					fenetre1.dispose();
					JOptionPane.showMessageDialog(null, "Votre inscription est terminée. Votre login est "+login+".");
					new PagedeConnection();
				}
				
					
			} else {
				JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
	        }
		}else {
			JOptionPane.showMessageDialog(null, "Date non valide.");
		}
				
	}
	
	public void retour() {
		fenetre1.dispose();
		new PagedeConnection();
	}
	
	public boolean bissextile(int year) {

	    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
	        return true;
	    } else {
	        return false;
	    }
	    }
	 
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
			 
			 int annee_actuel = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
			 
			 
			 if (mois <= 12 || annee <= annee_actuel) {
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
	 
	 public boolean jours30(int a) {
		 int[] tab = {4,6,9,11};
		 for (int mois : tab) {
			if (mois == a) {
				return true;
			}
		}
		 return false;
	 }
		
		
		
	
	public boolean ChampsVide() {
		if (category.equals("Adulte") && (name.equals("") || surname.equals("") || sexe.equals("") || adress.equals("") || phoneNumber.equals("##-##-##-##-##") 
				|| birthdate.equals("##-##-####") || birthcity.equals("")
				|| email.equals("") || ville.equals("") || zipCode.equals("#####") || numberOfChild.equals("#") 
				|| driverLicenceDate.equals("##-##-####") || netIncome.equals("") || pwd.equals(""))) {		
			return true;
		}else if(category.equals("Enfant") && (name.equals("") || surname.equals("") || sexe.equals("") || adress.equals("") || 
				birthdate.equals("##-##-####") || ville.equals("") || zipCode.equals("#####") || loginparent1.equals("") || pwd.equals("")))  {
			return true;
		}
		return false;
	}
	
	
	


	//Génération aléatoire du login de l'utilisateur
	public String LoginGenerator() {
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

	//Vérifie si un utilisateur existe ou pas
	public boolean exist(String login) {
		String req = "Select * from Person where login = \""+login+"\"";
		ResultSet rs =bdd.getResult(req);
		return bdd.getRowCount(rs) !=0; 
	}
	
	
	//mise en format SQL des dates (ex: 10-12-1995 -> 1995-12-10)
	public String dateFormatSQL(String date) {
		String[] tab = date.split("-");
		date = String.join("-", tab[2],tab[1],tab[0]);
		return "'"+date+"'";
	}
	

}
