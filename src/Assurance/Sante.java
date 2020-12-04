package Assurance;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
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
	private String get,StringArray[],Age,Nom,Prenom,NbSecu,Nombre,type,type1,type2,type3,Couverture[];
	private JTextField JTF[],nbPersonne,JTF1[],JTF2[],JTF3[];
	private JCheckBox[] TJCB,TJCB1,TJCB2,TJCB3,TJCB4;
	private JButton JBNumber,JBFormu;
	private JLabel[] JL,JL1,JL2,JL3;
	private JLabel Jl;
	private int n,x;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Sante(Object sante) {
		
		
				 
		panel = new JPanel();

		//creation d'une Zone de Texte pour le choixdu nombre de personne
		nbPersonne = new JTextField();
		nbPersonne.setColumns(10);
		
		//creation d'une zone de texte
		Jl = new JLabel("Nombre de personne à assuerées");
		
		//creation d'un bouton de validation du choix
		JBNumber = new JButton("Validez");
		
		
		//Ajout d'un itemListener pour le choix fait 
		JBNumber.addActionListener(event -> NumberOfFamilyNumber(nbPersonne.getText()));
		//ajout de  la fenetre deroulante au panel
		panel.add(Jl);
		panel.add(nbPersonne);
		panel.add(JBNumber);
		
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
	public void NumberOfFamilyNumber(String _nombre) {
		
		//transforme l'objet de la zone de text en nombre
		Nombre =(String)_nombre;
		n = Integer.parseInt(Nombre);
		
		//empeche de recuperer la valeur de la premier case de la fenetre deroulante
		if (n==0);
		
		//permet de recuperer l'information dans un terminal
		System.out.println(n);
		
		//creation des elements du panel
		TJCB=new JCheckBox[n];
		TJCB1 = new JCheckBox[n];
		TJCB2=new JCheckBox[n];
		TJCB3=new JCheckBox[n];
		JTF = new JTextField[n];
		JTF1 = new JTextField[n];
		JTF2 = new JTextField[n];
		JTF3 = new JTextField[n];
		JL=new JLabel[n];
		JL1=new JLabel[n];
		JL2=new JLabel[n];
		JL3=new JLabel[n];
		
		//Layout du panel
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//indique au panel de prendre toute la place libre horizontalement
		c.fill = GridBagConstraints.HORIZONTAL;
		    
		   
		
		//selecteur
		if ( _nombre == "0") {
	}
	else {	 
		//on ferme la fenetre precedente pour effacer les anciennes données
			panel.removeAll();	
			
			//on fait une boucle pour la creation des elements en fonction du nombre de personnes a assurer
			for(int i=0;i<n;i++) {
				x=i;
				
				//ajout des zone de saisie
					 JTF[i]=new JTextField();
					 c.weightx = 0.25;
					 
					 //Tout ces if permettent le positionnement des zone de saisie a l'emplacement souhaiter dans le Layout en fonction du nombre de personne
					    if(i==0) {
					    c.gridx=1;
					    c.gridy =i ;
					    }
					    else if (i==1) {
					    	c.gridx=1;
					    	c.gridy =2;
					    }
					    else {
					    	c.gridx=1;
					    	c.gridy =i*2;
					    }
					 panel.add(JTF[i],c);
					 JTF1[i]=new JTextField();
					 c.weightx = 0.25;
					 
					 //Tout ces if permettent le positionnement des zone de saisie a l'emplacement souhaiter dans le Layout en fonction du nombre de personne
					    if(i==0) {
					    c.gridx=3;
					    c.gridy =i ;
					    }
					    else if (i==1) {
					    	c.gridx=3;
					    	c.gridy =2;
					    }
					    else {
					    	c.gridx=3;
					    	c.gridy =i*2;
					    }
					 panel.add(JTF1[i],c);
					 
					 JTF2[i]=new JTextField();
					 c.weightx = 0.25;
					 
					 //Tout ces if permettent le positionnement des zone de saisie a l'emplacement souhaiter dans le Layout en fonction du nombre de personne
					    if(i==0) {
					    c.gridx=5;
					    c.gridy =i ;
					    }
					    else if (i==1) {
					    	c.gridx=5;
					    	c.gridy =2;
					    }
					    else {
					    	c.gridx=5;
					    	c.gridy =i*2;
					    }
					 panel.add(JTF2[i],c);
					 
					 JTF3[i]=new JTextField();
					 c.weightx = 0.25;
					 
					 //Tout ces if permettent le positionnement des zone de saisie a l'emplacement souhaiter dans le Layout en fonction du nombre de personne
					    if(i==0) {
					    c.gridx=7;
					    c.gridy =i ;
					    }
					    else if (i==1) {
					    	c.gridx=7;
					    	c.gridy =2;
					    }
					    else {
					    	c.gridx=7;
					    	c.gridy =i*2;
					    }
					 panel.add(JTF3[i],c);
					 
					 //creation des zones de texte
					 JL[i]=new JLabel("Nom",(int) Component.LEFT_ALIGNMENT);
					 c.weightx = 0.25;
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
					 panel.add(JL[i],c);
					 
					 
					 JL1[i]=new JLabel("Prenom",(int) Component.LEFT_ALIGNMENT);
					 c.weightx = 0.25;
					 if(i==0) {
						    c.gridx=2;
						    c.gridy =i ;
						    }
						    else if (i==1) {
						    	c.gridx=2;
						    	c.gridy =2;
						    }
						    else {
						    	c.gridx=2;
						    	c.gridy =i*2;
						    }
					 panel.add(JL1[i],c);
					 JL2[i]=new JLabel("Age",(int) Component.LEFT_ALIGNMENT);
					 c.weightx = 0.25;
					 if(i==0) {
						    c.gridx=4;
						    c.gridy =i ;
						    }
						    else if (i==1) {
						    	c.gridx=4;
						    	c.gridy =2;
						    }
						    else {
						    	c.gridx=4;
						    	c.gridy =i*2;
						    }
					 panel.add(JL2[i],c);
					 JL3[i]=new JLabel("Securité Social",(int) Component.LEFT_ALIGNMENT);
					 c.weightx = 0.25;
					 if(i==0) {
						    c.gridx=6;
						    c.gridy =i ;
						    }
						    else if (i==1) {
						    	c.gridx=6;
						    	c.gridy =2;
						    }
						    else {
						    	c.gridx=6;
						    	c.gridy =i*2;
						    }
					 panel.add(JL3[i],c);
					 
					 //creation des diffrente check box qui definise les couverture santés disponible et souhaiter pour chaque individue
					 TJCB[i]=new JCheckBox("Opti");
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
					    
//					    type = TJCB.getText();
					   
					    //ici on recupere si la case est coche ou non et le contenue de la case pour pouvoir les envoyer plus tard dans un autre terminale
//					    TJCB.addItemListener(event-> recuptype(event,type));
					    panel.add(TJCB[i], c);
					    
					 TJCB1[i]=new JCheckBox("gene");
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
//					    type1 = TJCB1.getText();
//					    TJCB1.addItemListener(event-> recuptype(event, type1)); 
					    panel.add(TJCB1[i], c);
					    
					 TJCB2[i]=new JCheckBox("specia");
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
//					    type2 = TJCB2.getText();
//					    TJCB2.addItemListener(event-> recuptype(event, type2));
					    panel.add(TJCB2[i], c);
					   
					 TJCB3[i]=new JCheckBox("denti");
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
//					    type3 = TJCB3.getText();
//					    TJCB3.addItemListener(event-> recuptype(event, type3));
					    panel.add(TJCB3[i], c);
					    
					}
			JBFormu = new JButton("Validez");
				c.weightx = 0.25;
			    c.gridx=0;
			    c.gridy =n*2+1;
			   
			
			JBFormu.addActionListener(event -> Recup(n));
			
			panel.add(JBFormu,c);
			this.setVisible(true);
			this.setLocation(1150,320);
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
	
	//Permet de recuperer les information des individues
	private void Recup(int nb) {
		
			
		for(int i=0;i<nb;i++) {
			x =i;
			
			//on recup toute les infos rentrer dans le formulaire
		Nom= JTF[x].getText();
		Prenom=JTF1[x].getText();
		NbSecu=JTF3[x].getText();
		
		//transforme 
		Age =(String) JTF2[x].getText();;
		n = Integer.parseInt(Age);
		
		
			
			
			Couverture= new String[4];
			if(TJCB[i].isSelected()==true) {			
				Couverture[0]=TJCB[i].getText();}
			else {
				Couverture[0]=" ";	
			}
			if(TJCB1[i].isSelected()==true) {
				Couverture[1]=TJCB1[i].getText();}
			else {
				Couverture[1]=" ";	
			}
			if(TJCB2[i].isSelected()==true) {
				Couverture[2]=TJCB2[i].getText();}
			else {
				Couverture[2]=" ";	
			}
			if(TJCB3[i].isSelected()==true) {
				Couverture[3]=TJCB3[i].getText();}
			else {
				Couverture[3]=" ";	
			}
		
		if(n>0 && n<10) {
			System.out.println("Nom : "+Nom+" Prenom : "+Prenom+" L'age est compris entre 0 et 10 : "+n+" Numéro de sécurité social : "+NbSecu+" Avec les covertures suivantes : "+Couverture[0]+" "+Couverture[1]+" "+Couverture[2]+" "+Couverture[3]);
		}
		else if(n>11 && n<18) {
			System.out.println("Nom : "+Nom+" Prenom : "+Prenom+" L'age est compris entre 11 et 18 : "+n+" Numéro de sécurité social : "+NbSecu+" Avec les covertures suivantes : "+Couverture[0]+""+Couverture[1]+" "+Couverture[2]+" "+Couverture[3]);
		}
		else if(n>18 && n<25) {
			System.out.println("Nom : "+Nom+" Prenom : "+Prenom+" L'age est compris entre 18 et 25 : "+n+" Numéro de sécurité social : "+NbSecu+" Avec les covertures suivantes : "+Couverture[0]+" "+Couverture[1]+" "+Couverture[2]+" "+Couverture[3]);
		}
		else if(n>26 && n<50) {
			System.out.println("Nom : "+Nom+" Prenom : "+Prenom+" L'age est compris entre 26 et 50 : "+n+" Numéro de sécurité social : "+NbSecu+" Avec les covertures suivantes : "+Couverture[0]+" "+Couverture[1]+" "+Couverture[2]+" "+Couverture[3]);
		}
		else if(n>51) {
			System.out.println("Nom : "+Nom+" Prenom : "+Prenom+" L'age est compris entre 51 et au dessus: "+n+" Numéro de sécurité social : "+NbSecu+" Avec les covertures suivantes : "+Couverture[0]+" "+Couverture[1]+" "+Couverture[2]+" "+Couverture[3]);
		}
		
		}	
	}
	
	
}
