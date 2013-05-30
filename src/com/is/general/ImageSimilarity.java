/**
 * 
 */
package com.is.general;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.is.algorithm.Compare;
import com.is.utils.ISLogger;
import com.is.utils.ImageHolder;

/**
 * @author Grzegorz Polek <grzegorz.polek@gmail.com>
 *
 */
public class ImageSimilarity {

	private final static Logger LOG = Logger.getLogger(ImageSimilarity.class .getName()); 
	
	private static void setup()
	{
		// TODO: Do iniitial setup of Semaphore, Multithreading etc. for this class, or other great stuff.
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		// Set up the logger
		try {
			ISLogger.setup();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	throw new RuntimeException("Problems with creating the log files!");
	    }
		
		String path = null;
		
		// Set up path to image
		if (args.length > 0) 
		{
			// set image path
			path = args[0];
			
			Pattern path_pattern = Pattern.compile("[^\0]+");
			Pattern url_pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
			
			Matcher matcher = null;
			
			matcher = path_pattern.matcher(path);

			// If it is file
			if(matcher.find())
			{
				LOG.info("File Path found:" + path);
				
				// TODO: Check if file exists, if not throw exception
			}
			else
			{
				matcher = url_pattern.matcher(path);
				
				// If it is URL
				if(matcher.find())
				{
					LOG.info("URL Path found:" + path);
					
					// TODO: Download image from url
					// TODO: Save image on a new path, somwehere
					// TODO: Change the path variable to the new path of the image
				}
				else
				{
					LOG.severe("Not correct path: " + path + "!");
					throw new Exception("Not correct path! You can use file path or url path for this program.");
				}
			}
			
			// Run setup function.
			if(path != null)
			{
				setup();
			}
			else
			{
				LOG.severe("Path is null. What the hell?!");
				throw new Exception("Path is null. What the hell?!");
			}
			
			File file = new File(path);
			
			// Compare them
			try {
				Compare compare = new Compare(file);
				List<ImageHolder> images = compare.getResults();
				for(ImageHolder i : images)
				{
					System.out.println("Image: " + i.getFile().getPath());
					System.out.println("Distance: " + Double.toString(i.getDistance()));
				}
			} catch (Exception e) {
				LOG.severe("Comparision failed. Ooops!");
				throw new Exception("Comparision failed. Ooops!");
			}
		}
		else
		{
			LOG.severe("No argument passed to this program.");
			throw new Exception("You have to pass an argument to this application. File path or url path.");
		}
	}

}
