/**
 * 
 */
package languages;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;


/**
 * @author harirajan
 *
 */
public enum Language {
	
	CHINESE("Chinese"),
	ENGLISH("English"),
	FRENCH("French"),
	GERMAN("German"),
	ITALIAN("Italian"),
	PORTUGESE("Portuguese"),
	RUSSIAN("Russian"),
	SPANISH("Spanish"),
	SYNTAX("Syntax");
	
	private String myLang;
	private ResourceBundle myResources;
	
	Language(String lang) {
		myLang = lang;
		myResources = ResourceBundle.getBundle("languages/" + lang);
	}
	
	public String getString(String key) {
		return myResources.getString(key);
	}
	
	public String getLang() {
		return myLang;
	}
	
	public Set<String> getKeys() {
		return myResources.keySet();
	}
	
}
