package Gestion;

import java.util.Date;



public abstract class residency {
    
    private String value;
    private String type;
    private int area;
    private int numberOfrooms;
    private Date entryDate;
    private String constructionYear;
    
    public residency(String _type, int _area, String _value, String _constructionYear, int _numberOfrooms, Date _entryDate) {
    	this.type = _type;
    	this.area = _area;
    	this.value = _value;
    	this.constructionYear = _constructionYear;
    	this.numberOfrooms = _numberOfrooms;
    	this.entryDate = _entryDate;
    }
    
    


    
    void setNumberOfrooms(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.numberOfrooms = value;
    }

    
    int getNumberOfrooms() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numberOfrooms;
    }
    
    void setType(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.type = value;
    }

    
    String getType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.type;
    }

    
    void setArea(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.area = value;
    }

    
    int getArea() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.area;
    }

    
    String getValue() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.value;
    }

    
    void setValue(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.value = value;
    }

    
    Date getEntryDate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.entryDate;
    }

    
    void setEntryDate(Date value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.entryDate = value;
    }

    
    String getConstructionYear() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.constructionYear;
    }

    
    void setConstructionYear(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.constructionYear = value;
    }

}
