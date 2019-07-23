package fr.mtg.gestion.querymanagers.impl;

import org.springframework.stereotype.Service;

import fr.mtg.gestion.querymanagers.SearchQueryManager;

@Service
public class SearchQueryManagerImpl implements SearchQueryManager{
	
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
