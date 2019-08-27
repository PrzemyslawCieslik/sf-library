package com.Przemek.sflibrary.controllers;

import com.Przemek.sflibrary.model.User;
import com.Przemek.sflibrary.services.BookService;
import com.Przemek.sflibrary.services.MagazineService;
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
    private final BookService bookService;
    private final MagazineService magazineService;

    public UserController(UserService userService, BookService bookService, MagazineService magazineService) {
        this.userService = userService;
        this.bookService = bookService;
        this.magazineService = magazineService;
    }

    @InitBinder("/user")
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/new_User")
    public String addUser(Model model){
        model.addAttribute("user", User.builder().build());
        return "users/addUserOrUpdate";
    }

    @PostMapping("/new_user")
    public String createUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "users/addUserOrUpdate";
        }
        else {
            User savedUser = userService.save(user);
            return "redirect:/users/" + savedUser.getId();
        }
    }

    @GetMapping("/{userId}/edit")
    public String updateUser(@PathVariable Long userId, Model model) {
        model.addAttribute(userService.findById(userId));
        return "users/addUserOrUpdate";
    }

    @PostMapping("/{userId}/edit")
    public String updateUserForm(@Valid User user, BindingResult result, @PathVariable Long userId) {
        if (result.hasErrors()) {
            return "users/addUserOrUpdate";
        } else {
            user.setId(userId);
            User savedUser = userService.save(user);
            return "redirect:/users/" + savedUser.getId();
        }
    }


    @RequestMapping("/find_user")
    public String findAuthor(Model model){
        model.addAttribute("user", User.builder().build());
        return "users/findUsers";
    }

    @GetMapping(value = "/find_UserBy")
    public String findByLikeLastName(User user, BindingResult result, Model model){
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
