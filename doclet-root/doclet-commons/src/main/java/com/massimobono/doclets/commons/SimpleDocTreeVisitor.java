package com.massimobono.doclets.commons;

import java.util.Arrays;
import java.util.List;

import com.massimobono.doclets.commons.taglets.TagletVisitorContext;
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
 * a visitor which calls recurisvely the appropriate method of anther visitor
 * 
 * {@link DocTreeVisitor} normally doesn't recursively visit the children of a doc tree.
 * This visitor explicitly does it.
 *  
 * @author koldar
 *
 * @param <OUT>
 * @param <P>
 */
public class SimpleDocTreeVisitor<OUT> implements DocTreeVisitor<OUT, TagletVisitorContext<OUT>> {

	private DocTreeVisitor<OUT, TagletVisitorContext<OUT>> visitor;
	
	public SimpleDocTreeVisitor(DocTreeVisitor<OUT, TagletVisitorContext<OUT>> visitor) {
		this.visitor = visitor;
	}
	
	/**
	 * call the visitor on the children of a {@link DocTree} node
	 * 
	 * @param nodes the children we need to iterate over
	 * @param previousReturn the building element 
	 * @param parent parent of the children 
	 * @param previous structure used to keep track of the building elements
	 * @return
	 */
	private OUT navigate(List<? extends DocTree> nodes, OUT previousReturn, DocTree parent, TagletVisitorContext<OUT> previous) {
		OUT result = null;
		for (int i=0; i<nodes.size(); ++i) {
			var node = nodes.get(i);
			System.out.println(String.format("visiting child %s of %s with type...", node, parent, node.getKind()));
			var current = new TagletVisitorContext<>(
					previousReturn, 
					parent,
					previous.getDocTreeIndex(), 
					previous.getForest(),
					previous.getElement(),
					previous.getDepth() + 1
			);
			result = this.navigate(node, current);
		}
		return result;
	}
	
	private OUT navigate(DocTree child, OUT previousReturn, DocTree parent, TagletVisitorContext<OUT> previous) {
		return this.navigate(Arrays.asList(child), previousReturn, parent, previous);
	}
	
	/**
	 * call the correct visitor method given a node to visit and the context to pass to the visitor
	 * 
	 * @param node the node to visit
	 * @param p the context
	 * @return
	 */
	private OUT navigate(DocTree node, TagletVisitorContext<OUT> p) {
		switch (node.getKind()) {
		case ATTRIBUTE:
			return this.visitAttribute((AttributeTree) node, p);
		case AUTHOR:
			return this.visitAuthor((AuthorTree) node, p);
		case CODE:
			throw new RuntimeException();
		case COMMENT:
			return this.visitComment((CommentTree) node, p);
		case DEPRECATED:
			return this.visitDeprecated((DeprecatedTree) node, p);
		case DOC_COMMENT:
			return this.visitDocComment((DocCommentTree) node, p);
		case DOC_ROOT:
			return this.visitDocRoot((DocRootTree) node, p);
		case DOC_TYPE:
			throw new RuntimeException();
		case END_ELEMENT:
			return this.visitEndElement((EndElementTree) node, p);
		case ENTITY:
			return this.visitEntity((EntityTree) node, p);
		case ERRONEOUS:
			return this.visitErroneous((ErroneousTree) node, p);
		case EXCEPTION:
			throw new RuntimeException();
		case HIDDEN:
			throw new RuntimeException();
		case IDENTIFIER:
			return this.visitIdentifier((IdentifierTree) node, p);
		case INDEX:
			throw new RuntimeException();
		case INHERIT_DOC:
			return this.visitInheritDoc((InheritDocTree) node, p);
		case LINK:
			return this.visitLink((LinkTree) node, p);
		case LINK_PLAIN:
			throw new RuntimeException();
		case LITERAL:
			return this.visitLiteral((LiteralTree) node, p);
		case OTHER:
			throw new RuntimeException();
		case PARAM:
			return this.visitParam((ParamTree) node, p);
		case PROVIDES:
			throw new RuntimeException();
		case REFERENCE:
			return this.visitReference((ReferenceTree) node, p);
		case RETURN:
			return this.visitReturn((ReturnTree) node, p);
		case SEE:
			return this.visitSee((SeeTree) node, p);
		case SERIAL:
			return this.visitSerial((SerialTree) node, p);
		case SERIAL_DATA:
			return this.visitSerialData((SerialDataTree) node, p);
		case SERIAL_FIELD:
			return this.visitSerialField((SerialFieldTree) node, p);
		case SINCE:
			return this.visitSince((SinceTree) node, p);
		case START_ELEMENT:
			return this.visitStartElement((StartElementTree) node, p);
		case SUMMARY:
			throw new RuntimeException();
		case TEXT:
			return this.visitText((TextTree) node, p);
		case THROWS:
			return this.visitThrows((ThrowsTree) node, p);
		case UNKNOWN_BLOCK_TAG:
			return this.visitUnknownBlockTag((UnknownBlockTagTree) node, p);
		case UNKNOWN_INLINE_TAG:
			return this.visitUnknownInlineTag((UnknownInlineTagTree) node, p);
		case USES:
			throw new RuntimeException();
		case VALUE:
			return this.visitValue((ValueTree) node, p);
		case VERSION:
			return this.visitVersion((VersionTree) node, p);
		default:
			throw new RuntimeException();
		}
	}
	
