/**
 * 
 */
package com.is.general;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.is.algorithm.Compare;
import com.is.utils.Check;
import com.is.utils.ISLogger;
import com.is.utils.ImageHolder;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

/**
 * @author Grzegorz Polek <grzegorz.polek@gmail.com>
 *
 */
public class ImageSimilarity {

	private final static Logger LOG = Logger.getLogger(ImageSimilarity.class .getName()); 
    
	@Parameter
	private List<String> parameters = new ArrayList<String>();
	
	@Parameter(names = {"-h", "--help"}, description = "Show help")
	private boolean help = false;
	
	@Parameter(names = {"-g", "--gui"}, description = "Enable Graphical User Interface")
	private boolean gui = false;
	
	@Parameter(names = {"-i", "--img"}, description = "Absolute Path to the image")
	private String img;

	@Parameter(names = {"-d", "--dir"}, description = "Absolute Path to directory with images to compare with")
	private String dir;

	private static JCommander jc;
	
    /**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws RuntimeException, Exception 
	{
		ImageSimilarity is = new ImageSimilarity();
		
		jc = new JCommander(is);
		jc.setProgramName("ImageSimilarity");
		
		try
		{
			jc.parse(args);
		} 
		catch (ParameterException pe) 
		{
			System.out.println("Wrong console parameters. See usage of ImageSimilarity below:");
			jc.usage();
		}
		
		is.setup();
	}
	
	private void setup()
	{
		// Show help
		if(help)
		{
			jc.usage();
		}
		
		// GUI enabled
		if(gui)
		{
			try {
				UserInterface ui = new UserInterface();
				ui.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Disable MediaLib. lol.
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");
		
		// Set up the logger
		try {
			ISLogger.setup();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	throw new RuntimeException("Problems with creating the log files!");
	    }
		
		// Run
		if(img != null && dir != null)
		{
			run();
		}
		else
		{
			throw new RuntimeException("Comparision failed. Ooops!");
		}
	}
	
	private void run()
	{
		// Get a file
		File image = new File(img);
		File directory = new File(dir);
		
		if(!image.exists())
		{
			throw new RuntimeException("Image doesn't exist!");
		}
		
		if(!directory.exists())
		{
			throw new RuntimeException("Directory doesn't exist!");
		}
		
		// TODO: Think about multithreading here, how we can implement it...
		
		// Compare images
		try {
			Compare compare = new Compare(image, directory);
			
			List<ImageHolder> images = compare.getResults();
			for(ImageHolder i : images)
			{
				System.out.println("Image: " + i.getFile().getPath());
				System.out.println("Distance: " + Double.toString(i.getDistance()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.severe("Comparision failed. Ooops!");
			throw new RuntimeException("Comparision failed. Ooops!");
		}
	}

}
