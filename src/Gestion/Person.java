package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

public abstract class Person {
	
	private int idPerson;
    private String name;
    private String surname;
    private String sexe;
    private String login;
    private String pwd;
    private String category;
    private String address;
    private String phoneNumber;
    private String birthdate;
    private String birthcity;
    private String city;
    private String zipCode;
    public Vehicle vehicle;
    
    private BDconnection bdd = new BDconnection();
	
	public Person(String _login) {
		
		login = _login;
    	ResultSet rs = bdd.getResult("Select * from Person where login = \""+login+"\"");
    	try {
    		while(rs.next()) {
		    	idPerson = rs.getInt(1);
		        name = rs.getString(2);
		        surname = rs.getString(3);
		        sexe = rs.getString(4);
		        pwd = rs.getString(6);
		        category = rs.getString(7);
		        address = rs.getString(8);
		        phoneNumber = rs.getString(9);
		        birthdate = FormatDDMMYY(rs.getString(10));
		        birthcity = rs.getString(11);
		        city = rs.getString(14);
		        zipCode = rs.getString(15);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
		
    	}
	}
    	
    public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthcity() {
		return birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public BDconnection getBdd() {
		return bdd;
	}

	public void setBdd(BDconnection bdd) {
		this.bdd = bdd;
	}

	public String FormatDDMMYY(String date) {
    		String[] tab = date.split("-");
    		return String.join("-", tab[2],tab[1],tab[0]);
   		}
}
