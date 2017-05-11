/**
 * 
 */
package org.nyu.csgy6083database.repository;

import org.nyu.csgy6083database.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author divyeshsurana
 *
 */
public interface LikesRepository extends JpaRepository<Likes, String> {

}
