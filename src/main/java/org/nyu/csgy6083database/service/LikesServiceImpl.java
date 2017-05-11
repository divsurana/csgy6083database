/**
 * 
 */
package org.nyu.csgy6083database.service;

import javax.transaction.Transactional;

import org.nyu.csgy6083database.model.Likes;
import org.nyu.csgy6083database.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author divyeshsurana
 *
 */
@Service("likesService")
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesRepository likesRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public Likes save(Likes likes) {
		return likesRepository.save(likes);
	}

}
