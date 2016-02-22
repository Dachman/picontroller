package com.picontroller.home.properties;

import java.util.Map;

public interface IWebcamProperties {

	Map<String, Integer> getDimension();

	int getWidth();

	int getHeight();

	String getPath();

	String getFacesPath();

	String getFaceDetectionClassifierName();

}
