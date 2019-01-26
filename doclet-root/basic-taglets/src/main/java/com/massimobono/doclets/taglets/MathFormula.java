package com.massimobono.doclets.taglets;


import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.block.AbstractTextBlockTaglet;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

public class MathFormula extends AbstractTextInlineTaglet {

	@Override
	public String getName() {
		return "eq";
	}

	@Override
	public String visitText(TextTree arg0, TagletVisitorContext<String> arg1) {
		return "";
	}

}
