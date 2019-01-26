package com.massimobono.doclets.commons.taglets.inline;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
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
	public String visitAttribute(AttributeTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitAuthor(AuthorTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitComment(CommentTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitDeprecated(DeprecatedTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitDocComment(DocCommentTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitDocRoot(DocRootTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitEndElement(EndElementTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitEntity(EntityTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitErroneous(ErroneousTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitIdentifier(IdentifierTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitInheritDoc(InheritDocTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitLink(LinkTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitLiteral(LiteralTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitParam(ParamTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitReference(ReferenceTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitReturn(ReturnTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitSee(SeeTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitSerial(SerialTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitSerialData(SerialDataTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitSerialField(SerialFieldTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitSince(SinceTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitStartElement(StartElementTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitThrows(ThrowsTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitUnknownBlockTag(UnknownBlockTagTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitUnknownInlineTag(UnknownInlineTagTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitValue(ValueTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitVersion(VersionTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}

	@Override
	public String visitOther(DocTree node, TagletVisitorContext<String> p) {
		System.out.println(node.getClass().getSimpleName() + " " + node.toString());
		return p.getBuilding();
	}
	
	
}
