package com.massimobono.doclets.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HTMLSimpleFileFormatter {
	
	private static final Pattern PATTERN = Pattern.compile("__(?<param>[0-9a-zA-Z]+)__");
	private Map<String, Object> parameters;
	
	public HTMLSimpleFileFormatter() {
		this.parameters = new HashMap<>();
	}
	
	public HTMLSimpleFileFormatter addParam(String param, Object value) {
		this.parameters.putIfAbsent(param, value);
		return this;
	}
	
	public String format(String filename) throws IOException {
		var resource = this.getClass().getClassLoader().getResourceAsStream(filename);
		List<String> lines = new ArrayList<>();
		try (var br = new BufferedReader(new InputStreamReader(resource))) {
			lines = br.lines().collect(Collectors.toList());
		}
		//now we convert every placeholder we can find. If a place is not found. we raise exeption
		List<String> tmp = new ArrayList<>();
		for (int i=0; i<lines.size(); ++i) {
			var line = lines.get(i);
			
			while (true) {
				Matcher m = PATTERN.matcher(line);
				if (!m.find()) {
					//there are no other parameters left in the line
					tmp.add(line);
					break;
				} else {
					if (!this.parameters.containsKey(m.group("param"))) {
						throw new RuntimeException("parameter is not contained in the parameters");
					}
					var templateStart = m.start("param") - 2;
					var templateEnd = m.end("param") + 2;
					
					if (templateEnd == line.length()) {
						//template is at the end of the line
						line = line.substring(0, templateStart) + this.parameters.get(m.group("param")).toString();
					} else {
						//template in the midlde of the line
						line = line.substring(0, templateStart) + this.parameters.get(m.group("param")).toString() + line.substring(templateEnd, line.length());
					}
					
				}
			}
		}
		
		return String.join("\n", tmp);
	}
}
