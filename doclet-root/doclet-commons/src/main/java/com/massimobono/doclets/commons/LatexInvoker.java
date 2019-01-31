package com.massimobono.doclets.commons;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LatexInvoker {
	private static final Logger LOG = Logger.getLogger(LatexInvoker.class.getSimpleName());

	private static int nextId;
	
	static {
		nextId = 0;
	}
	
	/**
	 * path to the pdflatex command in the system 
	 * 
	 * This is not mandatory to be an absolute path.
	 * For example it may be {@code /usr/local/bin/dot} but it may also be {@code dot}.
	 * You shouldn't call absolute path of it because otherwise it the path is not an abolute one, {@code dot} command will be prepended
	 * with the current working directory.
	 */
	private Path pdflatex;
	/**
	 * path to the convert command in the system
	 * 
	 * This is not mandatory to be an absolute path.
	 */
	private Path convert;
	/**
	 * the extension the image of the formula will have
	 */
	private String imageExtension;
	/**
	 * directory where we will generate the files from dot
	 */
	private Path outputDirectory;
	/**
	 * true if you want to generate in the same directory of {@link DotInvoker#outputDirectory} as the .tex file as well
	 */
	private boolean generateTexFile;
	/**
	 * String containing extra characters to be injected in the pdflatex command
	 */
	private String extraParams;
	/**
	 * the name to associate to the output image. If empty we will generate a name for you
	 */
	private String outputName;
	/**
	 * we will run pdflatex twice in order to match the references as well.
	 * 
	 * This of course doubles the time but allows yout to generate references thourhg the project
	 */
	private boolean generatedReferences;

	public LatexInvoker(Path pdflatex, Path convert, String extension, Path outputDirectory, boolean generateTexFile, String extraParams, String outputName, boolean generatedReferences) {
		this.pdflatex = pdflatex;
		this.convert = convert;
		this.imageExtension = extension;
		this.outputDirectory = outputDirectory;
		this.generateTexFile = generateTexFile;
		this.extraParams = extraParams;
		this.outputName = outputName;
		this.generatedReferences = generatedReferences;
	}


	/**
	 * generate the image representing the dot file associated
	 * 
	 * @param texFileContent the content of the dot file
	 * @return the path of the generated image
	 * @throws IOException if we fail to generate both intermediate files or final image
	 */
	public Path invoke(String texFileContent) throws IOException {
		if (this.imageExtension.equalsIgnoreCase("svg")) {
			throw new RuntimeException(String.format("format svg is invalid for latex formula! Please use seomthing like png!"));
		}
		
		var basename = (!this.outputName.isEmpty()) ? this.outputName : String.format("latexFormula_%05d", nextId++);
		LOG.info("basename is \"" + basename + "\"");
		LOG.info("output directory is \"" + this.outputDirectory.toAbsolutePath() + "\"");
		var texFile = this.outputDirectory.resolve(basename + "." + "tex").toAbsolutePath();
		var pdfFile = this.outputDirectory.resolve(basename + "." + "pdf").toAbsolutePath();
		var imageFile = this.outputDirectory.resolve(basename + "." + this.imageExtension).toAbsolutePath();
		
		// create tex file
		try (var pw = new PrintStream(texFile.toFile())) {
			pw.println(texFileContent);
		}
		
		int times = this.generatedReferences ? 2 : 1;
		
		for (int i=0; i<times; ++i) {
			//create pdf file
			new ExternalProgramInvoker().invoke(this.outputDirectory, 
					this.pdflatex.toString(),
					"--shell-escape",
					"-interaction=nonstopmode",
					"-halt-on-error",
					this.extraParams,
					texFile.toAbsolutePath().toString()
			);
		}
		
		//convert the pdf into the image
		new ExternalProgramInvoker().invoke(this.outputDirectory, 
			this.convert.toString(),
			pdfFile.toAbsolutePath().toString(),
			"-fuzz 2%",
			"-trim",
			imageFile.toAbsolutePath().toString()
		);
		//remove the pdf file
//		Files.deleteIfExists(pdfFile);
		//remove tex file if needed
		if (!this.generateTexFile) {
			Files.deleteIfExists(texFile);
		}
		
		return imageFile;
		
	}
}
