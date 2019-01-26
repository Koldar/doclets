package com.massimobono.doclets.taglets;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.inline.AbstractInlineTaglet;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

public class Textit extends AbstractTextInlineTaglet {

	@Override
	public String getName() {
		return "textit";
	}

	@Override
	public String visitText(TextTree arg0, TagletVisitorContext<String> arg1) {
		return String.format("<i>%s</i>", arg0.getBody());
	}

}
