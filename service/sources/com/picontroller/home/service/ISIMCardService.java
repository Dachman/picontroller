package com.picontroller.home.service;

/**
 * 
 * @author dcharles
 *
 *         SIM card management interface.
 *
 */
public interface ISIMCardService {

	/** Send a SMS message */
	void sendSMS(String number, String message);

	/** Get modem signal level */
	int getSignalLevel();
}
