package Assurance;


import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;
import Gestion.Auto;
import Gestion.Person;


public class carInsurance{
	
	/**
	 * Id de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see carInsurance#getID()
	 * */
	private int ID;
	 /**
		 * Date de début de l'assurance.Cette valeur est récupérable.
		 * @since 1.0
		 * @see carInsurance#getStartDate()
		 * */
    private String startDate;
    /**
	 * Demandeur de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see carInsurance#getAsker()
	 * */
    private Person asker;
    /**
	 * Voiture assurée par l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see carInsurance#getCar()
	 * */
	private Auto car;
	/**
	 * Bonus/Malus de la voiture.
	 * @since 1.0
	 * @see carInsurance#getBonus_malus()
	 * */
    private float bonus_malus;
    /**
	 *Valeur disant si l'assurance est tout risques ou pas.Cette valeur est récupérable.
	 * @since 1.0
	 * @see carInsurance#isAllRisksCover()
	 * */
    private boolean allRisksCover;
    /**
	 * Prix de l'assurance.Cette valeur est récupérable.
	 * @since 1.0
	 * @see carInsurance#getPrice()
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
	 * @param _car
	 * 		Voiture assurée
	 * @since 1.0
	 * */
    public carInsurance(int IDassu,String login,Auto _car) {
    	ResultSet assu = bdd.getResult("SELECT * FROM VehicleAssurance WHERE idVA = '"+IDassu+"' and vehicle = '"+_car.getNumberplate()+"'");
    	try {
			while (assu.next()) {
				this.ID  = assu.getInt(1);
				this.asker = new Person(login);
				this.car = _car;
			    this.startDate = FormatDDMMYY(assu.getString(2));
			    this.bonus_malus = assu.getFloat(5);
			    this.allRisksCover = assu.getBoolean(6);
			    this.price = assu.getFloat(7);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    
    
    public int getID() {
		return ID;
	}


	public String getStartDate() {
		return startDate;
	}


	public Person getAsker() {
		return asker;
	}


	public Auto getCar() {
		return car;
	}


	public float getBonus_malus() {
		return bonus_malus;
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
   