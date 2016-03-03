package com.picontroller.home.service;

/**
 * Interface for handling the webcam.
 * 
 * @author dcharles
 *
 */
public interface IWebcamService {

	/**
	 * Take a picture from the default webcam usign JavaCV.
	 * 
	 * @return true if managed to do so.
	 */
	boolean captureImage();

	/**
	 * Capture a face and save in the appropriate folder (name).
	 * 
	 * @param name
	 *            Name for the associated face.
	 * @return true if managed to do so.
	 */
	boolean captureFace(String name);

	/**
	 * Predict the name related to the face captured.
	 * 
	 * @return the name found.
	 */
	String predictFace();

	/**
	 * Start learning stored faces.
	 * 
	 * @return true if succeeded.
	 */
	boolean learnFaces();

	/**
	 * Predict a name for each samples in the faces path.
	 * 
	 * @return the corresponding names.
	 */
	String predictFacesFromSample();
}
