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


public class PagedeConnection {
	/**
	 * 
	 */
	private JFrame f;
	private JButton Connex;
	private String user;
	private JButton inscription;
	private char[] pwd;
	private BDconnection bdd = new BDconnection();

	public PagedeConnection() {
		
		
		
		//creation des elements de zone de texte et de champ de texte
	    JLabel User= new JLabel("Username", JLabel.CENTER);
	    JTextField JUser = new JTextField();
	    JLabel Mdp = new JLabel("Password", JLabel.CENTER);
	    JPasswordField JMdp = new JPasswordField (); 
 	    
	    JMdp.setEchoChar ('*');
	    JPanel p = new JPanel( );
	    Connex = new JButton("Connection");
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
 
	     
	    f = new JFrame("Connection");
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f.setPreferredSize(new Dimension(400,200));
	    f.setContentPane(p);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	}
	 public void actionPerformed(String Username,char[] cs) {
		 
		 user = Username;
		 pwd = cs;
			 
		 if (isAdmin(user, pwd)) {
	        f.dispose();	
	        System.out.println("Connexion Admin réussie");
	        new PageAdmin();
		 }else if(estInscrit(user,pwd)){
			 f.dispose();	
			 System.out.println("Connexion User réussie");
			 new PageAccueil(user,getCategory());
		 }else {
			 JOptionPane.showMessageDialog(null,"Login ou mot de passe incorrecte.");
	 
		 }
	 }
	 
	
	public void inscription() {
		f.dispose();
		new Inscription();		
	}
	
	public String getCategory() {
		ResultSet category = bdd.getResult("SELECT category from Person where login = '"+user+"'");
		try {
			if (category.next()) {
				return category.getString(1);
			}

		} catch (SQLException e) {
			System.out.println("Erreur de récupération");
		}
		return "";
	}
	 
	 
	 public boolean estInscrit(String username, char[] pw) {
		ResultSet inscrit = bdd.getResult("SELECT login,pwd from Person where login = '"+username+"'");
		char[] inscrit_pwd = null;
		try {
			while(inscrit.next())
				inscrit_pwd = inscrit.getString(2).toCharArray();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Arrays.equals(inscrit_pwd,pw)) {
			return true;
		}
		return false;
	}
	public boolean isAdmin(String username,char[] pw) {
		 char[] AdminPass = new char[] {'a','d','m','i','n'};
		 if (username.equals("Admin") && Arrays.equals(pw,AdminPass)) {
			 return true;
		 }
		 return false;	 
	 }
	 
	 public static void main(String[] args) {
		new PagedeConnection();
	}
	
	 
	 
	 
	 
	 
	 
	 

}
