package com.massimobono.doclets.commons;

import java.util.List;

import com.massimobono.doclets.commons.taglets.AbstractSingleOption;

public class DoubleOption extends AbstractSingleOption<Double>{
	
	public DoubleOption(List<String> names, String description) {
		super(names, description);
	}

	public DoubleOption(String name, String description) {
		super(name, description);
	}

	public DoubleOption(String[] names, String description) {
		super(names, description);
	}

	@Override
	protected Double parse(String value) {
		return Double.parseDouble(value);
	}

	@Override
	protected void process(String option, Double argument) throws Exception {
		this.value = argument;
	}

}
