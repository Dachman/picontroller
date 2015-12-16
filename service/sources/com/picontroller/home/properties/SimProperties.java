package com.picontroller.home.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Sim card and gateway configuration bean. Get the parameters from
 * application-xxx.properties
 * 
 * @author dcharles
 */
@Component
@ConfigurationProperties(prefix = "sim")
public class SimProperties {
	private String gatewayManufacturer;
	private String gatewayName;
	private String gatewayPort;
	private int gatewayBaudRate;
	private String smscNumber;
	private String simPin;

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getGatewayPort() {
		return gatewayPort;
	}

	public void setGatewayPort(String gatewayPort) {
		this.gatewayPort = gatewayPort;
	}

	public int getGatewayBaudRate() {
		return gatewayBaudRate;
	}

	public void setGatewayBaudRate(int gatewayBaudRate) {
		this.gatewayBaudRate = gatewayBaudRate;
	}

	public String getSmscNumber() {
		return smscNumber;
	}

	public void setSmscNumber(String smscNumber) {
		this.smscNumber = smscNumber;
	}

	public String getGatewayManufacturer() {
		return gatewayManufacturer;
	}

	public void setGatewayManufacturer(String gatewayManufacturer) {
		this.gatewayManufacturer = gatewayManufacturer;
	}

	public String getSimPin() {
		return simPin;
	}

	public void setSimPin(String simPin) {
		this.simPin = simPin;
	}

}
