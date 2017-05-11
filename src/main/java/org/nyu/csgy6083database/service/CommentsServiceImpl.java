/**
 * 
 */
package org.nyu.csgy6083database.service;

import org.nyu.csgy6083database.model.Comments;
import org.nyu.csgy6083database.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author divyeshsurana
 *
 */
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	public Comments save(Comments comments) {
		return commentsRepository.save(comments);
	}

}
