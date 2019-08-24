package com.Przemek.sflibrary.controllers;

import com.Przemek.sflibrary.model.User;
import com.Przemek.sflibrary.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/new_User")
    public String addUser(Model model){
        model.addAttribute("user", User.builder().build());
        return "users/addUserOrUpdate";
    }

    @PostMapping("/new_user")
    public String createAuthor(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "users/addUserOrUpdate";
        }
        else {
            User savedUser = userService.save(user);
            return "redirect:/users/" + savedUser.getId();
        }
    }

    @GetMapping("/{userId}/edit")
    public String updateAuthor(@PathVariable Long userId, Model model) {
        model.addAttribute(userService.findById(userId));
        return "users/addUserOrUpdate";
    }

    @PostMapping("/{userId}/edit")
    public String updateAuthorForm(@Valid User user, BindingResult result, @PathVariable Long userId) {
        if (result.hasErrors()) {
            return "users/addUserOrUpdate";
        } else {
            user.setId(userId);
            User savedUser = userService.save(user);
            return "redirect:/authors/" + savedUser.getId();
        }
    }


    @RequestMapping("/find_user")
    public String findAuthor(Model model){
        model.addAttribute("user", User.builder().build());
        return "users/findUsers";
    }

    @GetMapping
    public String findBy(User user, BindingResult result, Model model){
        if (user.getLastName() == null){
            user.setLastName("");
        }

        List<User> results = userService.findAllByLastName("%" + user.getLastName() + "%");

        if (results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "users/findUsers";
        }
        else if (results.size() == 1){
            return "redirect:/users/" + user.getId();
        }
        else {
            model.addAttribute("selections", results);
            return "users/userList";
        }
    }

    @GetMapping("/{userId}")
    public ModelAndView showAuthor(@PathVariable Long userId){
        String url;
        ModelAndView mav = new ModelAndView("users/userDetails");
        mav.addObject(userService.findById(userId));
        return mav;
    }
}