	@Override
	public OUT visitAttribute(AttributeTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitAttribute(node, p);
		return this.navigate(node.getValue(), result, node, p);
	}

	@Override
	public OUT visitAuthor(AuthorTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitAuthor(node, p);
		return result;
	}

	@Override
	public OUT visitComment(CommentTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitComment(node, p);
		return result;
	}

	@Override
	public OUT visitDeprecated(DeprecatedTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitDeprecated(node, p);
		return this.navigate(node.getBody(), result, node, p);
	}

	@Override
	public OUT visitDocComment(DocCommentTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitDocComment(node, p);
		result = this.navigate(node.getPreamble(), result, node, p);
		result = this.navigate(node.getFullBody(), result, node, p);
		result = this.navigate(node.getPostamble(), result, node, p);
		return result;
	}

	@Override
	public OUT visitDocRoot(DocRootTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitDocRoot(node, p);
		return result;
	}

	@Override
	public OUT visitEndElement(EndElementTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitEndElement(node, p);
		return result;
	}

	@Override
	public OUT visitEntity(EntityTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitEntity(node, p);
		return result;
	}

	@Override
	public OUT visitErroneous(ErroneousTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitErroneous(node, p);
		return result;
	}

	@Override
	public OUT visitIdentifier(IdentifierTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitIdentifier(node, p);
		return result;
	}

	@Override
	public OUT visitInheritDoc(InheritDocTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitInheritDoc(node, p);
		return result;
	}

	@Override
	public OUT visitLink(LinkTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitLink(node, p);
		result = this.navigate(node.getLabel(), result, node, p);
		return result;
	}

	@Override
	public OUT visitLiteral(LiteralTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitLiteral(node, p);
		result = this.navigate(node.getBody(), result, node, p);
		return result;
	}

	@Override
	public OUT visitParam(ParamTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitParam(node, p);
		result = this.navigate(node.getDescription(), result, node, p);
		result = this.visitIdentifier(node.getName(), p);
		return result;
	}

	@Override
	public OUT visitReference(ReferenceTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitReference(node, p);
		return result;
	}

	@Override
	public OUT visitReturn(ReturnTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitReturn(node, p);
		result = this.navigate(node.getDescription(), result, node, p);
		return result;
	}

	@Override
	public OUT visitSee(SeeTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitSee(node, p);
		result = this.navigate(node.getReference(), result, node, p);
		return result;
	}

	@Override
	public OUT visitSerial(SerialTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitSerial(node, p);
		result = this.navigate(node.getDescription(), result, node, p);
		return result;
	}

	@Override
	public OUT visitSerialData(SerialDataTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitSerialData(node, p);
		result = this.navigate(node.getDescription(), result, node, p);
		return result;
	}

	@Override
	public OUT visitSerialField(SerialFieldTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitSerialField(node, p);
		result = this.navigate(node.getDescription(), result, node, p);
		result = this.navigate(node.getName(), result, node, p);
		result = this.navigate(node.getType(), result, node, p);
		return result;
	}

	@Override
	public OUT visitSince(SinceTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitSince(node, p);
		result = this.navigate(node.getBody(), result, node, p);
		return result;
	}

	@Override
	public OUT visitStartElement(StartElementTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitStartElement(node, p);
		result = this.navigate(node.getAttributes(), result, node, p);
		return result;
	}

	@Override
	public OUT visitText(TextTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitText(node, p);
		return result;
	}

	@Override
	public OUT visitThrows(ThrowsTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitThrows(node, p);
		result = this.navigate(node.getDescription(), result, node, p);
		result = this.navigate(node.getExceptionName(), result, node, p);
		return result;
	}

	@Override
	public OUT visitUnknownBlockTag(UnknownBlockTagTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitUnknownBlockTag(node, p);
		result = this.navigate(node.getContent(), result, node, p);
		return result;
	}

	@Override
	public OUT visitUnknownInlineTag(UnknownInlineTagTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitUnknownInlineTag(node, p);
		result = this.navigate(node.getContent(), result, node, p);
		return result;
	}

	@Override
	public OUT visitValue(ValueTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitValue(node, p);
		result = this.navigate(node.getReference(), result, node, p);
		return result;
	}

	@Override
	public OUT visitVersion(VersionTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitVersion(node, p);
		result = this.navigate(node.getBody(), result, node, p);
		return result;
	}

	@Override
	public OUT visitOther(DocTree node, TagletVisitorContext<OUT> p) {
		OUT result = this.visitor.visitOther(node, p);
		return result;
	}

}
