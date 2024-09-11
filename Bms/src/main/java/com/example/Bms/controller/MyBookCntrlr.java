package com.example.Bms.controller;

import com.example.Bms.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookCntrlr {

    @Autowired
    private MyBookService myBook;

    @RequestMapping(path = "/delete/{id}")
    public String deleteMyBook(@PathVariable ("id") int id){
        myBook.deleteById(id);
        return "redirect:/my_books";
    }
}
