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
import com.is.utils.ISLogger;
import com.is.utils.ImageHolder;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * @author Grzegorz Polek <grzegorz.polek@gmail.com>
 *
 */
public class ImageSimilarity {

	private final static Logger LOG = Logger.getLogger(ImageSimilarity.class .getName()); 
    
	@Parameter
	private List<String> parameters = new ArrayList<String>();
	
	@Parameter(names = "-gui", description = "GUI")
	private boolean gui = false;

	@Parameter(names = "-img", description = "Absolute Path to the image")
	private String img;

	@Parameter(names = "-dir", description = "Absolute Path to directory with images to compare with")
	private String dir;

    /**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws RuntimeException, Exception 
	{
		ImageSimilarity is = new ImageSimilarity();
		
		new JCommander(is, args);
		
		is.setup();
		is.run();
	}
	
	private void setup()
	{
		if(gui)
		{
			try {
				UserInterface ui = new UserInterface();
				ui.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void run()
	{
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");
		
		// Set up the logger
		try {
			ISLogger.setup();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	throw new RuntimeException("Problems with creating the log files!");
	    }
		
		String path = null;
			
		/*// Run setup function.
		if(path != null)
		{
			setup();
		}
		else
		{
			LOG.severe("Path is null. What the hell?!");
			throw new RuntimeException("Path is null. What the hell?!");
		}
		
		// Get a file
		File file = new File(path);
		
		// TODO: Think about multithreading here, how we can implement it...
		
		// Compare images
		try {
			Compare compare = new Compare(file);
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
		}*/
	}
	
	protected boolean checkURL(String url)
	{
		Pattern url_pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		
		Matcher matcher = null;
		
		matcher = url_pattern.matcher(url);
		
		return matcher.find();
	}
	
	protected boolean checkPATH(String path)
	{
		Pattern path_pattern = Pattern.compile("[^\0]+");
		
		Matcher matcher = null;
		
		matcher = path_pattern.matcher(path);
		
		return matcher.find();
	}

}
