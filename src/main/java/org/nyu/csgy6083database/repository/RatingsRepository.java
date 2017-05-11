/**
 * 
 */
package org.nyu.csgy6083database.repository;

import org.nyu.csgy6083database.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author divyeshsurana
 *
 */
public interface RatingsRepository extends JpaRepository<Ratings, String> {

}
