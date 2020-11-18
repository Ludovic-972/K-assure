package BDgestion;

/**
 * <p>
 * Classe héritant de la classe Exception qui lance une exception
 * quand une requête SQL est null.
 * </p>
 * 
 * @see BDconnection#testRequete(String)
 * 
 * @author Ludovic Mathurin-Cayol
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class RequeteNull extends Exception{
	
	/**
	 * <p>
	 * Constructeur avec en paramètre une chaine de caractère.
	 * </p>
	 * 
	 * @param s : 
	 * 			Chaine de caractère qui définit le message qui décrit l'exception.
	 * 
	 * @since 1.0
	 */
	public RequeteNull(String s) {
		super(s);
	}
	
	/**
	 * <p>
	 * Constructeur sans paramètre.
	 * </p>
	 * 
	 * @since 1.0
	 */
	public RequeteNull() {
		super();
	}
}
