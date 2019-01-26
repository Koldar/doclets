package com.massimobono.doclets.taglets;

import java.awt.Color;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
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
	

}
