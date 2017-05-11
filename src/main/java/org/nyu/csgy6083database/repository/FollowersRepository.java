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
	@Query("select f from Followers f where f.userfollowed = :username")
	public List<Followers> findFollowers(@Param("username") String username);

	/**
	 * @param username
	 * @return
	 */
	@Query("select f from Followers f where f.userfollower = :username")
	public List<Followers> findFollowed(@Param("username") String username);

}
