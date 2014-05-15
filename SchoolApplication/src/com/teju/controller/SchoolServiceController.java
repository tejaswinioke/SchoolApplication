package com.teju.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teju.dao.SchoolDAO;
import com.teju.domain.SchoolRecord;

/**
 * This Spring MVC controller extends RESThub REST controller to get the schools
 * as per the subject
 * 
 * @author Teju
 *
 */
@RestController
public class SchoolServiceController {

	// Create a DAO instance
	SchoolDAO schooldao = new SchoolDAO();

	/**
	 * This method is serves the specific request and respond with the list of
	 * schools The request URL could be
	 * "http://localhost:8080/SchoolApplication/schoolservice?subject=numeracy"
	 * 
	 * @param subject
	 *            It is the type of subject requested from UI
	 * @return It returns the list of schoolrecords
	 */
	@RequestMapping("/schoolservice")
	public @ResponseBody List<SchoolRecord> findSchoolsBySubject(
			@RequestParam(value = "subject") String subject) {

		// Call findSchool method of DAO
		List<SchoolRecord> schools = schooldao.findSchoolsBySubject(subject);
		return schools;
	}

}