package com.massimobono.doclets.commons.taglets.inline;

import com.massimobono.doclets.commons.taglets.AbstractTaglet;

public abstract class AbstractInlineTaglet<OUT> extends AbstractTaglet<OUT> {

	@Override
	public boolean isInlineTag() {
		return true;
	}
	
}
