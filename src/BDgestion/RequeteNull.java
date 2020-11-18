package BDgestion;

/**
 * <p>
 * Classe h�ritant de la classe Exception qui lance une exception
 * quand une requ�te SQL est null.
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
	 * Constructeur avec en param�tre une chaine de caract�re.
	 * </p>
	 * 
	 * @param s : 
	 * 			Chaine de caract�re qui d�finit le message qui d�crit l'exception.
	 * 
	 * @since 1.0
	 */
	public RequeteNull(String s) {
		super(s);
	}
	
	/**
	 * <p>
	 * Constructeur sans param�tre.
	 * </p>
	 * 
	 * @since 1.0
	 */
	public RequeteNull() {
		super();
	}
}
