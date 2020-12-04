package Assurance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings({ "unused", "serial" })
public class Sante extends JFrame {
	
	//Implementation des différentes variable
	public JPanel panel,JP2;
	private String get,JCBS[],Nombre,type,type1,type2,type3;
	private int n;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Sante(Object sante) {
		
		
				 
		panel = new JPanel();

		//creation d'une fenetre déroulante pour le choixdu nombre de personne
		JComboBox nbPersonne = new JComboBox();
		
		//ajout des choix
		nbPersonne.addItem("0");
		nbPersonne.addItem("1");
		nbPersonne.addItem("2");
		nbPersonne.addItem("3");
		nbPersonne.addItem("4");
		nbPersonne.addItem("5");
		nbPersonne.addItem("6");
		nbPersonne.addItem("7");
		
		//Ajout d'un itemListener pour le choix fait 
		nbPersonne.addItemListener(event -> NumberOfFamilyNumber(event,sante) );
		
		//ajout de  la fenetre deroulante au panel
		panel.add(nbPersonne);
		
		
		//Reglage de la fenetre
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Santé");
		this.setLocation(1150,320);
		this.setResizable(true);
		this.add(panel, BorderLayout.NORTH);
		this.setVisible(true);	
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//methode d'action suite à la selection du nombre de personnes choisi
	public void NumberOfFamilyNumber(ItemEvent nb, Object sante) {
		
		//transforme l'ibjet de la fenetre deroulante en nombre
		Nombre =(String)nb.getItem();
		n = Integer.parseInt(Nombre);
		
		//empeche de recuperer la valeur de la premier case de la fenetre deroulante
		if (n==0);
		
		//permet de recuperer l'information dans un terminal
		System.out.println(n);
		
		//creation des elements du panel
		JComboBox[] JCB;
		JCheckBox TJCB,TJCB1,TJCB2,TJCB3,TJCB4;
		TJCB=new JCheckBox();
		TJCB1 = new JCheckBox();
		TJCB2=new JCheckBox();
		TJCB3=new JCheckBox();
		JCB = new JComboBox[n];
		
		//Layout du panel
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//indique au panel de prendre toute la place libre horizontalement
		c.fill = GridBagConstraints.HORIZONTAL;
		    
		   
		
		//selecteur
		if (  nb.getItem() == "0") {
	}
	else {	 
		//on ferme la fenetre precedente pour effacer les anciennes données
			panel.removeAll();	
			
			//on fait une boucle pour la creation des elements en fonction du nombre de personnes a assurer
			for(int i=0;i<n;i++) {
				int x=i;
				
				//ajout des elements a la fenetre deroulante
					 JCB[i]=new JComboBox();
					 JCB[i].addItem(" ");
					 JCB[i].addItem("1-10");
					 JCB[i].addItem("11-18");
					 JCB[i].addItem("19-25");
					 JCB[i].addItem("25-50");
					 JCB[i].addItem("50-110");
					 JCB[i].getSelectedItem();
					 JCB[i].addActionListener(event -> RecupTrancheAge(JCB[x].getSelectedItem()));
					 
					 //Tout ces if permettent le positionnement des fenetre a l'emplacement souhaiter dans le Layout en fonction du nombre de personne
					    if(i==0) {
					    c.gridx=0;
					    c.gridy =i ;
					    }
					    else if (i==1) {
					    	c.gridx=0;
					    	c.gridy =2;
					    }
					    else {
					    	c.gridx=0;
					    	c.gridy =i*2;
					    }
					 panel.add(JCB[i],c);
					 
					 //creation des diffrente check box qui definise les couverture santés disponible et souhaiter pour chaque individue
					 TJCB=new JCheckBox("Opti");
					 	c.weightx = 0.25;
					    c.fill = GridBagConstraints.HORIZONTAL;
					    c.gridx = 0;
					    
					    //pareil que precedement on definit le positionnement des check box en fonction du nombre de personne
					    if(i==0) {
						    c.gridy =1 ;
						    }
					    else if (i==1) {
					       	c.gridy =3;
					    }
					    else {
					    	c.gridy =i*2+1;
					    }
					    
					    type = TJCB.getText();
					   
					    //ici on recupere si la case est coche ou non et le contenue de la case pour pouvoir les envoyer plus tard dans un autre terminale
					    TJCB.addItemListener(event-> recuptype(event,type));
					    panel.add(TJCB, c);
					    
					 TJCB1=new JCheckBox("gene");
					 	c.fill = GridBagConstraints.HORIZONTAL;
					    c.weightx = 0.25;
					    c.gridx = 1;
					    if(i==0) {
						    c.gridy =1 ;
						    }
					    else if (i==1) {
					       	c.gridy =3;
					    }
					    else {
					    	c.gridy =i*2+1;
					    }
					    type1 = TJCB1.getText();
					    TJCB1.addItemListener(event-> recuptype(event, type1)); 
					    panel.add(TJCB1, c);
					    
					 TJCB2=new JCheckBox("specia");
					 	c.fill = GridBagConstraints.HORIZONTAL;
					    c.weightx = 0.25;
					    c.gridx = 2;
					    if(i==0) {
						    c.gridy =1 ;
						    }
					    else if (i==1) {
					       	c.gridy =3;
					    }
					    else {
					    	c.gridy =i*2+1;
					    }    
					    type2 = TJCB2.getText();
					    TJCB2.addItemListener(event-> recuptype(event, type2));
					    panel.add(TJCB2, c);
					   
					 TJCB3=new JCheckBox("denti");
					 c.fill = GridBagConstraints.HORIZONTAL;
					    c.weightx = 0.25;
					    c.gridx = 3;
					    if(i==0) {
						    c.gridy =1 ;
						    }
					    else if (i==1) {
					       	c.gridy =3;
					    }
					    else {
					    	c.gridy =i*2+1;
					    }
					    type3 = TJCB3.getText();
					    TJCB3.addItemListener(event-> recuptype(event, type3));
					    panel.add(TJCB3, c);
					    
					}
			this.setVisible(true);
			this.setLocation(1150,320);;
		}	
		
	}
	
	//ici on permet la recuperation des type de couverture souhaiter
	private void recuptype(ItemEvent event, String _type) {
		//on transforme l'event soit la box est check soit elle ne l'ai pas (0 ou 1)
		int checked = event.getStateChange();
		
		//verification si la box est check ou non si elle n'est aps check on ne recupere pas l'information (permet de uncheck sans rerecevoir l'information)
		if(checked == 1)
		System.out.println(_type);
	}
	
	//Permet de recuperer les information sur la tranche d'age des individues
	private void RecupTrancheAge(Object object) {
		System.out.println(object);
	}

	
		
		
	
}
