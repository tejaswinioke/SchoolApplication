package com.teju.serviceclient;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.teju.domain.SchoolRecord;

// Testing service
public class TestSpringService {

	public static final String SERVER_URI = "http://localhost:8080/SchoolApplication/schoolservice";

	public static void main(String args[]) {

		testGetSchoolsBySubject("numeracy");

		System.out.println("*****");
		// testGetAllEmployee();
	}

	

	private static void testGetSchoolsBySubject(String subject) {
		RestTemplate restTemplate = new RestTemplate();
		List<SchoolRecord> records = restTemplate.getForObject(SERVER_URI
				+ "?subject=" + subject, List.class);
		for (SchoolRecord record : records) {
			System.out.println("in the test"+record.getSubject());
		}
	}


}
