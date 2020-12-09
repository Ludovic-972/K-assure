package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

public class Sinistre {
	
	private String name;
	private int criticity;
	private String sector;
	
	private BDconnection bdd = new BDconnection();
	
	public Sinistre(String _name){
		this.name = _name;
		ResultSet sinistre = bdd.getResult("SELECT * FROM sinister WHERE name = "+_name);
		try {
			while (sinistre.next()) {
				this.criticity = sinistre.getInt(2);
				this.sector = sinistre.getString(3);
				
			}
		} catch (SQLException e) {
			System.out.println("Erreur de récupération d'information.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCriticity() {
		return criticity;
	}

	public void setCriticity(int criticity) {
		this.criticity = criticity;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}
