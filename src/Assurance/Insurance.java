package Assurance;

import java.util.Date;

import Gestion.Adult;


public abstract class Insurance {
    
    private Adult asker;
    private Date startDate;
    private boolean simulation = false;

    public Insurance(Adult _asker, Date _startDate, boolean _simulation) {
		this.asker = _asker;
		this.startDate = _startDate;
		this.simulation = _simulation;
	}
    
    void setAsker(Adult value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.asker = value;
    }

    
    Adult getAsker() {
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
