/**
 * 
 */
package org.nyu.csgy6083database.repository;

import org.nyu.csgy6083database.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author divyeshsurana
 *
 */
public interface CommentsRepository extends JpaRepository<Comments, String> {

}
