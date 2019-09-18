package common.controller;

import common.model.User;
import common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init() {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addUser(User user, Model model) {
		if (userService.addUser(user)==0) {
			model.addAttribute("message", "exception");
		} else {
			model.addAttribute("message", "success");
		}
		return "add";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String allUsers(Model model) {
		model.addAttribute("usersList", userService.getAllUsers());
		return "list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateUserGet(@RequestParam("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "update";
	}

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserPost(User user, Model model) {
		if (userService.updateUser(user)==0) {
			model.addAttribute("message", "exception");
			return "update";
		}
		return "redirect:/list";
    }
}
