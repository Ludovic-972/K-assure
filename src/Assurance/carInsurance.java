package Assurance;


import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;
import Gestion.Auto;
import Gestion.Person;


public class carInsurance{
	
	private int ID;
    private String startDate;
    private Person asker;
	private Auto car;
    private float bonus_malus;
    private boolean allRisksCover;
    private float price;
    
    BDconnection bdd = new BDconnection();
    
    public carInsurance(int IDassu,String _asker,Auto _car) {
    	ResultSet assu = bdd.getResult("SELECT * FROM VehicleAssurance WHERE idVA = '"+IDassu+"' and vehicle = '"+_car.getNumberplate()+"'");
    	try {
			while (assu.next()) {
				this.ID  = assu.getInt(1);
				this.asker = new Person(_asker);
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


	public void setID(int iD) {
		ID = iD;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public Person getAsker() {
		return asker;
	}


	public void setAsker(Person asker) {
		this.asker = asker;
	}


	public Auto getCar() {
		return car;
	}


	public void setCar(Auto car) {
		this.car = car;
	}


	public float getBonus_malus() {
		return bonus_malus;
	}


	public void setBonus_malus(float bonus_malus) {
		this.bonus_malus = bonus_malus;
	}


	public boolean isAllRisksCover() {
		return allRisksCover;
	}


	public void setAllRisksCover(boolean allRisksCover) {
		this.allRisksCover = allRisksCover;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String FormatDDMMYY(String date) {
		String[] tab = date.split("-");
		return String.join("-", tab[2],tab[1],tab[0]);
	}

    
}
   