package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;
public class Auto {
    
	private Person owner;
	private String numberplate;
	private String driverLicenceDate;
    private String make;
    private String model;
    private String engine;
    private String function;
    private String buyingYear; 
    private String energy;
    private String carbodyType;
    private int age;
    private String garage;
    private BDconnection bdd = new BDconnection();
    
    public Auto(Person _user,String numberplate) {
    	ResultSet rs = bdd.getResult("SELECT * FROM Driving WHERE plateNumber = '"+numberplate+"'"
    					+ " AND driverID = (SELECT idPerson FROM Person WHERE login =  '"+_user.getLogin()+"')");
    	try {
			while(rs.next()) {
				this.owner = _user;
				this.numberplate = rs.getString(2);
				this.driverLicenceDate = rs.getString(3);
			    this.make = rs.getString(4);
			    this.model = rs.getString(5);
			    this.engine = rs.getString(6);
			    this.function = rs.getString(7);
			    this.buyingYear = rs.getString(8); 
			    this.energy = rs.getString(9);
			    this.age = rs.getInt(10);
			    this.garage = rs.getString(11);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public BDconnection getBdd() {
		return bdd;
	}

	public String getNumberplate() {
		return numberplate;
	}

	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
	}

	public String getDriverLicenceDate() {
		return driverLicenceDate;
	}

	public void setDriverLicenceDate(String driverLicenceDate) {
		this.driverLicenceDate = driverLicenceDate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getBuyingYear() {
		return buyingYear;
	}

	public void setBuyingYear(String buyingYear) {
		this.buyingYear = buyingYear;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getCarbodyType() {
		return carbodyType;
	}

	public void setCarbodyType(String carbodyType) {
		this.carbodyType = carbodyType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

    
}
