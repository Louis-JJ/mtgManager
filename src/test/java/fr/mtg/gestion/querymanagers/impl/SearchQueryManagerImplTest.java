/**
 * 
 */
package fr.mtg.gestion.querymanagers.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.mtg.gestion.querymanagers.impl.SearchQueryManagerImpl;

public class SearchQueryManagerImplTest {
	
	private SearchQueryManagerImpl searchQueryManagerImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.searchQueryManagerImpl = new SearchQueryManagerImpl();
	}

	/**
	 * Test method for {@link fr.mtg.gestion.querymanagers.impl.SearchQueryManagerImpl#validTextSearch(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testValidTextSearch() {
		assertTrue(this.searchQueryManagerImpl.validTextSearch("mtgId", "1"));
		assertTrue(this.searchQueryManagerImpl.validTextSearch("mtgId", "12345678910111213"));
		
		assertTrue(this.searchQueryManagerImpl.validTextSearch("nameFr", "Option"));
		assertTrue(this.searchQueryManagerImpl.validTextSearch("nameFr", "Nécropède"));
		assertTrue(this.searchQueryManagerImpl.validTextSearch("nameFr", "Lotus noir"));
		
		assertTrue(this.searchQueryManagerImpl.validTextSearch("nameEn", "Opt"));
		assertTrue(this.searchQueryManagerImpl.validTextSearch("nameEn", "Necropede"));
		assertTrue(this.searchQueryManagerImpl.validTextSearch("nameEn", "Black lotus"));
		
		assertFalse(this.searchQueryManagerImpl.validTextSearch("unknown", "Valid text"));
		
		assertFalse(this.searchQueryManagerImpl.validTextSearch("mtgId", ""));
		assertFalse(this.searchQueryManagerImpl.validTextSearch("nameFr", ""));
		assertFalse(this.searchQueryManagerImpl.validTextSearch("nameEn", ""));
		
		assertFalse(this.searchQueryManagerImpl.validTextSearch("mtgId", "; injection"));
		assertFalse(this.searchQueryManagerImpl.validTextSearch("nameFr", "; injection"));
		assertFalse(this.searchQueryManagerImpl.validTextSearch("nameEn", "; injection"));
		
		assertFalse(this.searchQueryManagerImpl.validTextSearch("mtgId", "Lotus noir"));
		
		assertFalse(this.searchQueryManagerImpl.validTextSearch("nameEn", "Nécropède"));
	}

}
