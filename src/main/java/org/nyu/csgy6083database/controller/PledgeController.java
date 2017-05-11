/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.nyu.csgy6083database.model.Pledge;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.PledgeService;
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
@RequestMapping("/pledge")
@SessionAttributes("user")
public class PledgeController {

	@Autowired
	private PledgeService pledgeService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user, @Param("pledge") Pledge pledge, BindingResult result,
			Model model) {
		String message = "";
		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			pledgeService.save(pledge);
			model.addAttribute("message", "Pledged successfully.");
			message = "redirect:/project/viewproject/" + pledge.getProject().getProjectid();
		}

		return message;
	}

	@RequestMapping(value = "/mypledges", method = RequestMethod.GET)
	public String getPledgesOfUser(@Valid @ModelAttribute("user") User user, @Param("isbilled") Boolean isbilled,
			BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			if (isbilled)
				model.addAttribute("pledges", pledgeService.findBilledPledgesOfUser(user));
			else
				model.addAttribute("pledges", pledgeService.findPledgeByUser(user));
			message = "yourpledges";
		}

		return message;
	}

	@RequestMapping(value = "/projectpledges/{projectid}", method = RequestMethod.GET)
	public String getPledgesOfProject(@Valid @ModelAttribute("user") User user, @PathVariable String projectId,
			BindingResult result, Model model) {
		String message = "";

		if (result.hasErrors()) {
			message = "errorpage";
		} else if (projectService.findProject(projectId).getOwner().equals(user)) {
			model.addAttribute("pledges", pledgeService.findPledgeByProject(projectId));
			message = "yourpledges";
		} else {
			model.addAttribute("message", "Not your project.");
			message = "redirect:/project/viewproject/" + projectId;
		}

		return message;
	}
}
