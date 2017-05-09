/**
 * 
 */
package org.nyu.csgy6083database.repository;

import java.util.List;

import org.nyu.csgy6083database.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author divyeshsurana
 *
 */
public interface CategoryRepository extends JpaRepository<Category, String> {

	@Query("select c from Category c where c.categoryname = :name")
	Category find(@Param("name") String name);

	@Query("select c from Category c where c.categoryname like :name")
	List<Category> findByName(@Param("name") String name);
}
