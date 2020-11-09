package Gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Vehicle {
    
    private String make;
    private String use;
    private String power;
    private Date obtainingDate; 
    private String gearboxType; 
    private String energy;
    private List<Person> drivers = new ArrayList<Person>();
    private Person owner;
    private String model;
    private String carbodyType;
    private int age;
    private int numberOfdoors;
    private String numberplate;
    private String tradeName;
    private String garage;
    
    public Vehicle(Person _owner, List<Person> _drivers, Date _obtainingDate, String _numberplate, String _make, String _model, String _energy, String _power, String _gearboxType, String _carbodyType, String _tradeName, int _age, int _numberOfdoors, String _garage, String _use) {
    	this.owner = _owner;
    	this.drivers = _drivers;
    	this.obtainingDate = _obtainingDate;
    	this.numberplate = _numberplate;
		this.make = _make;
		this.model = _model;
		this.energy = _energy;
		this.power = _power;
		this.gearboxType = _gearboxType;
		this.carbodyType = _carbodyType;
		this.tradeName = _tradeName;
		this.age = _age;
		this.numberOfdoors = _numberOfdoors;
		this.garage = _garage;
		this.use = _use;
	}

    
    String getMake() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.make;
    }

    
    void setMake(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.make = value;
    }

    
    String getUse() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.use;
    }

    
    void setUse(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.use = value;
    }
    
    String getPower() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.power;
    }

    
    void setPower(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.power = value;
    }

    
    Date getObtainingDate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.obtainingDate;
    }

    
    void setObtainingDate(Date value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.obtainingDate = value;
    }

    
    String getGearboxType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.gearboxType;
    }

    
    void setGearboxType(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.gearboxType = value;
    }

    
    String getEnergy() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.energy;
    }

    
    void setEnergy(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.energy = value;
    }
    
    void setOwner(Person value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.owner = value;
    }

    
    Person getOwner() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.owner;
    }

    
    List<Person> getDrivers() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.drivers;
    }

    
    void setDrivers(List<Person> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.drivers = value;
    }

    
    String getModel() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.model;
    }

    
    void setModel(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.model = value;
    }

    
    String getCarbodyType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.carbodyType;
    }

    
    void setCarbodyType(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.carbodyType = value;
    }

    
    int getAge() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.age;
    }

    
    void setAge(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.age = value;
    }

    
    int getNumberOfdoors() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberOfdoors;
    }

    
    void setNumberOfdoors(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberOfdoors = value;
    }

    
    String getNumberplate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberplate;
    }

    
    void setNumberplate(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberplate = value;
    }

    
    String getTradeName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.tradeName;
    }

    
    void setTradeName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.tradeName = value;
    }

    
    String getGarage() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.garage;
    }

    
    void setGarage(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.garage = value;
    }
    
    void addDrivers(Person new_driver) {
    	drivers.add(new_driver);
    }

}
