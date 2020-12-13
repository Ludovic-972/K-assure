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

/**
 * PageAccueil est la premiere d'acces lors de l'execution du programme
 * <p>
 * Elle permet de naviguer entre les diffrentes onglet pour une personne connecter
 *  </p>
 * @author Gaëtan Lory,Ludovic Mathurin-Cayol
 * @version 1.0
 * */
public class PageAccueil extends JFrame{
	
	/**
	 * Menu de Navigation entre les diffrentes page de la page acceuil
	 * @see PageAcceuiFront
	 * @since 1.0
	 */
    private JTree tree;//initialisation d'un arbre de fichier
    /**
    * Boutton qui renvoie vers la PageDeConnection
    * @see PageDeConnection
    * @since 1.0
    */
    private JButton Connection;//initialisation  d'un bouton
    /**
     * Dossier pour faciliter la Navigation dans le menu.
     * @see tree
     * @since 1.0
     */
    private DefaultMutableTreeNode root;//initialisation de la racine de l'arbre de fichier
    /**
     * Creation du conteneur de la page JFrame
     * @see JFrame
     * @since 1.0
     */
    private JPanel panel ;//initialisation  d'un conteneur panel 
    /**
	 * initialisation d'un user ceci permet de garder en mémoire l'utilisater connecter et de récuperer ses informations
	 * @see Person
	 * @since 2.0
	 */
    private Person user;
    /**
     * Affiche d'element de texte sur la page 
     * @see JPanel
     * @since 1.0 
     */
    private JLabel JL1,JL2,JL3;

    
    /**
     * <p>
     * Constrcuteur de la Page PageAccueil permet d'initialiser la fenetre JFrame
     * il permet aussi l'ajout du menu de navigation au panel.
     * </p>
     * @see PageAcceuilFront
     * @param _user
     * 				Login de l'utilisateur connecter
     * @since 1.0  
     * 
     */
    public PageAccueil(String _user){	
    	super("Accueil");
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
        this.pack();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    /**
     * Cette méthode permet de renvoyer l'utilisateur vers la page qu'il désire via le menu de navigation
     * @param e
     * @since 1.0
     */
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
        	if(x==0)new Habitation();
        	if(x==1)new Vehicule(user.getLogin());
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
    
    /**
     *  methode d'ecoute du bouton de deconnexion qui permet d'ouvrir la classe PagedeConnection apres cliquement sur le bouton
     * @param event
     * @since 2.0
     */
    public void deconnexion(ActionEvent event) {
    	new PagedeConnection();
    	this.dispose();
    	
    	
    }
     
}