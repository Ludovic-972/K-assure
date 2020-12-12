package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

public class Child extends Person{


	private String parent1;
    private String parent2;
    private BDconnection bdd = new BDconnection();
    
    
    public Child(String _login) {
    	super(_login);
    	
		ResultSet rs = bdd.getResult("Select loginparent1,loginparent2 from Person where login = \""+_login+"\"");
		try {
			while (rs.next()) {
				parent1 = rs.getString(1);
				parent2 = rs.getString(2);
				
			}
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    

	String getParent1() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.parent1;
    }
    void setParent1(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.parent1 = value;
    }
    
    String getParent2() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.parent2;
    }
    
    void setParent2(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.parent2 = value;
    }

}
