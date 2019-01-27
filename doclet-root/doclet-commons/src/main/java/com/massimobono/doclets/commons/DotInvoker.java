package com.massimobono.doclets.commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class DotInvoker {
	
	private static final Logger LOG = Logger.getLogger(DotInvoker.class.getSimpleName());

	private static int nextId;
	
	static {
		nextId = 0;
	}
	
	/**
	 * path to the dot command in the system 
	 */
	private Path dot;
	/**
	 * the extension the image of dot will have
	 */
	private String extension;
	/**
	 * directory where we will generate the files from dot
	 */
	private Path outputDirectory;
	/**
	 * true if you want to generate in the same directory of {@link DotInvoker#outputDirectory} as the .dot file as well
	 */
	private boolean generateDotFile;
	/**
	 * String containing extra characters to be injected in the dot command
	 */
	private String extraParams;
	/**
	 * the name to associate to the output image. If emptym we will generate a name for you
	 */
	private String outputName;

	public DotInvoker(Path dot, String outputExtension, Path outputDirectory, boolean generateDotFile, String extraParams, String outputName) {
		this.dot = dot;
		this.outputDirectory = outputDirectory;
		this.extension = outputExtension;
		this.generateDotFile = generateDotFile;
		this.extraParams = extraParams;
		this.outputName = outputName;
	}


	/**
	 * generate the image representing the dot file associated
	 * 
	 * @param dotFileContent the content of the dot file
	 * @return the path of the generated image
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Path invoke(String dotFileContent) throws IOException, InterruptedException {

		var basename = (!this.outputName.isEmpty()) ? this.outputName : String.format("dotimage_%05d", nextId++);
		LOG.info("basename is \"" + basename + "\"");
		LOG.info("output directory is \"" + this.outputDirectory.toAbsolutePath() + "\"");
		var dotFile = this.outputDirectory.resolve(basename + "." + "dot").toAbsolutePath();
		var imageFile = this.outputDirectory.resolve(basename + "." + this.extension).toAbsolutePath();
		
		// create dot file
		try (var pw = new PrintStream(dotFile.toFile())) {
			pw.println(dotFileContent);
		}
		
		//create image file
		var cmd = String.format("%s -T%s -o %s %s %s", 
				this.dot.toAbsolutePath().toString(), 
				this.extension,
				imageFile.toString(),
				this.extraParams,
				dotFile.toString()
		);
		new ExternalProgramInvoker().invoke(cmd, this.outputDirectory);
		
		//remove dot file if needed
		if (!this.generateDotFile) {
			Files.deleteIfExists(dotFile);
		}
		
		return imageFile;
		
	}
}
