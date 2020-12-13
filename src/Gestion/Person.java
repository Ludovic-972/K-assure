package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

/**
 * 
 * @author Ludovic
 * @version 1.0
 */
public class Person {
	
	/**
	 * @see Person#Person(String)
	 * @see Person#getIdPerson()
	 * @see Person#setIdPerson(int)
	 */
	private int idPerson;
	/**
	 * @see Person#Person(String)
	 * @see Person#getName()
	 * @see Person#setName(String)
	 */
    private String name;
    /**
     * @see Person#Person(String)
     * @see Person#getSurname()
     * @see Person#setSurname(String)
     */
    private String surname;
    /**
     * @see Person#Person(String)
     * @see Person#getSexe()
     * @see Person#setSexe(String)
     */
    private String sexe;
    /**
     * @see Person#Person(String)
     * @see Person#getLogin()
     * @see Person#setLogin(String)
     */
    private String login;
    /**
     * @see Person#Person(String)
     * @see Person#getPwd()
     * @see Person#setPwd(String)
     */
    private String pwd;
    /**
     * @see Person#Person(String)
     * @see Person#getCategory()
     * @see Person#setCategory(String)
     */
    private String category;
    /**
     * @see Person#Person(String)
     * @see Person#getAddress()
     * @see Person#setAddress(String)
     */
    private String address;
    /**
     * @see Person#Person(String)
     * @see Person#getPhoneNumber()
     * @see Person#setPhoneNumber(String)
     */
    private String phoneNumber;
    /**
     * @see Person#Person(String)
     * @see Person#getBirthdate()
     * @see Person#setBirthdate(String)
     */
    private String birthdate;
    /**
     * @see Person#Person(String)
     * @see Person#getBirthcity()
     * @see Person#setBirthcity(String)
     */
    private String birthcity;
    /**
     * @see Person#Person(String)
     * @see Person#getCity()
     * @see Person#setCity(String)
     */
    private String city;
    /**
     * @see Person#Person(String)
     * @see Person#getZipCode()
     * @see Person#setZipCode(String)
     */
    private String zipCode;
    /**
     * @see Person#Person(String)
     * @see Person#getFamilySituation()
     * @see Person#setFamilySituation(String)
     */
    private String familySituation;
    /**
     * @see Person#Person(String)
     * @see Person#getEmail()
     * @see Person#setEmail(String)
     */
    private String email; 
    /**
     * @see Person#Person(String)
     * @see Person#getNumberOfChild()
     * @see Person#setNumberOfChild(int)
     */
    private int numberOfChild;
    /**
     * @see Person#Person(String)
     * @see Person#getDriverLicenceDate()
     * @see Person#setDriverLicenceDate(String)
     */
    private String driverLicenceDate;
    /**
     * @see Person#Person(String)
     * @see Person#getNetIncome()
     * @see Person#setNetIncome(int)
     */
    private int netIncome;
    /**
     * @see Person#Person(String)
     * @see Person#getProfession()
     * @see Person#setProfession(String)
     */
    private String profession; 
    /**
     * @see Person#Person(String)
     */
    BDconnection bdd = new BDconnection();
	
    /**
     * 
     * @param _login
     * 		Identifiant de l'utilisateur
     * 
     * @see Person#idPerson
     * @see Person#name
     * @see Person#surname
     * @see Person#sexe
     * @see Person#pwd
     * @see Person#category
     * @see Person#address
     * @see Person#phoneNumber
     * @see Person#birthdate
     * @see Person#birthcity
     * @see Person#city
     * @see Person#zipCode
     * @see Person#familySituation
     * @see Person#email
     * @see Person#numberOfChild
     * @see Person#netIncome
     * @see Person#profession
     * @see Person#bdd
     */
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
		
    	}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    	
	/**
	 * 
	 * @return Un identifiant généré correspondant à un utilisateur
	 */
    public int getIdPerson() {
		return idPerson;
	}

	/**
	 * 
	 * @return Le prénom de l'utilisateur
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Le nom de famille de l'utilisateur
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * 
	 * @return Le sexe de l'utilisateur
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * 
	 * @return L'identifiant de connexion
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * 
	 * @return Le mot de passe de l'utilisateur
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * 
	 * @return Si l'utilisateur est un enfant ou un adulte
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * @return L'adresse de l'utilisateur
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @return Le numéro de téléphone de l'utilisateur
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @return La date de naissance de l'utilisateur
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * 
	 * @return Le ville de naissance de l'utilisateur
	 */
	public String getBirthcity() {
		return birthcity;
	}

	/**
	 * 
	 * @return La ville de résidence de l'utilisateur
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return Le code postal de l'utilisateur
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * 
	 * @return La situation familiale de l'utilisateur (Marié, célibataire, ...)
	 */
	public String getFamilySituation() {
		return familySituation;
	}
	
	/**
	 * 
	 * @return L'adresse mail de l'utilisateur
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return Le nombre d'enfant de l'utilisateur
	 */
	public int getNumberOfChild() {
		return numberOfChild;
	}

	/**
	 * 
	 * @return La date d'obtention du permis
	 */
	public String getDriverLicenceDate() {
		return driverLicenceDate;
	}
	
	/**
	 * 
	 * @return Le revenu de l'utilisateur
	 */
	public int getNetIncome() {
		return netIncome;
	}
	
	/**
	 * 
	 * @return La profession de l'utilisateur
	 */
	public String getProfession() {
		return profession;
	}
	
	/**
	 * 
	 * @param date
	 * 		Entrée d'une date
	 * @return La date au bon format
	 */
	public String FormatDDMMYY(String date) {
    	String[] tab = date.split("-");
    	return String.join("-", tab[2],tab[1],tab[0]);
   	}
}
