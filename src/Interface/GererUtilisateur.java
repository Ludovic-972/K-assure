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
/**
 * GererUtilisateur est une classe qui permet a l'admin connecter de rentrer le code de l'utilisateur d'ont il souhaite voir les informatiosn
 * @author Gaëtan Lory
 * @since 2.0
 */
public class GererUtilisateur extends JFrame{
	 /**
     * Creation du conteneur de la page JFrame
     * @see JFrame
     * @since 1.0
     */
private JPanel panel;
/**
 * initialisation d'un user ceci permet de garder en mémoire l'utilisater connecter et de récuperer ses informations
 * @see Person
 * @since 2.0
 */
private Person utilisateur;
/**
 * Affiche d'element de texte sur la page 
 * @see JPanel
 * @since 1.0 
 */
private JLabel Jl,Jl2,Jl3,Jl4,Jl5,Jl6,Jl7,Jl8,Jl9,Jl10,Jl11,Jl12,Jl13,Jl14,Jl15,Jl16;
/**
 * Ajoute un zone de saisie de texte
 * @see JPanel
 * @since 1.0 
 */
private JTextField Jtf;
/**
 * Ajoute un bouton qui renvoie les informations rentrer dans la zone de saisie de texte
 * @see JPanel
 * @since 1.0 
 */
private JButton Jb;

/**
 * Constructeur de la classe qui créer la fenetre, ou l'admin peut entrer le code utilisateur
 * @see GererUtilisateur
 * @since 2.0
 */
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

	
	/**
	 * methode qui renvoie les information entrer dans le zone de texte vers la classe PageUtilisateurAdmin
	 * @param text
	 * 				Login de l'utilisateur
	 * @since 2.0
	 */
	private void recup(String text) {
		utilisateur = new Person(text);
		new Compte(utilisateur.getLogin());
		
		
		
		
	}
	
	
	
	
}
