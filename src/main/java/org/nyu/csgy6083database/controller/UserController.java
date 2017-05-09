/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "firstpage";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		String message = "";
		if (result.hasErrors()) {
			message = "firstpage";
		} else if (userService.isUserExists(user.getUsername())) {
			model.addAttribute("message", "User Name exists. Try another username.");
			message = "firstpage";
		} else {
			userService.save(user);
			model.addAttribute("message", "Saved User details");
			message = "redirect:login.html";
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
			message = "dashboard";
		} else {
			model.addAttribute("message", "Login failed. Username or Password incorrect.");
			message = "firstpage";
		}

		return message;
	}
}
