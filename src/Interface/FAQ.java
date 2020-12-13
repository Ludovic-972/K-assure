package Interface;


import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * FAQ est la page qui permet à un utilisatuer connecter ou non d'avoir acces une base de question réponse
 * @author Paul Rittaud
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class FAQ  extends JFrame{
	/**
	 * Panel de contruction de la classe
	 * @since 1.0
	 */
	private JPanel panel;
	
	/**
	 * Contstructeur de la classe qui affiche la totatlités des question et leur réponse
	 * @since 1.0
	 */
	public FAQ() {
		

		JLabel q1 = new JLabel("<html><body><u>Q : Comment déclarer un sinistre ?</u></body></html>");
		JLabel q2 = new JLabel("<html><body><u>Q : Comment puis-je contacter mon assurance ?</u></body></html>");
		JLabel q3 = new JLabel("<html><body><u>Q : Mon animal est-il couvert par mon assurance habitation ?</u></body></html>");
		JLabel q4 = new JLabel("<html><body><u>Q : Peut-on assurer des appartements ?</u></body></html>");
		JLabel q5 = new JLabel("<html><body><u>Q : Assurez-vous les deux roues ?</u></body></html>");
		JLabel q6 = new JLabel("<html><body><u>Q : Est-ce que je peux assurer mon vélo ?</u></body></html>");
		JLabel q7 = new JLabel("<html><body><u>Q : Les frais d’ostéopathe ou de chiropracteur peuvent-ils être remboursés ?</u></body></html>");	
		JLabel q8 = new JLabel("<html><body><u>Q : Les frais d'amniocentèse non remboursés par la Sécurité sociale peuvent-ils être pris en charge ?</u></body></html>");	
		JLabel q9 = new JLabel("<html><body><u>Q : Puis-je avoir l'assurance scolaire si je suis étudiant ?</u></body></html>");
		JLabel q10 = new JLabel("<html><body><u>Q : Est-ce que je vais avoir besoin de prendre une nouvelle assurance scolaire quand je vais changer d'établissement ?</u></body></html>");
	
		JLabel r1 = new JLabel("R : Pour déclarer un sinistre, il suffit d'aller dans la section \"Déclarer un sinistre\".");
		JLabel r2 = new JLabel("R : Pour pouvoir contacter votre assurance, vous devez aller dans la rubrique \"Contact\".");
		JLabel r3 = new JLabel("R : En cas de sinistre dans votre habitation, votre animal de compagnie sera assuré."
				+ " Cependant, si il lui arrive quoi que ce soit en dehors de votre habitation, votre assurance ne pourra plus le couvrir.");
		JLabel r4 = new JLabel("R : Il est possible d'assurer tout type d'habitation, y compris les appartements.");
		JLabel r5 = new JLabel("R : Oui, les deux roues sont assurés au même titre que les autres véhicules.");
		JLabel r6 = new JLabel("R : Non, l'assurance véhicule ne couvre que les véhicules motorisés.");
		JLabel r7 = new JLabel("R : Oui, les frais d'ostéopathe et de chiropracteur sont pris en charge par l'assurance.");
		JLabel r8 = new JLabel("R : De même, les frais d'amniocentèse sont pris en charge par votre assurance.");
		JLabel r9 = new JLabel("R : Non, il faut que vous soyez scolarisé dans une école maternelle, primaire, collège ou lycée.");
		JLabel r10 = new JLabel("R : Pas besoin, votre assurance scolaire vous suivra jusqu'à l'obtention de votre baccalauréat.");
		
		panel = new JPanel(new GridLayout(10, 1));
		JLabel[] q = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};
		JLabel[] r = {r1,r2,r3,r4,r5,r6,r7,r8,r9,r10};
		
		JPanel[] tab = new JPanel[10];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new JPanel(new GridLayout(2,1));
			
			q[i].setFont(new Font("Arial",Font.TYPE1_FONT, 14));
			r[i].setFont(new Font("Arial",Font.TYPE1_FONT, 13));
			
			tab[i].add(q[i]);
			tab[i].add(r[i]);
			panel.add(tab[i]);
		}
		
		
		

		this.add(panel);
	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("FAQ");       
		this.setSize(1300,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FAQ();
	}
}

