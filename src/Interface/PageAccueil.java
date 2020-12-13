package Interface;

// Liste des imports d'outils depuis la bibliotheque Java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import Assurance.*;
import Gestion.*;

@SuppressWarnings("serial")
public class PageAccueil extends JFrame{
    private JTree tree;//initialisation d'un arbre de fichier
    private JButton Connection;//initialisation  d'un bouton
    private DefaultMutableTreeNode root;//initialisation de la racine de l'arbre de fichier
    private JPanel panel ;//initialisation  d'un conteneur panel 
    private Person user;
    private JLabel JL1,JL2,JL3;

    
    
    public PageAccueil(String _user){	
    	user = new Person(_user);

    	
        panel = new JPanel();//creation d'un conteneur
        root = new DefaultMutableTreeNode("Root");
        //creation des elements de l'arbre de fichier 
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Accueil");
        DefaultMutableTreeNode vegetableNode2 = new DefaultMutableTreeNode("Compte");
        DefaultMutableTreeNode vegetableNode3 = new DefaultMutableTreeNode("S'assurer");
        DefaultMutableTreeNode vegetableNode4 = new DefaultMutableTreeNode("Declarez sinistre");
        DefaultMutableTreeNode vegetableNode5 = new DefaultMutableTreeNode("Simuler un sinistre");
        DefaultMutableTreeNode vegetableNode6 = new DefaultMutableTreeNode("Contact");
        DefaultMutableTreeNode vegetableNode7 = new DefaultMutableTreeNode("FAQ");

        
        
    	//creation de zone de text, avec le text ainsi que sa position
    	JL1 = new JLabel("Bonjour "+user.getSurname()+",", JLabel.CENTER);
    	JL2 = new JLabel("Vous pouvez nous contactez via la page dédiez", JLabel.CENTER);
    	JL3 = new JLabel("Ou bien vous renseignez sur les contrats existant", JLabel.CENTER);
    	
    	//Ajout des zones de text dans le conteneur
    	panel.add(JL1);
    	panel.add(JL2);
    	panel.add(JL3);
		panel.setLayout(new GridLayout(5, 4, 7, 7));
       
        //Ajouts des elements de l'arbre a la racine
       
        root.add(vegetableNode);
        root.add(vegetableNode2);
        root.add(vegetableNode3);
        root.add(vegetableNode4);
        root.add(vegetableNode5);
        root.add(vegetableNode6);
        root.add(vegetableNode7);
         
        //creation de l'arbre en ajoutant la racine
        tree = new JTree(root);
        
        //creation du boutton de connection
     
        Connection = new JButton("Déconnexion");
        
        //ajout du Bouton, contneur et arbre a la fenetre
        add(Connection, BorderLayout.SOUTH);
        add(panel,BorderLayout.EAST);
        add(tree,BorderLayout.WEST);
        add(new JScrollPane(panel)); // ajout d'une barre de scroll au cas ou la page serait reduite en taille
        
        
        //Ajout d'evenement "d'ecoute" pour le bouton et les fichier de l'arbre
        Connection.addActionListener(event -> deconnexion(event));        
        tree.getSelectionModel().addTreeSelectionListener(event -> valueChanged(event));       		
                  
        
        
       
         
        //Configuration de la fenetre 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(user.getName()+" "+user.getSurname());       
        this.pack();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    // methode d'ecoute de l'arbre
    public void valueChanged(TreeSelectionEvent e) {
    	// transormation de l'evenement de selection d'un fichier de l'arbre en String afin d'utiliser l'evenement
    	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    	String choix =  selectedNode.getUserObject().toString();

    	//Ouverture de la classe Contact si le fichier contact a ete selectionner dans l'arbre
        if (choix == "Contact") {
        	JL1.setText("Voici la page de contact");
        	JL2.setText("Numéro de téléphone : 0123456789");
        	JL3.setText("Adresse Mail agence : KAssure@monmail.com");      	
        }
      //Ouverture de la classe Contrat si le fichier contrat a ete selectionner dans l'arbre
        else if (choix =="S'assurer") {
        	String[] options = { "Habitation", "Véhicule" };
        	int x =JOptionPane.showOptionDialog(null, "Quel d'assurance voulez-vouz ?", "S'assurer",
        			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        			null, options, options[0]);
        	switch (x) {
			case 0:
				new Habitation();
				break;
			case 1:
				new Vehicule(user.getLogin());
				break;
			default:
				break;
			}
        }
        else if (choix =="FAQ") {
        	new FAQ();
        }
        else if (choix =="Compte") {
        	new Compte(user.getLogin());
        }
        else if (choix =="Accueil") {
        	JL1.setText("Bonjour "+user.getSurname()+",");
        	JL2.setText("Vous pouvez nous contactez via la page dédiez");
        	JL3.setText("Ou bien vous renseignez sur les contrats existant");  
        	
        }else if (choix=="Declarez sinistre") {
        	String[] options = { "Habitation", "Véhicule" };
        	int x =JOptionPane.showOptionDialog(null, "Quel type de sinitre déclarez-vous ?", "Déclarer un sinistre",
        			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        			null, options, options[0]);
        	if(x!=-1)
        		new DeclarerSinistre(options[x],user.getLogin(),false);
        	
        }else if (choix=="Simuler un sinistre") {
        	String[] options = { "Habitation", "Véhicule" };
        	int x =JOptionPane.showOptionDialog(null, "Quel type de sinistre voulez-vous simulez ?", "Simuler un sinistre",
        			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        			null, options, options[0]);
        	if(x!=-1)
        		new DeclarerSinistre(options[x],user.getLogin(),true);
        }
        	
    }
    
    // methode d'ecoute du bouton de connection qui permet d'ouvrir la classe PagedeConnection apres cliquement sur le bouton
    public void deconnexion(ActionEvent event) {
    	new PagedeConnection();
    	this.dispose();
    	
    	
    }
     
  
}