package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import Gestion.Person;




/**
 * PageAdimn est la page d'access lorsque une personne se connecte en tant qu'admin sur la page de connection
 * <p>
 * Elle permet de naviguer entre les diffrentes onglet pour l'admin
 *  </p>
 * @author Gaëtan Lory
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class PageAdmin extends JFrame {
	/**
	 * Menu de Navigation entre les diffrentes page de la page acceuil
	 * @see PageAcceuiFront
	 * @since 1.0
	 */
	private JTree tree;
	/**
     * Dossier pour faciliter la Navigation dans le menu.
     * @see tree
     * @since 1.0
     */
    private DefaultMutableTreeNode root;
    /**
     * Creation du conteneur de la page JFrame
     * @see JFrame
     * @since 1.0
     */
    private JPanel panel ;
    /**
	 * initialisation d'un user ceci permet de garder en mémoire l'utilisater connecter et de récuperer ses informations
	 * @see Person
	 * @since 2.0
	 */
    private Person utilisateur;
    public PageAdmin()
    {
    	
    	// on recreet la meme page que pour pageAcceuil en ajoutant cette fois les elements specifique a l'administrateur
        root = new DefaultMutableTreeNode("Root");

        DefaultMutableTreeNode vegetableNode3 = new DefaultMutableTreeNode("Gerer utilisateur");
		 
       
       

        root.add(vegetableNode3);
         
        
        
        
        
        
    
    	JLabel JL1 = new JLabel("Bonjour", JLabel.CENTER);
    	JLabel JL2 = new JLabel("Vous pouvez nous gerer les utlisateurs via la page dédiez", JLabel.CENTER);
    	
    	panel = new JPanel();
    	panel.add(JL1);
    	panel.add(JL2);
		panel.setLayout(new GridLayout(5, 4, 7, 7));
        
        
        tree = new JTree(root);
        add(panel,BorderLayout.EAST);
        add(tree);
        add(new JScrollPane(tree)); 
        tree.getSelectionModel().addTreeSelectionListener(event -> valueChanged(event));       		
                  
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
        
        
        
}

    
    /**
     * Cette méthode permet de renvoyer l'utilisateur vers la page qu'il désire via le menu de navigation
     * @param e
     * @since 1.0
     */
    public void valueChanged(TreeSelectionEvent e) {
    	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    	String choix =  selectedNode.getUserObject().toString();
    	//renvoie sur la classe Nouveaux Formualaire
        if (choix == "Gerer utilisateur") {
     	   new GererUtilisateur();}
        }
}
