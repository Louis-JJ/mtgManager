package fr.mtg.gestion.queryhandlers;

/**
 * Handler for card's search by specific fields
 * @author redSpoutnik
 *
 */
public interface SearchQueryHandler {
	
	/**
	 * Check if <b>searchText</b> is valid for corresponding <b>searchType</b>.
	 * @param searchType card's field to be tested
	 * @param searchText value to be searching for
	 * @return boolean value
	 */
	public boolean validTextSearch(String searchType, String searchText);

}
