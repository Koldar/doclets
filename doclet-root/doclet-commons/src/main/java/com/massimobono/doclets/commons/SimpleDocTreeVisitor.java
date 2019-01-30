package com.massimobono.doclets.commons;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

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
	
	private static final Logger LOG = Logger.getLogger(SimpleDocTreeVisitor.class.getName());

	private BeginEndDocVisitor<OUT, TagletVisitorContext<OUT>> visitor;

	public SimpleDocTreeVisitor(BeginEndDocVisitor<OUT, TagletVisitorContext<OUT>> visitor) {
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
		for (int i=0; i<nodes.size(); ++i) {
			var node = nodes.get(i);
			LOG.info(String.format("in parent of type %s: visiting child %s with type %s...", parent.getKind(), node, node.getKind()));
			var current = new TagletVisitorContext<>(
					previousReturn, 
					parent,
					previous.getDocTreeIndex(), 
					previous.getForest(),
					previous.getElement(),
					previous.getDepth() + 1
					);
			previousReturn = this.navigate(node, current);
			LOG.info(String.format("in parent of type %s: finished visiting child %s of type %s", parent.getKind(), node, node.getKind()));
		}
		return previousReturn;
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
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getValue(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitAuthor(AuthorTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitComment(CommentTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitDeprecated(DeprecatedTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		return this.navigate(node.getBody(), p.getBuilding(), node, p);
	}

	@Override
	public OUT visitDocComment(DocCommentTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getPreamble(), p.getBuilding(), node, p));
		p.setBuilding(this.navigate(node.getFullBody(), p.getBuilding(), node, p));
		p.setBuilding(this.navigate(node.getPostamble(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitDocRoot(DocRootTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitEndElement(EndElementTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitEntity(EntityTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitErroneous(ErroneousTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitIdentifier(IdentifierTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitInheritDoc(InheritDocTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitLink(LinkTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getLabel(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitLiteral(LiteralTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getBody(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitParam(ParamTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getDescription(), p.getBuilding(), node, p));
		p.setBuilding(this.visitIdentifier(node.getName(), p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitReference(ReferenceTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitReturn(ReturnTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getDescription(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitSee(SeeTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getReference(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitSerial(SerialTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getDescription(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitSerialData(SerialDataTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getDescription(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitSerialField(SerialFieldTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getDescription(), p.getBuilding(), node, p));
		p.setBuilding(this.navigate(node.getName(), p.getBuilding(), node, p));
		p.setBuilding(this.navigate(node.getType(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitSince(SinceTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getBody(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitStartElement(StartElementTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getAttributes(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitText(TextTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitThrows(ThrowsTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getDescription(), p.getBuilding(), node, p));
		p.setBuilding(this.navigate(node.getExceptionName(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitUnknownBlockTag(UnknownBlockTagTree node, TagletVisitorContext<OUT> p) {
		LOG.info("init parsing begin unknow block \"" + p.getBuilding() + "\"");
		p.setBuilding(this.visitor.visitBegin(node, p));
		LOG.info("init children of unknow block \"" + p.getBuilding() + "\"");
		p.setBuilding(this.navigate(node.getContent(), p.getBuilding(), node, p));
		LOG.info("init parsing end unknow block" + p.getBuilding());
		p.setBuilding(this.visitor.visitEnd(node, p));
		LOG.info("returnin building.." + p.getBuilding());
		return p.getBuilding();
	}

	@Override
	public OUT visitUnknownInlineTag(UnknownInlineTagTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getContent(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitValue(ValueTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getReference(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitVersion(VersionTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.navigate(node.getBody(), p.getBuilding(), node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

	@Override
	public OUT visitOther(DocTree node, TagletVisitorContext<OUT> p) {
		p.setBuilding(this.visitor.visitBegin(node, p));
		p.setBuilding(this.visitor.visitEnd(node, p));
		return p.getBuilding();
	}

}
