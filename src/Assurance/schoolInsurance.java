package Assurance;

import java.util.Date;

import Gestion.Adult;
import Gestion.Child;

public class schoolInsurance extends Insurance {
	
	private Child child;
    private String school;
    
    public schoolInsurance(Adult _asker, Date _startDate, boolean _simulation, Child _child, String _school) {
		super(_asker, _startDate, _simulation);
		this.child = _child;
		this.school = _school;
	}


    
    Child getChild() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.child;
    }

    
    void setChild(Child value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.child = value;
    }

    
    String getSchool() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.school;
    }

    
    void setSchool(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.school = value;
    }

}
