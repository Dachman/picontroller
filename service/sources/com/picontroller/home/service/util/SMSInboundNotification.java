package com.picontroller.home.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Message.MessageTypes;

/**
 * Notification of inbound SMS messages.
 * 
 * @author dcharles
 *
 */
public class SMSInboundNotification implements IInboundMessageNotification {

	/** Logger. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void process(AGateway gateway, MessageTypes messageType, InboundMessage message) {
		switch (messageType) {
		case INBOUND:
			log.info(">>> New Inbound message detected from " + "+" + message.getOriginator() + " " + message.getText());
			break;
		case STATUSREPORT:
			break;
		default:
			break;
		}
	}

}
