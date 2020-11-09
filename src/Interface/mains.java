//package Interface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

//import BDgestion.BDconnection;

public class mains{
	static JFormattedTextField numero;
	static JFormattedTextField date;
	static JFormattedTextField postal;
	static JFormattedTextField nombre;
	static JFormattedTextField permi;
	static JFormattedTextField annuel;
	static String name;
	static String surname;
	static String category;
	static String adress;
	static String phoneNumber;
	static String birthdate;
	static String familySituation;
	static String email;
	static String ville;
	static String zipCode;
	static String numberOfChild;
	static String driverLicenceDate;
	static String netIncome;
	static String profession;
	static BDconnection bdd = new BDconnection();
	static JFrame fenetre1;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
			
<<<<<<< HEAD
		fenetre1 = new JFrame("inscription");
=======
		JFrame fenetre1 = new JFrame("Inscription");
>>>>>>> 2ff8641daa2e0ca29b1471070a3ab861b8e49b02
		fenetre1.setLayout(new FlowLayout());
		fenetre1.setSize(800,800);
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre1.setLocationRelativeTo(null);
		fenetre1.setResizable(true);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(16,2,7,7));
		
		
		JLabel surnames = new JLabel("Nom :");
		JTextField surnam = new JTextField("");
		panel1.add(surnames);
		panel1.add(surnam);
		
		JLabel names = new JLabel("Prenom :");
		JTextField nam = new JTextField("");
		panel1.add(names);
		panel1.add(nam);
		
		JLabel categorys = new JLabel("Catï¿½gorie :");
		JComboBox categori = new JComboBox();
		categori.addItem("enfant");
		categori.addItem("adulte");
		panel1.add(categorys);
		panel1.add(categori);
		
		JLabel adresse = new JLabel("Adresse :");
		JTextField adresss = new JTextField("");
		panel1.add(adresse);
		panel1.add(adresss);
			
		JLabel number = new JLabel("Numï¿½ro de tï¿½lï¿½phone : ");
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
		
		JLabel situation = new JLabel("Situation familiale :");
		JComboBox familiale = new JComboBox();
<<<<<<< HEAD
		familiale.addItem("Marié.ée");
		familiale.addItem("Pacsé.ée");
		familiale.addItem("Divorcé.ée");
		familiale.addItem("Séparé.ée");
		familiale.addItem("Célibataire");
		familiale.addItem("Veuf-ve");
=======
		familiale.addItem("mariï¿½");
		familiale.addItem("pacsï¿½");
		familiale.addItem("divorcï¿½");
		familiale.addItem("sï¿½parï¿½");
		familiale.addItem("cï¿½libataire");
		familiale.addItem("veuf");
>>>>>>> 2ff8641daa2e0ca29b1471070a3ab861b8e49b02
		panel1.add(situation);
		panel1.add(familiale);
		
		JLabel i = new JLabel("Adresse email :");
<<<<<<< HEAD
		JTextField mail = new JTextField();
=======
		JTextField mail = new JTextField("");
>>>>>>> 2ff8641daa2e0ca29b1471070a3ab861b8e49b02
		panel1.add(i);
		panel1.add(mail);
		
		JLabel Ville = new JLabel("Ville :");
		JTextField city = new JTextField("");
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
		
<<<<<<< HEAD
		JLabel driver = new JLabel("Date d'obtention du permis conduire : ");
=======
		JLabel driver = new JLabel("Obtention permis conduire : ");
>>>>>>> 2ff8641daa2e0ca29b1471070a3ab861b8e49b02
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
<<<<<<< HEAD
		JTextField annuel = new JTextField();
=======
		JTextField annuel = new JTextField("");
