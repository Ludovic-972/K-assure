package Assurance;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BDgestion.BDconnection;

public class Refund{
	
	
	private int niveau;
	BDconnection bdd = new BDconnection();
	
	public Refund(String type,String code) {
		switch (type) {
			case "Habitation":
				HabitationRefund(code);
				break;
			case "Santé":
				SanteRefund(code);
				break;
			case "Scolaire":
				ScolaireRefund(code);
				break;
			case "Vehicule":
				VehiculeRefund(code);
				break;
	
			default:
				break;
		}
	}

	private void VehiculeRefund(String code) {
		ResultSet assu = bdd.getResult("SELECT * FROM VehicleAssurance WHERE codeVA="+code);
		ResultSet vehicle = bdd.getResult("SELECT * FROM `Vehicle` where plateNumber = (SELECT vehicle from VehicleAssurance where codeVA = "+code+")");
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

	private void ScolaireRefund(String code) {
		// TODO Auto-generated method stub
		
	}

	private void SanteRefund(String code) {
		// TODO Auto-generated method stub
		
	}

	private void HabitationRefund(String code) {
		// TODO Auto-generated method stub
		
	}
	


}
