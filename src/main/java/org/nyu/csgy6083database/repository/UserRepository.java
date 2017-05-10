/**
 * 
 */
package org.nyu.csgy6083database.repository;

import java.util.List;

import org.nyu.csgy6083database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author divyeshsurana
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

	@Query("select u from User u where u.username = :userName")
	User findByUserName(@Param("userName") String userName);

	// @Query("select u from User u where u.fname like :name or u.lname like
	// :name")
	@Query(value = "select from user where u.fname like :name or u.lname like :name", nativeQuery = true)
	List<User> findByName(@Param("name") String name);
}
