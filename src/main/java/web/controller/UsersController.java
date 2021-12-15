package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    private UserServiceImpl service;

    @Autowired
    public UsersController (UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> userList = new ArrayList<>();
        userList = service.getAllUsers();
        System.out.println(userList.get(0));
        model.addAttribute("showUsers", userList);
        return "show_users";
    }
    @GetMapping("/add_user")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }
    @PostMapping("/add_user")
    public String saveUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.removeUserById(id);
        return "redirect:/";
    }
    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user){
        service.updateUser(user, id);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", service.getUser(id));
        return "/update";
    }
}
