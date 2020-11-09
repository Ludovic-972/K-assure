package Assurance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Interface.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class sante extends JFrame implements ItemListener, ActionListener{
	public JPanel panel;
	public JPanel panel2;
	public JButton home;
	
	public sante() {
		
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
		
		JComboBox nbPersonne = new JComboBox();
		nbPersonne.addItem("0");
		nbPersonne.addItem("1");
		nbPersonne.addItem("2");
		nbPersonne.addItem("3");
		nbPersonne.addItem("4");
		nbPersonne.addItem("5");
		nbPersonne.addItem("6");
		nbPersonne.addItem("7");
		nbPersonne.addItemListener(event -> tranchedage(event) );
		
		home = new JButton("home");
		home.addActionListener(this);
		
		panel.add(home);
		panel.add(nbPersonne);
		
	}
	public void tranchedage(ItemEvent nb) {
		// TODO Auto-generated method stub
		String Nombre =(String)nb.getItem();
		int n = Integer.parseInt(Nombre);
		JComboBox[] JCB;
		JComboBox[] TJCB;
		TJCB=new JComboBox[n];
		JCB = new JComboBox[n];
		if (  nb.getItem() == "0") {
	}
	else {	 
			panel.removeAll();
			panel.add(home);
			for(int i=0;i<n;i++) {				
					 JCB[i]=new JComboBox();
					 JCB[i].addItem(" ");
					 JCB[i].addItem("1-10");
					 JCB[i].addItem("11-18");
					 JCB[i].addItem("19-25");
					 JCB[i].addItem("25-50");
					 JCB[i].addItem("50-110");
					 JCB[i].addItemListener(event ->recup(event) );
					 panel.add(JCB[i]);
					 TJCB[i]=new JComboBox();
					 TJCB[i].addItem("");
					 TJCB[i].addItem("Opti");
					 TJCB[i].addItem("gene");
					 TJCB[i].addItem("specia");
					 TJCB[i].addItem("denti");
					 TJCB[i].addItemListener(event -> recup(event));
					 panel.add(TJCB[i]);
					 
					
				}
			this.setVisible(true);
		}	
		
	}
	public void recup(ItemEvent nb) { 
		String recup = (String) nb.getItem();
		System.out.println(recup);
		

			
			 
			
		}
		
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == home) {
			this.dispose();
			fenetre test = new fenetre();
			
		
		}
	}

		
		
	
}
