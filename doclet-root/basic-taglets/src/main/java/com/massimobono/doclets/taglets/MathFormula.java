package com.massimobono.doclets.taglets;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import com.massimobono.doclets.commons.LatexInvoker;
import com.massimobono.doclets.commons.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.TextTree;

public class MathFormula extends AbstractTextInlineTaglet {

	private static final Logger LOG = Logger.getLogger(MathFormula.class.getName());
	
	public MathFormula() {

	}

	@Override
	public String getName() {
		return "eq";
	}

	@Override
	public String visitBegin(TextTree arg0, TagletVisitorContext<String> arg1) {
		
		//fetch the resource
		var content = "";
		try {
			var is = this.getClass().getResourceAsStream("/latexFormulaTemplate.tex");
			LOG.info(String.format("input stream is " + is));
			var bis = new BufferedReader(new InputStreamReader(is));
			var sb = new StringBuilder();
			while (true) {
				String line = bis.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			content = sb.toString();
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		
		//replace __FORMULA__ with the text content
		content = content.replace("__FORMULA__", arg0.getBody());
		
		var latexInvoker = new LatexInvoker(
				Paths.get("pdflatex"),
				Paths.get("convert"),
				"png",
				Paths.get(""),
				false,
				"",
				"",
				false
				);

		try {
			var imageFile = latexInvoker.invoke(content);
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
