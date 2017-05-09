/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Category;

/**
 * @author divyeshsurana
 *
 */
public interface CategoryService extends Service<Category> {

	public List<Category> findByName(String name);

	public Category find(String name);

}
