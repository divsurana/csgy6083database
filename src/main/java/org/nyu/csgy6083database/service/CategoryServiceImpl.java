/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Category;
import org.nyu.csgy6083database.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author divyeshsurana
 *
 */
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.nyu.csgy6083database.service.CategoryService#findByName(java.lang.
	 * String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Category> findByName(String name) {
		return categoryRepository.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.nyu.csgy6083database.service.CategoryService#find(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Category find(String name) {
		return categoryRepository.find(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
