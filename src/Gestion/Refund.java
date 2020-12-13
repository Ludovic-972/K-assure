package Gestion;


import Assurance.carInsurance;
import Assurance.homeInsurance;
import BDgestion.BDconnection;

/**
 * 
 * @author Ludovic Mathurin-Cayol
 * @version 1.0
 */
public class Refund{
	
	/**
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 * @see Refund#isInscrit()
	 */
	private boolean inscrit = false;
	/**
	 * @see Refund#getRate()
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 * @see Refund#getNewCost()
	 */
	private double rate;
	/**
	 * @see Refund#Refund(String, int, double, String, Sinistre, String, boolean)
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 * @see Refund#getDamageCost()
	 */
	private double DamageCost;
	/**
	 * @see Refund#Refund(String, int, double, String, Sinistre, String, boolean)
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 */
	private Sinistre sinistre;
	/**
	 * @see Refund#Refund(String, int, double, String, Sinistre, String, boolean)
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 */
	private Person user;
	/**
	 * @see Refund#Refund(String, int, double, String, Sinistre, String, boolean)
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 */
	private String bien;
	/**
	 * @see Refund#Refund(String, int, double, String, Sinistre, String, boolean)
	 */
	private boolean sim;
	
	/**
	 * @see Refund#VehiculeRefund(int)
	 * @see Refund#HabitationRefund(int)
	 */
	private BDconnection bdd = new BDconnection();
	
	/**
	 * 
	 * @param name
	 * 		Nom de l'assurance choisie
	 * @param IDAssu
	 * 		Identifiant de l'assurance choisie
	 * @param _cost
	 * 		Coût de l'assurance choisie
	 * @param _user
	 * 		Nom de l'utilisateur
	 * @param sin
	 * 		Sinistre entré par l'utilisateur
	 * @param _bien
	 * 		Bien concerné par le sinistre
	 * @param _sim
	 * 		Simulation générée pour l'utilisateur
	 * 
	 * @see Refund#sinistre
	 * @see Refund#DamageCost
	 * @see Refund#user
	 * @see Refund#bien
	 * @see Refund#sim
	 * @see Refund#HabitationRefund(int)
	 * @see Refund#SanteRefund(int)
	 * @see Refund#VehiculeRefund(int)
	 */
	public Refund(String name, int IDAssu, double _cost, String _user, Sinistre sin, String _bien, boolean _sim) {
		this.sinistre = sin;
		this.DamageCost = _cost;
		this.user = new Person(_user);
		this.bien = _bien;
		this.sim = _sim;
		
		switch (sinistre.getSector()) {
			case "Habitation":
				HabitationRefund(IDAssu);
				break;
			case "V�hicule":
				VehiculeRefund(IDAssu);
				break;
	
			default:
				break;
		}
	}
	
	/**
	 * 
	 * @return Le taux de l'assurance choisie
	 */
	public double getRate() {
		return rate;
	}


	/**
	 * 
	 * @param IDassu
	 * 		Identifiant de l'assurance choisie
	 * 
	 * @see Auto#Auto(String, String)
	 * 
	 * @see carInsurance#carInsurance(int, String, Auto)
	 * @see carInsurance#isAllRisksCover()
	 * @see carInsurance#getBonus_malus()
	 * 
	 * @see Sinistre#getCriticity()
	 * @see Sinistre#getName()
	 * @see Sinistre#getSector()
	 * 
	 * @see Refund#sinistre
	 * @see Refund#rate
	 * @see Refund#user
	 * @see Refund#bdd
	 * @see Refund#DamageCost
	 * @see Refund#inscrit
	 */
	private void VehiculeRefund(int IDassu) {
		
		Auto car = new Auto(user.getLogin(), bien);
		carInsurance assu = new carInsurance(IDassu, user.getLogin(), car);
		
		
		switch (sinistre.getCriticity()) {
			case 1:
				if (assu.isAllRisksCover()) {
					rate = 20;
				}else {
					rate = 15;
				}
				break;
			case 2:
				if (assu.isAllRisksCover()) {
					rate = 45;
				}else {
					rate = 25;
				}
				break;
			case 3:
				if (assu.isAllRisksCover()) {
					rate = 75;
				}else {
					rate = 55;
				}
				break;

			default:
				break;
		}
		rate = rate *assu.getBonus_malus();
			
		if (user.getProfession().equals("Etudiant.e boursier.�re")) {
			rate = rate*1.2;
		}	
		
		bdd.executeQuery("INSERT INTO `Refund`(`idAsker`, `Sector`, `rate`, `sinister`, `ValueOfDamages`) VALUES ('"+user.getIdPerson()
		+"','"+sinistre.getSector()+"','"+rate+"','"+sinistre.getName()+"','"+DamageCost+"')");
		inscrit = true;
		
		
	}

	

