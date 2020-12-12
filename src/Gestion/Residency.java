package Gestion;

import BDgestion.BDconnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Residency {
    
    private int idResidency;
    private String type;
    private String askerType;
    private String MSR;
    private String city;
    private String zipCode;
    private String RenderUse;
    private int area;
    private int TotalArea;
    private int constructionYear;
    private boolean habitable;
    private int roof;
    private int PersonalEffectsValue;
    private int jewelryValue;
    private int numberOfRooms;
    private int numberOfRoomates;
    
    private BDconnection bdd = new BDconnection();
    
    
    public Residency() {
    	ResultSet rs = bdd.getResult("SELECT * FROM Residency");
    	try {
			while(rs.next()) {
				idResidency = rs.getInt(1);
			    type = rs.getString(2);
			    askerType = rs.getString(3);
			    MSR = rs.getString(4);
			    city = rs.getString(5);
			    zipCode = rs.getString(6);
			    RenderUse = rs.getString(7);
			    area = rs.getInt(8);
			    TotalArea = rs.getInt(9);
			    constructionYear = rs.getInt(10);
			    habitable = rs.getBoolean(11);
			    roof = rs.getInt(12);
			    PersonalEffectsValue = rs.getInt(13);
			    jewelryValue = rs.getInt(14);
			    numberOfRooms = rs.getInt(15);
			    numberOfRoomates = rs.getInt(16);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }


	public int getIdResidency() {
		return idResidency;
	}


	public void setIdResidency(int idResidency) {
		this.idResidency = idResidency;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAskerType() {
		return askerType;
	}


	public void setAskerType(String askerType) {
		this.askerType = askerType;
	}


	public String getMSR() {
		return MSR;
	}


	public void setMSR(String mSR) {
		MSR = mSR;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getRenderUse() {
		return RenderUse;
	}


	public void setRenderUse(String renderUse) {
		RenderUse = renderUse;
	}


	public int getArea() {
		return area;
	}


	public void setArea(int area) {
		this.area = area;
	}


	public int getTotalArea() {
		return TotalArea;
	}


	public void setTotalArea(int totalArea) {
		TotalArea = totalArea;
	}


	public int getConstructionYear() {
		return constructionYear;
	}


	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}


	public boolean isHabitable() {
		return habitable;
	}


	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}


	public int getRoof() {
		return roof;
	}


	public void setRoof(int roof) {
		this.roof = roof;
	}


	public int getPersonalEffectsValue() {
		return PersonalEffectsValue;
	}


	public void setPersonalEffectsValue(int personalEffectsValue) {
		PersonalEffectsValue = personalEffectsValue;
	}


	public int getJewelryValue() {
		return jewelryValue;
	}


	public void setJewelryValue(int jewelryValue) {
		this.jewelryValue = jewelryValue;
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}


	public int getNumberOfRoomates() {
		return numberOfRoomates;
	}


	public void setNumberOfRoomates(int numberOfRoomates) {
		this.numberOfRoomates = numberOfRoomates;
	}
    
    
    
}

   