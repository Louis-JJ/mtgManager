package fr.mtg.gestion.queryhandlers.impl;

import org.springframework.stereotype.Service;

import fr.mtg.gestion.queryhandlers.SearchQueryHandler;

@Service
public class SearchQueryHandlerImpl implements SearchQueryHandler{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validTextSearch(String searchType, String searchText) {
		switch(searchType) {
		case "mtgId": return searchText.matches("\\d+");
		case "nameFr": return searchText.matches("[A-Za-z0-9 'éèàç,]+");
		case "nameEn": return searchText.matches("[A-Za-z0-9 ',]+");
		default: return false;
 		}
	}

}
