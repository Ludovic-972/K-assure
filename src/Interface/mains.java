//package Interface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

//import BDgestion.BDconnection;

public class mains {
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
	BDconnection bdd = new BDconnection();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
			
		JFrame fenetre1 = new JFrame("Inscription");
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
		
		JLabel categorys = new JLabel("Cat�gorie :");
		JComboBox categori = new JComboBox();
		categori.addItem("enfant");
		categori.addItem("adulte");
		panel1.add(categorys);
		panel1.add(categori);
		
		JLabel adresse = new JLabel("Adresse :");
		JTextField adresss = new JTextField("");
		panel1.add(adresse);
		panel1.add(adresss);
			
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
		
		JLabel birthdates = new JLabel("Date de naissance : ");
		try {
	         MaskFormatter formatter = new MaskFormatter("##/##/####");
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
		familiale.addItem("mari�");
		familiale.addItem("pacs�");
		familiale.addItem("divorc�");
		familiale.addItem("s�par�");
		familiale.addItem("c�libataire");
		familiale.addItem("veuf");
		panel1.add(situation);
		panel1.add(familiale);
		
		JLabel i = new JLabel("Adresse email :");
		JTextField mail = new JTextField("");
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
		
		JLabel driver = new JLabel("Obtention permis conduire : ");
		try {
	         MaskFormatter formatter = new MaskFormatter("##/##/####");
	         formatter.setPlaceholderCharacter('#');
	         permi = new JFormattedTextField(formatter);
	         permi.setColumns(20);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		panel1.add(driver);
		panel1.add(permi);
		
		JLabel revenue = new JLabel("Revenu annuel : ");
		JTextField annuel = new JTextField("");
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
		professionel.addItem("H�tellerie � Restauration");
		professionel.addItem("Agronomie");
		professionel.addItem("Professions scientifiques");
		professionel.addItem("Politique, Social, Etude de la soci�t�");
		professionel.addItem("Transport et logistique");
		professionel.addItem("Sciences m�dicales et param�dicales");
		professionel.addItem("Arts et culture");
		professionel.addItem("Juridique");
		professionel.addItem("Communication");
		professionel.addItem("Informatique");
		professionel.addItem("Tourisme");
		professionel.addItem("Enseignement");
		professionel.addItem("B�timent & G�nie civil");
		professionel.addItem("Industrie/Sciences appliqu�es");
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
	}
	
	
	

}
