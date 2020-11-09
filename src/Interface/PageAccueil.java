package Interface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
public class PageAccueil extends JFrame
{
    private JTree tree;
    private JButton Connection;
    public PageAccueil()
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Utilisateur");
        vegetableNode.add(new DefaultMutableTreeNode("Contact"));
        vegetableNode.add(new DefaultMutableTreeNode("Contrats"));
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Assurances");

        //add the child nodes to the root node
       
        root.add(vegetableNode);
        root.add(fruitNode);
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        Connection = new JButton("Connection Assu");
        add(Connection, BorderLayout.SOUTH);
        add(tree);
        add(new JScrollPane(tree)); 
        Connection.addActionListener(event -> connection(event));
        
        tree.getSelectionModel().addTreeSelectionListener(event -> valueChanged(event));
        		
                  
         
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
    }
    public void valueChanged(TreeSelectionEvent e) {
    	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    	String choix =  selectedNode.getUserObject().toString();
    	System.out.println(selectedNode);
        if (choix == "Assurances") {
     	   NouveauxContrat NC = new NouveauxContrat();
     	   NC.setVisible(true);}
        else if (choix =="Utilisateur") {
//        	ici la page de Paulo      	
        	
        }
        	
        }
    public void connection(ActionEvent event) {
    	PagedeConnection PDC = new PagedeConnection();
    	PDC.setVisible(true);
    	
    	
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PageAccueil();
            }
        });
    }       
}