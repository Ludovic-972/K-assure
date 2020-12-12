package JunitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Interface.Inscription;
import jdk.javadoc.internal.tool.resources.javadoc;

/**
 * Classe Test des méthodes de la classe Inscription
 * 
 * @author Mathurin-Cayol Ludovic 
 * @version 1.0
 * @see Inscription
 * */
class InscriptionTest {
	
	@Test
	void testBissextile() {
		assertTrue(Inscription.bissextile(2000));
		assertTrue(Inscription.bissextile(2016));
		
		assertFalse(Inscription.bissextile(2058));
		assertFalse(Inscription.bissextile(2018));
	}

	@Test
	void testDateValid() {
		assertTrue(Inscription.DateValid("29-02-2020","Enfant"));
		assertTrue(Inscription.DateValid("05-03-2001","Adulte"));
		assertTrue(Inscription.DateValid("11-06-2001","Adulte"));
		assertTrue(Inscription.DateValid("NULL","Enfant"));

		assertFalse(Inscription.DateValid("29-02-2018","Adulte"));
		assertFalse(Inscription.DateValid("12-13-2014","Enfant"));
		assertFalse(Inscription.DateValid("12-13-2024","Adulte"));
		assertFalse(Inscription.DateValid("45-01-2019","Adulte"));
		assertFalse(Inscription.DateValid("-02-05-2016","Adulte"));
		assertFalse(Inscription.DateValid("11-06-2001","Enfant"));
		assertFalse(Inscription.DateValid("11-06-2008","Adulte"));
	}		

	@Test
	void testJours30() {
		assertFalse(Inscription.jours30(1)); // Janvier
		assertFalse(Inscription.jours30(2)); // Février
		assertFalse(Inscription.jours30(3)); // Mars
		assertTrue(Inscription.jours30(4)); // Avril
		assertFalse(Inscription.jours30(5)); // Mai
		assertTrue(Inscription.jours30(6)); // Juin
		assertFalse(Inscription.jours30(7)); // Juillet
		assertFalse(Inscription.jours30(8)); // Août
		assertTrue(Inscription.jours30(9)); // Septembre
		assertFalse(Inscription.jours30(10)); // Octobre
		assertTrue(Inscription.jours30(11)); // Novembre
		assertFalse(Inscription.jours30(12)); // Décembre
	}

	@Test
	void testEmailValidator() {
		assertTrue(Inscription.EmailValidator("test@testy.com"));
		assertTrue(Inscription.EmailValidator("abc123@def456.ghi"));
		assertTrue(Inscription.EmailValidator("char@clavier.azerty"));
		
		assertFalse(Inscription.EmailValidator("genie@logiciel"));
		assertFalse(Inscription.EmailValidator("char@clavier.azertyuiop"));
		assertFalse(Inscription.EmailValidator("bon@jovi.a"));
		assertFalse(Inscription.EmailValidator("123@456.789"));
		assertFalse(Inscription.EmailValidator("_azerty@fmail.fr"));
		assertFalse(Inscription.EmailValidator("@coucou.salut"));
		assertFalse(Inscription.EmailValidator("%joe%@wanadoo.fr"));
		assertFalse(Inscription.EmailValidator("joe%@wanadoo"));
	}

	@Test
	void testLoginGenerator() {
		String login = Inscription.LoginGenerator();
		assertTrue(login.length() ==8);
	}

	@Test
	void testDateFormatSQL() {
		assertEquals("'2020-01-02'", Inscription.dateFormatSQL("02-01-2020"));
		assertEquals("'2016-02-14'", Inscription.dateFormatSQL("14-02-2016"));
		assertNotEquals("'21-12-2012'", Inscription.dateFormatSQL("02-01-2020"));
		assertNotEquals("'2020-02-01'", Inscription.dateFormatSQL("02-01-2020"));
	}

}
