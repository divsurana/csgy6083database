/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.User;

/**
 * @author divyeshsurana
 *
 */

public interface UserService extends Service<User> {

	boolean findByLogin(String userName, String password);

	List<User> findByName(String name);

	/**
	 * @param username
	 * @return
	 */
	User findByUserName(String userName);

	/**
	 * @param username
	 * @return
	 */
	boolean isUserExists(String userName);

}
