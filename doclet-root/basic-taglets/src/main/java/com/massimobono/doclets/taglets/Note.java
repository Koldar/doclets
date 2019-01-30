package com.massimobono.doclets.taglets;

import java.awt.Color;

import com.massimobono.doclets.commons.TagletVisitorContext;
import com.sun.source.doctree.TextTree;

public class Note extends AbstractBox {

	@Override
	public String getName() {
		return "note";
	}

	@Override
	public Color getTitleBackgroundColor() {
		return Color.BLUE;
	}

	@Override
	public Color getTitleColor() {
		return Color.WHITE;
	}

	@Override
	public Color getBodyBackgroundColor() {
		return Color.BLUE.brighter();
	}

	@Override
	public Color getBodyColor() {
		return Color.WHITE;
	}

}
