package Assurance;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class Sante extends JFrame implements ItemListener{
	
	private JPanel panel;
	private static JButton[] t;
	private String get;

	
	public Sante(Object sante) {
		
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Santé");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
				 
		panel = new JPanel();

		this.add(panel, BorderLayout.NORTH);
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
		nbPersonne.addItemListener(event -> tranchedage(event,sante) );
		
		panel.add(nbPersonne);
		
	}
	public void tranchedage(ItemEvent nb, Object sante) {
		// TODO Auto-generated method stub
		String Nombre =(String)nb.getItem();
		int n = Integer.parseInt(Nombre);
		

		JComboBox[] JCB;
		JComboBox[] TJCB;
		TJCB=new JComboBox[n];
		JCB = new JComboBox[n];
		panel.setLayout(new GridLayout(n, 3, 7, 7));
		if (  nb.getItem() == "0") {
	}
	else {	 
			panel.removeAll();	
			t = new JButton[n];
			for(int i=0;i<n;i++) {
				int x=i;
					 JCB[i]=new JComboBox();
					 JCB[i].addItem(" ");
					 JCB[i].addItem("1-10");
					 JCB[i].addItem("11-18");
					 JCB[i].addItem("19-25");
					 JCB[i].addItem("25-50");
					 JCB[i].addItem("50-110");
					 JCB[i].getSelectedItem();
					 panel.add(JCB[i]);
					 TJCB[i]=new JComboBox();
					 TJCB[i].addItem("");
					 TJCB[i].addItem("Opti");
					 TJCB[i].addItem("gene");
					 TJCB[i].addItem("specia");
					 TJCB[i].addItem("denti");
					 panel.add(TJCB[i]);
					 					 
					 t[x] = new JButton();
					 panel.add(t[i]);
				 t[i].addActionListener(event -> CreeAge((String) TJCB[x].getSelectedItem(),(String) JCB[x].getSelectedItem()));
					 
					
				}
			JPanel p2 = new JPanel();
			p2.setLayout(new GridLayout(1,2,7,7));
			JLabel JL = new JLabel("Information Complementaire",JLabel.CENTER);
			JL.setSize(150,50);
			JTextField JTF =new JTextField();
			JTF.setSize(200,50);
			
			JButton JB = new JButton("validez");
			p2.add(JL);
			p2.add(JTF);
			
			
			JPanel p3 = new JPanel();
			p3.add(JB);
			p3.setSize(230,500);
			add(p3,BorderLayout.SOUTH);
			JB.addActionListener(event -> AjoutComplementaire(JTF.getText()) );
			
			
				
			
			
			this.add(p2);
			this.setVisible(true);
		}	
		
	}
	private void AjoutComplementaire(String text) {
		// TODO Auto-generated method stub
		
	System.out.println(text);
		
		
	}
	private void CreeAge(String type, String age) {
		// TODO Auto-generated method stub
		System.out.println(type+" "+age);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

		
		
	
}
