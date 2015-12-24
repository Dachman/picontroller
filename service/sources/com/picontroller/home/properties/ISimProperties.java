package com.picontroller.home.properties;

public interface ISimProperties {

	String getGatewayName();

	String getGatewayPort();

	int getGatewayBaudRate();

	String getSmscNumber();

	String getGatewayManufacturer();

	String getSimPin();

	String getForwardToNumber();

}