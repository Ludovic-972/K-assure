package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

public class Adult extends Person{
    
	
    private String phoneNumber;
    private String familySituation;
    private String email; 
    private int numberOfChild;
    private String driverLicenceDate;
    private int netIncome;
    private String profession;
    private Vehicle vehicle;
    
    private BDconnection bdd = new BDconnection();
    
    public Adult(String _login) {
    	super(_login);
    	
    	ResultSet rs = bdd.getResult("Select * from Person where login = \""+_login+"\"");
    	try {
    		while(rs.next()) {
		        familySituation = rs.getString(12);
		        email = rs.getString(13); 
		        numberOfChild = rs.getInt(16);
		        netIncome = rs.getInt(17);
		        profession = rs.getString(18);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public String FormatDDMMYY(String date) {
		String[] tab = date.split("-");
		return String.join("-", tab[2],tab[1],tab[0]);
	}
    


	public String getPhoneNumber() {
		return phoneNumber;
	}
	

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	



	public String getFamilySituation() {
		return familySituation;
	}
	

	public void setFamilySituation(String familySituation) {
		this.familySituation = familySituation;
	}
	

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	


	public int getNumberOfChild() {
		return numberOfChild;
	}
	

	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}
	

	public String getDriverLicenceDate() {
		return driverLicenceDate;
	}
	

	public void setDriverLicenceDate(String driverLicenceDate) {
		this.driverLicenceDate = driverLicenceDate;
	}
	

	public int getNetIncome() {
		return netIncome;
	}
	

	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}
	

	public String getProfession() {
		return profession;
	}
	

	public void setProfession(String profession) {
		this.profession = profession;
	}
	

	public Vehicle getVehicle() {
		return vehicle;
	}
	

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	


}
