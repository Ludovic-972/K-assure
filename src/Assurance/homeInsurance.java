package Assurance;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;
import Gestion.Person;
import Gestion.Residency;

/**
 * Classe modélisant une assurance habitation
 * 
 * @author Mathurin-Cayol Ludovic
 * @version 1.0
 * */
public class homeInsurance{
    
	/**
	 * Id de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see homeInsurance#getID()
	 * */
	private int ID;
	/**
	 * Demandeur de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see homeInsurance#getAsker()
	 * */
    private Person asker;
    /**
	 * Date de début de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see homeInsurance#getStartDate()
	 * */
    private String startDate;
    /**
	 * Résidence assurée par l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see homeInsurance#getResidency()
	 * */
	private Residency Residency;
	/**
	 *Valeur disant si l'assurance est tout risques ou pas.Cette valeur est récupérable.
	 * @since 1.0
	 * @see homeInsurance#isAllRisksCover()
	 * */
	private boolean allRisksCover;
	/**
	 * Prix de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see homeInsurance#getPrice()
	 * */
	private float price;
	
	/**
	 * Connexion à la base de données
	 * @see BDconnection#BDconnection()
	 * */
	BDconnection bdd = new BDconnection();
	
	
	/**
	 * Constructeur récupérant les informations d'une assurance 
	 * 
	 * @param IDassu
	 * 		Id de l'assurance
	 * @param login
	 * 		Login de l'utilisateur
	 * @param _residency
	 * 		Résidence assurée
	 * @since 1.0
	 * */
    public homeInsurance(int IDassu,String login,Residency _residency) {
    	ResultSet assu = bdd.getResult("SELECT * FROM HomeAssurance WHERE idHoA = '"+IDassu+"'");
    	try {
			while (assu.next()) {
				this.ID  = assu.getInt(1);
			    this.startDate = FormatDDMMYY(assu.getString(2));
			    this.allRisksCover = assu.getBoolean(5);
			    this.price = assu.getFloat(6);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	this.asker = new Person(login);
		this.Residency = _residency;
		
	}

	public int getID() {
		return ID;
	}

	public Person getAsker() {
		return asker;
	}

	public String getStartDate() {
		return startDate;
	}

	public Residency getResidency() {
		return Residency;
	}

	public boolean isAllRisksCover() {
		return allRisksCover;
	}

	public float getPrice() {
		return price;
	}
	
	/**
	 * Renvoie une date au format YYYY-MM--JJ au format JJ-MM-YYYY
	 * @param date
	 * 		Date au format YYYY-MM-JJ
	 * @return Date au format JJ-MM-YYYY
	 * */
	public String FormatDDMMYY(String date) {
		String[] tab = date.split("-");
		return String.join("-", tab[2],tab[1],tab[0]);
	}

    
}
