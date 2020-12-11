package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

public class Person {
	
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
    private String familySituation;
    private String email; 
    private int numberOfChild;
    private String driverLicenceDate;
    private int netIncome;
    private String profession; 
    BDconnection bdd = new BDconnection();
	
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

	public String FormatDDMMYY(String date) {
    	String[] tab = date.split("-");
    	return String.join("-", tab[2],tab[1],tab[0]);
   	}
}
