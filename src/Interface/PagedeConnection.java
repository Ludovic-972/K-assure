package Interface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BDgestion.BDconnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  PagedeConnection est la classe permettant de se connecter au logiciel K-assure 
 * 
 * @author Gaëtan Lory,Mathurin-Cayol Ludovic
 * @version 2.0
 * */
public class PagedeConnection {
	
	/**
	 * Interface principale contenant les éléments permettant l'authentification.
	 * 
	 * @since 1.0
	 **/
	private JFrame f;
	
	/**
	 * Bouton de connexion.
	 * 
	 * @since 1.0
	 * */
	private JButton Connex;
	
	/**
	 * Login de l'utilisateur récupéré à la connexion.
	 * 
	 * @see PagedeConnection
	 * @since 1.0
	 * */
	private String user;
	
	/**
	 * Bouton d'inscription.
	 * 
	 * @since 1.0
	 * */
	private JButton inscription;
	
	/**
	 * Mot de passe de l'utilisateur récupéré dans un tableau de caractère.
	 * 
	 * @since 1.0
	 * */
	private char[] pwd;
	
	/**
	 * Connexion à la base de données.
	 * 
	 * <p>
	 * Pour plus d'informations sur la connexion à la base de données,regarder 
	 * la documentation de la classe BDconnection.
	 * <p>
	 * @see BDconnection
	 * @since 1.0
	 * */
	private BDconnection bdd = new BDconnection();
	
	
	
	/**
	 * Constructeur de Page de connexion.
	 *  <p>
	 * A la création de la page, une interface est créée où il faut s'inscrire ou se connecter.
	 * </p>
	 * 
	 * @since 1.0
	 * */
	public PagedeConnection() {
		
		//creation des elements de zone de texte et de champ de texte
	    JLabel User= new JLabel("Username", JLabel.CENTER);
	    JTextField JUser = new JTextField();
	    JLabel Mdp = new JLabel("Password", JLabel.CENTER);
	    JPasswordField JMdp = new JPasswordField (); 
 	    
	    JMdp.setEchoChar ('*');
	    JPanel p = new JPanel( );
	    Connex = new JButton("Connexion");
	    inscription = new JButton("Inscription");
	    
	    Connex.addActionListener(event -> actionPerformed(JUser.getText() ,JMdp.getPassword()));
	    inscription.addActionListener(event -> inscription());
	    p.setLayout(new GridLayout(4, 2, 7, 7));
	   
	    p.add(User);
	    p.add(JUser);
	    p.add(Mdp);
	    p.add(JMdp);
	    p.add(Connex);
	    p.add(inscription);
 
	     
	    f = new JFrame("Connexion");
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f.setPreferredSize(new Dimension(400,200));
	    f.setContentPane(p);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	}
	
	/**
	 * Connecte l'utilisateur sauf si il n'existe pas.
	 * 
	 * @param username
	 * 			L'identifiant de l'utilisateur.
	 * @param cs
	 * 			Le mot de passe de l'utilisateur
	 * 
	 * @see PagedeConnection#getCategory
	 * @see PagedeConnection#estInscrit
	 * @see PagedeConnection#isAdmin
	 * 
	 * @since 1.0
	 * */
	 public void actionPerformed(String username,char[] cs) {
		 
		 user = username;
		 pwd = cs;
			 
		 if (isAdmin(user, pwd)) {
	        f.dispose();	
	        System.out.println("Connexion Admin réussie");
	        new PageAdmin();
		 }else if(estInscrit(user,pwd)){
			 f.dispose();	
			 System.out.println("Connexion User réussie");
			 new PageAccueil(user);
		 }else {
			 JOptionPane.showMessageDialog(null,"Login ou mot de passe incorrecte.");
	 
		 }
	 }
	 
	 /**
	 * Ferme la page de connexion et envoie l'utilisateur sur la page d'inscription.
	 *  	 
	 * @since 2.0
	 *
	 **/
	public void inscription() {
		f.dispose();
		new Inscription();		
	}
	

	 
	/**
	 * Vérifie si l'utilisateur est inscrit.
	 * 
	 * @param username
	 * 			L'identifiant de l'utilisateur.
	 * @param pw
	 * 			Le mot de passe de l'utilisateur
	 * 
	 * @return True si l'utilisateur est inscrit,false sinon.
	 * @since 2.0
	 * */
	 public boolean estInscrit(String username, char[] pw) {
		ResultSet inscrit = bdd.getResult("SELECT login,pwd from Person where login = '"+username+"'");
		char[] inscrit_pwd = null;
		try {
			while(inscrit.next())
				inscrit_pwd = inscrit.getString(2).toCharArray();
		} catch (SQLException e) {
			return false;
		}
		if (Arrays.equals(inscrit_pwd,pw)) {
			return true;
		}
		return false;
	 }
	 
	 /**
	 *  Vérifie l'identifiant et le mot de passe entrés par l'user
	 *  pour savoir si c'est un administrateur.
	 *  
	 * @param username
	 * 			L'identifiant de l'utilisateur.
	 * @param pw
	 * 			Le mot de passe de l'utilisateur
	 * 
	 *  @return True si l'utilisateur est un administrateur,false sinon.
	 *  
	 * @since 1.0
	 * */
	public boolean isAdmin(String username,char[] pw) {
		 char[] AdminPass = new char[] {'a','d','m','i','n'};
		 if (username.equals("Admin") && Arrays.equals(pw,AdminPass)) {
			 return true;
		 }
		 return false;	 
	 }
	
	
	
	
	 
	 
	 
	 
	 
	 
	 

}
