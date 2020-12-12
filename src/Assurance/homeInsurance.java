package Assurance;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;
import Gestion.Person;
import Gestion.Residency;

public class homeInsurance{
    
	private int ID;
    private Person asker;
    private String startDate;
	private Residency Residency;
	private boolean allRisksCover;
	private float price;
	
	BDconnection bdd = new BDconnection();
	
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

	public void setID(int iD) {
		ID = iD;
	}

	public Person getAsker() {
		return asker;
	}

	public void setAsker(Person asker) {
		this.asker = asker;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Residency getResidency() {
		return Residency;
	}

	public void setResidency(Residency residency) {
		Residency = residency;
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
