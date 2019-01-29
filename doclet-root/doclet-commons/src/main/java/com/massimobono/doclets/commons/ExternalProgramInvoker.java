package com.massimobono.doclets.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.Arrays;

public class ExternalProgramInvoker {
	
	public ExternalProgramInvoker() {
		
	}
	
	public int invoke(String command, Path cwd) {
		try {
			System.out.println("executing command \"" + command + "\" in directory \"" + cwd.toAbsolutePath().toString()+"\"");
			var process = new ProcessBuilder()
					.command(command.split(" "))
					.directory(cwd.toAbsolutePath().toFile())
					.inheritIO()
					.start();
			
			// Wait to finish application execution.
			int returnVal = process.waitFor();
			if (returnVal != 0) {
				throw new RuntimeException(String.format("the returned value of the program \"%s\" was %d (cwd was \"%s\")",
						command,
						returnVal,
						cwd.toAbsolutePath().toString()
				));
			}
			return returnVal;
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
