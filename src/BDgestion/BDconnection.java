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
			connection = DriverManager.getConnection(url,login,pwd);
		} catch (SQLException | ClassNotFoundException e) {
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
		int a = 0;
		try {
			while (rs.next()){
				a = rs.getInt(1); //typeID is the number of rows in the ResultSet
			}
		 return a;
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
			testRequete(req);
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
		} catch (RequeteNull e1) {
			e1.printStackTrace();
		}
	}

	public ResultSet getResult(String req) {
		Statement st = null;
		ResultSet rs = null;
		try {
			testRequete(req);
			try {
				st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				//Selection 
				rs = st.executeQuery(req);
			}catch(SQLException e){
				System.out.println("Problème d'exécution de requête");
				e.printStackTrace();
			}
			
		} catch (RequeteNull e1) {
			e1.printStackTrace();
		}
		return rs;

	}
	
	public void executeQuery(String req) {
		try {
			testRequete(req);
			Statement st = null;
			try {
				st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				st.executeUpdate(req);
			}catch(SQLException e){
				System.out.println("Problème d'exécution de requête .");
				e.printStackTrace();
			}
		} catch (RequeteNull e1) {
			e1.printStackTrace();
		}
	}

	public void testRequete(String s)throws RequeteNull {
		if(s.equals(null))
			throw new RequeteNull("Requete nulle.");
	}
}
