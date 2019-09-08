package com.Przemek.sflibrary.controllers;

import com.Przemek.sflibrary.model.Magazine;
import com.Przemek.sflibrary.services.MagazineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MagazineController {

    private MagazineService magazineService;

    public MagazineController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }


    @GetMapping("/new_magazine")
    public String addBook(Model model){
        model.addAttribute("book", Magazine.builder().build());
        return "books/addBook";
    }

    @RequestMapping("/find_magazine")
    public String findBook(Model model){
        model.addAttribute("book", Magazine.builder().build());
        return "magazines/magazineList";
    }

    @GetMapping("{magazineId")
    public ModelAndView showBook(@PathVariable Long bookId){
        String url;
        ModelAndView mav = new ModelAndView("magazines/magazineDetails");
        mav.addObject(magazineService.findById(bookId));
        return mav;
    }
}
