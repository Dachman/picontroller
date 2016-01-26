package com.picontroller.home.service;

/**
 * Interface for handling the webcam.
 * @author dcharles
 *
 */
public interface IWebcamService {

	/**
	 * Take a picture from the default webcam.
	 * @return true if managed to do so.
	 */
	boolean takeAShot();
}
