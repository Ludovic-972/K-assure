package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

public class Child {

	private int idPerson;
    private String name;
    private String surname;
    private String sexe;
    private String login;
    private String pwd;
    private String category;
    private String address;
    private String birthdate;
    private String birthcity;
    private String city;
    private String zipCode;
    private int numberOfChild;
	private String parent1;
    private String parent2;
    private BDconnection bdd = new BDconnection();
    
    
    public Child(String _login) {
    	
		login = _login;
		ResultSet rs = bdd.getResult("Select loginparent1,loginparent2 from Person where login = \""+_login+"\"");
		try {
			while (rs.next()) {
				parent1 = rs.getString(1);
				parent2 = rs.getString(2);
				
			}
		rs.close();
		ResultSet rs2 = bdd.getResult("Select * from Person where login = \""+login+"\"");
		try {
			while(rs2.next()) {
		    	idPerson = rs.getInt(1);
		        name = rs.getString(2);
		        surname = rs.getString(3);
		        sexe = rs.getString(4);
		        pwd = rs.getString(6);
		        category = rs.getString(7);
		        address = rs.getString(8);
		        birthdate = FormatDDMMYY(rs.getString(10));
		        birthcity = rs.getString(11);
		        city = rs.getString(14);
		        zipCode = rs.getString(15);
		        numberOfChild = rs.getInt(16);
			}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    
    public String FormatDDMMYY(String date) {
		String[] tab = date.split("-");
		return String.join("-", tab[2],tab[1],tab[0]);
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

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}

	public BDconnection getBdd() {
		return bdd;
	}

	public void setBdd(BDconnection bdd) {
		this.bdd = bdd;
	}

	String getParent1() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.parent1;
    }
    void setParent1(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.parent1 = value;
    }
    
    String getParent2() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.parent2;
    }
    
    void setParent2(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.parent2 = value;
    }

}
