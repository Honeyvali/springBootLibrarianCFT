package com.gcit.lms;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.Branch;

/**
 * Handles requests for the application home page.
 */
@RestController
public class LibrarianController {
	
	private static final Logger logger = LoggerFactory.getLogger(LibrarianController.class);
	@Autowired
	BookCopiesDAO bookCopiesDao;
	@Autowired
	BranchDAO branchDao;
	@Autowired
	BookDAO bookDao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public List<Branch> getAllBranchs() {
		logger.info("Welcome home! Message from the POST Method "); 
		return branchDao.getAllBranchs();	
	}
	@RequestMapping(value = "/branch", method = RequestMethod.PUT)
	public void updateBranch(@RequestBody Branch branch) {
		logger.info("Welcome home! Message from the POST Method ");
		branchDao.updateBranch(branch);
	}
	@RequestMapping(value = "/book/{bookId}/branch/{branchId}", method = RequestMethod.GET)
	public Book getBookByIdAndBranchId(@PathVariable Integer bookId, @PathVariable Integer branchId) {
		logger.info("Welcome home! The client locale is {}.");
		return bookDao.getBookByIdAndBranchId(bookId, branchId);
	}
	@RequestMapping(value = "/book/{bookId}/branch/{branchId}/bookcopies", method = RequestMethod.GET)
	public BookCopies readBookCopies(@PathVariable Integer bookId, @PathVariable Integer branchId) {
		logger.info("Welcome home! The client locale is {}.");
		return bookCopiesDao.readBookCopies(bookId, branchId);
	}
	@RequestMapping(value = "/book/{bookId}/branch/{branchId}/bookcopies", method = RequestMethod.PUT)
	public void updateBookCopies(@RequestBody BookCopies bookCopies,@PathVariable Integer bookId,@PathVariable Integer branchId) {
		logger.info("Welcome home! Message from the POST Method ");
		bookCopiesDao.updateBookCopies(bookCopies, bookId, branchId);
	}
}
