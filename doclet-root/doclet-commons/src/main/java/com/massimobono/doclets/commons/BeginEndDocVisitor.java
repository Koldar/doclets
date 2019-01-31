package com.massimobono.doclets.commons;
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


/**
 * a {@link DocTreeVisitor} which implements the pattern begin and end.
 * @author koldar
 *
 * @param <R> the return value of each visitor method
 * @param <P> the type of an additional parameter of each visitor method 
 */
public interface BeginEndDocVisitor<R, P> extends DocTreeVisitor<R, P>{
	public R visitBegin(AttributeTree node, P p);
	public R visitBegin(AuthorTree node, P p);
	public R visitBegin(CommentTree node, P p);
	public R visitBegin(DeprecatedTree node, P p);
	public R visitBegin(DocCommentTree node, P p);
	public R visitBegin(DocRootTree node, P p);
	public R visitBegin(EndElementTree node, P p);
	public R visitBegin(EntityTree node, P p);
	public R visitBegin(ErroneousTree node, P p);
	public R visitBegin(IdentifierTree node, P p);
	public R visitBegin(InheritDocTree node, P p);
	public R visitBegin(LinkTree node, P p);
	public R visitBegin(LiteralTree node, P p);
	public R visitBegin(ParamTree node, P p);
	public R visitBegin(ReferenceTree node, P p);
	public R visitBegin(ReturnTree node, P p);
	public R visitBegin(SeeTree node, P p);
	public R visitBegin(SerialTree node, P p);
	public R visitBegin(SerialDataTree node, P p);
	public R visitBegin(SerialFieldTree node, P p);
	public R visitBegin(SinceTree node, P p);
	public R visitBegin(StartElementTree node, P p);
	public R visitBegin(TextTree node, P p);
	public R visitBegin(ThrowsTree node, P p);
	public R visitBegin(UnknownBlockTagTree node, P p);
	public R visitBegin(UnknownInlineTagTree node, P p);
	public R visitBegin(ValueTree node, P p);
	public R visitBegin(VersionTree node, P p);
	public R visitBegin(DocTree node, P p);
	public R visitEnd(AttributeTree node, P p);
	public R visitEnd(AuthorTree node, P p);
	public R visitEnd(CommentTree node, P p);
	public R visitEnd(DeprecatedTree node, P p);
	public R visitEnd(DocCommentTree node, P p);
	public R visitEnd(DocRootTree node, P p);
	public R visitEnd(EndElementTree node, P p);
	public R visitEnd(EntityTree node, P p);
	public R visitEnd(ErroneousTree node, P p);
	public R visitEnd(IdentifierTree node, P p);
	public R visitEnd(InheritDocTree node, P p);
	public R visitEnd(LinkTree node, P p);
	public R visitEnd(LiteralTree node, P p);
	public R visitEnd(ParamTree node, P p);
	public R visitEnd(ReferenceTree node, P p);
	public R visitEnd(ReturnTree node, P p);
	public R visitEnd(SeeTree node, P p);
	public R visitEnd(SerialTree node, P p);
	public R visitEnd(SerialDataTree node, P p);
	public R visitEnd(SerialFieldTree node, P p);
	public R visitEnd(SinceTree node, P p);
	public R visitEnd(StartElementTree node, P p);
	public R visitEnd(TextTree node, P p);
	public R visitEnd(ThrowsTree node, P p);
	public R visitEnd(UnknownBlockTagTree node, P p);
	public R visitEnd(UnknownInlineTagTree node, P p);
	public R visitEnd(ValueTree node, P p);
	public R visitEnd(VersionTree node, P p);
	public R visitEnd(DocTree node, P p);
	
	@Override
	default R visitAttribute(AttributeTree node, P p) {
		return this.visitBegin(node, p);
	}
	@Override
	default R visitAuthor(AuthorTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitComment(CommentTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitDeprecated(DeprecatedTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitDocComment(DocCommentTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitDocRoot(DocRootTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitEndElement(EndElementTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitEntity(EntityTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitErroneous(ErroneousTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitIdentifier(IdentifierTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitInheritDoc(InheritDocTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitLink(LinkTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitLiteral(LiteralTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitParam(ParamTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitReference(ReferenceTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitReturn(ReturnTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitSee(SeeTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitSerial(SerialTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitSerialData(SerialDataTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitSerialField(SerialFieldTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitSince(SinceTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitStartElement(StartElementTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitText(TextTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitThrows(ThrowsTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitUnknownBlockTag(UnknownBlockTagTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitUnknownInlineTag(UnknownInlineTagTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitValue(ValueTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitVersion(VersionTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	@Override
	default R visitOther(DocTree node, P p) {
		
		return this.visitBegin(node, p);
	}
	
	
}
