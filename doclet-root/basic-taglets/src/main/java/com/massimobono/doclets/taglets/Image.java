package com.massimobono.doclets.taglets;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.massimobono.doclets.commons.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.inline.AbstractInlineTaglet;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

public class Image extends AbstractTextInlineTaglet implements CssUser {

	private Path imageFolder;
	
	@Override
	public String getName() {
		return "image";
	}

	@Override
	public String visitBegin(TextTree arg0, TagletVisitorContext<String> arg1) {
		var imageName = arg0.getBody();
		if (imageName.startsWith("http")) {
			//URL
			return String.format("<img src=\"%s\" class=\"%s\"/>",
					imageName,
					this.getCenterCSS()
			);
		} else {
			//file name
			//if imageName is an absolutepath resolve will return imageName by contract
			return String.format("<img src=\"%s\" class=\"%s\"/>",
					this.imageFolder.resolve(imageName).toAbsolutePath().toString(),
					this.getCenterCSS()
			);

		}
	}
	
	public String visitEnd(TextTree arg0, TagletVisitorContext<String> arg1) {
		return arg1.getBuilding();
	}

}
