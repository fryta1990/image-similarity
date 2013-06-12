package com.is.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

	public static boolean url(String url)
	{
		Pattern url_pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		
		Matcher matcher = null;
		
		matcher = url_pattern.matcher(url);
		
		return matcher.find();
	}
	
	public static boolean path(String path)
	{
		Pattern path_pattern = Pattern.compile("[^\0]+");
		
		Matcher matcher = null;
		
		matcher = path_pattern.matcher(path);
		
		return matcher.find();
	}
}
