package Gestion;

import java.util.Date;


public class Adult extends Person {
    
	private int numberOfchild;
    private Date driverLicence_date;
    private int netIncome;
    private String profession;
    public Vehicle vehicle;
    
    public Adult(String _name, String _surname, String _gender, Date _birthdate, String _email, String _phoneNumber,
			String _address, String _zipCode, String _city, String _familySituation, Vehicle _vehicle, int _numberOfchild, 
			Date _driverLicence_date, int _netIncome, String _profession, Object _birthcity) {
    	
    	
		super(_name, _surname, _gender, _birthdate, _email, _phoneNumber, _address, _zipCode, _city, _familySituation, _profession);
		
		this.numberOfchild = _numberOfchild;
		this.driverLicence_date = _driverLicence_date;
		this.netIncome = _netIncome;
		this.profession = _profession;
		this.vehicle = _vehicle;
	}
    
    


    int getNumberOfchild() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberOfchild;
    }


    void setNumberOfchild(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberOfchild = value;
    }


    Date getDriverLicence_date() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.driverLicence_date;
    }


    void setDriverLicence_date(Date value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.driverLicence_date = value;
    }


    int getNetIncome() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.netIncome;
    }


    void setNetIncome(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.netIncome = value;
    }


    String getProfession() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.profession;
    }


    void setProfession(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.profession = value;
    }

}
