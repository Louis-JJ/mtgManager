package fr.mtg.gestion.queryhandlers.impl;


import org.springframework.stereotype.Service;

import fr.mtg.gestion.queryhandlers.ColorQueryHandler;

@Service
public class ColorQueryHandlerImpl implements ColorQueryHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validColorPattern(String colors) {
		return colors.matches("\\{\\}|(\\{[RGUWB]\\})+");
	}

	/**
	 * {@inheritDoc}
	 */
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
