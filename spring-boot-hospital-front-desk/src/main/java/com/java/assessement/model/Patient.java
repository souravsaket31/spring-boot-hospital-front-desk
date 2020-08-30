package com.java.assessement.model;

public class Patient {

	private String patientName;
	private String patientStatus;

	public Patient(String patientName, String patientStatus) {
		super();
		this.patientName = patientName;
		this.patientStatus = patientStatus;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

}
