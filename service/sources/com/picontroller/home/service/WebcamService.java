package com.picontroller.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picontroller.home.properties.IWebcamProperties;
import com.picontroller.home.service.util.WebcamManager;

/**
 * Webcam services.
 * 
 * @author dcharles
 *
 */
@Service("webcamSercice")
public class WebcamService implements IWebcamService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IWebcamProperties webcamProperties;

	@Autowired
	WebcamManager webcamManager;

	@Override
	public boolean captureImage() {
		return webcamManager.saveImagesToDisk(webcamManager.getFaces(webcamManager.getImagefromWebcam()));
	}

	@Override
	public boolean captureFace(String name) {
		return webcamManager.saveFaces(name, webcamManager.getFaces(webcamManager.getImagefromWebcam()));
	}

}
