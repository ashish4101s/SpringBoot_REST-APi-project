package com.example.Bms.service;

import com.example.Bms.entity.Book;
import com.example.Bms.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class BookService {


    private final BookRepository bRepo;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bRepo = bookRepository;
    }


    public void save(Book b){
        bRepo.save(b);
    }

    public List<Book> getAllBook(){
        return bRepo.findAll();
    }
    public Book getBookById(int id){
        return bRepo.findById(id)
                .get();
    }
}
