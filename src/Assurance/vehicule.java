package Assurance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Interface.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Vehicule extends JFrame implements ItemListener, ActionListener{
	private JPanel panel;
	private JPanel panel2;
	private JButton home;
	
	
	public Vehicule() {
		
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("formulaire");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
				 
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.setVisible(true);
		
		JComboBox<String> Marque = new JComboBox<String>();
		Marque.addItem("");
		Marque.addItem("Renault");
		Marque.addItem("Peugeot");
		Marque.addItem("Tesla");
		Marque.addItem("Ford");
		Marque.addItem("Autre");
		Marque.addItemListener(event -> annee(event));	
		home = new JButton("home");
		home.addActionListener(this);
		panel.add(home);
		panel.add(Marque);
		
	}

		
		
	 {

}
	 public void annee(ItemEvent nb) {
		 if (  nb.getItem() == "") {
			}else {
		 JComboBox<String> JCB=new JComboBox<String>();	 
		 JCB.addItem(" ");
		 JCB.addItem("1-10");
		 JCB.addItem("11-18");
		 JCB.addItem("20+");
		 JCB.addItemListener(event ->recup(event) );
		 panel.add(JCB);
		 JComboBox<String> JCB1=new JComboBox<String>();	 
		 JCB1.addItem(" ");
		 JCB1.addItem("3");
		 JCB1.addItem("5");
		 JCB1.addItemListener(event ->recup(event) );
		 panel.add(JCB1);
		 JComboBox<String> JCB2=new JComboBox<String>();	 
		 JCB2.addItem(" ");
		 JCB2.addItem("1-2");
		 JCB2.addItem("3-6");
		 JCB2.addItem("7-20");
		 JCB2.addItem("Au dela");
		 JCB2.addItemListener(event ->recup(event) );
		 panel.add(JCB2);
		 this.setVisible(true);
			}}
	 public void recup(ItemEvent nb) { 
			String recup = (String) nb.getItem();
			System.out.println(recup);	
			}
	 public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if (source == home) {
				this.dispose();
				new PageAccueil("","");
				
			
			}
		}
	 
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
