package com.java.assessement.model;

import org.springframework.stereotype.Component;

@Component
public class Specialist {

	private String type;
	private String name;
	private String availableDay;
	private String availableTime;
	private Boolean isAvailable;
	private Integer hospitalId;

	public Specialist() {
		super();
	}

	public Specialist(String type, String name, String availableDay, String availableTime, Boolean isAvailable,
			Integer hospitalId) {
		super();
		this.type = type;
		this.name = name;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		this.isAvailable = isAvailable;
		this.hospitalId = hospitalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailableDay() {
		return availableDay;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}
