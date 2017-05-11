/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.nyu.csgy6083database.model.Pledge;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.PledgeService;
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
@RequestMapping("/pledge")
@SessionAttributes("user")
public class PledgeController {

	@Autowired
	private PledgeService pledgeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user, @Param("pledge") Pledge pledge, BindingResult result,
			Model model) {
		// TODO: Add redirection url
		String message = "";
		if (result.hasErrors()) {

		} else {
			pledgeService.save(pledge);
			model.addAttribute("message", "Pledged successfully.");
			message = "redirect:/project/viewproject/" + pledge.getProject().getProjectid();
		}

		return message;
	}
}
