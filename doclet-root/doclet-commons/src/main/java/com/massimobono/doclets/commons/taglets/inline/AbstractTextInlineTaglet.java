package com.massimobono.doclets.commons.taglets.inline;

import com.massimobono.doclets.commons.TagletVisitorContext;
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

/**
 * a taglet which accept a single string value and process it
 * 
 * @author koldar
 *
 */
public abstract class AbstractTextInlineTaglet extends AbstractInlineTaglet<String> {

	@Override
	protected boolean canBeOnConstructor() {
		return true;
	}

	@Override
	protected boolean canBeOnField() {
		return true;
	}

	@Override
	protected boolean canBeOnMethod() {
		return true;
	}

	@Override
	protected boolean canBeOnModule() {
		return true;
	}

	@Override
	protected boolean canBeOnOverview() {
		return true;
	}

	@Override
	protected boolean canBeOnPackage() {
		return true;
	}

	@Override
	protected boolean canBeOnType() {
		return true;
	}
	
	@Override
	public String createOut() {
		return "";
	}

	@Override
	public String convertOutputToString(String out) {
		return out;
	}
	
	@Override
	public String visitBegin(AttributeTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(AuthorTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(CommentTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(DeprecatedTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(DocCommentTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(DocRootTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(EndElementTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(EntityTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(ErroneousTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(IdentifierTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(InheritDocTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(LinkTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(LiteralTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(ParamTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(ReferenceTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(ReturnTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(SeeTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(SerialTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(SerialDataTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(SerialFieldTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(SinceTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(StartElementTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(ThrowsTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(UnknownBlockTagTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(UnknownInlineTagTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(ValueTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(VersionTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitBegin(DocTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitEnd(AttributeTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(AuthorTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(CommentTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(DeprecatedTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(DocCommentTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(DocRootTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(EndElementTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(EntityTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(ErroneousTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(IdentifierTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(InheritDocTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(LinkTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(LiteralTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(ParamTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(ReferenceTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(ReturnTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(SeeTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(SerialTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(SerialDataTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(SerialFieldTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(SinceTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(StartElementTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(ThrowsTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(UnknownBlockTagTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(UnknownInlineTagTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(ValueTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(VersionTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}

	@Override
	public String visitEnd(DocTree node, TagletVisitorContext<String> p) {
		
		return p.getBuilding();
	}
	
	
	
}
