package Gestion;


public class Child extends Person {


	private String parent1;
    private String parent2;
    
    public Child(String _login) {
    	
		super(_login);
		
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
