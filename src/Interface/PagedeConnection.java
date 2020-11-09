package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PagedeConnection extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PagedeConnection() {
	    JLabel User= new JLabel("Username", JLabel.CENTER);
	    JTextField JUser = new JTextField();
	    JLabel Mdp = new JLabel("Password", JLabel.CENTER);
	    JTextField JMdp = new JTextField();
	    JPanel p = new JPanel( );
	    p.setLayout(new GridLayout(5, 4, 7, 7));
	    p.add(User);
	    p.add(JUser);
	    p.add(Mdp);
	    p.add(JMdp);
	    
 
	 
	    JFrame f = new JFrame("Connection");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setContentPane(p);
	    f.pack( );
	    f.setVisible(true);
	}

}
