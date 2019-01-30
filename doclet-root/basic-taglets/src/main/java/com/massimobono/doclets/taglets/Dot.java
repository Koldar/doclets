package com.massimobono.doclets.taglets;

import java.nio.file.Paths;
import java.util.logging.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.massimobono.doclets.commons.DotInvoker;
import com.massimobono.doclets.commons.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

public class Dot extends AbstractTextInlineTaglet {
	
	private static final Logger LOG = Logger.getLogger(AbstractTextInlineTaglet.class.getName());

	private DotInvoker dot;
	
	public Dot() {
		this.dot = new DotInvoker(
				Paths.get("dot"), 
				"svg", 
				Paths.get(""), 
				true, 
				"",
				"");
	}
	
	@Override
	public String getName() {
		return "dot";
	}

	@Override
	public String visitBegin(TextTree arg0, TagletVisitorContext<String> arg1) {
		//we need to generate the image file and then put an image instead of the dot file
		try {
			var imageFile = this.dot.invoke(arg0.getBody());
			return String.format("<img src=\"%s\"/>", imageFile.toAbsolutePath().toFile());
		} catch (Exception e) {
			//TODO add warning logging
			LOG.warning("Cannot generate dot image for the following content:");
			LOG.warning(arg0.getBody());
			e.printStackTrace();
			return "";
		}
	}
	
	public String visitEnd(TextTree arg0, TagletVisitorContext<String> arg1) {
		return arg1.getBuilding();
	}

}
