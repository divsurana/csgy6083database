/**
 * 
 */
package org.nyu.csgy6083database.repository;

import java.util.List;

import org.nyu.csgy6083database.model.Project;
import org.nyu.csgy6083database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author divyeshsurana
 *
 */
public interface ProjectRepository extends JpaRepository<Project, String> {

	/**
	 * @param user
	 * @return
	 */
	@Query("select p from Project p where p.owner = :user")
	public List<Project> findProjectByOwner(@Param("user") User user);

	// TODO: Get the query for top 5 projects with most likes.
	@Query("select p from Project p where ")
	public List<Project> findTopProjects();

	/**
	 * @param relevantCategories
	 * @return
	 */
	@Query(value = "select from projects p where p.pcategory in (:categories)")
	public List<Project> findProjectsByCategories(@Param("categories") List<String> relevantCategories);
}
