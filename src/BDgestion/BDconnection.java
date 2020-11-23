package BDgestion;
import java.sql.*;

/**
 * <b>BDconnection est la classe utilis�e pour cr�er une connexion � la base de donn�es</b>
 * <p>
 * Elle contient une instance de la classe Connection qui r�alise 
 * la connexion et l'authentification � la base de donn�es. 
 * </p>
 * <p>
 * De plus cette classe permet d'envoyer les req�etes SQL � la base de donn�es 
 * pour les ex�cuter et occasionnellement renvoyer les donn�es dans un ResultSet.
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
	 * Constructeur de la connexion � la base de donn�es
	 * <p>
	 *A la construction d'un objet BDconnection une connexion et une authentification
	 *� la base de donn�es est cr��e par le biais d'une instance de la classe Connection. 
	 *</p>
	 *<p>
	 *La connexion se fait d'abord par le chargement du pilote JDBC puis
	 *par une instance de la classe Driver et enfin l'authentification 
	 *� la base gr�ce � l'url de celle-ci,le login de l'utilisateur et son mot de passe.
	 *</p>
	 *
	 *
	 *@see BDconnection#connection 
	 *
	 *@since 1.0
	 * */
	public BDconnection() {
		String nom_driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://mysql-mathurin.alwaysdata.net:3306/mathurin_k_assure"  // Lien vers la base de donn�es
				+ "?serverTimezone=UTC"; // Fuseau horaire (UTC = Universal Time Coordinated)
		String login = "mathurin";
		String pwd = "85#Rc$4wM";
		this.connection = null;
		try {
			/* Connexion avec la base */
			Class.forName(nom_driver); // Chargement du pilote JDBC + instance de la classe Driver
			this.connection = DriverManager.getConnection(url,login,pwd);  // Connexion � la base de donn�es
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connexion to the database denied."); 
		}
		
	}
	
	/**
	 *Retourne le nombre de lignes d'un ResultSet
	 *
	 *@param rs : 
	 *		Instance de ResultSet trait�
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
	 *		Instance de ResultSet trait�
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
	 *Retourne un ResultSet contenant les donn�es renvoy�es
	 *par la bases de donn�es gr�ce � une requ�te SQL de type <i>SELECTs</i>.
	 *Le ResultSet a deux arguments:
	 *</p>
	 *<ul>
	 *	<li> TYPE_SCROLL_INSENSITIVE : ResultSet insensible aux modifications des valeurs dans la base de donn�es.
	 *								   Vue statique des donn�es du ResultSet.
	 *	<li> CONCUR_READ_ONLY: Indique que les donn�es du ResultSet ne peuvent qu'�tre lues;
	 *</ul>
	 *
	 *
	 *@param req :Requ�te SQL envoy� � la base de donn�e gr�ce � un Statement.
	 *
	 *@return Les donn�es d'une requ�te SQL
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
				System.out.println("Probl�me d'ex�cution de requ�te");
				e.printStackTrace();
			}
			
		} catch (RequeteNull e1) {
			e1.printStackTrace();
		}
		return rs;

	}
	
	
	/**
	 * <p>
	 * Ex�cute la requ�te demand�e g�n�ralement utilis�e pour les <i>INSERTs</i> ou les <i>UPDATEs</i>.
	 * Le ResultSet d�fini dans la cr�ation du Statement a deux arguments:
	 *</p>
	 *<ul>
	 *	<li> TYPE_SCROLL_INSENSITIVE : ResultSet insensible aux modifications des valeurs dans la base de donn�es.
	 *								   Vue statique des donn�es du ResultSet.
	 *	<li> CONCUR_READ_ONLY: Indique que les donn�es du ResultSet ne peuvent qu'�tre lues;
	 *</ul>
	 * 
	 * @param req: Requ�te SQL envoy� � la base de donn�e gr�ce � un Statement.
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
				System.out.println("Probl�me d'ex�cution de requ�te .");
				e.printStackTrace();
			}
		} catch (RequeteNull e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Teste si une requ�te est null
	 * 
	 * @param s: requ�te SQL dont la valeur sera �valu�
	 * 
	 * @see RequeteNull
	 * @since 2.0
	 * @throws RequeteNull si la requ�te en param�tre est null
	 * */
	public void testRequete(String s)throws RequeteNull {
		if(s.equals(null))
			throw new RequeteNull("Requete nulle.");
	}
}
