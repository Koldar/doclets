package com.massimobono.doclets.commons;

import java.util.List;

import com.massimobono.doclets.commons.taglets.AbstractSingleOption;

public class StringOption extends AbstractSingleOption<String> {

	

	public StringOption(List<String> names, String description) {
		super(names, description);
	}

	public StringOption(String name, String description) {
		super(name, description);
	}

	public StringOption(String[] names, String description) {
		super(names, description);
	}

	@Override
	protected String parse(String value) {
		return value;
	}

	@Override
	protected void process(String option, String argument) {
		this.value = argument;
	}

}
