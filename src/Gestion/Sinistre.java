package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

/**
 * 
 * @author Ludovic
 * @version 1.0
 */
public class Sinistre {
	
	/**
	 * @see Sinistre#Sinistre(String)
	 * @see Sinistre#getName()
	 */
	private String name;
	/**
	 * @see Sinistre#Sinistre(String)
	 * @see Sinistre#getCriticity()
	 */
	private int criticity;
	/**
	 * @see Sinistre#Sinistre(String)
	 * @see Sinistre#getSector()
	 */
	private String sector;
	
	/**
	 * @see Sinistre#Sinistre(String)
	 */
	private BDconnection bdd = new BDconnection();
	
	/**
	 * 
	 * @param _name
	 * 		Nom du sinistre
	 * 
	 * @see Sinistre#name
	 * @see Sinistre#criticity
	 * @see Sinistre#sector
	 * @see Sinistre#bdd
	 */
	public Sinistre(String _name){
		this.name = _name;
		ResultSet sinistre = bdd.getResult("SELECT * FROM Sinister WHERE name = '"+_name+"'");
		try {
			while (sinistre.next()) {
				this.criticity = sinistre.getInt(2);
				this.sector = sinistre.getString(3);
				
			}
		} catch (SQLException e) {
			System.out.println("Erreur de r�cup�ration d'information.");
		}
	}

	/**
	 * 
	 * @return Le nom du sinistre
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return La criticité du sinistre
	 */
	public int getCriticity() {
		return criticity;
	}

	/**
	 * 
	 * @return Le secteur auquel le sinistre appartient
	 */
	public String getSector() {
		return sector;
	}

}
