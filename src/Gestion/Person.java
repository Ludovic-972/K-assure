package Gestion;

import java.util.Date;


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
    private Date birthdate;
    private String birthcity;
    private String familySituation;
    private String email; 
    private String city;
    private String zipCode;
    private int numberOfChild;
    private Date driverLicenceDate;
    private int netIncome;
    private String profession;
    
    
    public Person(String login) {
    	
    }

    
    
    public int getIdPerson() {
		return idPerson;
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


	public int getNumberOfChild() {
		return numberOfChild;
	}


	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}


	public Date getDriverLicenceDate() {
		return driverLicenceDate;
	}


	public void setDriverLicenceDate(Date driverLicenceDate) {
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

	
    String getSurname() {
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

	public String getBirthcity() {
		return birthcity;
	}


	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

}
