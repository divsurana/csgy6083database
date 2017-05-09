/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Project;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author divyeshsurana
 *
 */
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> findProjectByOwner(User user) {
		return projectRepository.findProjectByOwner(user);
	}

	@Override
	public List<Project> findTopProjects() {
		return projectRepository.findTopProjects();
	}
}
