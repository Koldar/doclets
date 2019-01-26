package com.massimobono.doclets.commons;

import java.util.List;

import com.massimobono.doclets.commons.taglets.AbstractSingleOption;

public class IntOption extends AbstractSingleOption<Integer>{
	
	public IntOption(List<String> names, String description) {
		super(names, description);
	}

	public IntOption(String name, String description) {
		super(name, description);
	}

	public IntOption(String[] names, String description) {
		super(names, description);
	}

	@Override
	protected Integer parse(String value) {
		return Integer.parseInt(value, 10);
	}

	@Override
	protected void process(String option, Integer argument) throws Exception {
		this.value = argument;
	}

}
