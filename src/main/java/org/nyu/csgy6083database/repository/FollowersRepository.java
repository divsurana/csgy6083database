/**
 * 
 */
package org.nyu.csgy6083database.repository;

import java.util.List;

import org.nyu.csgy6083database.model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author divyeshsurana
 *
 */
public interface FollowersRepository extends JpaRepository<Followers, String> {

	/**
	 * @param username
	 * @return
	 */
	@Query("select from followers f where f.userfollowed = :username")
	public List<Followers> findFollowers(@Param("userName") String username);

	/**
	 * @param username
	 * @return
	 */
	@Query("select from followers f where f.userfollower = :username")
	public List<Followers> findFollowed(@Param("userName") String username);

}
