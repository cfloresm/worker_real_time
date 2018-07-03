package com.gohan.button.worker;

public class Protocol {
	
	private char transacctionCode;
	private String vehicleID;
	private String communicationID;
	private String IMEI;
	private String unitIdentifier;
	private String timePosition;
	private String latitude;
	private String longitud;
	private String speed;
	private String heading;
	private String valid;
	private String alarmState;
	public char getTransacctionCode() {
		return transacctionCode;
	}
	public void setTransacctionCode(char transacctionCode) {
		this.transacctionCode = transacctionCode;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getCommunicationID() {
		return communicationID;
	}
	public void setCommunicationID(String communicationID) {
		this.communicationID = communicationID;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getUnitIdentifier() {
		return unitIdentifier;
	}
	public void setUnitIdentifier(String unitIdentifier) {
		this.unitIdentifier = unitIdentifier;
	}
	public String getTimePosition() {
		return timePosition;
	}
	public void setTimePosition(String timePosition) {
		this.timePosition = timePosition;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getAlarmState() {
		return alarmState;
	}
	public void setAlarmState(String alarmState) {
		this.alarmState = alarmState;
	}
}
