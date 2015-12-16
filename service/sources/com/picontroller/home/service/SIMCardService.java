package com.picontroller.home.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.GatewayException;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;
import org.springframework.beans.factory.annotation.Autowired;

import com.picontroller.home.properties.SimProperties;
import com.picontroller.home.service.util.SMSInboundNotification;

@org.springframework.stereotype.Service("simCardService")
public class SIMCardService implements ISIMCardService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SimProperties simProperties;

	/** Gateway */
	private SerialModemGateway gateway;

	@PostConstruct
	private void InitializeSIMCardService() {
		try {
			log.info("Initializing the gateway to the mobile network with the parameters: Port:"
					+ simProperties.getGatewayPort() + ", BaudRate:" + simProperties.getGatewayBaudRate()
					+ ", Manufacturer:" + simProperties.getGatewayManufacturer() + ", Gateway name:"
					+ simProperties.getGatewayName());
			gateway = new SerialModemGateway(simProperties.getGatewayManufacturer(), simProperties.getGatewayPort(),
					simProperties.getGatewayBaudRate(), simProperties.getGatewayManufacturer(),
					simProperties.getGatewayName());
			Service.getInstance().addGateway(gateway);
			Service.getInstance().startService();
			gateway.setSmscNumber(simProperties.getSmscNumber());
			gateway.setOutbound(true);
			gateway.setInbound(true);
			gateway.setSimPin(simProperties.getSimPin());
		} catch (TimeoutException e) {
			log.error(e.getMessage(), e);
		} catch (GatewayException e) {
			log.error(e.getMessage(), e);
		} catch (SMSLibException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}

	@Override
	public void initInboundMessageNotification() {
		if (gateway != null) {
			try {
				Service.getInstance().setInboundMessageNotification(new SMSInboundNotification());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		} else {
			log.error("Tried to initialize the inbound message notification handler but no gateway initialized");
		}
	}

	@Override
	public void sendSMS(String number, String message) {
		if (gateway != null) {
			OutboundMessage outboundMessage = new OutboundMessage(number, message);
			try {
				gateway.sendMessage(outboundMessage);
			} catch (Exception e) {
				log.error("Error while sending a messge to " + number + ". Message: " + message + ". Error: "
						+ e.getMessage(), e);
			}
		} else {
			log.error("Tried to initialize the inbound message notification handler but no gateway initialized");
		}
	}

	@Override
	public int getSignalLevel() {
		if (gateway != null) {
			try {
				return gateway.getSignalLevel();
			} catch (Exception e) {
				try {
					log.error("Unable to retrieve the signal level from the gateway " + gateway.getManufacturer() + ".",
							e);
				} catch (Exception ex) {
					log.error("Unable to retrieve the signal level and the model name from the gateway.", ex);
				}
				return 0;
			}
		} else {
			return 0;
		}
	}

}
