package com.massimobono.doclets.taglets;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

/**
 * a taglet allowing you to print the text in bold
 * 
 * 
 * 
 * @author koldar
 * @date 26/01/2018
 */
public class Textbf extends AbstractTextInlineTaglet {

	@Override
	public String getName() {
		return "textbf";
	}

	@Override
	public String visitText(TextTree arg0, TagletVisitorContext<String> arg1) {
		return String.format("<b>%s</b>", arg0.getBody());
	}

}
