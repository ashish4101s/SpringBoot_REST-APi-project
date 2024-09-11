package com.example.Bms.controller;

import org.springframework.ui.Model;
import com.example.Bms.entity.Book;
import com.example.Bms.entity.MyBook;
import com.example.Bms.service.BookService;
import com.example.Bms.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookCntrlr {
    @Autowired
    private BookService service;

    @Autowired
    private MyBookService myService;

    @GetMapping(path="/")
    public String Home(){
        return "Home";
    }

    @GetMapping(path="/newbook")
    public String newbook(){
        return "newbook";
    }
    @GetMapping(path="/booklist")
    public ModelAndView booklist(){
        List<Book> list=service.getAllBook();
//        ModelAndView m=new ModelAndView();
//        m.setViewName("booklist");
//        m.addObject("book",list);
        return new ModelAndView("booklist","book",list);
    }

    @PostMapping(path = "/save")
    public String addBook(@ModelAttribute Book b){
            service.save(b);
            return "redirect:/booklist ";
    }

    @RequestMapping(path = "mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b= service.getBookById(id);
        MyBook mb=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myService.saveMyBook(mb);
        return "redirect:/my_books";


    }
    @GetMapping(path="/my_books")
    public String my_books(Model model){

        List<MyBook> list=myService.getAllMyBooks();
        model.addAttribute("mybook",list);

        return "myBooks";
    }

    @RequestMapping(path = "/edit/{id}")
    public String editList(@PathVariable ("id")int id,Model model){
        Book b=service.getBookById(id);
        model.addAttribute("editBook",b);
        return "bookEdit";
    }
}
