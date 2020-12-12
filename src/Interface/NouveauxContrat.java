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
	private JPanel panel;
	private JPanel panel2;
	private JComboBox contrat;
	private JFrame fenetre1;
	private String user;
	
	
	public NouveauxContrat(String _user) {
		this.user = _user;
		fenetre1 = new JFrame();
		fenetre1.setLayout(new BorderLayout());
		fenetre1.setSize(500,500);
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre1.setTitle("formulaire");
		fenetre1.setLocation(1200,280);
		fenetre1.setResizable(true);
		
		
		contrat = new JComboBox();
		contrat.addItem(" ");
		contrat.addItem("Habitation");
		contrat.addItem("Santé");
		contrat.addItem("Véhicule");
		contrat.addItem("Scolaire");
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
		if ( item.getItem() == "Habitation") {
			Habitation hab = new Habitation();
			hab.setVisible(true);			
			fenetre1.setVisible(false);

		}
		else if (item.getItem() == "Scolaire") {
				Scolaire sco = new Scolaire();
				sco.setVisible(true);
				fenetre1.setVisible(false);
					
			
		}else if (item.getItem() == "Santé") {
			
			Sante sante = new Sante(item.getItem());
			sante.setVisible(true);
			fenetre1.setVisible(false);
				
		
	}else if (item.getItem() == "Véhicule") {
		Vehicule veh = new Vehicule(user);
		veh.setVisible(true);
		fenetre1.setVisible(false);
			
	
}
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
	}

}
