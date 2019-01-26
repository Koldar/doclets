package com.massimobono.doclets.commons.taglets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;

import com.massimobono.doclets.commons.SimpleDocTreeVisitor;
import com.sun.source.doctree.AttributeTree;
import com.sun.source.doctree.AuthorTree;
import com.sun.source.doctree.CommentTree;
import com.sun.source.doctree.DeprecatedTree;
import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocRootTree;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.DocTreeVisitor;
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

import jdk.javadoc.doclet.Taglet;

/**
 * 
 * @author koldar
 *
 * @param <OUT> the structure that we're going to build whilw we're inside the visitor used to explore the tag children
 */
public abstract class AbstractTaglet<OUT> implements Taglet, DocTreeVisitor<OUT, TagletVisitorContext<OUT>> {
	
	public AbstractTaglet() {
	}
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a constructor
	 */
	protected abstract boolean canBeOnConstructor();
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a field
	 */
	protected abstract boolean canBeOnField();
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a method
	 */
	protected abstract boolean canBeOnMethod();
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a module
	 */
	protected abstract boolean canBeOnModule();
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a package overview
	 */
	protected abstract boolean canBeOnOverview();
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a package
	 */
	protected abstract boolean canBeOnPackage();
	
	/**
	 * 
	 * @return true if the taglet can be used in the javadoc of a class
	 */
	protected abstract boolean canBeOnType();
	
	@Override
	public Set<Location> getAllowedLocations() {
		var result = new HashSet<Location>();
		
		if (this.canBeOnConstructor()) {
			result.add(Location.CONSTRUCTOR);
		}
		
		if (this.canBeOnField()) {
			result.add(Location.FIELD);
		}
		
		if (this.canBeOnMethod()) {
			result.add(Location.METHOD);
		}
		
		if (this.canBeOnModule()) {
			result.add(Location.MODULE);
		}
		
		if (this.canBeOnOverview()) {
			result.add(Location.OVERVIEW);
		}

		if (this.canBeOnPackage()) {
			result.add(Location.PACKAGE);
		}
		
		if (this.canBeOnType()) {
			result.add(Location.TYPE);
		}
		
		return result;
	}

	@Override
	public String toString(List<? extends DocTree> tags, Element element) {
		OUT result = this.createOut();
		
		var tagVisitor = new SimpleDocTreeVisitor<OUT>(this);
		
		for (int i=0; i<tags.size(); ++i) {
			var tag = tags.get(i);
			result = tag.accept(tagVisitor, new TagletVisitorContext<OUT>(result, null, i, tags, element, 0));
		}
		
		return this.convertOutputToString(result);
	}
	
	/**
	 * generate a new empty output object ready to be filled with the information fetched from visiting the taglet content
	 * @return
	 */
	public abstract OUT createOut();
	
	/**
	 * After filling the output object with the information gathered in the visitor we convert the structure in a string 
	 * 
	 * This string will be put in the HTML generated
	 * 
	 * @param out the object structure to convert to string
	 * @return html code of the structure
	 */
	public abstract String convertOutputToString(OUT out);

}
