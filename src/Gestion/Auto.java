package Gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BDgestion.BDconnection;

/**
 * 
 * @author Ludovic
 * @version 1.0
 *
 */
public class Auto {
    
	/**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getOwner()
	 * @see Auto#setOwner(Person)
	 */
	private Person owner;
	/**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getNumberplate()
	 * @see Auto#setNumberplate()
	 */
	private String numberplate;
	/**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getDriverLicenceDate()
	 * @see Auto#setDriverLicenceDate()
	 */
	private String driverLicenceDate;
	/**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getMake()
	 * @see Auto#setMake()
	 */
    private String make;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getModel()
	 * @see Auto#setModel()
	 */
    private String model;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getEngine()
	 * @see Auto#setEngine()
	 */
    private String engine;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getFunction()
	 * @see Auto#setFunction()
	 */
    private String function;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getBuyingYear()
	 * @see Auto#setBuyingYear()
	 */
    private String buyingYear; 
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getEnergy()
	 * @see Auto#setEnergy()
	 */
    private String energy;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getCarbodyType()
	 * @see Auto#setCarbodyType()
	 */
    private String carbodyType;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getAge()
	 * @see Auto#setAge()
	 */
    private int age;
    /**
	 * @see Auto#Auto(String, String)
	 * @see Auto#getGarage()
	 * @see Auto#setGarage()
	 */
    private String garage;
    /**
	 * @see Auto#Auto(String, String)
	 */
    private BDconnection bdd = new BDconnection();
    
    /**
     * 
     * @param _user
     * 		Nom de l'utilisateur
     * @param numberplate
     * 		Numéro de la plaque d'immatriculation
     * 
     * @see Auto#owner
     * @see Auto#numberplate
     * @see Auto#driverLicenceDate
     * @see Auto#make
     * @see Auto#model
     * @see Auto#engine
     * @see Auto#function
     * @see Auto#buyingYear
     * @see Auto#energy
     * @see Auto#age
     * @see Auto#garage
     * @see Auto#bdd
     */
    public Auto(String _user,String numberplate) {
    	ResultSet rs = bdd.getResult("SELECT * FROM Driving WHERE plateNumber = '"+numberplate+"'"
    					+ " AND driverID = (SELECT idPerson FROM Person WHERE login =  '"+_user+"')");
    	try {
			while(rs.next()) {
				this.owner = new Person(_user);
				this.numberplate = rs.getString(2);
				this.driverLicenceDate = rs.getString(3);
			    this.make = rs.getString(4);
			    this.model = rs.getString(5);
			    this.engine = rs.getString(6);
			    this.function = rs.getString(7);
			    this.buyingYear = rs.getString(8); 
			    this.energy = rs.getString(9);
			    this.age = rs.getInt(10);
			    this.garage = rs.getString(11);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * 
     * @return Le nom du propriétaire.
     * 
     * @see Person
     */
	public Person getOwner() {
		return owner;
	}

	/**
	 * 
	 * @return Le numéro de la plaque d'immatriculation.
	 */
	public String getNumberplate() {
		return numberplate;
	}

	/**
	 * 
	 * @return La date d'obtention du permis
	 */
	public String getDriverLicenceDate() {
		return driverLicenceDate;
	}

	/**
	 * 
	 * @return La marque du véhicule
	 */
	public String getMake() {
		return make;
	}

	/**
	 * 
	 * @return Le modèle du véhicule
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 
	 * @return Le nom du moteur du véhicule
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * 
	 * @return L'usage du véhicule si il est plus profesionnel ou personnel
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * 
	 * @return L'année d'achat du véhicule
	 */
	public String getBuyingYear() {
		return buyingYear;
	}

	/**
	 * 
	 * @return Le type d'énergie que le véhicule consomme
	 */
	public String getEnergy() {
		return energy;
	}

	/**
	 * 
	 * @return Le type de carosserie du véhicule
	 */
	public String getCarbodyType() {
		return carbodyType;
	}

	/**
	 * 
	 * @return L'âge du véhicule
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @return Le garage où le véhicule est garé
	 */
	public String getGarage() {
		return garage;
	}

    
}
