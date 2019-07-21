package fr.mtg.gestion.querymanagers;

public interface ColorQueryManager {
	
	public boolean validColorPattern(String colors);
	
	public String colorsToRegex(String colors);

}
