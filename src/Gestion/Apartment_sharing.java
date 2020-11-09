package Gestion;

import java.util.Date;

import Assurance.Rental;

public class Apartment_sharing extends Rental {

	private int numberOfroomate;
    private float part_per_person;
    
    public Apartment_sharing(String _type, int _area, String _value, String _constructionYear, int _numberOfrooms,
			Date _entryDate, Person _owner,int _rent, int _numberOfroomate, float _part_per_person) {
		super(_type, _area, _value, _constructionYear, _numberOfrooms, _entryDate, _owner, _rent);

		this.numberOfroomate = _numberOfroomate;
		this.part_per_person = _part_per_person;
	}


    int getNumberOfroomate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberOfroomate;
    }


    void setNumberOfroomate(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberOfroomate = value;
    }


    float getPart_per_person() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.part_per_person;
    }


    void setPart_per_person(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.part_per_person = value;
    }

}
