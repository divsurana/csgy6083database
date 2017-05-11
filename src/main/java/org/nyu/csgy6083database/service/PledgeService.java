/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Pledge;
import org.nyu.csgy6083database.model.User;

/**
 * @author divyeshsurana
 *
 */
public interface PledgeService extends Service<Pledge> {

	/**
	 * @param projectid
	 * @return
	 */
	public List<Pledge> findPledgeByProject(String projectid);

	/**
	 * @param user
	 * @return
	 */
	public List<Pledge> findPledgeByUser(User user);

	/**
	 * @param user
	 * @return
	 */
	public List<Pledge> findBilledPledgesOfUser(User user);

}
