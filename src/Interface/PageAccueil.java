package Interface;

// Liste des imports d'outils depuis la bibliotheque Java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import Assurance.*;

@SuppressWarnings("serial")
public class PageAccueil extends JFrame 
{
    private JTree tree;//initialisation d'un arbre de fichier
    private JButton Connection;//initialisation  d'un bouton
    private DefaultMutableTreeNode root;//initialisation de la racine de l'arbre de fichier
    private JPanel panel ;//initialisation  d'un conteneur panel 
    
    
    public PageAccueil(String user)
    {
        panel = new JPanel();//creation d'un conteneur
        root = new DefaultMutableTreeNode("Root");
        //creation des elements de l'arbre de fichier 
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Contact");
        DefaultMutableTreeNode vegetableNode2 = new DefaultMutableTreeNode("Contrats");
        
        
        
    	//creation de zone de text, avec le text ainsi que sa position
    	JLabel JL1 = new JLabel("Bienvenue chez K-Assure", JLabel.CENTER);
    	JLabel JL2 = new JLabel("Vous pouvez nous contactez via la page dédiez", JLabel.CENTER);
    	JLabel JL3 = new JLabel("Ou bien vous renseignez sur les contrats existant", JLabel.CENTER);
    	
    	//Ajout des zones de text dans le conteneur
    	panel.add(JL1);
    	panel.add(JL2);
    	panel.add(JL3);
		panel.setLayout(new GridLayout(5, 4, 7, 7));
       
        //Ajouts des elements de l'arbre a la racine
       
        root.add(vegetableNode);
        root.add(vegetableNode2);
         
        //creation de l'arbre en ajoutant la racine
        tree = new JTree(root);
        
        //creation du boutton de connection
     
        Connection = new JButton("Connection Assu");
        
        //ajout du Bouton, contneur et arbre a la fenetre
        add(Connection, BorderLayout.SOUTH);
        add(panel,BorderLayout.EAST);
        add(tree);
        add(new JScrollPane(tree)); // ajout d'une barre de scroll au cas ou la page serait reduite en taille
        
        
        //Ajout d'evenement "d'ecoute" pour le bouton et les fichier de l'arbre
        Connection.addActionListener(event -> connection(event));        
        tree.getSelectionModel().addTreeSelectionListener(event -> valueChanged(event));       		
                  
        
        
       
         
        //Configuration de la fenetre 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
    }
    
    
    // methode d'ecoute de l'arbre
    public void valueChanged(TreeSelectionEvent e) {
    	// transormation de l'evenement de selection d'un fichier de l'arbre en String afin d'utiliser l'evenement
    	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    	String choix =  selectedNode.getUserObject().toString();

    	//Ouverture de la classe Contact si le fichier contact a ete selectionner dans l'arbre
        if (choix == "Contact") {
        	Contact Contact = new Contact();
        	Contact.setVisible(true);
        	this.dispose();
        	
        	
        	
        	
        }
      //Ouverture de la classe Contrat si le fichier contrat a ete selectionner dans l'arbre
        else if (choix =="Contrats") {
//        	ici la page de Paulo      	
        	
        }
        	
        }
    
    // methode d'ecoute du bouton de connection qui permet d'ouvrir la classe PagedeConnection apres cliquement sur le bouton
    public void connection(ActionEvent event) {
    	new PagedeConnection();
    	this.dispose();
    	
    	
    }
     
  
}