>>>>>>> 2ff8641daa2e0ca29b1471070a3ab861b8e49b02
		annuel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
	            String value = annuel.getText();
	            int l = value.length();
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
		JComboBox professionel = new JComboBox();
		professionel.addItem("Services publics");
		professionel.addItem("Professions administratives, commerciales et de gestion");
		professionel.addItem("Commerce et artisanat");
		professionel.addItem("Hï¿½tellerie ï¿½ Restauration");
		professionel.addItem("Agronomie");
		professionel.addItem("Professions scientifiques");
		professionel.addItem("Politique, Social, Etude de la sociï¿½tï¿½");
		professionel.addItem("Transport et logistique");
		professionel.addItem("Sciences mï¿½dicales et paramï¿½dicales");
		professionel.addItem("Arts et culture");
		professionel.addItem("Juridique");
		professionel.addItem("Communication");
		professionel.addItem("Informatique");
		professionel.addItem("Tourisme");
		professionel.addItem("Enseignement");
		professionel.addItem("Bï¿½timent & Gï¿½nie civil");
		professionel.addItem("Industrie/Sciences appliquï¿½es");
		panel1.add(professions);
		panel1.add(professionel);
		
		JLabel mdp = new JLabel("Mot de passe : ");
		JTextField secret = new JTextField("");
		secret.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ki) {
	            String value = secret.getText();
	            int l = value.length();
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
		inscription.addActionListener(event -> inscrit(surnam.getText(),nam.getText(),categori.getSelectedItem().toString(),adresss.getText(),numero.getText(),date.getText(),familiale.getSelectedItem().toString(),mail.getText(),city.getText(),postal.getText(),nombre.getText(),permi.getText(),annuel.getText(),professionel.getSelectedItem().toString(),secret.getText()));
		panel1.add(inscription);
		
		fenetre1.add(panel1);
		fenetre1.setVisible(true);
		
		

		
		}

	public static void inscrit(String name, String surname, String category, String adress, String phoneNumber, String birthdate, String familySituation, String email, String ville, String zipCode, String numberOfChild, String driverLicenceDate, String netIncome, String profession, String password) {
		
<<<<<<< HEAD
		System.out.println(" name = " + name + "\n surname = " + surname + "\n category = " + category + "\n adress = " 
		+ adress + "\n phoneNumber = " + phoneNumber + "\n birthdate = " + dateFormatSQL(birthdate) + "\n familySituation = " 
				+ familySituation + "\n email = " + email + "\n ville = " + ville + "\n zipCode = " 
		+ zipCode + "\n numberOfChild = " + numberOfChild + "\n driverLicenceDate = "
				+ driverLicenceDate + "\n netIncome = " + netIncome + "\n profession = " 
		+ profession + " \n password = " + password);
		String login = LoginGenerator();
		
		
		String req = "INSERT INTO `Person`(`name`, `surname`, `login`, `pwd`, `category`, `adress`,"
				+ " `phoneNumber`, `birthdate`, `family_situation`, `email`, `ville`, `zipCode`,"
				+ " `numberOfChild`, `driverLicenceDate`, `netIncome`, `profession`) VALUES ('"+name
				+"','"+surname+"','"+login+"','"+password+"','"+category+"','"+adress+"','"
				+phoneNumber+"','"+dateFormatSQL(birthdate)+"','"+familySituation
				+"','"+email+"','"+ville+"','"+zipCode+"',"+numberOfChild+",'"
				+dateFormatSQL(driverLicenceDate)+"',"+netIncome+",'"+profession+"')";
		
		bdd.executeQuery(req);
		
			
		fenetre1.dispose();
		 JOptionPane.showMessageDialog(null, "Votre inscription est terminée. Votre login est "+login);
		
=======
		if (name.equals("") && surname.equals("") && adress.equals("") && phoneNumber.equals("##-##-##-##-##") && birthdate.equals("##/##/####") && email.equals("") && ville.equals("") && zipCode.equals("#####") && numberOfChild.equals("#") && driverLicenceDate.equals("##/##/####") && netIncome.equals("") && password.equals("")) {
			System.out.println(" name = " + name + "\n surname = " + surname + "\n category = " + category + "\n adress = " + adress + "\n phoneNumber = " + phoneNumber + "\n birthdate = " + birthdate + "\n familySituation = " + familySituation + "\n email = " + email + "\n ville = " + ville + "\n zipCode = " + zipCode + "\n numberOfChild = " + numberOfChild + "\n driverLicenceDate = " + driverLicenceDate + "\n netIncome = " + netIncome + "\n profession = " + profession + " \n password = " + password);
		} else {
			JFrame erreur = new JFrame("Erreur");
			erreur.setLayout(new FlowLayout());
			erreur.setSize(400,100);
			erreur.setLocationRelativeTo(null);
			
			JLabel messageErreur = new JLabel("Tous les champs ne sont pas remplis");
			erreur.add(messageErreur);
			
			erreur.setVisible(true);
		}
>>>>>>> 2ff8641daa2e0ca29b1471070a3ab861b8e49b02
	}
	
	
	//Génération aléatoire du login de l'utilisateur
	public static String LoginGenerator() {
		while(true) {
			String numbers = "0123456789";
			String login = "";
			for (int i = 0; i < 8; i++) {
				login += numbers.charAt((int)(Math.random()*(numbers.length())));
			}
			System.out.println(login);
			
			if(!exist(login))
				return login;
			
		}
	}

	//Vérifie si un utilisateur existe ou pas
	public static boolean exist(String login) {
		String req = "Select * from Person where login = \""+login+"\"";
		ResultSet rs =bdd.getResult(req);
		return bdd.getRowCount(rs) !=0; 
	}
	
	
	//mise en format SQL des dates (ex: 10-12-1995 -> 1995-12-10)
	public static String dateFormatSQL(String date) {
		String[] tab = date.split("-");
		return String.join("-", tab[2],tab[1],tab[0]);
	}

}
