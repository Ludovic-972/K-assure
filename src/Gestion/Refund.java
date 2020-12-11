package Gestion;


import Assurance.carInsurance;
import Assurance.homeInsurance;
import BDgestion.BDconnection;

public class Refund{
	
	private boolean inscrit = false;
	private double rate;
	private double DamageCost;
	private Sinistre sinistre;
	private Person user;
	private String bien;
	private boolean sim;
	
	private BDconnection bdd = new BDconnection();
	
	public Refund(String name,int IDAssu, double _cost,Person _user,Sinistre sin,String _bien,boolean _sim) {
		this.sinistre = sin;
		this.DamageCost = _cost;
		this.user = _user;
		this.bien = _bien;
		this.sim = _sim;
		
		switch (sinistre.getSector()) {
			case "Habitation":
				HabitationRefund(IDAssu);
				break;
			case "Santé":
				SanteRefund(IDAssu);
				break;
			case "Véhicule":
				VehiculeRefund(IDAssu);
				break;
	
			default:
				break;
		}
	}
	
	public double getRate() {
		return rate;
	}


	private void VehiculeRefund(int IDassu) {
		
		Auto car = new Auto(user.getLogin(), bien);
		carInsurance assu = new carInsurance(IDassu, user, car);
		
		
		switch (sinistre.getCriticity()) {
			case 1:
				if (assu.isAllRisksCover()) {
					rate = 15;
				}else {
					rate = 10;
				}
				break;
			case 2:
				if (assu.isAllRisksCover()) {
					rate = 40;
				}else {
					rate = 20;
				}
				break;
			case 3:
				if (assu.isAllRisksCover()) {
					rate = 70;
				}else {
					rate = 50;
				}
				break;

			default:
				break;
		}
		rate = rate *assu.getBonus_malus();
			
		if (user.getProfession().equals("Etudiant.e boursier.ère")) {
			rate = rate*1.2;
		}	
		
		bdd.executeQuery("INSERT INTO `Refund`(`idAsker`, `Sector`, `rate`, `sinister`, `ValueOfDamages`) VALUES ('"+user.getIdPerson()
		+"','"+sinistre.getSector()+"','"+rate+"','"+sinistre.getName()+"','"+DamageCost+"')");
		inscrit = true;
		
		
	}



	private void SanteRefund(int IDassu) {
		// TODO Auto-generated method stub
		
	}

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
			
		if (user.getProfession().equals("Etudiant.e boursier.ère")) {
			rate = rate*1.2;
		}	
		if (!sim) {
			bdd.executeQuery("INSERT INTO `Refund`(`idAsker`, `Sector`, `rate`, `sinister`, `ValueOfDamages`) VALUES ('"+user.getIdPerson()
			+"','"+sinistre.getSector()+"','"+rate+"','"+sinistre.getName()+"','"+DamageCost+"')");
		}
		inscrit = true;
	}

	public boolean isInscrit() {
		return inscrit;
	}

	public double getDamageCost() {
		return DamageCost;
	}
	
	public double getNewCost() {
		return Math.round((DamageCost*(rate/100)) * 100) / 100;
	}



}
