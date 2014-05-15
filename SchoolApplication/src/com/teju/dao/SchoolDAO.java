package com.teju.dao;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teju.domain.SchoolRecord;
import com.teju.repository.SchoolsRepository;

/**
 * This class acts as layer between repository and controller This class hides
 * the implementation of MongoRepository which is very specific to database
 * 
 * @author Teju
 *
 */

public class SchoolDAO {

	// Create instances
	private SchoolsRepository schoolsRepository;
	private AbstractApplicationContext appContext;

	/**
	 * The actual call to repository which in turn gets the data from database
	 * 
	 * @param subject
	 * @return list of schoolrecords
	 */
	public List<SchoolRecord> findSchoolsBySubject(String subject) {

		// get hold of context to get the repository instance
		// TODO Find the other option to get the repository instance as context
		// usage is not a good idea
		appContext = new ClassPathXmlApplicationContext(
				"springdata-context.xml");
		schoolsRepository = appContext.getBean(SchoolsRepository.class);

		return schoolsRepository.findBySubject(subject);

	}

	/**
	 * @param schoolsRepository
	 *            the schoolsRepository to set
	 */
	public void setSchoolsRepository(SchoolsRepository schoolsRepository) {
		this.schoolsRepository = schoolsRepository;
	}

}
