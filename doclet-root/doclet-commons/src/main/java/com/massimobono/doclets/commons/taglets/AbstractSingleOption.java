package com.massimobono.doclets.commons.taglets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.javadoc.doclet.Doclet;

/**
 * Represents a doclet option which represents a single value
 * 
 * https://docs.oracle.com/javase/9/javadoc/javadoc-command.htm#JSJAV-GUID-3051737B-FFF9-45F9-85D1-5F07D6703592
 * @author Massimo
 * @param T the type of the value of the option
 */
@Deprecated
public abstract class AbstractSingleOption<T> implements Doclet.Option {

	private String description;
	private List<String> optionNames;
	protected T value;
	
	public AbstractSingleOption(List<String> names, String description) {
		this.optionNames = new ArrayList<String>(names);
		this.description = description;
	}
	
	public AbstractSingleOption(String[] names, String description) {
		this(Arrays.asList(names), description);
	}
	
	public AbstractSingleOption(String name, String description) {
		this(Arrays.asList(name), description);
	}
	
	@Override
	public int getArgumentCount() {
		return 1;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Kind getKind() {
		return Kind.STANDARD;
	}

	@Override
	public List<String> getNames() {
		return this.optionNames;
	}

	//I think this is still something for generating the help command
	@Override
	public String getParameters() {
		 return "name <p1>:<p2>..";
	}

	@Override
	public boolean process(String option, List<String> arguments) {
		String toParse = arguments.get(0);
		T value = this.parse(toParse);
		try {
			this.process(option, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected abstract T parse(String value);
	
	protected abstract void process(String option, T argument) throws Exception;

	public T getParameterValue() {
		return this.value;
	}
}
