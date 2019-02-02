package com.massimobono.doclets.taglets;

import com.massimobono.doclets.commons.TagletVisitorContext;
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
 * Finally here's latex formula
 * 
 * {@eq eta_{i+1} = \frac{eta_{i}}{4}}
 * 
 *  And look! there is a note!
 *  
 *  {@note title
 *  Internal information!
 *  }
 *  
 *  Here's a note with custom taglets within it
 *  
 *  {@note title with {@textbf bold}
 *  Internal information with {@textit italic}!
 *  }
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
	public String visitBegin(TextTree arg0, TagletVisitorContext<String> arg1) {
		return String.format("<b>%s</b>", arg0.getBody());
	}
	
	public String visitEnd(TextTree arg0, TagletVisitorContext<String> arg1) {
		return arg1.getBuilding();
	}

}
