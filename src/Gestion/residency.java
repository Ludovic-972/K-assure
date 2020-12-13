package Gestion;

import BDgestion.BDconnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Ludovic
 * @version 1.0
 */
public class Residency {
    
	/**
	 * @see Residency#Residency(int, String)
	 * @see Residency#getIdResidency()
	 */
    private int idResidency;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getResident()
     */
    private Person Resident;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getType()
     */
    private String type;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getAskerType()
     */
    private String askerType;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getMSR()
     */
    private String MSR;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getRent()
     */
    private int rent;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getCity()
     */
    private String city;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getZipCode()
     */
    private String zipCode;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getRenderUse()
     */
    private String RenderUse;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getArea()
     */
    private int area;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getTotalArea()
     */
    private int TotalArea;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getConstructionYear()
     */
    private int constructionYear;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#isHabitable()
     */
    private boolean habitable;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getRoof()
     */
    private int roof;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getPersonalEffectsValue()
     */
    private int PersonalEffectsValue;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getJewelryValue()
     */
    private int jewelryValue;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getNumberOfRooms()
     */
    private int numberOfRooms;
    /**
     * @see Residency#Residency(int, String)
     * @see Residency#getNumberOfRoomates()
     */
    private int numberOfRoomates;
    
    /**
     * @see Residency#Residency(int, String)
     */
    private BDconnection bdd = new BDconnection();
    
    
    /**
     * 
     * @param ID
     * 		Identifiant de la résidence
     * @param _user
     * 		Nom de l'utilisateur
     * 
     * @see Residency#idResidency
     * @see Residency#Resident
     * @see Residency#type
     * @see Residency#askerType
     * @see Residency#MSR
     * @see Residency#rent
     * @see Residency#city
     * @see Residency#zipCode
     * @see Residency#RenderUse
     * @see Residency#area
     * @see Residency#TotalArea
     * @see Residency#constructionYear
     * @see Residency#habitable
     * @see Residency#roof
     * @see Residency#PersonalEffectsValue
     * @see Residency#jewelryValue
     * @see Residency#numberOfRooms
     * @see Residency#numberOfRoomates
     */
    public Residency(int ID,String _user) {
    	ResultSet rs = bdd.getResult("SELECT * FROM Residency WHERE idResidency ='"+ID+"'"
    			+ "AND idResident = (SELECT idPerson FROM Person WHERE login ='"+_user+"')");
    	try {
			while(rs.next()) {
				idResidency = rs.getInt(1);
				Resident = new Person(_user);
			    type = rs.getString(3);
			    askerType = rs.getString(4);
			    MSR = rs.getString(5);
			    rent = rs.getInt(6);
			    city = rs.getString(7);
			    zipCode = rs.getString(8);
			    RenderUse = rs.getString(9);
			    area = rs.getInt(10);
			    TotalArea = rs.getInt(11);
			    constructionYear = rs.getInt(12);
			    habitable = rs.getBoolean(13);
			    roof = rs.getInt(14);
			    PersonalEffectsValue = rs.getInt(15);
			    jewelryValue = rs.getInt(16);
			    numberOfRooms = rs.getInt(17);
			    numberOfRoomates = rs.getInt(18);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }


    /**
     * 
     * @return L'identifiant de la résidence
     */
	public int getIdResidency() {
		return idResidency;
	}

	/**
	 * 
	 * @return Le type de résidence
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return Le type de résident (Propriétaire, Locataire, Collocataire)
	 */
	public String getAskerType() {
		return askerType;
	}

	/**
	 * 
	 * @return Si la résidence est la principale, secondaire ou une location
	 */
	public String getMSR() {
		return MSR;
	}

	/**
	 * 
	 * @return La ville où se trouve la résidence
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return Le code postal de la résidence
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * 
	 * @return L'utilité de la résidence (Gîte, habitation personnelle, ...)
	 */
	public String getRenderUse() {
		return RenderUse;
	}

	/**
	 * 
	 * @return La surface habitable de la résidence
	 */
	public int getArea() {
		return area;
	}

	/**
	 * 
	 * @return La surface totale de la résidence
	 */
	public int getTotalArea() {
		return TotalArea;
	}

	/**
	 * 
	 * @return L'année de construction de la résidence
	 */
	public int getConstructionYear() {
		return constructionYear;
	}

	/**
	 * 
	 * @return Si la résidence est habitable ou non
	 */
	public boolean isHabitable() {
		return habitable;
	}

	/**
	 * 
	 * @return L'étage où se situe la résidence
	 */
	public int getRoof() {
		return roof;
	}

	/**
	 * 
	 * @return La valeur des effets personnels dans la résidence
	 */
	public int getPersonalEffectsValue() {
		return PersonalEffectsValue;
	}

	/**
	 * 
	 * @return La valeur des bijoux dans la résidence
	 */
	public int getJewelryValue() {
		return jewelryValue;
	}

	/**
	 * 
	 * @return Le nombre de chambre dans la résidence
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * 
	 * @return Le nombre de personnes habitant dans la résidence
	 */
	public int getNumberOfRoomates() {
		return numberOfRoomates;
	}

	/**
	 * 
	 * @return La ou les personne qui habite dans la résidence
	 */
	public Person getResident() {
		return Resident;
	}

	/**
	 * 
	 * @return Le prix de la location de la résidence
	 */
	public int getRent() {
		return rent;
	}

    
}

   