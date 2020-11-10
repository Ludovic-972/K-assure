package Interface;

import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BDgestion.BDconnection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PagedeConnection extends JFrame {
	/**
	 * 
	 */
	private JFrame f;
	private JButton JB;
	String user;
	char[] pwd;
	BDconnection bdd = new BDconnection();
	private static final long serialVersionUID = 1L;

	public PagedeConnection() {
		
		
		
		//creation des elements de zone de texte et de champ de texte
	    JLabel User= new JLabel("Username", JLabel.CENTER);
	    JTextField JUser = new JTextField();
	    JLabel Mdp = new JLabel("Password", JLabel.CENTER);
	    JPasswordField JMdp = new JPasswordField (); 
 	    
	    JMdp.setEchoChar ('*');
	    JPanel p = new JPanel( );
	    JB = new JButton("Connection");
	    
	    JB.addActionListener(event -> actionPerformed(JUser.getText() ,JMdp.getPassword()));
	    p.setLayout(new GridLayout(3, 2, 7, 7));
	    
	   
	    p.add(User);
	    p.add(JUser);
	    p.add(Mdp);
	    p.add(JMdp);
	    p.add(JB);
 
	     
	    f = new JFrame("Connection");
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f.setContentPane(p);
	    f.pack();
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
			 new PageAccueil();
		 }else {
			 System.out.println("Je ne vous connais pas "+Username+" "+String.valueOf(pwd));
	 
		 }
	 }
	 
	 
	 private boolean estInscrit(String username, char[] pw) {
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
