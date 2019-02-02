package com.massimobono.doclets.taglets;

import java.awt.Color;

public class Attention extends AbstractBox {

	@Override
	public String getName() {
		return "attention";
	}

	@Override
	public Color getTitleBackgroundColor() {
		return Color.RED.darker();
	}

	@Override
	public Color getTitleColor() {
		return Color.BLACK;
	}

	@Override
	public Color getBodyBackgroundColor() {
		return Color.RED;
	}

	@Override
	public Color getBodyColor() {
		// TODO Auto-generated method stub
		return Color.black;
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
