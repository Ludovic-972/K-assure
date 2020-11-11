package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Assurance.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class NouveauxContrat extends JFrame implements ItemListener {

	
	private static final long serialVersionUID = 1L;
	JPanel fenetre = new JPanel();
	public JPanel panel;
	public JPanel panel2;
	public JComboBox contrat;
	public JFrame fenetre1;
			
	
	
	public NouveauxContrat() {
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
		contrat.addItem("sant�");
		contrat.addItem("v�hicule");
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
			Habitation hab = new Habitation();
			hab.setVisible(true);			
			fenetre1.setVisible(false);

		}
		else if (item.getItem() == "scolaire") {
				Scolaire sco = new Scolaire();
				sco.setVisible(true);
				fenetre1.setVisible(false);
					
			
		}else if (item.getItem() == "sant�") {
			
			Sante sante = new Sante(item.getItem());
			sante.setVisible(true);
			fenetre1.setVisible(false);
				
		
	}else if (item.getItem() == "v�hicule") {
		Vehicule veh = new Vehicule();
		veh.setVisible(true);
		fenetre1.setVisible(false);
			
	
}
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
	}

}
