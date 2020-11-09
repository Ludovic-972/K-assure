package Gestion;

import java.util.ArrayList;
import java.util.List;


public class Family {
    
    private int numberOfperson;    
    private int numberOfchildren;
    public List<Person> members = new ArrayList<Person> ();
    
    public Family(List<Person> _members) {
		this.members = _members;
		this.numberOfperson = _members.size();
		for (Person person : _members) {
			if (person instanceof Child) {
				this.numberOfchildren++;
			}
		}
	}

    
    int getNumberOfperson() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberOfperson;
    }

    
    void setNumberOfperson(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberOfperson = value;
    }
    
    int getNumberOfchildren() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberOfchildren;
    }

    
    void setNumberOfchildren(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberOfchildren = value;
    }

    
    List<Person> getMembers() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.members;
    }

    
    void setMembers(List<Person> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.members = value;
    }
    
    void addMembers(Person new_member) {
    	members.add(new_member);
    	if(new_member instanceof Child)
    		this.numberOfchildren++;
    }

}
