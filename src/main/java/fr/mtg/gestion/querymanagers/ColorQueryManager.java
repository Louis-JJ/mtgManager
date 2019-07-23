package fr.mtg.gestion.querymanagers;

/**
 * Manager to handle colors string's patterns
 * @author redSpoutnik
 *
 */
public interface ColorQueryManager {
	
	/**
	 * Valid colors string's pattern for further treatments.</br>
	 * A valid colors pattern is :
	 * <li>'<b>{}</b>' (uncolor) </li>
	 * </br>Or any combination of :
	 * <li>'<b>{R}</b>' (red) </li>
	 * <li>'<b>{G}</b>' (green) </li>
	 * <li>'<b>{U}</b>' (blue) </li>
	 * <li>'<b>{W}</b>' (white) </li>
	 * <li>'<b>{B}</b>' (black) </li>
	 * </br>
	 * @param colors string pattern
	 * @return boolean value
	 */
	public boolean validColorPattern(String colors);
	
	/**
	 * Convert colors string's pattern into valid regex.</br>
	 * The regex is intended to be used into Neo4j's query.
	 * @param colors string pattern
	 * @return usable regex
	 */
	public String colorsToRegex(String colors);

}
