package com.massimobono.doclets.taglets;

import java.awt.Color;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.block.AbstractGroupTaglet;
import com.massimobono.doclets.commons.taglets.block.AbstractTextBlockTaglet;
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

import com.massimobono.doclets.taglets.AbstractBox.BoxInfo;

public abstract class AbstractBox extends AbstractGroupTaglet<BoxInfo>{
	
	public static class BoxInfo {
		public boolean isTitleFound;
		
		public BoxInfo(boolean isTitleFound) {
			this.isTitleFound = isTitleFound;
		}
	}
	
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
	
	
	@Override
	public BoxInfo visitAttribute(AttributeTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitAuthor(AuthorTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitComment(CommentTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitDeprecated(DeprecatedTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitDocComment(DocCommentTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitDocRoot(DocRootTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitEndElement(EndElementTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitEntity(EntityTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitErroneous(ErroneousTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitIdentifier(IdentifierTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitInheritDoc(InheritDocTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitLink(LinkTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitLiteral(LiteralTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitOther(DocTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitParam(ParamTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitReference(ReferenceTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitReturn(ReturnTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitSee(SeeTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitSerial(SerialTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitSerialData(SerialDataTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitSerialField(SerialFieldTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitSince(SinceTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitStartElement(StartElementTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitText(TextTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitThrows(ThrowsTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitUnknownBlockTag(UnknownBlockTagTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitUnknownInlineTag(UnknownInlineTagTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitValue(ValueTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

	@Override
	public BoxInfo visitVersion(VersionTree arg0, TagletVisitorContext<BoxInfo> arg1) {
		return arg1.getBuilding();
	}

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
	public BoxInfo createOut() {
		return new BoxInfo(false);
	}

	@Override
	public String convertOutputToString(BoxInfo out) {
		return out;
	}

}
