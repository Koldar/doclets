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
	
	public int invoke(String command, Path cwd) throws IOException, InterruptedException {
		System.out.println("executing command " + command + " in directory " + cwd.toAbsolutePath().toString());
		var process = new ProcessBuilder()
				.command(command)
				.directory(cwd.toAbsolutePath().toFile())
				.start();
		
		// Wait to finish application execution.
		process.waitFor();
		int returnVal = process.exitValue();
		if (returnVal != 0) {
			throw new RuntimeException();
		}
		return returnVal;
		
	}
}
