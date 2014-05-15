package com.teju.domain;

import org.springframework.data.annotation.Id;

/**
 * This class represents the model part. Its a document in MongoDB language
 * @author Teju
 *
 */
public class SchoolRecord {
	@Id
	private String id;

	private SchoolDetails school;
	private String subject;
	private double latestY3;
	private double latestY5;
	private double latestY7;
	private double latestY9;
	private double rawGainY3Y5;
	private double factoredGainY3Y5;
	private double glgY3Y5;
	private double latestGainInGainY3Y5;

	public SchoolRecord() {
	}

	/**
	 * @param school
	 * @param subject
	 * @param latestY3
	 * @param latestY5
	 * @param latestY7
	 * @param latestY9
	 * @param rawGainY3Y5
	 * @param factoredGainY3Y5
	 * @param glgY3Y5
	 * @param latestGainInGainY3Y5
	 */
	public SchoolRecord(SchoolDetails school, String subject, double latestY3,
			double latestY5, double latestY7, double latestY9,
			double rawGainY3Y5, double factoredGainY3Y5, double glgY3Y5,
			double latestGainInGainY3Y5) {
		super();
		this.school = school;
		this.subject = subject;
		this.latestY3 = latestY3;
		this.latestY5 = latestY5;
		this.latestY7 = latestY7;
		this.latestY9 = latestY9;
		this.rawGainY3Y5 = rawGainY3Y5;
		this.factoredGainY3Y5 = factoredGainY3Y5;
		this.glgY3Y5 = glgY3Y5;
		this.latestGainInGainY3Y5 = latestGainInGainY3Y5;
	}

	/**
	 * @return the school
	 */
	public SchoolDetails getSchool() {
		return school;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return the latestY3
	 */
	public double getLatestY3() {
		return latestY3;
	}

	/**
	 * @return the latestY5
	 */
	public double getLatestY5() {
		return latestY5;
	}

	/**
	 * @return the latestY7
	 */
	public double getLatestY7() {
		return latestY7;
	}

	/**
	 * @return the latestY9
	 */
	public double getLatestY9() {
		return latestY9;
	}

	/**
	 * @return the rawGainY3Y5
	 */
	public double getRawGainY3Y5() {
		return rawGainY3Y5;
	}

	/**
	 * @return the factoredGainY3Y5
	 */
	public double getFactoredGainY3Y5() {
		return factoredGainY3Y5;
	}

	/**
	 * @return the glgY3Y5
	 */
	public double getGlgY3Y5() {
		return glgY3Y5;
	}

	/**
	 * @return the latestGainInGainY3Y5
	 */
	public double getLatestGainInGainY3Y5() {
		return latestGainInGainY3Y5;
	}

	@Override
	public String toString() {
		return String.format("School --> id=" + id + " latestY3=" + latestY3
				+ "school name=" + school.getSchoolName());
	}

}