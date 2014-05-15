package com.teju.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teju.domain.SchoolRecord;
import java.lang.String;
import java.util.List;

/**
 * This interface implements Mongo style repository to fetch the data
 * @author Teju
 *
 */
@Repository
public interface SchoolsRepository extends
		MongoRepository<SchoolRecord, String> {

	/**
	 * This method's implementation is available by MongoRepository
	 * @param subject
	 * @return list of schools
	 */
	List<SchoolRecord> findBySubject(String subject);
}
