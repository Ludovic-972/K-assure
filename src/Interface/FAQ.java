package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FAQ  extends JFrame{
	
	private JPanel panel;
	
	
	public FAQ() {
		
		panel = new JPanel();

		JLabel q1 = new JLabel("Q : Comment d�clarer un sinistre ?");
		JLabel q2 = new JLabel("Q : Comment puis-je contacter mon assurance ?");
		JLabel q3 = new JLabel("Q : Mon animal est-il couvert par mon assurance habitation ?");
		JLabel q4 = new JLabel("Q : Peut-on assurer des appartements ?");
		JLabel q5 = new JLabel("Q : Assurez-vous les deux roues ?");
		JLabel q6 = new JLabel("Q : Est-ce que je peux assurer mon v�lo ?");
		JLabel q7 = new JLabel("Q : Les frais d�ost�opathe ou de chiropracteur peuvent-ils �tre rembours�s ?");	
		JLabel q8 = new JLabel("Q : Les frais d'amniocent�se non rembours�s par la S�curit� sociale peuvent-ils �tre pris en charge ?");	
		JLabel q9 = new JLabel("Q : Puis-je avoir l'assurance scolaire si je suis �tudiant ?");
		JLabel q10 = new JLabel("Q : Est-ce que je vais avoir besoin de prendre une nouvelle assurance scolaire quand je vais changer d'�tablissement ?");
	
		JLabel r1 = new JLabel("R : Pour d�clarer un sinistre, il suffit d'aller dans la section \"D�clarer un sinistre\".");
		JLabel r2 = new JLabel("R : Pour pouvoir contacter votre assurance, vous devez aller dans la rubrique \"Contact\".");
		JLabel r3 = new JLabel("R : En cas de sinistre dans votre habitation, votre animal de compagnie sera assur�. Cependant, si il lui arrive quoi que ce soit en dehors de votre habitation, votre assurance ne pourra plus le couvrir.");
		JLabel r4 = new JLabel("R : Il est possible d'assurer tout type d'habitation, y compris les appartements.");
		JLabel r5 = new JLabel("R : Oui, les deux roues sont assur�s au m�me titre que les autres v�hicules.");
		JLabel r6 = new JLabel("R : Non, l'assurance v�hicule ne couvre que les v�hicules motoris�s.");
		JLabel r7 = new JLabel("R : Oui, les frais d'ost�opathe et de chiropracteur sont pris en charge par l'assurance.");
		JLabel r8 = new JLabel("R : De m�me, les frais d'amniocent�se sont pris en charge par votre assurance.");
		JLabel r9 = new JLabel("R : Non, il faut que vous soyez scolaris� dans une �cole maternelle, primaire, coll�ge ou lyc�e.");
		JLabel r10 = new JLabel("R : Pas besoin, votre assurance scolaire vous suivra jusqu'� l'obtention de votre baccalaur�at.");
		
		
		
		panel.add(q1);
		panel.add(r1);
		panel.add(q2);
		panel.add(r2);
		
		panel.add(q3);
		panel.add(r3);
		panel.add(q4);
		panel.add(r4);
		
		panel.add(q5);
		panel.add(r5);
		panel.add(q6);
		panel.add(r6);
		
		panel.add(q7);
		panel.add(r7);
		panel.add(q8);
		panel.add(r8);
		
		panel.add(q9);
		panel.add(r9);
		panel.add(q10);
		panel.add(r10);
		
		panel.setLayout(new GridLayout(0, 2, -400, 20));
		
		add(panel);
	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("FAQ");       
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

