package com.gcit.lms.dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gcit.lms.entity.Publisher;
/**
 * 
 * @author hvalipour
 *
 */
@Component
public class PublisherDAO {

	Logger logger = LoggerFactory.getLogger(PublisherDAO.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertPublisher(Publisher publisher) {
		String query = "INSERT INTO `newlibrary`.`tbl_publisher` (`publisherName`) VALUES (?);";
		int value = jdbcTemplate.update(query, new Object[] {publisher.getName() });
		logger.debug("returned value from backend is {}", value);
	}
	public void updatePublisher(Publisher publisher) {
		String query = "update tbl_publisher set publisherName = ? where publisherId = ?";
		int value = jdbcTemplate.update(query,new Object[] { publisher.getName(), publisher.getPubId() });
		logger.debug("returned value from backend is {}", value);
	}
	public void deletePublisher(Publisher publisher) {
		String query = "delete from tbl_publisher where publisherId = ?"; 
		int value = jdbcTemplate.update(query, new Object[] { publisher.getPubId() });
		logger.debug("returned value from backend is {}", value);
	}

}

