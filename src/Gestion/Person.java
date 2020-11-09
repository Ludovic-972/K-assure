package Gestion;

import java.util.Date;


public abstract class Person {
    
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private Date birthdate;
    private String familySituation;
    private String email; 
    private String city;
    private String zipCode;
    private String gender;
    private String birthcity;
    
    
    public Person(String _name, String _surname,String _gender, Date _birthdate, String _email, String _phoneNumber, String _address, String _zipCode, String _city, String _familySituation, String _birthcity) {
    	this.name = _name;
    	this.surname = _surname;
    	this.address = _address;
    	this.phoneNumber = _phoneNumber;
    	this.birthdate = _birthdate;
    	this.familySituation = _familySituation;
    	this.email = _email;
    	this.city = _city;
    	this.zipCode = _zipCode;
    	this.gender = _gender;
    	this.birthcity = _birthcity;
    }

    
    String getSurname() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.surname;
    }

    
    void setSurname(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.surname = value;
    }

    
    String getAddress() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.address;
    }

    
    void setAddress(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.address = value;
    }

    
    String getName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.name;
    }

    
    void setName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.name = value;
    }

    
    String getPhoneNumber() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.phoneNumber;
    }

    
    void setPhoneNumber(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.phoneNumber = value;
    }

    
    Date getBirthdate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.birthdate;
    }

    
    void setBirthdate(Date value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.birthdate = value;
    }

    
    String getFamilySituation() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.familySituation;
    }

    
    void setFamilySituation(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.familySituation = value;
    }

    
    String getEmail() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.email;
    }

    
    void setEmail(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.email = value;
    }

    
    String getCity() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.city;
    }

    
    void setCity(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.city = value;
    }

    
    String getZipCode() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.zipCode;
    }

    
    void setZipCode(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.zipCode = value;
    }

    
    String getGender() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.gender;
    }

    
    void setGender(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.gender = value;
    }


	public String getBirthcity() {
		return birthcity;
	}


	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

}
