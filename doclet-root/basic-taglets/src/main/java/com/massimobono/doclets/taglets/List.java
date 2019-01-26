package com.massimobono.doclets.taglets;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.block.AbstractGroupTaglet;
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

public class List extends AbstractGroupTaglet<String>{

	@Override
	public String getName() {
		return "li";
	}

	@Override
	public String visitAttribute(AttributeTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitAuthor(AuthorTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitComment(CommentTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDeprecated(DeprecatedTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDocComment(DocCommentTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDocRoot(DocRootTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitEndElement(EndElementTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitEntity(EntityTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitErroneous(ErroneousTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitIdentifier(IdentifierTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitInheritDoc(InheritDocTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitLink(LinkTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitLiteral(LiteralTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitOther(DocTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitParam(ParamTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitReference(ReferenceTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitReturn(ReturnTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitSee(SeeTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitSerial(SerialTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitSerialData(SerialDataTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitSerialField(SerialFieldTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitSince(SinceTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStartElement(StartElementTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitText(TextTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitThrows(ThrowsTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitUnknownBlockTag(UnknownBlockTagTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitUnknownInlineTag(UnknownInlineTagTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitValue(ValueTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitVersion(VersionTree arg0, TagletVisitorContext<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canBeOnConstructor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canBeOnField() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canBeOnMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canBeOnModule() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canBeOnOverview() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canBeOnPackage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canBeOnType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String createOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convertOutputToString(String out) {
		// TODO Auto-generated method stub
		return null;
	}

}
