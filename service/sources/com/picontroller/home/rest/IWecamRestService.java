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

}
