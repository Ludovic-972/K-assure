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
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * PageAccueilFront est la premiere d'acces lors de l'executio du programme
 * <p>
 * Elle permet de naviguer entre les diffrentes onglet pour une personne non connecter
 *  </p>
 * <p>
 * De plus cette classe permet l'acces à la page de connection
 * </p>
 * @author Gaëtan Lory
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class PageAccueilFront extends JFrame 
{
	/**
	 * Menu de Navigation entre les diffrentes page de la page acceuil
	 * @since 1.0
	 */
    private JTree tree;//initialisation d'un arbre de fichier
    /**
     * Boutton qui renvoie vers la PageDeConnection
     * @see PagedeConnection
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
     * Affiche d'element de texte sur la page 
     * @see JPanel
     * @since 1.0 
     */
    private JLabel JL1,JL2,JL3;
    /**
     * Onglet de Navigation dans le menu
     * @see root
     * @since 1.0 
     */
    private DefaultMutableTreeNode vegetableNode,vegetableNode2,vegetableNode3;
    /**
     * <p>
     * Constrcuteur de la Page PageAccueilFront permet d'initialiser la fenetre JFrame
     * il permet aussi l'ajout du menu de navigation au panel.
     * </p>
     * @since 1.0  
     * 
     */
    public PageAccueilFront()
    {
        panel = new JPanel();//creation d'un conteneur
        root = new DefaultMutableTreeNode("K-assure");
        //creation des elements de l'arbre de fichier 
         vegetableNode3 = new DefaultMutableTreeNode("Contact");
         vegetableNode2 = new DefaultMutableTreeNode("FAQ");
         vegetableNode = new DefaultMutableTreeNode("Accueil");
        
    	//creation de zone de text, avec le text ainsi que sa position
    	 JL1 = new JLabel("Bienvenue chez K-Assure", JLabel.CENTER);
    	 JL2 = new JLabel("Vous pouvez nous contactez via la page dédiez", JLabel.CENTER);
    	 JL3 = new JLabel("Ou bien vous renseignez Sur les questions frequentes", JLabel.CENTER);
    	
    	//Ajout des zones de text dans le conteneur
    	panel.add(JL1);
    	panel.add(JL2);
    	panel.add(JL3);
		panel.setLayout(new GridLayout(5, 4, 7, 7));
       
        //Ajouts des elements de l'arbre a la racine
       
        root.add(vegetableNode);
        root.add(vegetableNode2);
        root.add(vegetableNode3);
        //creation de l'arbre en ajoutant la racine
        tree = new JTree(root);
       
        //creation du boutton de connection
     
        Connection = new JButton("Connexion");
        
        //ajout du Bouton, contneur et arbre a la fenetre
        add(Connection, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        add(tree,BorderLayout.WEST);
        add(new JScrollPane(panel)); // ajout d'une barre de scroll au cas ou la page serait reduite en taille
        
        
        //Ajout d'evenement "d'ecoute" pour le bouton et les fichier de l'arbre
        Connection.addActionListener(event -> connection(event));        
        tree.getSelectionModel().addTreeSelectionListener(event -> valueChanged(event));       		
                  
        
        
       
         
        //Configuration de la fenetre 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");   
        this.pack();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
/**
 * Cette méthode permet de renvoyer l'utilisateur vers la page qu'il désire via le menu de navigation
 * @param e 
 * 		Branche du JTree selectionné
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
        else if (choix =="FAQ") {
        	new FAQ();
        }
        else if (choix =="Accueil" ) {
         JL1.setText("Bienvenue chez K-Assure");
       	 JL2.setText("Vous pouvez nous contactez via la page dédiez");
       	 JL3.setText("Ou bien vous renseignez Sur les questions frequentes");
        }
        	
        }
    
    /**
     *  methode d'ecoute du bouton de connection qui permet d'ouvrir la classe PagedeConnection apres cliquement sur le bouton
     * @param event
     * 		Evenement du JButton implementé
     * @since 1.0
     */
    public void connection(ActionEvent event) {
    	this.dispose();
    	new PagedeConnection();  	
    	
    }
     
    /**
     * methode d'affichage et d'execution du programme
     * @param args
     * 		Argument de la méthode main
     * @since 1.0
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PageAccueilFront();
            }
        });
    }       
}