package com.picontroller.home.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.AGateway.Protocols;
import org.smslib.IInboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
import org.springframework.beans.factory.annotation.Autowired;

import com.picontroller.home.properties.ISimProperties;

@org.springframework.stereotype.Service("simCardService")
public class SIMCardService implements ISIMCardService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ISimProperties simProperties;

	@Autowired
	IInboundMessageNotification smsInboudNotification;

	/** SIM gateway. */
	private SerialModemGateway gateway;

	@PostConstruct
	private void InitializeSIMCardService() {

		if (!simProperties.getGatewayName().equals(""))
			try {
				log.info("Initializing the gateway to the mobile network with the parameters: Port:" + simProperties.getGatewayPort() + ", BaudRate:" + simProperties
						.getGatewayBaudRate() + ", Manufacturer:" + simProperties.getGatewayManufacturer() + ", Gateway name:" + simProperties.getGatewayName() + ".");

				gateway = new SerialModemGateway(simProperties.getGatewayManufacturer(), simProperties.getGatewayPort(), simProperties.getGatewayBaudRate(), simProperties.getGatewayManufacturer(),
						simProperties.getGatewayName());

				gateway.setSmscNumber(simProperties.getSmscNumber());
				gateway.setSimPin(simProperties.getSimPin());
				gateway.setProtocol(Protocols.PDU);
				gateway.setInbound(true);
				gateway.setOutbound(true);
				initInboundMessageNotification();

				Service.getInstance().addGateway(gateway);
				Service.getInstance().startService();
				log.info("Gateway initialized. SMScNumber is " + gateway.getSmscNumber() + ", PIN is " + gateway.getSimPin() + ".");

			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
	}

	/**
	 * Initialize the inbound message notification handler.
	 */
	private void initInboundMessageNotification() {
		if (gateway != null) {
			try {
				log.error("Initializing the inbound message notification handler.");
				Service.getInstance().setInboundMessageNotification(smsInboudNotification);
			} catch (Exception e) {
				log.error("Error while initializing the inbound message notification handler." + e);
			}
		} else {
			log.error("Tried to initialize the inbound message notification handler but no gateway initialized");
		}
	}

	@Override
	public void sendSMS(String number, String message) {
		if (gateway != null) {
			log.info("Sending a SMS to " + number + ". Message: " + message + ".");
			final OutboundMessage outboundMessage = new OutboundMessage(number, message);
			try {
				if (Service.getInstance().sendMessage(outboundMessage)) {
					log.info("Message sent.");
					// TODO - Persist the message sent.
				} else {
					log.error("Failed to send the message.");
				}
			} catch (Exception e) {
				log.error("Error while sending a SMS to " + number + ". Message: " + message + ". Error: " + e.getMessage(), e);
			}
		} else {
			log.error("Tried to send a SMS to " + number + ". Message: '" + message + "' but the gateway is not initialized.");
		}
	}

	@Override
	public int getSignalLevel() {
		if (gateway != null) {
			try {
				return gateway.getSignalLevel();
			} catch (Exception e) {
				try {
					log.error("Unable to retrieve the signal level from the gateway " + gateway.getManufacturer() + ".", e);
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
