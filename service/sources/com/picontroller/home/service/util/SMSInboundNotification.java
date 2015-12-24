package com.picontroller.home.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Message.MessageTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.picontroller.home.properties.ISimProperties;
import com.picontroller.home.service.ISIMCardService;

/**
 * Notification of inbound SMS messages.
 * 
 * @author dcharles
 *
 */
@Component("smsInboudNotification")
public class SMSInboundNotification implements IInboundMessageNotification {

	@Autowired
	ISimProperties simProperties;

	@Autowired
	ISIMCardService simCardService;

	/** Logger. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void process(AGateway gateway, MessageTypes messageType, InboundMessage message) {
		switch (messageType) {
		case INBOUND:
			log.info("New SMS message received from " + "+" + message.getOriginator() + ". Message: " + message.getText() + ".");

			// TODO - Persist the message received.

			// Forward the message received.
			if (simProperties.getForwardToNumber() != null && !simProperties.getForwardToNumber().isEmpty()) {
				simCardService.sendSMS(simProperties.getForwardToNumber(), "From: " + message.getOriginator() + " Message:" + message.getText());
				// Delete the message.
				try {
					gateway.deleteMessage(message);
				} catch (Exception e) {
					log.error("Deleting message received. From: +" + message.getOriginator() + ". Message: " + message.getText() + ".");
				}
			}

			break;
		case STATUSREPORT:
			break;
		default:
			break;
		}
	}

}
