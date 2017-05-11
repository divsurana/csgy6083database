/**
 * 
 */
package org.nyu.csgy6083database.service;

import org.nyu.csgy6083database.model.Ratings;
import org.nyu.csgy6083database.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author divyeshsurana
 *
 */
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	private RatingsRepository ratingsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	public Ratings save(Ratings ratings) {
		return ratingsRepository.save(ratings);
	}

}
