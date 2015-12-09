package com.picontroller.home.service.util;

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

	@Override
	public void process(AGateway gateway, MessageTypes messageType, InboundMessage message) {
		switch (messageType) {
		case INBOUND:
			System.out.println(
					">>> New Inbound message detected from " + "+" + message.getOriginator() + " " + message.getText());
			break;
		case STATUSREPORT:
			break;
		default:
			break;
		}
	}

}
