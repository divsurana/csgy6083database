/**
 * 
 */
package org.nyu.csgy6083database.repository;

import java.util.List;

import org.nyu.csgy6083database.model.Comments;
import org.nyu.csgy6083database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author divyeshsurana
 *
 */
public interface CommentsRepository extends JpaRepository<Comments, String> {

	@Query("select c from Comments c where c.user = :user")
	public List<Comments> findCommentsByUser(@Param("user") User user);

	@Query(value = "select from comments c where c.projectid = :projectid", nativeQuery = true)
	public List<Comments> findCommentsByProject(@Param("projectid") String projectid);
}
