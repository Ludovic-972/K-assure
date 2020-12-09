package Gestion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BDgestion.BDconnection;

public class Refund{
	
	private boolean inscrit = false;
	private int niveau = 0;
	private float amount;
	private float price;
	private Sinistre sinistre;

	private BDconnection bdd = new BDconnection();
	
	public Refund(String name,int IDAssu) {
		sinistre = new Sinistre(name);
		switch (sinistre.getSector()) {
			case "Habitation":
				HabitationRefund(IDAssu);
				break;
			case "Santé":
				SanteRefund(IDAssu);
				break;
			case "Scolaire":
				ScolaireRefund(IDAssu);
				break;
			case "Vehicule":
				VehiculeRefund(IDAssu);
				break;
	
			default:
				break;
		}
	}
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	private void VehiculeRefund(int IDassu) {
		ResultSet assu = bdd.getResult("SELECT * FROM VehicleAssurance WHERE idVA="+IDassu);
		ResultSet vehicle = bdd.getResult("SELECT * FROM `Vehicle` where plateNumber = (SELECT vehicle from VehicleAssurance where idVA = "+IDassu+")");
		List<Object> info_vehicle = new ArrayList<>();
		List<Object> info_assu = new ArrayList<>();
		
		try {
			for (int i = 1; assu.next(); i++) {
				info_assu.add(i);
			}
			for (int i = 1; vehicle.next(); i++) {
				info_vehicle.add(i);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Erreur de récupération d'information.");
		}
		
	}

	private void ScolaireRefund(int IDassu) {

		
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
