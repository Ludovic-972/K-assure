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

public class scolaire extends JFrame implements ItemListener, ActionListener{
	public JPanel panel;
	public JPanel panel2;
	public JButton home;
	public scolaire() {
		
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
		Object[] Nb = new Object[]{"0","1", "2", "3", "4", "5"};
		JComboBox nbenfant = new JComboBox(Nb);
		
		nbenfant.addItemListener(event ->nbEnfant(event));
		home = new JButton("home");
		home.addActionListener(this);
		panel.add(home);
		panel.add(nbenfant);		
	}
	public void nbEnfant(ItemEvent nb) {
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
			for(int i=0;i<n;i++) {				
					 JCB[i]=new JComboBox();
					 JCB[i].addItem(" ");
					 JCB[i].addItem("1-10");
					 JCB[i].addItem("11-18");
					 JCB[i].addItemListener(event ->recup(event) );
					 panel.add(JCB[i]);
					 TJCB[i]=new JComboBox();
					 TJCB[i].addItem("");
					 TJCB[i].addItem("Protection Scolaire");
					 TJCB[i].addItem("Trajet Scolaire");
					 TJCB[i].addItem("Vie Périscolaire");
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

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == home) {
			this.dispose();
			fenetre test = new fenetre();
			
		
		}
	}
	
	

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
