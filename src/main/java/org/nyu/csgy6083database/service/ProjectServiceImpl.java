/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.nyu.csgy6083database.model.Category;
import org.nyu.csgy6083database.model.Project;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author divyeshsurana
 *
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private CategoryService categoryService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Project> findProjectByOwner(User user) {
		return projectRepository.findProjectByOwner(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Project> findTopProjects() {
		return projectRepository.findTopProjects();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Project> findRecommendedProjects(User user) {
		List<String> interests = Arrays.asList(user.getInterests().split(","));
		List<Category> categories = categoryService.findAll();
		List<String> relevantCategories = new ArrayList<>();
		for (Category category : categories) {
			if (interests.contains(category.getCategoryname())) {
				relevantCategories.add(category.getCategoryid());
			}
		}

		return projectRepository.findProjectsByCategories(relevantCategories);
	}
}
