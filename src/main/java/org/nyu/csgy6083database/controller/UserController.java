/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		logger.info("User: " + user.getUsername() + " signing up.");
		return "firstpage";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		String message = "firstpage";
		if (result.hasErrors()) {
			message = "errorpage";
		} else if (userService.isUserExists(user.getUsername())) {
			model.addAttribute("message", "User Name exists. Try another username.");
			logger.info("User: " + user.getUsername() + " exists.");
		} else {
			userService.save(user);
			model.addAttribute("message", "Saved User details. Please login.");
			logger.info("User: " + user.getUsername() + " signed up.");
		}

		return message;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "firstpage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		String message = "";
		if (result.hasErrors()) {
			message = "firstpage";
		} else if (userService.findByLogin(user.getUsername(), user.getPassword())) {
			model.addAttribute("message", "Welcome back.");
			logger.info("User: " + user.getUsername() + " logged in.");
			message = "redirect:/user/" + user.getUsername();
		} else {
			model.addAttribute("message", "Login failed. Username or Password incorrect.");
			message = "firstpage";
		}

		return message;
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String viewDashboard(@Valid @ModelAttribute("user") User user, @PathVariable String username,
			BindingResult result, Model model) {
		String message = "errorpage";
		if (user.getUsername().equals(username)) {
			logger.info("User: " + user.getUsername() + " viewing dashboard.");
			message = "dashboard";
		}

		return message;
	}

	@RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
	public String viewProfile(@Valid @ModelAttribute("user") User user, @PathVariable String username,
			BindingResult result, Model model) {
		String message = "errorpage";
		if (result.hasErrors()) {
			message = "errorpage";
		} else if (user.getUsername().equals(username)) {
			logger.info("User: " + user.getUsername() + " viewing own profile.");
			message = "userprofile";
		} else {
			model.addAttribute("fetchUser", userService.findByUserName(username));
			logger.info("User: " + user.getUsername() + " viewing profile of user " + username);
			message = "userprofile";
		}

		return message;
	}

}
