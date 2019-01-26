package com.massimobono.doclets.commons.taglets.block;

import com.massimobono.doclets.commons.taglets.AbstractTaglet;

public abstract class AbstractGroupTaglet<OUT> extends AbstractTaglet<OUT> {

	@Override
	public boolean isInlineTag() {
		return false;
	}
	
}
