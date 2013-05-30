/**
 * 
 */
package com.is.general;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.is.utils.ISLogger;

/**
 * @author Grzegorz Polek <grzegorz.polek@gmail.com>
 *
 */
public class ImageSimilarity {

	private final static Logger LOG = Logger.getLogger(ImageSimilarity.class .getName()); 
	
	private static void setup()
	{
		
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
				
				// TODO: Load image from file path to program's memory
			}
			else
			{
				matcher = url_pattern.matcher(path);
				
				// If it is URL
				if(matcher.find())
				{
					LOG.info("URL Path found:" + path);
					
					// TODO: Load image from URL to program's memory
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
		}
		else
		{
			LOG.severe("No argument passed to this program.");
			throw new Exception("You have to pass an argument to this application. File path or url path.");
		}
	}

}
