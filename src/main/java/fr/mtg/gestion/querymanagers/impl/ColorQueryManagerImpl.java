package fr.mtg.gestion.querymanagers.impl;


import org.springframework.stereotype.Service;

import fr.mtg.gestion.querymanagers.ColorQueryManager;

@Service
public class ColorQueryManagerImpl implements ColorQueryManager {

	@Override
	public boolean validColorPattern(String colors) {
		return colors.matches("\\{\\}|(\\{[RGUWB]\\})+");
	}

	@Override
	public String colorsToRegex(String colors) {
		StringBuilder builder = new StringBuilder("(\\{");
		boolean hasNoColor = true;
		for(char c: colors.toCharArray()) {
			if(c == 'R' ||  c == 'G' || c == 'U' || c == 'W' || c == 'B') {
				if(hasNoColor) {
					builder.append('[');
					hasNoColor = false;
				}
				builder.append(c);
			}
		}
		if(!hasNoColor) {
			builder.append("]?");
		}
		builder.append("\\})+");
		return builder.toString();
	}

}
