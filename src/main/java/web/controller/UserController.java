package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.model.User;
import web.repository.UserRepository;


@Controller
@RequestMapping("/usr")
public class UserController {
    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "usr/allusers";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDAO.getUser(id));
        return "usr/personalpage";
    }

    @GetMapping("/newuser")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "usr/newuser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userDAO.addUser(user);
        return "redirect:/usr";
    }

    @GetMapping("/{id}/edituser")
    public String showEditUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAO.getUser(id));
        return "usr/edituser";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAO.editUser(id, user);
        return "redirect:/usr";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDAO.deleteUser(id);
        return "redirect:/usr";
    }
}
