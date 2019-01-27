package com.massimobono.doclets.taglets;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

/**
 * a taglet allowing you to print the text in bold
 * 
 * An example is {@textbf this string}, achieved via:
 * 
 * {@code textbf this string}
 * 
 * Just for reference, here's an image of a {@textit cat}:
 * 
 * {@image http://files-cdn.shortlist.com/app/uploads/2016/06/27172449/cat-killer-256x256.png}
 * 
 * And here a dot diagram
 * 
 * {@dot
 * 	digraph test {
 * 		A -> B;
 * 	} 
 * }
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
		System.out.println("detected textbf!");
		return String.format("<b>%s</b>", arg0.getBody());
	}

}
