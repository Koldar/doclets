package com.massimobono.doclets.taglets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import com.massimobono.doclets.commons.TagletVisitorContext;
import com.massimobono.doclets.commons.taglets.block.AbstractTextBlockTaglet;
import com.sun.source.doctree.TextTree;

/**
 * Allows the developer to add a date of the annotated element
 * 
 * @author koldar
 */
public class Date extends AbstractTextBlockTaglet {

	private static final DateTimeFormatter ITALY = DateTimeFormatter.ofPattern("d/M/yyyy");
	private static final DateTimeFormatter ISO = DateTimeFormatter.ISO_DATE;
	
	/**
	 * the date time format we accept as date parameter from the javadoc comments
	 */
	private List<DateTimeFormatter> allowedFormatter;
	/**
	 * the formatte rto use to print the date on the HTML
	 */
	private DateTimeFormatter toPrint;
	
	public Date() {
		this.toPrint = DateTimeFormatter.ISO_DATE;
		this.allowedFormatter = Arrays.asList(
				ITALY, ISO
		);
	}
	
	@Override
	public String getName() {
		return "date";
	}

	@Override
	public String visitBegin(TextTree arg0, TagletVisitorContext<String> arg1) {
		for (var dtf : this.allowedFormatter) {
			try {
				System.out.println(String.format("trying to parse \"%s\" with %s", arg0.getBody(), dtf.toString()));
				LocalDate ld = LocalDate.parse(arg0.getBody(), dtf);
				var date = ld.format(this.toPrint);
				return String.format("<p>Document added on <tt>%s</tt></p>", date);
			} catch (DateTimeParseException e) {
				continue;
			}
		}
		throw new RuntimeException(String.format("we couldn't parse the date \"%s\"!", arg0.getBody()));
	}
	
	public String visitEnd(TextTree arg0, TagletVisitorContext<String> arg1) {
		return arg1.getBuilding();
	}

}
