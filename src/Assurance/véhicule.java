

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class v�hicule extends JFrame implements ItemListener{
	public JPanel panel;
	public JPanel panel2;
	v�hicule() {
		
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("V�hicule");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
				 
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.setVisible(true);
		
		JComboBox Marque = new JComboBox();
		Marque.addItem("");
		Marque.addItem("Renault");
		Marque.addItem("Peugeot");
		Marque.addItem("Tesla");
		Marque.addItem("Ford");
		Marque.addItem("Autre");
		Marque.addItemListener(event -> annee(event));	
		panel.add(Marque);
		
	}

		
		
	 {

}
	 public void annee(ItemEvent nb) {
		 if (  nb.getItem() == "") {
			}else {
		 JComboBox JCB=new JComboBox();	 
		 JCB.addItem(" ");
		 JCB.addItem("1-10");
		 JCB.addItem("11-18");
		 JCB.addItem("20+");
		 JCB.addItemListener(event ->recup(event) );
		 panel.add(JCB);
		 JComboBox JCB1=new JComboBox();	 
		 JCB1.addItem(" ");
		 JCB1.addItem("3");
		 JCB1.addItem("5");
		 JCB1.addItemListener(event ->recup(event) );
		 panel.add(JCB1);
		 JComboBox JCB2=new JComboBox();	 
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
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
