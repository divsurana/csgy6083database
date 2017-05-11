/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.nyu.csgy6083database.model.Followers;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.FollowersService;
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
@RequestMapping("/followers")
@SessionAttributes("user")
public class FollowersController {

	@Autowired
	private FollowersService followersService;

	@RequestMapping(value = "/follow", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user, @Param("follower") Followers followers,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			followersService.save(followers);
			model.addAttribute("message", "User followed.");
			message = "redirect:/user/" + followers.getUserfollowed().getUsername();
		}

		return message;
	}

	@RequestMapping(value = "/showfollowers/{username}", method = RequestMethod.GET)
	public String getFollowers(@Valid @ModelAttribute("user") User user, @PathVariable("username") String username,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			model.addAttribute("followers", followersService.getFollowers(username));
			// message = "redirect:/user/" +
			// followers.getUserfollowed().getUsername();
		}

		return message;
	}

	@RequestMapping(value = "/showfollowed/{username}", method = RequestMethod.GET)
	public String getFollowed(@Valid @ModelAttribute("user") User user, @PathVariable("username") String username,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
			message = "errorpage";
		} else {
			model.addAttribute("followers", followersService.getFollowed(username));
			// message = "redirect:/user/" +
			// followers.getUserfollowed().getUsername();
		}

		return message;
	}

}
