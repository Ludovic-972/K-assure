package Assurance;


public class RefundRequest {
    
    private String level;
    private String sector;
    private boolean validate;
    
    public RefundRequest(String _level, String _sector) {
		this.level = _level;
		this.sector = _sector;
	}
    
    String getLevel() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.level;
    }

    
    void setLevel(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.level = value;
    }

    
    String getSector() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.sector;
    }

    
    void setSector(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.sector = value;
    }
    
    boolean isValidate() {
    	return this.validate;
    }
    
    void setValidate(boolean value) {
    	this.validate = value;
    }

    
}
