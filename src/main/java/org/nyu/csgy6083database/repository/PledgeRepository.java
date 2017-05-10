/**
 * 
 */
package org.nyu.csgy6083database.repository;

import java.util.List;

import org.nyu.csgy6083database.model.Pledge;
import org.nyu.csgy6083database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author divyeshsurana
 *
 */
public interface PledgeRepository extends JpaRepository<Pledge, String> {

	// @Query("select p from pledge p where p.project = :project")
	@Query(value = "SELECT FROM PLEDGE WHERE projectid = :projectid", nativeQuery = true)
	public List<Pledge> findPledgeByProject(@Param("projectid") String projectId);

	@Query("select p from pledge p where p.sponsor = :user")
	public List<Pledge> findPledgeByUser(@Param("user") User user);

	@Query("select p from pledge p where p.isbilled = true and p.sponsor = :user")
	public List<Pledge> findBilledPledgesOfUser(@Param("user") User user);

}
