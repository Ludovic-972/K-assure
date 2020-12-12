package Interface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestion.Person;

public class GererUtilisateur extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel panel;
private Person utilisateur;
private JLabel Jl,Jl2,Jl3,Jl4,Jl5,Jl6,Jl7,Jl8,Jl9,Jl10,Jl11,Jl12,Jl13,Jl14,Jl15,Jl16;
private JTextField Jtf;
private JButton Jb;


	public GererUtilisateur()  {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3,7,7));
		Jl = new JLabel("Nom d''utilisateur");
		panel.add(Jl);
		Jtf = new JTextField();	
		panel.add(Jtf);
		Jb=new JButton("validez");
		Jb.addActionListener(event-> recup(Jtf.getText()));
		panel.add(Jb);
		
		
		
		
		
		
		add(panel,BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setTitle("Utilisateurs enregistré");       
	    this.pack();
	    this.setSize(300,300);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
		
		
		
	}

	private void recup(String text) {
		utilisateur = new Person(text);
		new PageUtilisateurAdmin(utilisateur.getLogin());
		
		
		
		
	}
	
	
	
	
}
