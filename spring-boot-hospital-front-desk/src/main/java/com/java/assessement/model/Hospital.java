package com.java.assessement.model;

import org.springframework.stereotype.Component;

@Component
public class Hospital {

	private String hospitalName;
	private Integer numberOfBeds;
	private Patient patient;

	public Hospital() {
		super();
	}

	public Hospital(String hospitalName, Integer numberOfBeds, Patient patient) {
		super();
		this.hospitalName = hospitalName;
		this.numberOfBeds = numberOfBeds;
		this.patient = patient;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
