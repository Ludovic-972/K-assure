package Assurance;

import java.util.Date;

import Gestion.Adult;
import Gestion.Residency;

public class homeInsurance extends Insurance {
    
	
	private Residency Residency;
	
    public homeInsurance(Adult _asker, Date _startDate, boolean _simulation, Gestion.Residency _Residency) {
		super(_asker, _startDate, _simulation);

		this.Residency = _Residency;
	}


    
    Residency getResidency() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Residency;
    }

    
    void setResidency(Residency value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Residency = value;
    }

}
