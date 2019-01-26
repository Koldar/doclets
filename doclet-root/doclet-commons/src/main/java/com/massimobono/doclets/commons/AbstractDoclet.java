package com.massimobono.doclets.commons;

import java.util.Locale;

import javax.tools.Diagnostic.Kind;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.Reporter;

public abstract class AbstractDoclet implements Doclet {

	protected Reporter reporter;
	protected Locale locale;
	
	public AbstractDoclet() {
		this.reporter = null;
		this.locale = null;
	}
	
	@Override
	public void init(Locale locale, Reporter reporter) {
		this.reporter = reporter;
		this.locale = locale;
	}
	
	protected void info(String fmt, Object ...objs) {
		this.reporter.print(Kind.NOTE, String.format(fmt, objs));
	}
	
	protected void error(String fmt, Object ...objs) {
		this.reporter.print(Kind.ERROR, String.format(fmt, objs));
	}
	
	protected void mandatoryWarning(String fmt, Object ...objs) {
		this.reporter.print(Kind.MANDATORY_WARNING, String.format(fmt, objs));
	}
	protected void warning(String fmt, Object ...objs) {
		this.reporter.print(Kind.WARNING, String.format(fmt, objs));
	}
	
	protected void other(String fmt, Object ...objs) {
		this.reporter.print(Kind.OTHER, String.format(fmt, objs));
	}
	
}
