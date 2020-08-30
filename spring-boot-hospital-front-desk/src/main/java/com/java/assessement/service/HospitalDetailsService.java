package com.java.assessement.service;

import java.util.ArrayList;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.java.assessement.exception.ResourceNotFoundException;
import com.java.assessement.model.Hospital;
import com.java.assessement.model.Patient;

@Service
public class HospitalDetailsService {

	ArrayList<Hospital> al;

	@Cacheable("fetchnoofbed")
	public int getNumberOfBeds(String hospitalName) throws ResourceNotFoundException, InterruptedException {
		try {
			int disCharge = 0;// 15
			boolean flag = false;
			int numOfBedsAvailable = Integer.MIN_VALUE;
			ArrayList<Hospital> al = new ArrayList<>();

			al.add(new Hospital("RIIMS", 10, new Patient("Rahul", "Discharged")));
			al.add(new Hospital("RIIMS", 10, new Patient("Suganthi", "Admitted")));
			al.add(new Hospital("Apollo", 5, new Patient("Sonal", "Discharged")));
			al.add(new Hospital("Apollo", 5, new Patient("Sanjay", "Admitted")));
			al.add(new Hospital("PMCH", 7, new Patient("Raj", "Admitted")));

			for (Hospital a : al) {
				if (a.getHospitalName().equalsIgnoreCase(hospitalName)) {
					flag = true;
					numOfBedsAvailable = a.getNumberOfBeds();// 20

					if (a.getPatient().getPatientStatus().equalsIgnoreCase("Discharged")) {
						disCharge++;
					}
				}

			}
			numOfBedsAvailable = numOfBedsAvailable - disCharge;

			if (!flag) {
				System.out.println("Invalid Hospital Name !!");
				throw new ResourceNotFoundException("Hospital not Found");

			}
			/*
			 * Thread.sleep(5000); System.out.println("Taking rest for 5 seconds");
			 */

			return numOfBedsAvailable;
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Hospital not Found");
		}
	}

	public ArrayList<Hospital> getHospitalList() {
		return al;
	}
}
