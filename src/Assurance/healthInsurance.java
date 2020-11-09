package Assurance;

import java.util.Date;

import Gestion.Person;

public class healthInsurance extends Insurance {
    
	private Person subscriber;
    private String social_security_number;

    public healthInsurance(Person _asker, Date _startDate, boolean _simulation, Person _subscriber, String _social_security_number) {
		super(_asker, _startDate, _simulation);


		this.subscriber = _subscriber;
		this.social_security_number = _social_security_number;
	}
    
    Person getSubscriber() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.subscriber;
    }

    
    void setSubscriber(Person value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.subscriber = value;
    }

    
    String getSocial_security_number() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.social_security_number;
    }

    
    void setSocial_security_number(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.social_security_number = value;
    }

}
