package Assurance;

import java.util.Date;

import Gestion.Person;
import Gestion.residency;

public class homeInsurance extends Insurance {
    
	
	private residency residency;
	
    public homeInsurance(Person _asker, Date _startDate, boolean _simulation, Gestion.residency _residency) {
		super(_asker, _startDate, _simulation);

		this.residency = _residency;
	}


    
    residency getResidency() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.residency;
    }

    
    void setResidency(residency value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.residency = value;
    }

}
