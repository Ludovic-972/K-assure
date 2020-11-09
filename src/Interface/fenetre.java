package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Assurance.*;

public class fenetre extends JFrame implements ItemListener {

	
	private static final long serialVersionUID = 1L;
	JPanel fenetre = new JPanel();
	public JPanel panel;
	public JPanel panel2;
	public JComboBox contrat;
	public JFrame fenetre1;
			
	public fenetre() {
		fenetre1 = new JFrame();
		fenetre1.setLayout(new BorderLayout());
		fenetre1.setSize(500,500);
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre1.setTitle("formulaire");
		fenetre1.setLocationRelativeTo(null);
		fenetre1.setResizable(true);
		
		
		contrat = new JComboBox();
		contrat.addItem(" ");
		contrat.addItem("habitation");
		contrat.addItem("santé");
		contrat.addItem("véhicule");
		contrat.addItem("scolaire");
		contrat.addItemListener(this);
		
		 
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel.add(contrat);
		fenetre1.add(panel, BorderLayout.NORTH);
		fenetre1.add(panel2, BorderLayout.CENTER);
		fenetre1.setVisible(true);
		
		}
	
	public void itemStateChanged(ItemEvent item) {
		if ( item.getItem() == "habitation") {
			habitation hab = new habitation();
			hab.setVisible(true);
			fenetre1.dispose();
				

		}
		else if (item.getItem() == "scolaire") {
				scolaire sco = new scolaire();
				sco.setVisible(true);
				fenetre1.dispose();
					
			
		}else if (item.getItem() == "santé") {
			sante sante = new sante();
			sante.setVisible(true);
			fenetre1.dispose();
				
		
	}else if (item.getItem() == "véhicule") {
		vehicule veh = new vehicule();
		veh.setVisible(true);
		fenetre1.dispose();
			
	
}
			
			
			
			
			
			

			
			
			
		
		
		
		
		
		
		
		
		
	}

}
