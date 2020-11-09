package Assurance;

import java.util.Date;

import Gestion.Person;


public abstract class Insurance {
    
    private Person asker;
    private Date startDate;
    private boolean simulation = false;

    public Insurance(Person _asker, Date _startDate, boolean _simulation) {
		this.asker = _asker;
		this.startDate = _startDate;
		this.simulation = _simulation;
	}
    
    void setAsker(Person value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.asker = value;
    }

    
    Person getAsker() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.asker;
    }

    
    Date getStartDate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.startDate;
    }

    
    void setStartDate(Date value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.startDate = value;
    }

    
    boolean isSimulation() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.simulation;
    }

    
    void setSimulation(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.simulation = value;
    }

}
