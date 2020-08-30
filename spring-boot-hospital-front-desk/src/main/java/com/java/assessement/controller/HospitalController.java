package com.java.assessement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.assessement.exception.ResourceNotFoundException;
import com.java.assessement.model.AppointmentDetails;
import com.java.assessement.model.Hospital;
import com.java.assessement.model.Specialist;
import com.java.assessement.service.HospitalDetails;
import com.java.assessement.service.HospitalDetailsService;

@RestController
public class HospitalController {

	@Autowired
	HospitalDetails hospitalDetails;

	@Autowired
	HospitalDetailsService hospitalDetailsService;

	@Autowired
	Hospital hospital;

	public void justPrint() {
		for (Hospital h : hospitalDetailsService.getHospitalList()) {
			System.out.println("Hospital Name");
			System.out.println(h.getHospitalName());
		}
	}

	@GetMapping(value = "${api.getAllXml}", produces = MediaType.APPLICATION_XML_VALUE)
	public Specialist[] getSpecialistDetailsXml() {
		return hospitalDetails.getSpecialist();
	}

	@GetMapping(value = "${api.getAllJson}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Specialist[] getSpecialistDetailsJSON() {
		return hospitalDetails.getSpecialist();
	}

	@GetMapping(value = "${api.getspecialistjson}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Specialist validateDetailsJSON(@PathVariable String name, @PathVariable String specialist)
			throws ResourceNotFoundException {

		boolean flag = false;
		System.out.println("Validation Done");
		System.out.println(hospitalDetails.getSpecialist()[0].getName());
		System.out.println(hospitalDetails.getSpecialist()[1].getName());

		for (Specialist sp : hospitalDetails.getSpecialist()) {

			if (specialist.equalsIgnoreCase(sp.getType())) {
				System.out.println("Found");
				flag = true;
				return sp;
			} else {
				continue;
			}
		}
		if (flag == false) {
			System.out.println("No Details Found");
			throw new ResourceNotFoundException("No Details Found");
		}

		return null;
	}

	@GetMapping(value = "${api.getspecialistxml}", produces = MediaType.APPLICATION_XML_VALUE)
	public Specialist validateDetailsXML(@PathVariable String name, @PathVariable String specialist)
			throws ResourceNotFoundException {

		boolean flag = false;
		System.out.println("Validation Done: " + name + " " + specialist);
		System.out.println(hospitalDetails.getSpecialist()[0].getName());
		System.out.println(hospitalDetails.getSpecialist()[1].getName());

		/*
		 * for(Hospital h : hospitalDetailsService.getHospitalList() ) {
		 * System.out.println("Hospital Name"); System.out.println(h.getHospitalName());
		 * }
		 */

		for (Specialist sp : hospitalDetails.getSpecialist()) {

			if (specialist.equalsIgnoreCase(sp.getType())) {
				System.out.println("Found");
				flag = true;
				return sp;
			} else {
				continue;
			}
		}
		if (flag == false) {
			System.out.println("No Details Found");
			throw new ResourceNotFoundException("No Details Found");
		}

		return null;
	}
	
	//http://localhost:8080/bookappointmentjson/Sandhya/Tuesday/Stuart
	//http://localhost:8080/bookappointmentjson/Edward/Tuesday/Suganthi
	//api.getappointment=/bookappointmentjson/{specialistName}/{appointmentDay}/{patientName}

	@GetMapping(value = "${api.getappointment}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentDetails getAppointmentJSON(@PathVariable String specialistName,

			 @PathVariable String appointmentDay, @PathVariable String patientName) throws ResourceNotFoundException {

		boolean found = false;
		System.out.println(hospitalDetails.getAppDetails()[0].getAppointmentDay());
		System.out.println(hospitalDetails.getAppDetails()[0].getSpecialistName());
		System.out.println(specialistName);
		System.out.println(appointmentDay);
		System.out.println(patientName);
		for (AppointmentDetails ad : hospitalDetails.getAppDetails()) {
			if (specialistName.equalsIgnoreCase(ad.getSpecialistName())
					&& appointmentDay.equalsIgnoreCase(ad.getAppointmentDay())
					&& patientName.equalsIgnoreCase(ad.getPatientName())) {
				System.out.println("Found !! ");
				found = true;
				return ad;
			} else {
				continue;
			}
		}

		if (found == false) {
			System.out.println("Not Found !! ");
			throw new ResourceNotFoundException("No Details Found");

		}

		return null;
	}

	@GetMapping(value = "${api.getBed}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int fetchNumOfBedsAvailable(@PathVariable String hospitalName)
			throws ResourceNotFoundException, InterruptedException {
		System.out.println(hospitalName);
		return hospitalDetailsService.getNumberOfBeds(hospitalName);
	}

}
