/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Comments;
import org.nyu.csgy6083database.model.User;

/**
 * @author divyeshsurana
 *
 */
public interface CommentsService extends Service<Comments> {

	/**
	 * @param user
	 * @return
	 */
	List<Comments> findCommentsByUser(User user);

}
