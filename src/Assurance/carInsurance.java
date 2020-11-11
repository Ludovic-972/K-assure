package Assurance;

import java.util.Date;

import Gestion.Adult;
import Gestion.Vehicle;


public class carInsurance extends Insurance {

	private Vehicle car;
    private int mileage;
    private String periodOfuse;
    private boolean insuredInLast3Years;
    private float bonus_malus;
    private boolean allRisksCover;
    
    public carInsurance(Adult _asker, Date _startDate, boolean _simulation, Vehicle _car, int _mileage, String _periodOfuse, boolean _insuredInLast3Years, float _bonus_malus, boolean _allRisksCover) {
    	
		super(_asker, _startDate, _simulation);


		this.car = _car;
		this.mileage = _mileage;
		this.periodOfuse = _periodOfuse;
		this.insuredInLast3Years = _insuredInLast3Years;
		this.bonus_malus = _bonus_malus;
		this.allRisksCover = _allRisksCover;
	}

    Vehicle getCar() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.car;
    }


    void setCar(Vehicle value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.car = value;
    }


    int getMileage() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mileage;
    }


    void setMileage(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.mileage = value;
    }


    String getPeriodOfuse() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.periodOfuse;
    }


    void setPeriodOfuse(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.periodOfuse = value;
    }

    boolean isInsuredInLast3Years() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.insuredInLast3Years;
    }


    void setInsuredInLast3Years(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.insuredInLast3Years = value;
    }


    float getBonus_malus() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.bonus_malus;
    }


    void setBonus_malus(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.bonus_malus = value;
    }


    boolean isAllRisksCover() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.allRisksCover;
    }


    void setAllRisksCover(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.allRisksCover = value;
    }

}
