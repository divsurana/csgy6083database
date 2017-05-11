/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Followers;

/**
 * @author divyeshsurana
 *
 */
public interface FollowersService extends Service<Followers> {

	/**
	 * @param username
	 * @return
	 */
	public List<Followers> getFollowers(String username);

	/**
	 * @param username
	 * @return
	 */
	public List<Followers> getFollowed(String username);

}
