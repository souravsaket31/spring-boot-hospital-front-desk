package com.java.assessement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java.assessement.model.Specialist;

@RestController
public class ConsumeRestAPI {

	@Autowired
	RestTemplate restTemplate;
	public static final String URL_XML = "http://localhost:8080/getspecialistxml/fetchAllDetails/";
	public static final String URL_JSON = "http://localhost:8080/getspecialistjson/fetchAllDetails/";

	@GetMapping(value = "${api.reqXml}", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Specialist> restMethodXml() {
		ResponseEntity<Specialist[]> specialist = restTemplate.getForEntity(URL_XML, Specialist[].class);

		return Arrays.asList(specialist.getBody());
	}

	@GetMapping(value = "${api.reqJson}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Specialist> restMethodJson() {
		ResponseEntity<Specialist[]> specialist = restTemplate.getForEntity(URL_JSON, Specialist[].class);

		return Arrays.asList(specialist.getBody());
	}

}
