/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.nyu.csgy6083database.model.Project;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author divyeshsurana
 *
 */
@Controller
@RequestMapping("/project")
@SessionAttributes("user")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/newproject", method = RequestMethod.GET)
	public String newProject(@Valid @ModelAttribute User user, Model model) {
		logger.info("User: " + user.getUsername() + " posting a new project.");
		return "postaproject";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user, @Param("project") Project project,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			projectService.save(project);
			model.addAttribute("message", "Project successfully created.");
			logger.info("User: " + user.getUsername() + " creating project.");
			message = "redirect:/user/" + user.getUsername();
		}

		return message;
	}

	@RequestMapping(value = "/projectsbyowner", method = RequestMethod.GET)
	public String getProjectsByOwner(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			model.addAttribute("projects", projectService.findProjectByOwner(user));
			logger.info("User: " + user.getUsername() + " viewing own projects.");
			message = "viewmanyprojects";
		}

		return message;
	}

	@RequestMapping(value = "/recommendedprojects", method = RequestMethod.GET)
	public String getRecommendedProjects(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			model.addAttribute("projects", projectService.findRecommendedProjects(user));
			logger.info("User: " + user.getUsername() + " viewing recommended projects.");
			message = "viewmanyprojects";
		}

		return message;
	}

	@RequestMapping(value = "/viewproject", method = RequestMethod.GET)
	public String getProjectByCategory(@Valid @ModelAttribute("user") User user, @Param("categoryid") String categoryid,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			model.addAttribute("projects", projectService.findProjectsByCategory(categoryid));
			logger.info("User: " + user.getUsername() + " viewing category projects.");
			message = "viewmanyprojects";
		}

		return message;
	}

	@RequestMapping(value = "/viewproject/{projectid}", method = RequestMethod.GET)
	public String viewProject(@Valid @ModelAttribute("user") User user, @PathVariable String projectId,
			BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			model.addAttribute("project", projectService.findProject(projectId));
			message = "viewoneproject";
		}

		return message;
	}
}
