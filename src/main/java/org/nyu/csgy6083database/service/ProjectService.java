/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Project;
import org.nyu.csgy6083database.model.User;

/**
 * @author divyeshsurana
 *
 */
public interface ProjectService extends Service<Project> {

	/**
	 * @param user
	 * @return
	 */
	public List<Project> findProjectByOwner(User user);

	/**
	 * @return
	 */
	public List<Project> findTopProjects();

}
