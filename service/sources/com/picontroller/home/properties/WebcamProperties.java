package com.picontroller.home.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Webcam properties.
 * 
 * @author dcharles
 *
 */
@Component("webcamProperties")
@ConfigurationProperties(prefix = "webcam")
public class WebcamProperties implements IWebcamProperties {
	private Map<String, Integer> dimension;
	private int width;
	private int height;
	private String path;

	@Override
	public int getWidth() {
		width = dimension.get("width");
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		height = dimension.get("height");
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public Map<String, Integer> getDimension() {
		return dimension;
	}

	public void setDimension(Map<String, Integer> dimension) {
		this.dimension = dimension;
	}

}
