package Assurance;

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

import Gestion.Person;
import Interface.PageAccueil;
import Interface.PagedeConnection;

@SuppressWarnings("serial")
public class Contact extends JFrame{

	
	 private JTree tree;
	    private JButton Connection;
	    private DefaultMutableTreeNode root;
	    private JPanel panel ;
	    private String user;
	    private String cat;
	    
	    public Contact(String _login,String _cat) {
	    	this.user = _login;
	    	this.cat = _cat;
	        root = new DefaultMutableTreeNode("Root");
	        //create the child nodes
	        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Contact");
	        DefaultMutableTreeNode vegetableNode2 = new DefaultMutableTreeNode("Contrats");
	        panel = new JPanel();
        	
        	JLabel JL1 = new JLabel("Voici la page de contact", JLabel.CENTER);
        	JLabel JL2 = new JLabel("Numéro de téléphone : 0123456789", JLabel.CENTER);
        	JLabel JL3 = new JLabel("Adresse Mail de l'agence : KAssure@monmail.com", JLabel.CENTER);
        	panel.add(JL1);
        	panel.add(JL2);
        	panel.add(JL3);
			panel.setLayout(new GridLayout(5, 4, 7, 7));  
	       
	        //add the child nodes to the root node
	       
	        root.add(vegetableNode);
	        root.add(vegetableNode2);
	         
	        //create the tree by passing in the root node
	        
	        tree = new JTree(root);
	        Connection = new JButton("Retour à l'accueil");
	        add(panel,BorderLayout.EAST);
	        add(Connection, BorderLayout.SOUTH);
	        add(tree);
	        add(new JScrollPane(tree)); 
	        Connection.addActionListener(event -> connection(event));        
	        tree.getSelectionModel().addTreeSelectionListener(event -> valueChanged(event));       		
	               
	         
	        
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setTitle("Contactez K-Assure");      
	        this.pack();
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
}
	    public void valueChanged(TreeSelectionEvent e) {
	    	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	    	String choix =  selectedNode.getUserObject().toString();
	    	System.out.println(selectedNode);
/*	        if (choix == "Contact") {
	        	this.setTitle("Contactez K-Assure");
	        	JPanel panel = new JPanel();
	        	JLabel JL1 = new JLabel("Voici la page de contact");
	        	JLabel JL2 = new JLabel("Numéro de téléphone : 0123456789");
	        	JLabel JL3 = new JLabel("Adresse Mail de l'agence : KAssure@monmail.com");
	        	panel.add(JL1);
	        	panel.add(JL2);
	        	panel.add(JL3);
*/	        	
//	        	
//	        	
//	        	
//	        	
//	        	
//	        	
//	        		
//	        }
//	        else if (choix =="Contrats") {
////	        	ici la page de Paulo      	
//	        	
//	        }
	        }
	    
	    
	    public void connection(ActionEvent event) {
	    	this.dispose();
	    	new PageAccueil(user,cat);	
	    	
	    	
	    }
	    }
