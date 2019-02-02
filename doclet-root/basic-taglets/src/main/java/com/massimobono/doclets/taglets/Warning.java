package com.massimobono.doclets.taglets;

import java.awt.Color;

public class Warning extends AbstractBox {

	@Override
	public String getName() {
		return "warning";
	}

	@Override
	public Color getTitleBackgroundColor() {
		return Color.YELLOW.darker();
	}

	@Override
	public Color getTitleColor() {
		return Color.black;
	}

	@Override
	public Color getBodyBackgroundColor() {
		return Color.YELLOW;
	}

	@Override
	public Color getBodyColor() {
		return Color.BLACK;
	}

	@Override
	protected boolean considerTitleBodyReturn() {
		return false;
	}

	@Override
	protected boolean considerBodyReturns() {
		return false;
	}

	@Override
	protected boolean trimBody() {
		return true;
	}

}
