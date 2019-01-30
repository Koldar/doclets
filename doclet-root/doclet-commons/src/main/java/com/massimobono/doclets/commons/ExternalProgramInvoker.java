package com.massimobono.doclets.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ExternalProgramInvoker {
	
	public ExternalProgramInvoker() {
		
	}
	
	/**
	 * like {@link #invoke(Path, String...)} but every strings in {@code cmds} which are balk will be ignored
	 * @param cwd the working directory where you want to execute the command
	 * @param cmds the strings representing the command. Each of them will be joined with " ". null strings or blak strings will be ignored 
	 * @return the exit status of the program, always 0
	 */
	public int invoke(Path cwd, String... cmds) {
		var cmd = String.join(" ", Arrays.stream(cmds)
			.filter(s -> s != null)
			.filter(s -> !s.isBlank())
			.collect(Collectors.toList()));
		return this.invoke(cmd, cwd);
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
