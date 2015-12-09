package com.picontroller.home.service;

import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

import com.picontroller.home.service.util.SMSInboundNotification;

public class SIMCardService implements ISIMCardService {

	@Override
	public void initInboundMessageNotification() {
		SerialModemGateway gateway = new SerialModemGateway("", port, 9600, "InterCEL", "");
		Service.getInstance().addGateway(gateway);
		Service.getInstance().startService();
		// System.out.println("center number=" + gateway.getSmscNumber());
		gateway.setSmscNumber(SMSC);
		gateway.setOutbound(true); 

		OutboundMessage o = new OutboundMessage(number, str);
		gateway.sendMessage(o);
		
		gateway.setInbound(true);
		Service.getInstance().setInboundMessageNotification(new SMSInboundNotification());
	}

}
