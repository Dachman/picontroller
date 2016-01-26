package com.picontroller.home.service;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sarxos.webcam.Webcam;
import com.picontroller.home.properties.IWebcamProperties;

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

	@Override
	public boolean takeAShot() {
		log.debug("Taking a shot with the default webcam.");

		try {
			Webcam webcam = Webcam.getDefault();
			webcam.setViewSize(new Dimension(webcamProperties.getWidth(), webcamProperties.getHeight()));
			webcam.open();

			// Take a shot and save it to a file.
			BufferedImage image = webcam.getImage();
			ImageIO.write(image, "PNG", new File(webcamProperties.getPath() + UUID.randomUUID() + ".png"));
			
			return true;
		} catch (Exception e) {
			log.error("Unable to take a shot.", e);
			return false;
		}
	}

}
