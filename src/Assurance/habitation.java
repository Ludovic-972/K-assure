

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class habitation extends JFrame  {
	public JPanel panel;
	habitation() {
		// creation de la jframe Habitation
		this.setLayout(new BorderLayout());//definition de la methode de disposition des elements dans la fenetre
		this.setSize(500,500);// Taille de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// initialisation de la methode de fermeture du processus de la page, ici le processus ce ferme en meme temps que la page
		this.setTitle("Habitation");// initialisation du titre de la fenetre
		this.setLocationRelativeTo(null);// Permet de centrer la fenetre sur l'ecran
		this.setResizable(true);// permet de redefinir la taille de la fenetre
		
		
		panel = new JPanel();// creation d'un conteneur
		panel.setLayout(new FlowLayout());//definition de la methode de disposition des elements dans le conteneur
		this.add(panel, BorderLayout.NORTH);// Ajout du conteneur dans la fenetre
		this.setVisible(true);// Permet d'afficher la fenetre
		
		
		// creation Liste deroulante
		JComboBox type = new JComboBox();// creation d'une liste deroulante
		type.addItem(" ");// ajout d'element dans la liste deroulante
		type.addItem("principale");// ajout d'element dans la liste deroulante
		type.addItem("secondaire");// ajout d'element dans la liste deroulante
		panel.add(type);// ajout liste deroulante au conteneur panel
	
		// creation Liste deroulante
		JComboBox logement = new JComboBox();// creation d'une liste deroulante
		logement.addItem(" ");// ajout d'element dans la liste deroulante
		logement.addItem("Appartement");// ajout d'element dans la liste deroulante
		logement.addItem("Maison");// ajout d'element dans la liste deroulante
		panel.add(logement); // ajout liste deroulante au conteneur panel
	
		// creation Liste deroulante
		JComboBox type2 = new JComboBox();// creation d'une liste deroulante
		type2.addItem(" ");// ajout d'element dans la liste deroulante
		type2.addItem("Locataire");// ajout d'element dans la liste deroulante
		type2.addItem("Proprietaire");// ajout d'element dans la liste deroulante
		type2.addItem("Colocataire");// ajout d'element dans la liste deroulante
		panel.add(type2);// ajout liste deroulante au conteneur panel
	
	
	}
}
