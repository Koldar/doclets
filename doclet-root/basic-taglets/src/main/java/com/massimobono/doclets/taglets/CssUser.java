package com.massimobono.doclets.taglets;

import java.util.Arrays;

public interface CssUser {

	public default String getCenterCSS() {
		return String.join("", Arrays.asList(
				"display: block;",
				"margin-left: auto;",
				"margin-right: auto;",
				"width: 50%;"
		));
	}
}
