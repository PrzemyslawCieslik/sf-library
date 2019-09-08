package com.Przemek.sflibrary.controllers;

import com.Przemek.sflibrary.model.Book;
import com.Przemek.sflibrary.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/new_book")
    public String addBook(Model model){
        model.addAttribute("book", Book.builder().build());
        return "books/addBook";
    }

    @RequestMapping("/find_book")
    public String findBook(Model model){
        model.addAttribute("book", Book.builder().build());
        return "books/bookList";
    }

    @GetMapping("{bookId")
    public ModelAndView showBook(@PathVariable Long bookId){
        String url;
        ModelAndView mav = new ModelAndView("books/bookDetails");
        mav.addObject(bookService.findById(bookId));
        return mav;
    }
}
