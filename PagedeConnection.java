

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PagedeConnection extends JFrame {
	/**
	 * 
	 */
	private JFrame f;
	private JButton JB;
	boolean Admin;
	private static final long serialVersionUID = 1L;

	PagedeConnection() {
		
		
		
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
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	}
	 public void actionPerformed(String Username,char[] cs) {
		 
		 char[] password =cs;
		 char[] AdminPass = new char[] {'a','d','m','i','n'};
			 
		 if (Username.equals("Admin") && Arrays.equals(password,AdminPass)) {
	        f.dispose();	
	        PageAdmin PA = new PageAdmin();
		 }else 
			 System.out.println("Je ne vous connais pas "+Username+" "+cs);	 
	 }

	 

	 
	 
	 
	 
	 
	 
	 
	 
	 

}
