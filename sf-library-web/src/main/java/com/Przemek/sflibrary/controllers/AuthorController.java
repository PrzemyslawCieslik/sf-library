package com.Przemek.sflibrary.controllers;

import com.Przemek.sflibrary.model.Author;
import com.Przemek.sflibrary.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/new_author")
    public String addAuthor(Model model){
        model.addAttribute("author", Author.builder().build());
        return "authors/addAuthorOrUpdate";
    }

    @PostMapping("/new_author")
    public String createAuthor(@Valid Author author, BindingResult result){
        if (result.hasErrors()){
            return "authors/addAuthorOrUpdate";
        }
        else {
            Author savedAuthor = authorService.save(author);
            return "redirect:/authors/" + savedAuthor.getId();
        }
    }

    @GetMapping("/{authorId}/edit")
    public String updateAuthor(@PathVariable Long authorId, Model model) {
        model.addAttribute(authorService.findById(authorId));
        return "authors/addAuthorOrUpdate";
    }

    @PostMapping("/{authorId}/edit")
    public String updateAuthorForm(@Valid Author author, BindingResult result, @PathVariable Long authorId) {
        if (result.hasErrors()) {
            return "/authors/addAuthorOrUpdate";
        } else {
            author.setId(authorId);
            Author savedAuthor = authorService.save(author);
            return "redirect:/authors/" + savedAuthor.getId();
        }
    }


    @RequestMapping("/find_author")
    public String findAuthor(Model model){
        model.addAttribute("author", Author.builder().build());
        return "authors/findAuthors";
    }

    @GetMapping
    public String findBy(Author author, BindingResult result, Model model){
        if (author.getLastName() == null){
            author.setLastName("");
        }

        List<Author> results = authorService.findAllByLastName("%" + author.getLastName() + "%");

        if (results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "authors/findAuthors";
        }
        else if (results.size() == 1){
            return "redirect:/authors/" + author.getId();
        }
        else {
            model.addAttribute("selections", results);
            return "authors/authorList";
        }
    }

    @GetMapping("/{authorId}")
    public ModelAndView showAuthor(@PathVariable Long authorId){
        String url;
        ModelAndView mav = new ModelAndView("authors/authorDetails");
        mav.addObject(authorService.findById(authorId));
        return mav;
    }




}
