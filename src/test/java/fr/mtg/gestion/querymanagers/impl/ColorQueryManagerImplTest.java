/**
 * 
 */
package fr.mtg.gestion.querymanagers.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.mtg.gestion.querymanagers.impl.ColorQueryManagerImpl;

public class ColorQueryManagerImplTest {
	
	private ColorQueryManagerImpl colorQueryManagerImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.colorQueryManagerImpl = new ColorQueryManagerImpl();
	}
	
	/**
	 * Test method for {@link fr.mtg.gestion.querymanagers.impl.ColorQueryManagerImpl#validColorPattern(java.lang.String)}.
	 */
	@Test
	public final void testValidColorPattern() {
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{R}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{G}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{U}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{W}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{B}"));
		
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{R}{G}{U}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{W}{B}"));
		assertTrue(this.colorQueryManagerImpl.validColorPattern("{R}{G}{U}{W}{B}"));
		
		assertFalse(this.colorQueryManagerImpl.validColorPattern(""));
		assertFalse(this.colorQueryManagerImpl.validColorPattern("Test"));
		assertFalse(this.colorQueryManagerImpl.validColorPattern("Test{}"));
		assertFalse(this.colorQueryManagerImpl.validColorPattern("Test{R}"));
		
		assertFalse(this.colorQueryManagerImpl.validColorPattern("{}{R}{G}{U}"));
		assertFalse(this.colorQueryManagerImpl.validColorPattern("{}{W}{B}"));
		assertFalse(this.colorQueryManagerImpl.validColorPattern("{}{R}{G}{U}{W}{B}"));
		
		assertFalse(this.colorQueryManagerImpl.validColorPattern(" {}"));
		assertFalse(this.colorQueryManagerImpl.validColorPattern("{} "));
		
	}

	/**
	 * Test method for {@link fr.mtg.gestion.querymanagers.impl.ColorQueryManagerImpl#colorsToRegex(java.lang.String)}.
	 */
	@Test
	public final void testColorsToRegex() {
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{}"), "(\\{\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{R}"), "(\\{[R]?\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{G}"), "(\\{[G]?\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{U}"), "(\\{[U]?\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{W}"), "(\\{[W]?\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{B}"), "(\\{[B]?\\})+");
		
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{R}{G}{U}"), "(\\{[RGU]?\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{W}{B}"), "(\\{[WB]?\\})+");
		assertEquals(this.colorQueryManagerImpl.colorsToRegex("{R}{G}{U}{W}{B}"), "(\\{[RGUWB]?\\})+");
	}

}
