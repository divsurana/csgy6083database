/**
 * 
 */
package org.nyu.csgy6083database.controller;

import javax.validation.Valid;

import org.nyu.csgy6083database.model.Comments;
import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.service.CommentsService;
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
@RequestMapping("/comments")
@SessionAttributes("user")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user, @Param("comments") Comments comments,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {

		} else {
			commentsService.save(comments);
			model.addAttribute("message", "Pledged successfully.");
			message = "redirect:/project/viewproject/" + comments.getProject().getProjectid();
		}

		return message;
	}

	@RequestMapping(value = "/own", method = RequestMethod.GET)
	public String viewOwnComments(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
		} else {

			model.addAttribute("comments", commentsService.findCommentsByUser(user));
			message = "yourcomments";
		}

		return message;
	}

	@RequestMapping(value = "/{projectid}", method = RequestMethod.GET)
	public String viewProjectComments(@Valid @ModelAttribute("user") User user, @PathVariable String projectid,
			BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
		} else {

			model.addAttribute("comments", commentsService.findCommentsByProject(projectid));
			message = "yourcomments";
		}

		return message;
	}
}
