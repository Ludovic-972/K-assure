package Assurance;

public class Refund extends RefundRequest {

	private int amount;
	
    public Refund(String _level, String _sector, int _amount) {
		super(_level, _sector);

		this.amount = _amount;
	}


    
    void setAmount(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.amount = value;
    }

    
    int getAmount() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.amount;
    }

}
