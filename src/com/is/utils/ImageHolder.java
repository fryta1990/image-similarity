package com.is.utils;

import java.awt.image.RenderedImage;
import java.io.File;

public class ImageHolder {

	File file = null;
	RenderedImage render = null;
	double distance = 11041; // 0 - 11041
	
	public ImageHolder(File file, RenderedImage render, double distance)
	{
		this.file = file;
		this.render = render;
		this.distance = distance;
	}
	
	public File getFile()
	{
		return this.file;
	}
	
	public RenderedImage getRender()
	{
		return this.render;
	}
	
	public double getDistance()
	{
		return this.distance;
	}
	
	public double getDifference()
	{
		return this.distance;
	}
	
}
