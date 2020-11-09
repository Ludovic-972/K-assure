package Assurance;

import java.util.Date;

import Gestion.Person;
import Gestion.residency;

public class Rental extends residency {
	
	
	private Person owner;
    private int rent;

    
    
    public Rental(String _type, int _area, String _value, String _constructionYear, int _numberOfrooms,
			Date _entryDate, Person _owner, int _rent) {
    	
		super(_type, _area, _value, _constructionYear, _numberOfrooms, _entryDate);
		this.owner = _owner;
		this.rent = _rent;
	}

    int getRent() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.rent;
    }

    
    void setRent(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.rent = value;
    }

    
    void setOwner(Person value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.owner = value;
    }

    
    Person getOwner() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.owner;
    }

}
