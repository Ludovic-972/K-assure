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





//Pour cette page on reutilise les memes elements que pour pageAcceuil mais on ajoute juste les elements utile a la personnes qui ce connecte ici l'admin



public class PageAdmin extends JFrame {
	private JTree tree;
    private DefaultMutableTreeNode root;
    private JPanel panel ;
    public PageAdmin()
    {
    	
    	// on recreet la meme page que pour pageAcceuil en ajoutant cette fois les elements specifique a l'administrateur
        root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Contact");
        DefaultMutableTreeNode vegetableNode2 = new DefaultMutableTreeNode("Contrats");
        DefaultMutableTreeNode Assurance = new DefaultMutableTreeNode("Assurances");
		 
       
       
        root.add(vegetableNode);
        root.add(vegetableNode2);
        root.add(Assurance);
         
        
        
        
        
        
    
    	JLabel JL1 = new JLabel("Bonjour", JLabel.CENTER);
    	JLabel JL2 = new JLabel("Vous pouvez nous contactez via la page dédiez", JLabel.CENTER);
    	JLabel JL3 = new JLabel("Ou bien vous renseignez sur les contrats existant", JLabel.CENTER);
    	
    	panel = new JPanel();
    	panel.add(JL1);
    	panel.add(JL2);
    	panel.add(JL3);
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
    public void valueChanged(TreeSelectionEvent e) {
    	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    	String choix =  selectedNode.getUserObject().toString();
    	//renvoie sur la classe Nouveaux Formualaire
        if (choix == "Assurances") {
     	   NouveauxContrat NC = new NouveauxContrat();
     	   NC.setVisible(true);}
        else if (choix =="Contact") {
        	
            }
        else if (choix =="Contrats") {
//        	ici la page contrats
        }
        }
}