	/**
	 * 
	 * @param IDassu
	 * 		Identifiant de l'assurance choisie
	 * 
	 * @see Residency#Residency(int, String)
	 * @see Residency#getRent()
	 * @see Residency#getPersonalEffectsValue()
	 * 
	 * @see homeInsurance#homeInsurance(int, String, Residency)
	 * @see homeInsurance#isAllRisksCover()
	 * 
	 * @see Sinistre#getSector()
	 * @see Sinistre#getName()
	 * 
	 * @see Refund#sinistre
	 * @see Refund#DamageCost
	 * @see Refund#rate
	 * @see Refund#user
	 * @see Refund#inscrit
	 */
	private void HabitationRefund(int IDassu) {
		Residency residency = new Residency(Integer.parseInt(bien), user.getLogin());
		homeInsurance assu = new homeInsurance(IDassu, user.getLogin(), residency);
		
		
		switch (sinistre.getCriticity()) {
			case 1:
				if ((DamageCost>= residency.getRent()*10) && residency.getRent()!=0) {
					if (assu.isAllRisksCover()) {
						rate = 25;
					}else {
						rate = 18;
					}
				}else {
					if (assu.isAllRisksCover()) {
						rate = 15;
					}else {
						rate = 10;
					}
				}
				break;
			case 2:
				if (residency.getPersonalEffectsValue()+residency.getPersonalEffectsValue()>= residency.getRent()) {
					if (assu.isAllRisksCover()) {
						rate = 45;
					}else {
						rate = 32;
					}
				}else {
					if (assu.isAllRisksCover()) {
						rate = 30;
					}else {
						rate = 22;
					}
				}
				break;
			case 3:
				if (residency.getPersonalEffectsValue()+residency.getPersonalEffectsValue()>= residency.getRent()) {
					if (assu.isAllRisksCover()) {
						rate = 70;
					}else {
						rate = 60;
					}
				}else {
					if (assu.isAllRisksCover()) {
						rate = 50;
					}else {
						rate = 48;
					}
				}
				break;

			default:
				break;
		}
			
		if (user.getProfession().equals("Etudiant.e boursier.�re")) {
			rate = rate*1.2;
		}	
		if (!sim) {
			bdd.executeQuery("INSERT INTO `Refund`(`idAsker`, `Sector`, `rate`, `sinister`, `ValueOfDamages`) VALUES ('"+user.getIdPerson()
			+"','"+sinistre.getSector()+"','"+rate+"','"+sinistre.getName()+"','"+DamageCost+"')");
		}
		inscrit = true;
	}

	/**
	 * 
	 * @return Si l'utilisateur est inscrit ou non
	 */
	public boolean isInscrit() {
		return inscrit;
	}

	/**
	 * 
	 * @return Le co�t pour r�parer le sinistre
	 */
	public double getDamageCost() {
		return DamageCost;
	}
	
	/**
	 * 
	 * @return Le coût pour réparer le sinistre après le taux remboursé par l'assurance
	 */
	public double getNewCost() {
		return Math.round((DamageCost*(rate/100)) * 100) / 100;
	}



}
