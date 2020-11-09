package BDgestion;
import java.sql.*;

public class BDconnection{
	
	private Connection connection;
	
	public BDconnection() {
		String nom_driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://mysql-mathurin.alwaysdata.net:3306/mathurin_k_assure"  // Lien vers la base de données
				+ "?serverTimezone=UTC"; // Fuseau horaire (UTC = Universal Time Coordinated)
		String login = "mathurin";
		String pwd = "85#Rc$4wM";
		connection = null;
		try {
			/* Connexion avec la base */
			Class.forName(nom_driver);
			System.out.println("Driver is Loaded");
			connection = DriverManager.getConnection(url,login,pwd);
			System.out.println("Database has connected");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Driver introuvable."); 	
		} catch (SQLException e) {
			System.out.println("Connexion to the database denied."); 
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void close() {
		try {
			connection.close();
		}catch(SQLException e) {
			
		}
	}
	
	public int getRowCount(ResultSet rs) {
		int nombreLignes = 0;
		try {
			rs.last(); 
			nombreLignes = rs.getRow(); 
			rs.beforeFirst();
			return nombreLignes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int getColomnCount(ResultSet rs) {
		try {
			return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	public void affiche(String req) {
		try {
			Statement st = connection.createStatement();
			System.out.println("Statement created.");
			
			//Selection 
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				   for (int i = 1; i <= getColomnCount(rs); i++) {
					   String a = rs.getString(i);
					   System.out.print(a+" | ");
				   }
				   System.out.println();
				}
		} catch (SQLException e) {
			System.out.println("Problème d'affichage.");
		}
	}
	
	
}
