package com.massimobono.doclets.taglets;

import java.awt.Color;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import com.massimobono.doclets.commons.HTMLSimpleFileFormatter;
import com.massimobono.doclets.commons.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.block.AbstractGroupTaglet;
import com.massimobono.doclets.commons.taglets.block.AbstractTextBlockTaglet;
import com.massimobono.doclets.commons.taglets.inline.AbstractTextInlineTaglet;
import com.sun.source.doctree.AttributeTree;
import com.sun.source.doctree.AuthorTree;
import com.sun.source.doctree.CommentTree;
import com.sun.source.doctree.DeprecatedTree;
import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocRootTree;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.EndElementTree;
import com.sun.source.doctree.EntityTree;
import com.sun.source.doctree.ErroneousTree;
import com.sun.source.doctree.IdentifierTree;
import com.sun.source.doctree.InheritDocTree;
import com.sun.source.doctree.LinkTree;
import com.sun.source.doctree.LiteralTree;
import com.sun.source.doctree.ParamTree;
import com.sun.source.doctree.ReferenceTree;
import com.sun.source.doctree.ReturnTree;
import com.sun.source.doctree.SeeTree;
import com.sun.source.doctree.SerialDataTree;
import com.sun.source.doctree.SerialFieldTree;
import com.sun.source.doctree.SerialTree;
import com.sun.source.doctree.SinceTree;
import com.sun.source.doctree.StartElementTree;
import com.sun.source.doctree.TextTree;
import com.sun.source.doctree.ThrowsTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import com.sun.source.doctree.UnknownInlineTagTree;
import com.sun.source.doctree.ValueTree;
import com.sun.source.doctree.VersionTree;


public abstract class AbstractBox extends AbstractTextInlineTaglet {
	
	/**
	 * 
	 * @return color of the background of the box of the title
	 */
	public abstract Color getTitleBackgroundColor();
	
	/**
	 * 
	 * @return color of the font used to write the title
	 */
	public abstract Color getTitleColor();
	
	/**
	 * 
	 * @return color of the background in the body box
	 */
	public abstract Color getBodyBackgroundColor();
	
	/**
	 * 
	 * @return color of the font used to write the body text
	 */
	public abstract Color getBodyColor();
	
	/**
	 * check if you want to consider the carriage returns between the title and the body as in the body
	 * 
	 * @return true if you want to consider them in the body, false otherwise
	 */
	protected abstract boolean considerTitleBodyReturn();
	
	/**
	 * check if you want to consider the carriage returns after the body as in the body
	 * @return true if you want to consider them, false otherwise
	 */
	protected abstract boolean considerBodyReturns();
	
	/**
	 * if true we will remove any whitespace, tab or carriage return at the beignning and at the end of the body
	 * 
	 * @return true if you want to trim, false otherwise
	 */
	protected abstract boolean trimBody();
	
	@Override
	public String visitBegin(TextTree arg0, TagletVisitorContext<String> arg1) {
		
		return arg1.getBuilding();
	}
	
	@Override
	public String visitEnd(TextTree arg0, TagletVisitorContext<String> arg1) {
		System.out.println("tagletvisitor after finishing children " + arg1);
		
		//fetched the content of the note
		String wholeContent = arg0.getBody();
		//divide title from body
		
		
		var map = getTitleBody(wholeContent);
		
		String title = map.get("title");
		String body = map.get("body");
		
		System.out.println("title background " + this.getTitleBackgroundColor());
		System.out.println("title " + this.getTitleColor());
		System.out.println("body background " + this.getBodyBackgroundColor());
		System.out.println("body  " + this.getBodyColor());
		
		var htmlCode = "";
		try {
			htmlCode =  new HTMLSimpleFileFormatter()
					.addParam("TITLEBACKGROUNDCOLOR", this.convertColor(this.getTitleBackgroundColor()))
					.addParam("TITLECOLOR", this.convertColor(this.getTitleColor()))
					.addParam("BODYBACKGROUNDCOLOR", this.convertColor(this.getBodyBackgroundColor()))
					.addParam("BODYCOLOR", this.convertColor(this.getBodyColor()))
					.addParam("TITLE", title)
					.addParam("BODY", body)
					.format("abstractbox.html");
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		System.out.println("title = \"" + title + "\"");
		System.out.println("body = \"" + body + "\"");
		
		System.out.println("end note is >>>" + arg1.toString() + "<<<");
		return htmlCode;
	}
	
	private String convertColor(Color c) {
		return String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue());
	}
	
	private Map<String, String> getTitleBody(String wholeContent) {
		var p = Pattern.compile("^(?<title>[^\\n]*)(?<returns1>\\n+)(?<body>[^\\n]+)(?<returns2>\\n*)");
		var m = p.matcher(wholeContent);
		if (m.find()) {
			String title = m.group("title");
			String returns1 = m.group("returns1");
			String body = m.group("body");
			String returns2 = m.group("returns2");
			
			if (this.considerTitleBodyReturn()) {
				body = returns1 + body;
			}
			if (this.considerBodyReturns()) {
				body = body + returns2;
			}
			if (this.trimBody()) {
				body = body.strip();
			}
			
			return Map.of("title", title, "body", body);
		} else {
			throw new RuntimeException();
		}
	}
	

}
