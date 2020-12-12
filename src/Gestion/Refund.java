package Gestion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Assurance.carInsurance;
import BDgestion.BDconnection;

public class Refund{
	
	private boolean inscrit = false;
	private double rate;
	private float DamageCost;
	private Sinistre sinistre;
	private Adult user;
	private String bien;

	private BDconnection bdd = new BDconnection();
	
	public Refund(String name,int IDAssu, float _cost,Adult _user,Sinistre sin,String _bien) {
		System.out.println("coucou");
		this.sinistre = sin;
		this.DamageCost = _cost;
		this.user = _user;
		this.bien = _bien;
		switch (sinistre.getSector()) {
			case "Habitation":
				HabitationRefund(IDAssu);
				break;
			case "Santé":
				SanteRefund(IDAssu);
				break;
			case "Vehicule":
				VehiculeRefund(IDAssu);
				break;
	
			default:
				break;
		}
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double _rate) {
		this.rate = _rate;
	}

	private void VehiculeRefund(int IDassu) {

		carInsurance assu = new carInsurance(IDassu);
		Vehicle car = new Vehicle(user.getLogin(), bien);
		
		
		switch (sinistre.getCriticity()) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;

			default:
				break;
		}
			
		if (user.getProfession().equals("Etudiant.e boursier.ère")) {
			rate = rate*1.5;
		}	
		inscrit = true;
		
		
	}



	private void SanteRefund(int IDassu) {
		// TODO Auto-generated method stub
		
	}

	private void HabitationRefund(int IDassu) {
		ResultSet assu = bdd.getResult("SELECT * FROM HomeAssurance WHERE idVA="+IDassu);
		ResultSet maison = bdd.getResult("SELECT * FROM Residency where idResidency = (SELECT idResidency from HomeAssurance where idVA = "+IDassu+")");
		List<Object> info_maison = new ArrayList<>();
		List<Object> info_assu = new ArrayList<>();
		
		try {
			for (int i = 1; assu.next(); i++) {
				info_assu.add(i);
			}
			for (int i = 1; maison.next(); i++) {
				info_maison.add(i);
			}
		
		} catch (Exception e) {
			System.out.println("Erreur de récupération d'information.");
		}
	}

	public boolean isInscrit() {
		return inscrit;
	}



}
