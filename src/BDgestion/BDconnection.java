package BDgestion;
import java.sql.*;

/**
 * <b>BDconnection est la classe utilisée pour créer une connexion à la base de données</b>
 * <p>
 * Elle contient une instance de la classe Connection qui réalise 
 * la connexion et l'authentification à la base de données. 
 * </p>
 * <p>
 * De plus cette classe permet d'envoyer les reqûetes SQL à la base de données 
 * pour les exécuter et occasionnellement renvoyer les données dans un ResultSet.
 * </p>
 * @author Ludovic Mathurin-Cayol
 * @version 2.0
 * */

public class BDconnection{
	
	/**
	 * 
	 * */
	private Connection connection;
	
	/**
	 * Constructeur de la connexion à la base de données
	 * <p>
	 *A la construction d'un objet BDconnection une connexion et une authentification
	 *à la base de données est créée par le biais d'une instance de la classe Connection. 
	 *</p>
	 *<p>
	 *La connexion se fait d'abord par le chargement du pilote JDBC puis
	 *par une instance de la classe Driver et enfin l'authentification 
	 *à la base grâce à l'url de celle-ci,le login de l'utilisateur et son mot de passe.
	 *</p>
	 *
	 *
	 *@see BDconnection#connection 
	 *
	 *@since 1.0
	 * */
	public BDconnection() {
		String nom_driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://mysql-mathurin.alwaysdata.net:3306/mathurin_k_assure"  // Lien vers la base de données
				+ "?serverTimezone=UTC"; // Fuseau horaire (UTC = Universal Time Coordinated)
		String login = "mathurin";
		String pwd = "85#Rc$4wM";
		this.connection = null;
		try {
			/* Connexion avec la base */
			Class.forName(nom_driver); // Chargement du pilote JDBC + instance de la classe Driver
			this.connection = DriverManager.getConnection(url,login,pwd);  // Connexion à la base de données
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connexion to the database denied."); 
		}
		
	}
	
	/**
	 *Retourne le nombre de lignes d'un ResultSet
	 *
	 *@param rs : 
	 *		Instance de ResultSet traité
	 *
	 *@return Le nombre de ligne de rs 
	 *
	 *@since 1.0
	 * 
	 */
	public int getRowCount(ResultSet rs) {
		int a = 0;
		try {
			while (rs.next()){
				a++;
			}
		 return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 *Retourne le nombre de colonnes d'un ResultSet
	 *
	 *@param rs : 
	 *		Instance de ResultSet traité
	 *
	 *@return Le nombre de colonne de rs 
	 *
	 *@since 1.0
	 * 
	 */
	public int getColomnCount(ResultSet rs) {
		try {
			return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	/**
	 *<p>
	 *Retourne un ResultSet contenant les données renvoyées
	 *par la bases de données grâce à une requête SQL de type <i>SELECTs</i>.
	 *Le ResultSet a deux arguments:
	 *</p>
	 *<ul>
	 *	<li> TYPE_SCROLL_INSENSITIVE : ResultSet insensible aux modifications des valeurs dans la base de données.
	 *								   Vue statique des données du ResultSet.
	 *	<li> CONCUR_READ_ONLY: Indique que les données du ResultSet ne peuvent qu'être lues;
	 *</ul>
	 *
	 *
	 *@param req :Requête SQL envoyé à la base de donnée grâce à un Statement.
	 *
	 *@return Les données d'une requête SQL
	 *
	 *@since 1.0
	 */
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
	
	
	/**
	 * <p>
	 * Exécute la requête demandée généralement utilisée pour les <i>INSERTs</i> ou les <i>UPDATEs</i>.
	 * Le ResultSet défini dans la création du Statement a deux arguments:
	 *</p>
	 *<ul>
	 *	<li> TYPE_SCROLL_INSENSITIVE : ResultSet insensible aux modifications des valeurs dans la base de données.
	 *								   Vue statique des données du ResultSet.
	 *	<li> CONCUR_READ_ONLY: Indique que les données du ResultSet ne peuvent qu'être lues;
	 *</ul>
	 * 
	 * @param req: Requête SQL envoyé à la base de donnée grâce à un Statement.
	 * 
	 * @since 1.0
	 * 
	 * */
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
	
	/**
	 * Teste si une requête est null
	 * 
	 * @param s: requête SQL dont la valeur sera évalué
	 * 
	 * @see RequeteNull
	 * @since 2.0
	 * @throws RequeteNull si la requête en paramètre est null
	 * */
	public void testRequete(String s)throws RequeteNull {
		if(s.equals(null))
			throw new RequeteNull("Requete nulle.");
	}
}
