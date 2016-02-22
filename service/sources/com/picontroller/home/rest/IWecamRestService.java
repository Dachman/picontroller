package com.picontroller.home.rest;

/**
 * Webcam rest services interface.
 * 
 * @author dcharles
 *
 */
public interface IWecamRestService {

	/**
	 * Take a shot.
	 * @return true if succeed.
	 */
	boolean takeAShot();
	
	/**
	 * Get a face.
	 * @param name Name associated to the face
	 * @return true if succeed.
	 */
	boolean getFace(String name);

}
