package com.picontroller.home.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picontroller.home.service.IWebcamService;

/**
 * Webcam rest services implementation.
 * 
 * @author dcharles
 *
 */
@RestController
public class WebcamRestService implements IWecamRestService {

	@Autowired
	IWebcamService webcamService;

	@Override
	@RequestMapping("/shoot")
	public @ResponseBody boolean takeAShot() {
		return webcamService.takeAShot();
	}

}
