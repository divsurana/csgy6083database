/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.nyu.csgy6083database.model.Project;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user, @Param("project") Project project,
			BindingResult result, Model model) {
		// TODO: Add redirection page.
		String message = "";
		if (result.hasErrors()) {

		} else {
			projectService.save(project);
			model.addAttribute("message", "Project successfully created.");
		}

		return message;
	}

	@RequestMapping(value = "/projectsbyowner", method = RequestMethod.GET)
	public String getProjectsByOwner(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {
		} else {
			model.addAttribute("projects", projectService.findProjectByOwner(user));
			System.out.println(model.containsAttribute("projects"));
			message = "viewmanyprojects";
		}

		return message;
	}

	@RequestMapping(value = "/recommendedprojects", method = RequestMethod.GET)
	public String getRecommendedProjects(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {

		} else {
			//model.addAttribute("projects", projectService.findRecommendedProjects(user));
			message = "viewmanyprojects";
		}

		return message;
	}
}
