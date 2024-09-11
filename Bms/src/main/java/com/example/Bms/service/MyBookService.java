package com.example.Bms.service;

import com.example.Bms.entity.MyBook;
import com.example.Bms.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

    private final MyBookRepository mRepo;

    @Autowired
    public MyBookService (MyBookRepository myBook){
        this.mRepo=myBook;
    }
    public void saveMyBook(MyBook book){
        mRepo.save(book);

    }

    public List<MyBook> getAllMyBooks(){
        return mRepo.findAll();
    }
    public void deleteById(int id){
        mRepo.deleteById(id);
    }
}
