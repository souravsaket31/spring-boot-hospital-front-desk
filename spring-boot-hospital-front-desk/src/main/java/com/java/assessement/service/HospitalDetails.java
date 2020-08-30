package com.java.assessement.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.java.assessement.model.AppointmentDetails;
import com.java.assessement.model.Specialist;

@Component
@ConfigurationProperties
@PropertySource("classpath:specialist.properties")
public class HospitalDetails {

	private Specialist[] specialist;
	private AppointmentDetails[] appDetails;

	public Specialist[] getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist[] specialist) {
		this.specialist = specialist;
	}

	public AppointmentDetails[] getAppDetails() {
		return appDetails;
	}

	public void setAppDetails(AppointmentDetails[] appDetails) {
		this.appDetails = appDetails;
	}

}
