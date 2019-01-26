package com.massimobono.doclets.commons.taglets;

import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;

/**
 * Helper structure for the SimpleDocTreeVisitor
 * 
 * 
 * @author koldar
 *
 * @param <OUT>
 */
public class TagletVisitorContext<OUT> {
	
	/**
	 * the object we'0re buyilding while visiting the taglet tree
	 */
	private OUT building;
	/**
	 * parent of this {@link DocTree} we're currently visiting
	 * 
	 * Can be null
	 */
	private final DocTree parent;
	/**
	 * the index of the tree of the forest we're building.
	 * 
	 * When visiting a taglet, we generally have a forest of tree. This index represents the index of the tree
	 * we're currently exploring in the forest
	 */
	private int docTreeIndex;
	/**
	 * the forest we're exploring right now
	 */
	private List<? extends DocTree> forest;
	/**
	 * the java element we're visiting right now
	 */
	private Element element;
	/**
	 * the depth of the tree we're currently visiting 
	 */
	private int depth;
	
	public TagletVisitorContext(OUT building, DocTree parent, int index, List<? extends DocTree> forest, Element element, int depth) {
		this.building = building;
		this.parent = parent;
		this.forest = forest;
		this.docTreeIndex = index;
		this.element = element;
		this.depth = depth;
	}
	
	public Optional<DocTree> getParent() {
		return Optional.ofNullable(this.parent);
	}
	
	public OUT getBuilding() {
		return this.building;
	}

	public int getDocTreeIndex() {
		return docTreeIndex;
	}

	public List<? extends DocTree> getForest() {
		return forest;
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
}