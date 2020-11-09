package Gestion;

import java.util.Date;

public class Child extends Person {


	private Person parent1;
    private Person parent2;
    
    public Child(String _name, String _surname, String _gender, Date _birthdate, String _email, String _phoneNumber,
			String _address, String _zipCode, String _city, String _familySituation, Person _parent1, Person _parent2, String _birthcity) {
    	
		super(_name, _surname, _gender, _birthdate, _email, _phoneNumber, _address, _zipCode, _city, _familySituation, _birthcity);

		this.parent1 = _parent1;
		this.parent2 = _parent2;
	}

    
    Person getParent1() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.parent1;
    }

    
    void setParent1(Person value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.parent1 = value;
    }

    
    Person getParent2() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.parent2;
    }

    
    void setParent2(Person value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.parent2 = value;
    }

}
