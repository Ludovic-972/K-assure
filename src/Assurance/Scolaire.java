package Assurance;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scolaire extends JFrame implements ItemListener{
	private JPanel panel;
	private JPanel panel2;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Scolaire() {
		
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Scolaire");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
				 
		panel = new JPanel();
		
		this.add(panel, BorderLayout.NORTH);
		this.setVisible(true);
		Object[] Nb = new Object[]{"0","1", "2", "3", "4", "5"};
		JComboBox nbenfant = new JComboBox(Nb);
		
		nbenfant.addItemListener(event ->nbEnfant(event));	
		panel.add(nbenfant);		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void nbEnfant(ItemEvent nb) {
		String Nombre =(String)nb.getItem();
		int n = Integer.parseInt(Nombre);
		JComboBox[] JCB;
		panel.setLayout(new GridLayout(n, 3, 7, 7));
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
					 JCheckBox TJCB1=new JCheckBox("Protection Scolaire");
					 JCheckBox TJCB2=new JCheckBox("Trajet Scolaire");
					 JCheckBox TJCB3=new JCheckBox("Vie Périscolaire");
					 TJCB1.addActionListener(event -> recup(event));
					 TJCB2.addActionListener(event -> recup(event));
					 TJCB3.addActionListener(event -> recup(event));
					 panel.add(TJCB1); panel.add(TJCB2); panel.add(TJCB3); 					
				}
			this.setVisible(true);
		}	
		
	}
	private void recup(ItemEvent event) {
		String recup = (String) event.getItem();
		System.out.println(recup);

	}
	public void recup(ActionEvent event) { 
System.out.println(event.getActionCommand());
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
